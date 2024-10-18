LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://var-log-sa.mount \
    file://use-var-log-sa.conf \
"

S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

inherit allarch

do_install () {
    install -d ${D}${systemd_system_unitdir}/
    install -m 0644 -t ${D}${systemd_system_unitdir}/ ${UNPACKDIR}/var-log-sa.mount
    install -d ${D}${systemd_system_unitdir}/sysstat.service.d/
    install -m 0644 -t ${D}${systemd_system_unitdir}/sysstat.service.d/ \
        ${UNPACKDIR}/use-var-log-sa.conf
}

FILES:${PN} = "${systemd_system_unitdir}"
