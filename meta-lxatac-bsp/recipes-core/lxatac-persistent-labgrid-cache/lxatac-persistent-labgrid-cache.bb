LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://use-var-cache-labgrid.conf \
    file://var-cache-labgrid.mount \
"

S = "${WORKDIR}"

do_install () {
    install -d ${D}${systemd_system_unitdir}/
    install -m 0644 -t ${D}${systemd_system_unitdir}/ ${S}/var-cache-labgrid.mount
    install -d ${D}${systemd_system_unitdir}/labgrid-exporter.service.d/
    install -m 0644 -t ${D}${systemd_system_unitdir}/labgrid-exporter.service.d/ \
        ${S}/use-var-cache-labgrid.conf
}

FILES:${PN} = "${systemd_system_unitdir}"
