FILESEXTRAPATHS:prepend := "${THISDIR}/files:" 

SRC_URI += " \
    file://storage.conf \
    "

do_install:append() {
    install -D -m0644 ${WORKDIR}/storage.conf ${D}${sysconfdir}/containers/storage.conf
}
