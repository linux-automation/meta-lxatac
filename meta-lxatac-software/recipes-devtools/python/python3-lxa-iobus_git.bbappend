FILESEXTRAPATHS:prepend := "${THISDIR}/python3-lxa-iobus:"

SRC_URI = " \
    git://github.com/hnez/lxa-iobus.git;protocol=https;branch=webworker \
    file://environment \
    file://80-can0-iobus.link \
    file://lxa-iobus.service \
    "

SRCREV = "fbc1f152c851de44a35c3998e6b33e091a20c5d3"

RDEPENDS:${PN}:remove = "python3-aiohttp-json-rpc"

do_install:append() {
    install -D -m0644 ${UNPACKDIR}/80-can0-iobus.link ${D}${libdir}/systemd/network/80-can0-iobus.link
    install -D -m0644 ${UNPACKDIR}/lxa-iobus.service ${D}${systemd_system_unitdir}/lxa-iobus.service
    install -d -m0644 ${D}/var/cache/lxa-iobus
}
