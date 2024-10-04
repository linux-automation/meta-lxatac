LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch

SRC_URI += " \
    file://hostname.conf \
    file://tac-bridge.nmconnection \
    file://port-dut.nmconnection \
    file://port-uplink.nmconnection \
    file://switch.conf \
    file://01-disable_switch_ipv6.conf \
    file://50-g-usb.link \
    file://52-switch.link \
    "

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

N = "${libdir}/NetworkManager/system-connections"

do_install() {
    install -D -m0600 ${UNPACKDIR}/tac-bridge.nmconnection ${D}${N}/tac-bridge.nmconnection
    install -D -m0600 ${UNPACKDIR}/port-dut.nmconnection ${D}${N}/port-dut.nmconnection
    install -D -m0600 ${UNPACKDIR}/port-uplink.nmconnection ${D}${N}/port-uplink.nmconnection
    install -D -m0600 ${UNPACKDIR}/switch.conf ${D}${libdir}/NetworkManager/conf.d/switch.conf
    install -D -m0600 ${UNPACKDIR}/hostname.conf ${D}${libdir}/NetworkManager/conf.d/hostname.conf

    install -D -m0600 ${UNPACKDIR}/50-g-usb.link ${D}${libdir}/systemd/network/50-g-usb.link
    install -D -m0600 ${UNPACKDIR}/52-switch.link ${D}${libdir}/systemd/network/52-switch.link
    install -D -m0600 ${UNPACKDIR}/01-disable_switch_ipv6.conf ${D}${libdir}/sysctl.d/01-disable_switch_ipv6.conf
}

FILES:${PN} += "${libdir}/sysctl.d/"
FILES:${PN} += "${libdir}/systemd/network/"
FILES:${PN} += "${libdir}/NetworkManager/conf.d/"
FILES:${PN} += "${libdir}/NetworkManager/system-connections/"
