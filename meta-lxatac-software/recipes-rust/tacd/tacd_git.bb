inherit cargo
inherit cargo-update-recipe-crates

DEFAULT_PREFERENCE = "-1"

SRC_URI += "git://github.com/linux-automation/tacd.git;protocol=https;branch=main"

# Commit created 2026-06-23 10:27:11 +0200
SRCREV = "b8a9d111a3f6cb3a9d2f33977def393e10a9c38a"
PV = "0.1.0+git${SRCPV}"

CARGO_SRC_DIR = ""

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=570a9b3749dd0463a1778803b12a6dce \
"

SUMMARY = "tacd"
HOMEPAGE = "https://github.com/linux-automation/tacd"
LICENSE = "GPL-2.0-or-later"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include tacd-${PV}.inc
include tacd-crates.inc
include tacd.inc
