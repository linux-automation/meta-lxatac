SUMMARY = "eMMC image for the LXATAC Boot Partitions"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "fiptool-native"

SRC_URI += "file://genimage.config"

inherit genimage

COMPATIBLE_MACHINE = "lxatac"

GENIMAGE_IMAGE_SUFFIX = ""

# Backport from https://github.com/pengutronix/meta-ptx/pull/105
# Create image-name-${timestamp}.img -> image-name.img symlinks for everything
# that includes @IMAGE@ in its name, not only @IMAGE@ itself.
do_deploy () {
    install ${B}/* ${DEPLOYDIR}/

    for img in ${B}/*; do
        img=$(basename "${img}")
        case "$img" in *"${GENIMAGE_IMAGE_FULLNAME}"*)
            ln -sf ${img} \
                ${DEPLOYDIR}/$(echo "${img}" | sed "s/${GENIMAGE_IMAGE_FULLNAME}/${GENIMAGE_IMAGE_LINK_FULLNAME}/")
        esac
    done
}

do_genimage[depends] += " \
    virtual/bootloader:do_deploy \
    tf-a-stm32mp:do_deploy \
"
