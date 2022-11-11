LICENSE = "CLOSED"
PACKAGE_ARCH = "lxatac"

inherit systemd

SRC_URI += " \
    file://01-watchdog.conf \
"

do_install () {
    install -D -m0644 ${WORKDIR}/01-watchdog.conf ${D}${systemd_unitdir}/system.conf.d/01-watchdog.conf
}

FILES:${PN} = "${systemd_unitdir}/system.conf.d/"
