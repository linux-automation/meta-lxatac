LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd allarch

SRC_URI += " \
    file://01-watchdog.conf \
"

S = "${UNPACKDIR}"

do_install () {
    # We have decided against using the `WATCHDOG_RUNTIME_SEC` variable
    # introduced in the walnascar release and in favor of keeping the current
    # config-snippet since the configured watchdog frequency is specific to
    # LXA TAC _hardware_ and not e.g. a part of the tacos distribution.
    # So we want to install the config-snipped based on the machine.
    install -D -m0644 ${UNPACKDIR}/01-watchdog.conf ${D}${systemd_unitdir}/system.conf.d/01-watchdog.conf
}

FILES:${PN} = "${systemd_unitdir}/system.conf.d/"
