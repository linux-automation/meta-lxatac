SUMMARY = "GitLab Runner"
DESCRIPTION = "The Runner for GitLab Pipelines"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=6fbcd88d72be783faee090dc8f227594"

SRC_URI = "\
    git://${GO_IMPORT}.git;protocol=https;branch=${SRCBRANCH};tag=v${PV};destsuffix=${GO_SRCURI_DESTSUFFIX} \
    file://gitlab-runner.service \
    "

# Commit created 2026-04-05 13:53:20 +0000
SRCREV = "3b43bf9ff3eba1a75461d386b76fea77694e26a8"
SRCBRANCH = "18-10-stable"

RDEPENDS:${PN}:append = " git"
RDEPENDS:gitlab-runner-dev = "bash"

require ${BPN}-licenses.inc
require ${BPN}-go-mods.inc
GO_IMPORT = "gitlab.com/gitlab-org/gitlab-runner"
GO_INSTALL = "${GO_IMPORT}"

inherit go-mod go-mod-update-modules systemd

SYSTEMD_SERVICE:${PN} = "gitlab-runner.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/gitlab-runner.service ${D}${systemd_system_unitdir}/
}

