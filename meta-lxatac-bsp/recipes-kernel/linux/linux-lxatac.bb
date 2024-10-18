inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v6.x/linux-${LINUX_VERSION}.tar.xz \
           file://defconfig \
           "

SRC_URI[sha256sum] = "55d2c6c025ebc27810c748d66325dd5bc601e8d32f8581d9e77673529bdacb2e"

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
