FILESEXTRAPATHS:prepend := "${THISDIR}/python3-labgrid:" 

SRC_URI += " \
    file://userconfig.yaml \
    file://labgrid.conf \
"

do_install:append() {
    install -m 0644 ${WORKDIR}/userconfig.yaml ${D}${sysconfdir}/labgrid
    install -D -m 0644 ${WORKDIR}/labgrid.conf ${D}${libdir}/tmpfiles.d/labgrid.conf
}

FILES:${PN} += "${libdir}/tmpfiles.d"
