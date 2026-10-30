LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SUMMARY = "Keypair generation and TLS reverse proxy for tacd and LXA IOBus Server"

SRC_URI = "\
    file://tac-tls-gen-selfsigned.service \
    file://tac-tls-iobus.service \
    file://tac-tls-tacd.service \
    "

S = "${UNPACKDIR}"

inherit systemd

RDEPENDS:${PN} = "openssl socat"

SYSTEMD_SERVICE:${PN} = "\
    tac-tls-gen-selfsigned.service \
    tac-tls-iobus.service \
    tac-tls-tacd.service \
    "

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/tac-tls-gen-selfsigned.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${UNPACKDIR}/tac-tls-iobus.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${UNPACKDIR}/tac-tls-tacd.service ${D}${systemd_system_unitdir}/
}
