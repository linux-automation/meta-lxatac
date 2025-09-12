inherit cargo
inherit cargo-update-recipe-crates
inherit pkgconfig
inherit systemd

DEFAULT_PREFERENCE = "-1"

SRC_URI += " \
    git://github.com/linux-automation/tacd.git;protocol=https;branch=${SRCBRANCH} \
    file://tacd.service \
    file://tacd-failsafe.sh \
    file://de.pengutronix.tacd.conf \
    file://01_stable.yaml \
    file://05_testing.yaml \
    "

S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

SUMMARY = "tacd"
HOMEPAGE = "https://github.com/linux-automation/tacd"
LICENSE = "GPL-2.0-or-later"

DEPENDS:append = " libiio "

SYSTEMD_SERVICE:${PN} = "tacd.service"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/tacd.service ${D}${systemd_system_unitdir}/

    install -D -m 0755 ${UNPACKDIR}/tacd-failsafe.sh ${D}${bindir}/tacd-failsafe

    install -D -m 0644 ${UNPACKDIR}/01_stable.yaml ${D}${datadir}/tacd/update_channels/01_stable.yaml
    install -D -m 0644 ${UNPACKDIR}/05_testing.yaml ${D}${datadir}/tacd/update_channels/05_testing.yaml

    install -d ${D}${sysconfdir}/dbus-1/system.d
    install -m 0644 ${UNPACKDIR}/de.pengutronix.tacd.conf ${D}/${sysconfdir}/dbus-1/system.d/
}

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=570a9b3749dd0463a1778803b12a6dce \
"

require tacd-crates.inc
