inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

PR = "r0"
PV = "6.4"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;branch=master \
           file://defconfig \
           "

SRCREV = "6995e2de6891c724bfeb2db33d7b87775f913ad1"

require files/patches/series.inc

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "lxatac"

RDEPENDS:${KERNEL_PACKAGE_NAME}-base = ""

DEPENDS:append = "panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${S}/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${S}/firmware/
}

addtask copy_fw after do_configure before do_compile
