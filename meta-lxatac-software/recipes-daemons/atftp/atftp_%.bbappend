FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://create-dir.conf"

# On the TAC /srv is a separate partition, which does however fail to
# mount if the tftp directory already exists.
# Instead make sure that /srv/tftp is generated at runtime by an ExecStartPre
# in the service.
do_install:append() {
    rmdir ${D}/srv/tftp ${D}/srv

    install -D -m 0644 ${UNPACKDIR}/create-dir.conf \
        ${D}${systemd_system_unitdir}/atftpd.service.d/create-dir.conf
}

FILES:${PN}d += "${systemd_system_unitdir}/atftpd.service.d"
