SUMMARY = "GitLab Runner"
DESCRIPTION = "The Runner for GitLab Pipelines"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

GO_IMPORT = "gitlab.com/gitlab-org/gitlab-runner"
GO_INSTALL = "${GO_IMPORT}"

SRC_URI = " \
    git://${GO_IMPORT};branch=${SRCBRANCH};protocol=https;destsuffix=${BPN}-${PV}/src/${GO_IMPORT} \
    file://gitlab-runner.service \
    "

RDEPENDS:${PN}:append = "git"
RDEPENDS:gitlab-runner-dev = "bash"

inherit go-mod
inherit systemd

SYSTEMD_SERVICE:${PN} = "gitlab-runner.service"

# This is required because the go build system fetches dependencies in the
# compile stage.
do_compile[network] = "1"

# This is required to prevent build failures due to
# "duplicated definition of symbol" errors.
GO_LINKSHARED = ""

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/gitlab-runner.service ${D}${systemd_system_unitdir}/
}
