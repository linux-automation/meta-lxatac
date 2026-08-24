FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://defconfig \
    file://env \
"

# Release commit created 2026-08-24 15:10:36 +0200
PV = "2026.08.0"
SRC_URI[sha256sum] = "5b270cbde7f2fc6a78ff6e748eef788bbc04571682e2f2e964cd15a2e009774c"

COMPATIBLE_MACHINE = "lxatac"

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${UNPACKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${UNPACKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
