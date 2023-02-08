inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

PR = "r0"
PV = "6.2"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v6.x/linux-${PV}.tar.xz \
           file://defconfig \
           "

require files/patches/series.inc

S = "${WORKDIR}/linux-${PV}"

SRC_URI[sha256sum] = "74862fa8ab40edae85bb3385c0b71fe103288bce518526d63197800b3cbdecb1"

COMPATIBLE_MACHINE = "lxatac"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""
