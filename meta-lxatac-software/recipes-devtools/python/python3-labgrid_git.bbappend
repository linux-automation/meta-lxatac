FILESEXTRAPATHS:prepend := "${THISDIR}/python3-labgrid:" 

SRC_URI += "file://userconfig.yaml \
            file://labgrid.conf \
            "

SRCREV = "6b541210c6063e97d81e257d2d6bda1444d9ec78"

RDEPENDS:${PN} += " \
    python3-grpcio \
    python3-grpcio-reflection \
    python3-grpcio-channelz \
"
RDEPENDS:${PN}:remove = "python3-autobahn"

do_install:append() {
    # The userconfig.yaml is migrated via rauc hook between installs.
    # Deploy a copy of the file so that users can go back to a default config
    # or see what's new.
    install -D -m 0644 ${WORKDIR}/userconfig.yaml ${D}${sysconfdir}/labgrid/userconfig.yaml
    install -D -m 0644 ${WORKDIR}/userconfig.yaml ${D}${sysconfdir}/labgrid/userconfig.yaml.default

    install -D -m 0644 ${WORKDIR}/labgrid.conf ${D}${libdir}/tmpfiles.d/labgrid.conf
}

FILES:${PN} += "${libdir}/tmpfiles.d"
