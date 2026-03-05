inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v7.x/linux-${PV}.tar.xz \
           file://0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
           file://defconfig \
           "

SRC_URI[sha256sum] = "094977eb62c20e3d1939fe81a92958a1f987f339446e532fa86963b2804e32dc"

require recipes-kernel/linux/cve-exclusion.inc

S = "${UNPACKDIR}/linux-${PV}"

COMPATIBLE_MACHINE = "lxatac"

# Track which files are compiled in so we can ignore CVEs that only
# affect files we do not build.
SPDX_INCLUDE_COMPILED_SOURCES = "1"

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
