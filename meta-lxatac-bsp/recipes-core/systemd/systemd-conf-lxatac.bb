SUMMARY = "Configure how systemd should handle the watchdog on the LXA TAC"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd allarch

SRC_URI:append = " \
    file://01-watchdog.conf \
"

do_install () {
    install -D -m0644 ${WORKDIR}/01-watchdog.conf ${D}${systemd_unitdir}/system.conf.d/01-watchdog.conf
}

FILES:${PN} += "${systemd_unitdir}/system.conf.d/"
