#!/usr/bin/env python3

import glob
import hashlib
import os.path
import re
import subprocess
from datetime import datetime
from tempfile import TemporaryDirectory

import requests
import yaml

BRANCH_PRIORITIES = tuple(
    (re.compile(pattern), prio)
    for pattern, prio in (
        ("main", 9999),
        ("master", 9998),
        ("release.*", 9997),
        ("stable.*", 9996),
        (".*release", 9995),
        (".*stable", 9994),
        ("bugfix.*", 6001),
        ("hotfix.*", 6000),
        # The default is 5000
        ("next", 4003),
        ("develop", 4002),
        ("staging", 4001),
        ("feature.*", 4000),
        (".*/.*", 2000),
    )
)

PATTERNS = tuple(
    (re.compile(pattern, re.MULTILINE), replacement)
    for pattern, replacement in (
        (r'^PV = "(?P<needle>[^"]*)"', lambda ri: ri.get("pv")),
        (
            r'^SRCREV = "[^"]*(?P<needle>[0-9a-f]{40})',
            lambda ri: ri.get("commit_hash"),
        ),
        (r'^SRCBRANCH = "(?P<needle>[^"]*)"', lambda ri: ri.get("branch")),
        (
            r"\s(?P<needle>\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2} \+\d{4})\s",
            lambda ri: ri.get("commit_date"),
        ),
        (
            r'^SRC_URI\[md5sum\] = "[^"]*(?P<needle>[0-9a-f]{32})"',
            lambda ri: ri.get("md5sum"),
        ),
        (
            r'^SRC_URI\[sha1sum\] = "[^"]*(?P<needle>[0-9a-f]{40})"',
            lambda ri: ri.get("sha1sum"),
        ),
        (
            r'^SRC_URI\[sha256sum\] = "[^"]*(?P<needle>[0-9a-f]{64})"',
            lambda ri: ri.get("sha256sum"),
        ),
        (
            r'^SRC_URI\[sha512sum\] = "[^"]*(?P<needle>[0-9a-f]{128})"',
            lambda ri: ri.get("sha512sum"),
        ),
    )
)


def semver_key(info):
    return tuple(int(n) for n in info["pv"].split("."))


def branch_key(name):
    """Assign a priority to a branch name

    A commit will likely be contained in multiple branches, and we want to use
    the most descriptive one as SRCBRANCH in the recipes.
    Assign priorities to common branch names based on how descriptive they are.
    """

    for pattern, prio in BRANCH_PRIORITIES:
        if pattern.fullmatch(name):
            return (prio, name)

    return (5000, name)


def get_json(url):
    with requests.get(url, stream=True) as req:
        req.raise_for_status()
        return req.json()


class GitRepo:
    LOG_FORMAT = [
        ("%H", "commit_hash"),
        ("%ci", "commit_date"),
        ("%ct", "commit_timestamp"),
        ("%(describe:tags=true)", "describe"),
    ]

    def __init__(self, url):
        self.url = url

        self._git_dir = None
        self._refs = None

    def _run(self, cmd, capture=True):
        stdout = subprocess.PIPE if capture else None
        return subprocess.run(cmd, stdout=stdout, check=True, text=True).stdout

    def _git(self, *cmd):
        if self._git_dir is None:
            # We must keep a reference to self.tmp for as long as we need the
            # temporary directory.
            self._tmp = TemporaryDirectory()
            self._git_dir = os.path.join(self._tmp.name, "repo.git")

            self._run(
                [
                    "git",
                    "clone",
                    "--bare",
                    "--filter=blob:none",
                    self.url,
                    self._git_dir,
                ],
                False,
            )

        return self._run(["git", "-C", self._git_dir, *cmd]).strip()

    def commit_info(self, commit, basic):
        if basic:
            return {"commit_hash": self.refs().get(commit, commit)}

        else:
            git_format, fields = zip(*self.LOG_FORMAT, strict=True)
            res = self._git("log", "-1", f"--format={'%x00'.join(git_format)}", commit)

            return dict(zip(fields, res.split("\x00"), strict=True))

    def branch_head(self, branch, basic):
        return self.commit_info(f"refs/heads/{branch}", basic)

    def tag(self, tag, basic):
        return self.commit_info(f"refs/tags/{tag}", basic)

    def refs(self):
        if self._refs is None:
            # Use the local clone for information if there is one.
            # Otherwise, ask the server for a list of refs.
            ref_list = (
                self._git("show-ref")
                if self._git_dir is not None
                else self._run(["git", "ls-remote", "--refs", self.url]).strip()
            )

            self._refs = dict(ln.split("\t", 1)[::-1] for ln in ref_list.split("\n"))

        return self._refs

    def refs_with_prefix(self, prefix):
        return list(
            ref.removeprefix(prefix) for ref in self.refs() if ref.startswith(prefix)
        )

    def branches(self):
        return self.refs_with_prefix("refs/heads/")

    def tags(self):
        return self.refs_with_prefix("refs/tags/")

    def containing_branches(self, commit):
        res = self._git(
            "branch",
            "--format=%(refname:lstrip=2)",
            "--contains",
            commit,
        )

        return list(branch.strip() for branch in res.split())


