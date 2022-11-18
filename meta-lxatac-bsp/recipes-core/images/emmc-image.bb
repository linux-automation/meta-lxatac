SUMMARY = "eMMC image for the LXATAC Data Partitions"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "genext2fs-native e2fsprogs-native"

SRC_URI += "file://genimage.config"

inherit genimage

COMPATIBLE_MACHINE = "lxatac"

GENIMAGE_IMAGE_SUFFIX = ""
GENIMAGE_ROOTFS_IMAGE = "lxatac-core-image-base"
GENIMAGE_ROOTFS_IMAGE_FSTYPE = "tar"

do_genimage[depends] += " \
    ${GENIMAGE_ROOTFS_IMAGE}:do_image_complete \
"
