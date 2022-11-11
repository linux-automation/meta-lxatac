inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

PR = "r0"
PV = "6.0"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v6.x/linux-${PV}.tar.xz \
           file://defconfig \
           "

require files/patches/series.inc

S = "${WORKDIR}/linux-${PV}"

SRC_URI[sha256sum] = "5c2443a5538de52688efb55c27ab0539c1f5eb58c0cfd16a2b9fbb08fd81788e"

COMPATIBLE_MACHINE = "lxatac"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""
