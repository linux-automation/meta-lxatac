DEPENDS = "panel-mipi-dbi-native"

PANEL_FIRMWARE_BIN ?= "${@d.getVar('PANEL_FIRMWARE').removesuffix('.txt')}.bin"

do_configure[noexec] = "1"

do_compile () {
    mipi-dbi-cmd \
        "${UNPACKDIR}/${PANEL_FIRMWARE_BIN}" \
        "${UNPACKDIR}/${PANEL_FIRMWARE}"
}

do_install () {
    install -m 0644 -D \
        "${UNPACKDIR}/${PANEL_FIRMWARE_BIN}" \
        "${D}${nonarch_base_libdir}/firmware/${PANEL_FIRMWARE_BIN}"
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/"
