SUMMARY = "Rockchip Development Tool"
DESCRIPTION = "Communicate with the Rockchip Boot ROM to upload new software \
               read/write to memory locations and reset the device."
HOMEPAGE = "https://github.com/rockchip-linux/rkdeveloptool"
SECTION = "devel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://license.txt;md5=ea9445d9cc03d508cf6bb769d15a54ef"

SRC_URI = "git://github.com/rockchip-linux/rkdeveloptool.git;protocol=https;branch=${SRCBRANCH} \
           file://0001-Makefile-disable-format-truncation-errors.patch \
           "

S = "${WORKDIR}/git"

DEPENDS = "libusb1 udev"

inherit autotools pkgconfig
