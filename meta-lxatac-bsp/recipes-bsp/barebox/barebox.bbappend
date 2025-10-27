FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://defconfig \
    file://env \
"

PV = "2025.10.0"
SRC_URI[sha256sum] = "f7587d576637e46151333dff5bff0423869a5f9f6a9e4439c19c2429d983b84e"

COMPATIBLE_MACHINE = "lxatac"

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${UNPACKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${UNPACKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
