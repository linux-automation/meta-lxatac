FILESEXTRAPATHS:prepend := "${THISDIR}/files:" 

SRC_URI += "file://htoprc"

do_install:append() {
    install -D -m 0644 ${UNPACKDIR}/htoprc ${D}${sysconfdir}/htoprc
}

FILES:${PN} += "${sysconfdir}/htoprc"
