LICENSE = "CLOSED"
PACKAGE_ARCH = "lxatac"

SRC_URI = " \
    file://01-switch.conf \
"

do_install() {
    install -D -m0644 ${WORKDIR}/01-switch.conf ${D}${sysconfdir}/lldpd.d/01-switch.conf
}

FILES:${PN} = "${sysconfdir}/lldpd.d/"
