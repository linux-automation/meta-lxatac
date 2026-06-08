inherit cargo
inherit cargo-update-recipe-crates

DEFAULT_PREFERENCE = "-1"

SRC_URI += "git://github.com/linux-automation/tacd.git;protocol=https;branch=main"

# Commit created 2026-06-04 08:03:46 +0200
SRCREV = "0bf1aca15f7bebe6b02301fc6cd1a876c3037489"
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
