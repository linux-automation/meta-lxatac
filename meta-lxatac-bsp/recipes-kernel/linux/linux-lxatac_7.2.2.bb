inherit kernel

SECTION = "kernel"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v7.x/linux-${PV}.tar.xz \
           file://0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
           file://0002-iio-iio_triggered_buffer_setup_ext-request-IRQF_ONES.patch \
           file://defconfig \
           "

SRC_URI[sha256sum] = "7d0e7ce14f98c43efe880cffbf354a59be45928fdf7170d7333c374ae91c0d83"

require recipes-kernel/linux/cve-exclusion.inc

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

# ${S} is not overridden, so it is the shared kernel source directory
# (${STAGING_KERNEL_DIR}) set by kernel.bbclass, like in linux-yocto.
# The kernel tarball, however, unpacks to ${UNPACKDIR}/linux-${PV}, so
# move the unpacked source tree into ${S}. This keeps the source tree
# directly in the shared location instead of relying on the move +
# symlink workaround of do_symlink_kernsrc (which leaves a symlink in
# ${WORKDIR} pointing into the shared source tree).
python do_unpack:append() {
    # do_unpack's cleandirs leaves ${S} behind as an empty directory,
    # remove it so the source tree is moved to ${S} itself instead of
    # into it. This fails loudly in do_unpack if the tarball does not
    # unpack to the expected directory.
    bb.utils.remove(d.getVar('S'), True)
    bb.utils.rename(d.getVar('UNPACKDIR') + "/linux-" + d.getVar('PV'),
                    d.getVar('S'))
}

do_copy_fw() {
    mkdir -p ${S}/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${S}/firmware/
}

addtask copy_fw after do_configure before do_compile