def fetch_git_branch(info):
    """Fetch information about the most recent commit on a git branch

    This is used for _git.bb recipes.
    """

    url = info["git_branch"]["url"]
    branch = info["git_branch"]["branch"]
    basic = info["git_branch"].get("basic", False)

    repo = GitRepo(url)
    info.update(repo.branch_head(branch, basic))

    version_pattern = info.get("version_pattern")
    describe = info.get("describe")
    version = (
        re.match(version_pattern, describe)[1] if version_pattern and describe else ""
    )

    if version:
        info["pv"] = f"{version}+git"


def fetch_git_tag(info):
    """Fetch information about the most recent git tag

    ... that matches a version pattern and "most recent" may also not mean by
    date but by semver.
    """

    url = info["git_tag"]["url"]
    version_pattern = re.compile(info["git_tag"]["version_pattern"])
    basic = info["git_tag"].get("basic", False)

    repo = GitRepo(url)

    versions = list()

    for tag in repo.tags():
        if (version_match := version_pattern.match(tag)) is not None:
            pv = version_match[1]
            versions.append({"tag": tag, "pv": pv})

    if info["git_tag"]["version_order"] == "semver":
        # When sorting by semver we do not need to get all commit dates,
        # only the one for the newest commit by semver in the tag name.
        # We can thus reduce the versions dict to only one entry.
        versions.sort(key=semver_key)
        versions = versions[-1:]

    for version in versions:
        version.update(repo.tag(version["tag"], basic))

        if not basic:
            version["branches"] = repo.containing_branches(version["commit_hash"])
            version["branch"] = max(version["branches"], key=branch_key, default=None)

    # Sort the remaining candidates by date.
    # If the version_order is semver the dict will only have one element
    # at this point in time.
    newest = max(versions, key=lambda version: version.get("commit_timestamp"))
    info.update(newest)


def fetch_github_release(recipe_info):
    """Get information about the most recent GitHub release

    This has the benefit of being able to filter out pre-releases,
    when compared to `git_tag`.
    """

    project = recipe_info["github_release"]["project"]
    version_pattern = re.compile(recipe_info["github_release"]["version_pattern"])
    prereleases = recipe_info["github_release"].get("prereleases", False)

    releases = get_json(f"https://api.github.com/repos/{project}/releases")

    versions = list()

    for release in releases:
        # Filter out draft releases
        if release.get("draft", False):
            continue

        # Filter out prereleases (if desired)
        if not prereleases and release.get("prerelease", False):
            continue

        # Only keep versions that match our schema
        version_match = version_pattern.match(release["tag_name"])

        if version_match is not None:
            versions.append(
                {
                    "tag": version_match[0],
                    "pv": version_match[1],
                }
            )

    if recipe_info["github_release"]["version_order"] == "semver":
        versions.sort(key=semver_key)
        versions = versions[-1:]

    for version in versions:
        tag = version["tag"]
        tag_info = get_json(
            f"https://api.github.com/repos/{project}/git/matching-refs/tags/{tag}"
        )
        commit_info = get_json(tag_info[0]["object"]["url"])

        version["commit_hash"] = commit_info["sha"]

        who = (
            commit_info.get("committer")
            or commit_info.get("author")
            or commit_info.get("tagger")
        )
        commit_date = who["date"].replace("T", " ").replace("Z", " +0000")
        version["commit_date"] = commit_date
        version["commit_timestamp"] = datetime.fromisoformat(commit_date).timestamp()

    # Sort the remaining candidates by date.
    # If the version_order is semver the dict will only have one element
    # at this point in time.
    newest = max(versions, key=lambda version: version["commit_timestamp"])
    recipe_info.update(newest)


