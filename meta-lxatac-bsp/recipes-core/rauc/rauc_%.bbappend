FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

RDEPENDS:${PN} += "e2fsprogs-resize2fs"

SRC_URI += " \
    file://0001-install-remember-if-a-slot-or-artifact-was-updated.patch \
    file://0002-src-service-remember-whether-the-booted-slot-is-mark.patch \
    file://0003-utils-add-helper-to-get-a-string-list-from-a-GKeyFil.patch \
    file://0004-add-a-Poller-D-Bus-interface.patch \
    file://0005-context-implement-a-polling-speedup-factor-for-testi.patch \
    file://0006-implement-polling-in-the-service.patch \
    file://require-mount-srv.conf \
    "

do_install:append() {
    install -D -m 0644 ${UNPACKDIR}/require-mount-srv.conf \
        ${D}${systemd_system_unitdir}/rauc.service.d/require-mount-srv.conf
}

FILES:${PN} += "${systemd_system_unitdir}/rauc.service.d/"
