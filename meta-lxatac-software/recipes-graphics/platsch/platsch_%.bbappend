FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://splash-240x240-RGB565.bin "

do_install:append() {
    install -D -m 0644 ${WORKDIR}/splash-240x240-RGB565.bin ${D}${datadir}/platsch/splash-240x240-RGB565.bin
}

FILES:${PN} += " ${datadir}/platsch "
