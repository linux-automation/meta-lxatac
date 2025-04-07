# Use a local barebox.inc (instead of the one from meta-ptx that we have
# used before) that matches closely what will likely be included in oe-core
# soon. The file was taken from
# https://lore.kernel.org/all/20230425184720.456896-2-ejo@pengutronix.de/
# This should be changed to use the barebox.inc from oe-core once it is
# included.
require barebox.inc

SRC_URI += " \
    file://defconfig \
    file://env \
"
require files/patches/series.inc

SRC_URI[sha256sum] = "955b20bfa7358732d2c0c09ccfd4c1a69087b7e2c610b16dee7442d71a5af88d"

COMPATIBLE_MACHINE = "lxatac"

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${WORKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${WORKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
