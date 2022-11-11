FILESEXTRAPATHS:prepend := "${THISDIR}/files:" 

SRC_URI += "file://htoprc"

do_install:append() {
    install -D -m 0644 ${WORKDIR}/htoprc ${D}${sysconfdir}/htoprc
}

FILES:${PN} += "${sysconfdir}/htoprc"
