LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/aagallag/hid_gadget_test.git;protocol=https;branch=master \
           file://0001-Use-CC-to-compile-instead-of-calling-gcc-directly.patch \
           "

PV = "1.0+git${SRCPV}"
SRCREV = "f098065a03db2fd51cda24c8b90b29259e7bb81c"

S = "${WORKDIR}/git"

do_configure () {
    :
}

do_compile () {
    oe_runmake
}

do_install () {
    install -D -m0755 ${S}/hid_gadget_test ${D}${bindir}/hid_gadget_test
}

FILES:${PN} = "${bindir}"
