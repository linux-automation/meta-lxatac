FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://defconfig \
    file://env \
"

# Release commit created 2026-03-17 14:53:18 +0100
PV = "2026.03.1"
SRC_URI[sha256sum] = "9e4b23720016bb934dc5ea36d4c33886a8a295445d290b99993d0b32caab6469"

COMPATIBLE_MACHINE = "lxatac"

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${UNPACKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${UNPACKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
