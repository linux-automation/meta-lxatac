LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SUMMARY = "Export USB Gadget functions over the TAC USB-C connector"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INHIBIT_DEFAULT_DEPS = "1"

RDEPENDS:${PN} = " \
    bash \
"

SRC_URI = " \
    file://gadget-audio.sh \
    file://gadget-common.sh \
    file://gadget-ethernet-serial.sh \
    file://gadget-ethernet-storage.sh \
    file://gadget-ethernet.sh \
    file://gadget-hid-storage.sh \
    file://gadget-hid.sh \
    file://gadget-remove.sh \
    file://gadget-reports.sh \
    file://gadget-serial-storage.sh \
    file://gadget-serial.sh \
    file://gadget-storage.sh \
"

do_install () {
    install -D -m0644 ${WORKDIR}/gadget-common.sh ${D}${datadir}/gadget/gadget-common
    install -D -m0644 ${WORKDIR}/gadget-reports.sh ${D}${datadir}/gadget/gadget-reports

    install -D -m0755 ${WORKDIR}/gadget-audio.sh ${D}${bindir}/tac-gadget-audio
    install -D -m0755 ${WORKDIR}/gadget-ethernet-serial.sh ${D}${bindir}/tac-gadget-ethernet-serial
    install -D -m0755 ${WORKDIR}/gadget-ethernet-storage.sh ${D}${bindir}/tac-gadget-ethernet-storage
    install -D -m0755 ${WORKDIR}/gadget-ethernet.sh ${D}${bindir}/tac-gadget-ethernet
    install -D -m0755 ${WORKDIR}/gadget-hid-storage.sh ${D}${bindir}/tac-gadget-hid-storage
    install -D -m0755 ${WORKDIR}/gadget-hid.sh ${D}${bindir}/tac-gadget-hid
    install -D -m0755 ${WORKDIR}/gadget-remove.sh ${D}${bindir}/tac-gadget-remove
    install -D -m0755 ${WORKDIR}/gadget-serial-storage.sh ${D}${bindir}/tac-gadget-serial-storage
    install -D -m0755 ${WORKDIR}/gadget-serial.sh ${D}${bindir}/tac-gadget-serial
    install -D -m0755 ${WORKDIR}/gadget-storage.sh ${D}${bindir}/tac-gadget-storage
}

FILES:${PN} = "${bindir} ${datadir}"
