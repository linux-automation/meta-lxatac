LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://var-log-journal.mount \
"

S = "${WORKDIR}"

inherit allarch

do_install () {
    install -d ${D}${systemd_system_unitdir}/
    install -m 0644 -t ${D}${systemd_system_unitdir}/ ${S}/var-log-journal.mount
}

FILES:${PN} = "${systemd_system_unitdir}"
