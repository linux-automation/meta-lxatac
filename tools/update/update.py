#!/usr/bin/env python3

from datetime import datetime
import glob
import hashlib
from tempfile import TemporaryDirectory
import re
import os.path
import subprocess

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

    A commit will likely be contained in multiple branches and we want to use
    the most descriptive one as SRCBRANCH in the recipes.
    Assign priorities to common branch names based on how descriptive they are.
    """

    for pattern, prio in BRANCH_PRIORITIES:
        if pattern.fullmatch(name):
            return (prio, name)

    return (5000, name)


def run(cmd, capture=True):
    stdout = subprocess.PIPE if capture else None
    return subprocess.run(cmd, stdout=stdout, check=True, text=True).stdout


def get_json(url):
    with requests.get(url, stream=True) as req:
        req.raise_for_status()
        return req.json()


def fetch_git_branch(info):
    """Fetch information about the most recent commit on a git branch

    This is used for _git.bb recipes.
    """

    url = info["git_branch"]["url"]
    branch = info["git_branch"]["branch"]

    with TemporaryDirectory() as dir:
        git_dir = os.path.join(dir, "repo.git")

        run(["git", "clone", "--bare", "--filter=blob:none", url, git_dir], False)

        git = ["git", "-C", git_dir]
        commit_hash = run([*git, "rev-parse", f"refs/heads/{branch}"]).strip()
        commit_date = run([*git, "log", "-1", "--format=%ci", commit_hash]).strip()

        try:
            info["describe"] = run([*git, "describe", "--tags", branch]).strip()
        except subprocess.CalledProcessError:
            pass

    version_pattern = info.get("version_pattern")
    describe = info.get("describe")
    version = (
        re.match(version_pattern, describe)[1] if version_pattern and describe else ""
    )

    if version:
        info["pv"] = f"{version}+git"

    info["commit_hash"] = commit_hash
    info["commit_date"] = commit_date


def fetch_git_tag(info):
    """Fetch information about the most recent git tag

    ... that matches a version pattern and "most recent" may also not mean by
    date but by semver.
    """

    url = info["git_tag"]["url"]
    version_pattern = re.compile(info["git_tag"]["version_pattern"])

    versions = list()

    with TemporaryDirectory() as dir:
        git_dir = os.path.join(dir, "repo.git")

        run(["git", "clone", "--bare", "--filter=blob:none", url, git_dir], False)

        git = ["git", "-C", git_dir]
        tags = run([*git, "tag", "--list"]).strip()

        for tag in tags.split("\n"):
            version_match = version_pattern.match(tag)

            if version_match is not None:
                pv = version_match[1]
                versions.append({"tag": tag, "pv": pv})

        if info["git_tag"]["version_order"] == "semver":
            # When sorting by semver we do not need to get all commit dates,
            # only the one for the newest commit by semver in the tag name.
            # We can thus reduce the versions dict to only one entry.
            versions.sort(key=semver_key)
            versions = versions[-1:]

        for version in versions:
            tag_name = version["tag"]

            hash = run([*git, "rev-parse", f"refs/tags/{tag_name}^{{commit}}"]).strip()

            version["commit_hash"] = hash
            version["commit_date"] = run(
                [*git, "log", "-1", "--format=%ci", hash]
            ).strip()
            version["commit_timestamp"] = int(
                run([*git, "log", "-1", "--format=%ct", hash]).strip()
            )

            branches = run(
                [
                    *git,
                    "branch",
                    "--format=%(refname:lstrip=2)",
                    "--contains",
                    hash,
                ]
            ).strip()

            version["branches"] = list(
                branch.strip() for branch in branches.split("\n")
            )
            version["branch"] = max(version["branches"], key=branch_key)

    # Sort the remaining candidates by date.
    # If the version_order is semver the dict will only have one element
    # at this point in time.
    newest = max(versions, key=lambda version: version["commit_timestamp"])
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


def write_recipe(recipe_info):
    # List old recipes and read one of them
    old_recipes = glob.glob(glob.escape(recipe_info["recipe"]).replace("$PV", "*"))

    with open(old_recipes[0], "r") as fd:
        recipe_bb = fd.read()

    # Replace patterns with info from the new release
    for pattern, replacement in PATTERNS:
        if found := pattern.search(recipe_bb):
            start, end = found.span("needle")

            if (rep := replacement(recipe_info)) is not None:
                recipe_bb = recipe_bb[:start] + rep + recipe_bb[end:]

    # Write new recipe to disk
    recipe_path = recipe_info["recipe"].replace("$PV", recipe_info.get("pv", ""))

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
        print(f"\n\nGenerate: {recipe_info['recipe']}")

        fetch_info(recipe_info)
        write_recipe(recipe_info)

        print("done")


if __name__ == "__main__":
    import sys

    main(sys.argv)
