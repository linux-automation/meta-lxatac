DEPENDS = "panel-mipi-dbi-native"

PANEL_FIRMWARE_BIN ?= "${@d.getVar('PANEL_FIRMWARE').removesuffix('.txt')}.bin"

do_configure () {
}

do_compile () {
    mipi-dbi-cmd \
        "${WORKDIR}/${PANEL_FIRMWARE_BIN}" \
        "${WORKDIR}/${PANEL_FIRMWARE}"
}

do_install () {
    install -m 0644 -D \
        "${WORKDIR}/${PANEL_FIRMWARE_BIN}" \
        "${D}${nonarch_base_libdir}/firmware/${PANEL_FIRMWARE_BIN}"
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/"
