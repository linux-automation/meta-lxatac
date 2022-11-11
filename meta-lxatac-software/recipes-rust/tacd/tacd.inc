SRC_URI += " \
    file://tacd.service \
    file://de.pengutronix.tacd.conf \
    "

inherit systemd

DEPENDS += "libiio"

SYSTEMD_SERVICE:${PN} = "tacd.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/tacd.service ${D}${systemd_system_unitdir}/
    install -d ${D}${sysconfdir}/dbus-1/system.d
    install -m 0644 ${WORKDIR}/de.pengutronix.tacd.conf ${D}/${sysconfdir}/dbus-1/system.d/
}

#FILES:${PN} += "${sysconfdir} ${systemd_system_unitdir} ${sysconfdir}/dbus-1/system.d"
