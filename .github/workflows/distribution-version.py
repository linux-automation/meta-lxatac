import os
import re

import bb.tinfoil
import git

# TODO: add minor version numbers once we have them
RE_VERSION_TAG = "v(?P<year>[0-9][0-9])\.(?P<month>[0-9][0-9])"
RE_VERSION_BB = "(?P<year>[0-9][0-9])\.(?P<month>[0-9][0-9])(?P<dev>$|\+dev)"


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


def check_version(distro_version):
    prev_tag, commit_is_tagged = git_prev_tag()

    print(f"Checking tag {prev_tag} against version {distro_version}")

    version_tag = re.fullmatch(RE_VERSION_TAG, prev_tag)
    version_tag_numeric = int(version_tag["year"]) * 100 + int(version_tag["month"])

    version_bb = re.fullmatch(RE_VERSION_BB, distro_version)
    version_bb_numeric = int(version_bb["year"]) * 100 + int(version_bb["month"])

    if commit_is_tagged:
        # The version in a tagged commit must match the version in the tag's name.
        assert version_bb["dev"] == ""
        assert version_tag_numeric == version_bb_numeric

    elif version_bb["dev"] == "":
        # Release candidates already have the next release version set,
        # but it must be newer than any tag in the current commit's history.
        assert version_bb_numeric > version_tag_numeric

    else:
        # Non release candidate versions should have the previous tagged
        # version number plus the +dev suffix set.
        assert version_bb_numeric == version_tag_numeric


def check_codename(codename):
    base_ref = os.environ.get("GITHUB_BASE_REF")
    ref = os.environ.get("GITHUB_REF_NAME")
    ref_type = os.environ.get("GITHUB_REF_TYPE")

    if base_ref:
        print(f"Checking codename {codename} against pull request into {base_ref}")
        assert codename == f"tacos-{base_ref}"
    elif ref and ref_type == "branch":
        print(f"Checking codename {codename} against branch {ref}")
        assert codename == f"tacos-{ref}"
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
