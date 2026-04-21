FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://defconfig \
    file://env \
"

# Release commit created 2026-04-17 14:28:49 +0200
PV = "2026.04.0"
SRC_URI[sha256sum] = "07fd3e3440c23e27d0094432f67827887fcc0e37d5fe24dc257c39b97c4294a0"

COMPATIBLE_MACHINE = "lxatac"

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${UNPACKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${UNPACKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
