LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

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
