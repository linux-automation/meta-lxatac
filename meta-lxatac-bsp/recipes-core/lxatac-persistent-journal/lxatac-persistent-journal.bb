LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Because /var/log is symlinked to /var/volatile/log, we need to have a
# separate mount unit for the bind mount and a snippet for
# systemd-journal-flush.service.

SRC_URI = " \
    file://var-volatile-log-journal.mount \
    file://use-var-volatile-log-journal.conf \
"

S = "${WORKDIR}"

do_install () {
    install -d ${D}${systemd_system_unitdir}/
    install -m 0644 -t ${D}${systemd_system_unitdir}/ ${S}/var-volatile-log-journal.mount
    install -d ${D}${systemd_system_unitdir}/systemd-journal-flush.service.d/
    install -m 0644 -t ${D}${systemd_system_unitdir}/systemd-journal-flush.service.d/ \
        ${S}/use-var-volatile-log-journal.conf
}

FILES:${PN} = "${systemd_system_unitdir}"
