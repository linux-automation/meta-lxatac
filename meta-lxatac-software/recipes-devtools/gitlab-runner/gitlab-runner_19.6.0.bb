SUMMARY = "GitLab Runner"
DESCRIPTION = "The Runner for GitLab Pipelines"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=6fbcd88d72be783faee090dc8f227594"

SRC_URI = "\
    git://${GO_IMPORT}.git;protocol=https;branch=${SRCBRANCH};tag=v${PV};destsuffix=${GO_SRCURI_DESTSUFFIX} \
    file://gitlab-runner.service \
    "

# Commit created 2026-11-17 02:56:02 +0000
SRCREV = "9e4c6b50fd8a81ceaf2ee5c0b4d5d1c6c16067b0"
SRCBRANCH = "docker-services-allowed-users-19-6-stable"

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

