FILESEXTRAPATHS:prepend := "${THISDIR}/python3-lxa-iobus:" 

SRC_URI += " \
    file://80-can0-iobus.link \
    file://lxa-iobus.service \
    "

do_install:append() {
    install -D -m0644 ${UNPACKDIR}/80-can0-iobus.link ${D}${libdir}/systemd/network/80-can0-iobus.link
    install -D -m0644 ${UNPACKDIR}/lxa-iobus.service ${D}${systemd_system_unitdir}/lxa-iobus.service
}
