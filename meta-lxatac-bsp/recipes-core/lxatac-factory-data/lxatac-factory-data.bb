LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SUMMARY = "Read out and distribute factory data from the devicetree"

inherit allarch systemd

RDEPENDS:${PN} = "bash"

SYSTEMD_SERVICE:${PN} = "lxatac-factory-data.service"

SRC_URI += " \
    file://lxatac-factory-data.service \
    file://lxatac-factory-data.sh \
"

do_install() {
    install -m 0644 -D ${WORKDIR}/lxatac-factory-data.service ${D}${systemd_system_unitdir}/lxatac-factory-data.service
    install -m 0755 -D ${WORKDIR}/lxatac-factory-data.sh ${D}${sbindir}/lxatac-factory-data
}
