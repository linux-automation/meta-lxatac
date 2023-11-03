SUMMARY = "eMMC image for the LXATAC Data Partitions"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "genext2fs-native e2fsprogs-native"

SRC_URI += "file://genimage.config"

inherit genimage

COMPATIBLE_MACHINE = "lxatac"

GENIMAGE_IMAGE_SUFFIX = ""

# This can be removed once we have a genimage with fill= support
GENIMAGE_VARIABLES[WORKDIR] = "${WORKDIR}"

do_configure:append() {
    # This can be removed once we have a genimage with fill= support.
    # Just using /dev/zero in the genimage config does not work because ...
    #
    # $ python3
    # >>> import os
    # >>> os.stat("/dev/zero")
    # os.stat_result(st_mode=8630 ... st_size=0 ..)
    #
    # ... /dev/zero has 0 size and genimage only writes st_size bytes of
    # the file into the image and leaves the rest sparse.
    dd if=/dev/zero bs=1024 count=256 of=${WORKDIR}/state-filler.img
}

do_genimage[depends] += " \
    lxatac-core-image-base:do_image_complete \
"
