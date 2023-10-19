SUMMARY = "GitLab Runner"
DESCRIPTION = "The Runner for GitLab Pipelines"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI:append = " file://gitlab-runner.service "

GO_IMPORT = "gitlab.com/gitlab-org/gitlab-runner"
GO_INSTALL = "${GO_IMPORT}"

RDEPENDS:gitlab-runner-dev = "bash"

inherit go-mod
inherit systemd

SYSTEMD_SERVICE:${PN} = "gitlab-runner.service"

# This is required because the go build system fetches dependecies in the
# compile stage.
do_compile[network] = "1"

# This is required to prevent build failures due to
# "duplicated definition of symbol" errors.
GO_LINKSHARED = ""

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/gitlab-runner.service ${D}${systemd_system_unitdir}/
}
