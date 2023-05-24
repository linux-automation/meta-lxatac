LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://repart.d \
    file://ordering.conf \
    "

S = "${WORKDIR}"

do_install () {
    install -d ${D}${libdir}/systemd/system/systemd-repart.service.d/
    install -m 0644 -t ${D}${libdir}/systemd/system/systemd-repart.service.d/ ${S}/*.conf
    install -d ${D}${libdir}/repart.d/
    install -m 0644 -t ${D}${libdir}/repart.d/ ${S}/repart.d/*
}

FILES:${PN} = " \
    ${libdir}/repart.d \
    ${libdir}/systemd/system/systemd-repart.service.d \
    "

