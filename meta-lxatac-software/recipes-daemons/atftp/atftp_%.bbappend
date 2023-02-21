FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://atftp-tmpfiles.conf"

# On the TAC /srv is a separate partition, which does however fail to
# mount if the tftp directory already exists.
# Instead make sure that /srv/tftp is generated at runtime by tmpfiles.d.
do_install:append() {
    rmdir ${D}/srv/tftp ${D}/srv

    install -D -m 0644 ${WORKDIR}/atftp-tmpfiles.conf ${D}${libdir}/tmpfiles.d/atftp.conf
}

FILES:${PN}d += "${libdir}/tmpfiles.d"
