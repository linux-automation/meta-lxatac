inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI = "https://git.kernel.org/torvalds/t/linux-${LINUX_VERSION}.tar.gz \
           file://defconfig \
           "

SRC_URI[sha256sum] = "99c5fd53a51377f3a7faf9a1aa1700465773562720d1fc9c4399caceac268f7a"

ERROR_QA:remove = "patch-status"

require files/patches/series.inc

PV = "${UMPF_PV}"
S = "${WORKDIR}/linux-${LINUX_VERSION}"

COMPATIBLE_MACHINE = "lxatac"

# The coreutils-native dependency is required since kernel 6.11,
# which uses the `truncate` tool in a script.
# It can likely be removed again once the kernel.bbclass is updated.
DEPENDS:append = " panel-shineworld-lh133k coreutils-native"

# Some options depend on CONFIG_PAHOLE_VERSION, so need to make pahole-native available before do_kernel_configme
do_kernel_configme[depends] += "pahole-native:do_populate_sysroot"

do_copy_fw() {
    mkdir -p ${S}/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${S}/firmware/
}

addtask copy_fw after do_configure before do_compile
