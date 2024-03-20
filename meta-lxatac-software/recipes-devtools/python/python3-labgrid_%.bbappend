FILESEXTRAPATHS:prepend := "${THISDIR}/python3-labgrid:" 

SRC_URI:remove = "git://github.com/labgrid-project/labgrid.git;protocol=https;branch=stable-23.0"

SRC_URI += "git://github.com/labgrid-project/labgrid.git;protocol=https;branch=master \
            file://userconfig.yaml \
            file://labgrid.conf \
            file://0001-resource-udev-add-new-USB-ID-for-IMXUSBLoader.patch \
            "

SRCREV = "3e1c0df0a3503d6f22e63a50ae45945ed12b69f8"

do_install:append() {
    # The userconfig.yaml is migrated via rauc hook between installs.
    # Deploy a copy of the file so that users can go back to a default config
    # or see what's new.
    install -D -m 0644 ${WORKDIR}/userconfig.yaml ${D}${sysconfdir}/labgrid/userconfig.yaml
    install -D -m 0644 ${WORKDIR}/userconfig.yaml ${D}${sysconfdir}/labgrid/userconfig.yaml.default

    install -D -m 0644 ${WORKDIR}/labgrid.conf ${D}${libdir}/tmpfiles.d/labgrid.conf
}

FILES:${PN} += "${libdir}/tmpfiles.d"
