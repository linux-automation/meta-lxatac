FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

RDEPENDS:${PN}:append = "e2fsprogs-resize2fs"

SRC_URI:append = " \
    file://0001-src-nbd-initialize-info_headers-to-NULL.patch \
    file://require-mount-srv.conf \
    "

do_install:append() {
    install -D -m 0644 ${WORKDIR}/require-mount-srv.conf \
        ${D}${systemd_unitdir}/system/rauc.service.d/require-mount-srv.conf
}

FILES:${PN} += "${systemd_unitdir}/system/rauc.service.d/"
