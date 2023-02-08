FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
    git://github.com/notro/panel-mipi-dbi.git;protocol=https;branch=main \
    file://shineworld,lh133k.txt \
"

PV = "1.0+git${SRCPV}"
SRCREV = "374b15f78611c619c381c643c5b3a8b5d23f479b"

S = "${WORKDIR}/git"

LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://mipi-dbi-cmd;beginline=4;endline=13;md5=5e3d3f14cc87aa9e8976d728520cbcae"

DEPENDS = "python3-native"

do_configure () {
}

do_compile () {
    python3 mipi-dbi-cmd \
        "${WORKDIR}/shineworld,lh133k.bin" \
        "${WORKDIR}/shineworld,lh133k.txt"
}

do_install () {
    install -m 0644 -D \
        "${WORKDIR}/shineworld,lh133k.bin" \
        "${D}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin"
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/"
