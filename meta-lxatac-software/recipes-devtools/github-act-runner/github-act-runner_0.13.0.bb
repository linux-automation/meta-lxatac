SUMMARY = "GitHub act Runner"
DESCRIPTION = "Alternative implementation of the GitHub Action runner protocol written in Go"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=dedb37b1b0a2c1675163e60297c9d22b"

SRC_URI = "\
    git://${GO_IMPORT};protocol=https;branch=${SRCBRANCH};tag=v${PV};destsuffix=${GO_SRCURI_DESTSUFFIX} \
    file://github-act-runner.service \
    "

# Commit created 0000-00-00 00:00:00 +0000
SRCREV = "c934667526f602e5732e7072fcd53b36cf044e37"
SRCBRANCH = "main"

RDEPENDS:${PN}:append = " git nodejs"
RDEPENDS:github-act-runner-dev:append = " make bash"

SYSTEMD_SERVICE:${PN} = "github-act-runner.service"

require ${BPN}-licenses.inc
require ${BPN}-go-mods.inc
GO_IMPORT = "github.com/ChristopherHX/github-act-runner"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/github-act-runner.service ${D}${systemd_system_unitdir}/
}

inherit go-mod go-mod-update-modules systemd
