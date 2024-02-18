inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

PV = "6.7"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v6.x/linux-${PV}.tar.xz \
           file://defconfig \
           "

SRC_URI[sha256sum] = "ef31144a2576d080d8c31698e83ec9f66bf97c677fa2aaf0d5bbb9f3345b1069"

require files/patches/series.inc

S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_MACHINE = "lxatac"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${S}/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${S}/firmware/
}

addtask copy_fw after do_configure before do_compile