def fetch_tarball(recipe_info):
    """Get hash values for a release tarball

    Some recipes use git tags to determine the most recent version,
    but use tarballs to actually fetch the code.
    In that case download the tarball and calculate the checksum.
    """

    url = recipe_info["tarball"]["url"]
    url = url.replace("$PV", recipe_info.get("pv", ""))

    print(f"Hashing {url}")

    hashers = {
        "md5sum": hashlib.md5(),
        "sha1sum": hashlib.sha1(),
        "sha256sum": hashlib.sha256(),
        "sha512sum": hashlib.sha512(),
    }

    with requests.get(url, stream=True) as req:
        req.raise_for_status()

        for chunk in req.iter_content(chunk_size=8192):
            print(".", end="", flush=True)

            if chunk:
                for hasher in hashers.values():
                    hasher.update(chunk)

    recipe_info.update((name, hasher.hexdigest()) for name, hasher in hashers.items())

    print(" done.")


def fetch_info(recipe_info):
    if "git_branch" in recipe_info:
        fetch_git_branch(recipe_info)

    elif "git_tag" in recipe_info:
        fetch_git_tag(recipe_info)

    elif "github_release" in recipe_info:
        fetch_github_release(recipe_info)

    # The most recent version is determined by a git strategy,
    # but for some recipes a tarball is used to actually fetch the release.
    # If that is the case we need to update the hash.
    if "tarball" in recipe_info:
        fetch_tarball(recipe_info)


def get_old_recipes(recipe):
    # Use a glob to find candidate files
    recipe_glob = glob.escape(recipe).replace("$PV", "*")

    # Filter the candidate files using a regex that matches everything
    # that looks like a version number.
    # This excludes files that just happen to be called `..._*.bb`.
    recipe_regex = re.escape(recipe).replace("\\$PV", "[\\d+\\.]*\\d+")
    recipe_regex = re.compile(recipe_regex)

    return list(
        old_recipe
        for old_recipe in glob.glob(recipe_glob)
        if recipe_regex.fullmatch(old_recipe)
    )


def write_recipe(recipe, recipe_info):
    # List old recipes and read one of them
    old_recipes = get_old_recipes(recipe)

    with open(old_recipes[0], "r") as fd:
        recipe_bb = fd.read()

    # Replace patterns with info from the new release
    for pattern, replacement in PATTERNS:
        if found := pattern.search(recipe_bb):
            start, end = found.span("needle")

            if (rep := replacement(recipe_info)) is not None:
                recipe_bb = recipe_bb[:start] + rep + recipe_bb[end:]

    # Write new recipe to disk
    recipe_path = recipe.replace("$PV", recipe_info.get("pv", ""))

    with open(recipe_path, "w") as fd:
        fd.write(recipe_bb)
        print(f"Wrote {recipe_path}")

    # Delete old recipes
    for old_recipe in old_recipes:
        if old_recipe != recipe_path:
            os.remove(old_recipe)
            print(f"Removed {old_recipe}")


def main(argv):
    with open(argv[1]) as fd:
        config = yaml.safe_load(fd)

    for recipe_info in config["recipes"]:
        # Specify either a single recipe or a list of them to generate
        # using the same information.
        recipes = recipe_info.get("recipes", [])
        if "recipe" in recipe_info:
            recipes.append(recipe_info["recipe"])

        print("\n\nGenerate:", " ".join(recipes))

        fetch_info(recipe_info)

        for recipe in recipes:
            write_recipe(recipe, recipe_info)

        print("done")


if __name__ == "__main__":
    import sys

    main(sys.argv)
