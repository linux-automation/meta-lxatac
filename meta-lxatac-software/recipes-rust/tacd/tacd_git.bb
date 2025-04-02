inherit cargo
inherit cargo-update-recipe-crates

DEFAULT_PREFERENCE = "-1"

SRC_URI += "git://github.com/linux-automation/tacd.git;protocol=https;branch=main"
SRCREV = "588a7e059aed85ce3928914cdedfbf05d5fadaa7"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV = "0.1.0+git${SRCPV}"

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
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
