import os
import re

import bb.tinfoil
import git

RE_VERSION_TAG = r"v(?P<year>[0-9][0-9])\.(?P<month>[0-9][0-9])(?:\.(?P<minor>[0-9]+))?"
RE_VERSION_BB = r"(?P<year>[0-9][0-9])\.(?P<month>[0-9][0-9])(?:(?P<dev>$|\+dev)|(?:\.(?P<minor>[0-9]+))?)"


def bb_variables(names):
    ret = dict()

    with bb.tinfoil.Tinfoil(tracking=True, setup_logging=True) as tinfoil:
        tinfoil.prepare(quiet=2, config_only=True)
        d = tinfoil.config_data

        for name in names:
            ret[name] = d.getVar(name)

    return ret


def git_prev_tag():
    repo = git.Repo()

    # e.g. 'v23.11'
    tag = repo.git.describe(tags=True, abbrev=0)

    # e.g. 'v23.11-40-ga4a1'
    commit_description = repo.git.describe(tags=True)

    # The description matches the tag if there are no commits since the
    # last tag.
    commit_is_tagged = tag == commit_description

    return (tag, commit_is_tagged)


def version_tuple(version):
    year = int(version["year"])
    month = int(version["month"])
    minor = int(version["minor"] or "0")

    return (year, month, minor)


def check_version(distro_version):
    prev_tag, commit_is_tagged = git_prev_tag()

    print(f"Checking tag {prev_tag} against version {distro_version}")

    version_tag = re.fullmatch(RE_VERSION_TAG, prev_tag)
    version_tag_tuple = version_tuple(version_tag)

    version_bb = re.fullmatch(RE_VERSION_BB, distro_version)
    version_bb_tuple = version_tuple(version_bb)

    if commit_is_tagged:
        # The version in a tagged commit must match the version in the tag's name.
        assert version_bb["dev"] == ""
        assert version_tag_tuple == version_bb_tuple

    elif version_bb["dev"]:
        # Non release candidate versions should have the previous tagged
        # version number plus the +dev suffix set.
        assert version_bb_tuple == version_tag_tuple

    else:
        # Release candidates already have the next release version set,
        # but it must be newer than any tag in the current commit's history.
        assert version_bb_tuple > version_tag_tuple


def check_codename(codename):
    base_ref = os.environ.get("GITHUB_BASE_REF")
    ref = os.environ.get("GITHUB_REF_NAME")
    ref_type = os.environ.get("GITHUB_REF_TYPE")

    branch = base_ref or (ref if ref_type == "branch" else None)

    if branch and branch.startswith("stable-"):
        print("Running for a stable branch. Skipping codename check")
    elif branch:
        print(f"Checking codename {codename} against branch {branch}")
        assert codename == f"tacos-{branch}"
    elif ref_type == "tag":
        print("Running for a tag. Skipping codename check")
    else:
        print("Running outside of GitHub CI. Skipping codename check")


def main():
    variables = bb_variables(("DISTRO_VERSION", "DISTRO_CODENAME"))

    check_version(variables["DISTRO_VERSION"])
    check_codename(variables["DISTRO_CODENAME"])


if __name__ == "__main__":
    main()
