LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch

SRC_URI = " \
    file://01-switch.conf \
"

do_install() {
    install -D -m0644 ${WORKDIR}/01-switch.conf ${D}${sysconfdir}/lldpd.d/01-switch.conf
}

FILES:${PN} = "${sysconfdir}/lldpd.d/"
