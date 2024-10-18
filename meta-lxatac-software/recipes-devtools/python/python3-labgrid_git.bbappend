FILESEXTRAPATHS:prepend := "${THISDIR}/python3-labgrid:" 

SRC_URI += "file://userconfig.yaml \
            file://labgrid.conf \
            "

SRCREV = "e5ace1a36c4e552b950cf356ce0e34586f776432"

do_install:append() {
    # The userconfig.yaml is migrated via rauc hook between installs.
    # Deploy a copy of the file so that users can go back to a default config
    # or see what's new.
    install -D -m 0644 ${UNPACKDIR}/userconfig.yaml ${D}${sysconfdir}/labgrid/userconfig.yaml
    install -D -m 0644 ${UNPACKDIR}/userconfig.yaml ${D}${sysconfdir}/labgrid/userconfig.yaml.default

    install -D -m 0644 ${UNPACKDIR}/labgrid.conf ${D}${libdir}/tmpfiles.d/labgrid.conf
}

FILES:${PN} += "${libdir}/tmpfiles.d"
