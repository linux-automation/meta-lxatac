FILESEXTRAPATHS:prepend := "${THISDIR}/files:" 

do_install:append() {
    # NetworkManager dispatcher scripts
    install -d ${D}${nonarch_libdir}/NetworkManager/dispatcher.d
    install -m 0755 ${S}/examples/chrony.nm-dispatcher.dhcp ${D}${nonarch_libdir}/NetworkManager/dispatcher.d/
    install -m 0755 ${S}/examples/chrony.nm-dispatcher.onoffline ${D}${nonarch_libdir}/NetworkManager/dispatcher.d/
}

FILES:${PN} += " ${nonarch_libdir}/NetworkManager/dispatcher.d "
