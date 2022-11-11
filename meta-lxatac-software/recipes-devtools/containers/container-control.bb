LICENSE = "CLOSED"

inherit allarch

RDEPENDS_${PN} = " \
    podman \
    wget \
"

SRC_URI = " \
    file://container-start.sh \
    file://container-update.sh \
"

do_install() {
    install -D -m0755 ${WORKDIR}/container-start.sh ${D}${bindir}/container-start
    install -D -m0755 ${WORKDIR}/container-update.sh ${D}${bindir}/container-update
}

FILES_${PN} = "${bindir}"
