SUMMARY = "Use systemd's update mechanism to only re-partition the disk after image install"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://repart.d \
    file://ordering.conf \
    file://repart-before-tmpfiles.conf \
    "

S = "${WORKDIR}"

RDEPENDS:${PN} = "systemd"

do_install () {
    install -d ${D}${libdir}/systemd/system/systemd-repart.service.d/
    install -m 0644 -t ${D}${libdir}/systemd/system/systemd-repart.service.d/ ${S}/*.conf
    install -d ${D}${libdir}/repart.d/
    install -m 0644 -t ${D}${libdir}/repart.d/ ${S}/repart.d/*

    # The presence of a /system-update file/symlink is checked by
    # systemd-system-update-generator.
    # If it exists the boot process is redirected to system-update.target
    # instead of default.target.
    # This allows us to repart the eMMC without interference from other
    # services.
    touch ${D}/system-update
}

FILES:${PN} = " \
    /system-update \
    ${libdir}/repart.d \
    ${libdir}/systemd/system/systemd-repart.service.d \
    "

