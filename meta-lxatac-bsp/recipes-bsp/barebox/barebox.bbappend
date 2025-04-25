FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://defconfig \
    file://env \
"
require files/patches/series.inc

PV = "2024.10.0"
SRC_URI[sha256sum] = "955b20bfa7358732d2c0c09ccfd4c1a69087b7e2c610b16dee7442d71a5af88d"

COMPATIBLE_MACHINE = "lxatac"

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${UNPACKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${UNPACKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
