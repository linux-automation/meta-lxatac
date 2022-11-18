SUMMARY = "eMMC image for the LXATAC Boot Partitions"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "fiptool-native"

SRC_URI += "file://genimage.config"

inherit genimage

COMPATIBLE_MACHINE = "lxatac"

GENIMAGE_IMAGE_SUFFIX = ""

do_genimage[depends] += " \
    virtual/bootloader:do_deploy \
    tf-a-stm32mp:do_deploy \
"
