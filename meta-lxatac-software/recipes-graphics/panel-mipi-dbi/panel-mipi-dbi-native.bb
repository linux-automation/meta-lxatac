SUMMARY = "Tool to make firmware files for the Linux display driver panel-mipi-dbi."
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://mipi-dbi-cmd;beginline=4;endline=13;md5=5e3d3f14cc87aa9e8976d728520cbcae"
SRCREV = "374b15f78611c619c381c643c5b3a8b5d23f479b"
PV = "1.0+git${SRCPV}"

SRC_URI = "git://github.com/notro/panel-mipi-dbi.git;protocol=https;branch=main \
           file://0001-Use-python3-in-shebang.patch \
           "

S = "${WORKDIR}/git"

inherit native

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install () {
    install -D -p -m 0755 ${S}/mipi-dbi-cmd ${D}${bindir}/mipi-dbi-cmd
}

RDEPENDS:${PN} += "python3-native"
