inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

PR = "r0"
PV = "6.1.8"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v6.x/linux-${PV}.tar.xz \
           file://defconfig \
           "

require files/patches/series.inc

S = "${WORKDIR}/linux-${PV}"

SRC_URI[sha256sum] = "b60bb53ab8ba370a270454b11e93d41af29126fc72bd6ede517673e2e57b816d"

COMPATIBLE_MACHINE = "lxatac"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""
