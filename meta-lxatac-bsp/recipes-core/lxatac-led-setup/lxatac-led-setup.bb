SUMMARY = "Set up LXA TAC LEDs with triggers that need sysfs interaction"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
    file://lxatac-led-setup.service \
    file://lxatac-led-setup.sh \
"

SYSTEMD_SERVICE:${PN} = "lxatac-led-setup.service"

inherit allarch systemd

do_install() {
    install -m 0644 -D ${WORKDIR}/lxatac-led-setup.service ${D}${systemd_system_unitdir}/lxatac-led-setup.service
    install -m 0755 -D ${WORKDIR}/lxatac-led-setup.sh ${D}${sbindir}/lxatac-led-setup
}

RDEPENDS:${PN} = "bash"
