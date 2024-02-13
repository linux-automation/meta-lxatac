SRC_URI += " \
    file://tacd.service \
    file://tacd-failsafe.sh \
    file://de.pengutronix.tacd.conf \
    file://01_stable.yaml \
    file://05_testing.yaml \
    "

inherit pkgconfig
inherit systemd

DEPENDS:append = " libiio "

SYSTEMD_SERVICE:${PN} = "tacd.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/tacd.service ${D}${systemd_system_unitdir}/

    install -D -m 0755 ${WORKDIR}/tacd-failsafe.sh ${D}${bindir}/tacd-failsafe

    install -D -m 0644 ${WORKDIR}/01_stable.yaml ${D}${datadir}/tacd/update_channels/01_stable.yaml
    install -D -m 0644 ${WORKDIR}/05_testing.yaml ${D}${datadir}/tacd/update_channels/05_testing.yaml

    install -d ${D}${sysconfdir}/dbus-1/system.d
    install -m 0644 ${WORKDIR}/de.pengutronix.tacd.conf ${D}/${sysconfdir}/dbus-1/system.d/
}
