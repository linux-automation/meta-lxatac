SUMMARY = "GitHub act Runner"
DESCRIPTION = "Alternative implementation of the GitHub Action runner protocol written in Go"

SRC_URI = " \
    git://github.com/ChristopherHX/github-act-runner.git;branch=main;protocol=https \
    file://github-act-runner.service \
"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit go-mod
inherit systemd

GO_IMPORT = "github.com/ChristopherHX/github-act-runner"

RDEPENDS:${PN}:append = "nodejs"
RDEPENDS:github-act-runner-dev:append = "make bash"

SYSTEMD_SERVICE:${PN} = "github-act-runner.service"

# This is required because the go build system fetches dependencies in the
# compile stage.
do_compile[network] = "1"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/github-act-runner.service ${D}${systemd_system_unitdir}/
}
