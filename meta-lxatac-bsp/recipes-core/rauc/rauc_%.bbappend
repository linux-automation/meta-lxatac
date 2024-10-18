FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

RDEPENDS:${PN} += "e2fsprogs-resize2fs"

SRC_URI += " \
    file://require-mount-srv.conf \
    "

do_install:append() {
    install -D -m 0644 ${UNPACKDIR}/require-mount-srv.conf \
        ${D}${systemd_system_unitdir}/rauc.service.d/require-mount-srv.conf
}

FILES:${PN} += "${systemd_system_unitdir}/rauc.service.d/"
