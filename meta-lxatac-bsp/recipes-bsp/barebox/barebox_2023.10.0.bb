require recipes-bsp/barebox/barebox.inc

SRC_URI += " \
    file://defconfig \
    file://env \
"
require files/patches/series.inc

SRC_URI[sha256sum] = "07823aa3cdc083087788a1cccded99a15a250746e259c2ff905dc48f8d9f409a"

COMPATIBLE_MACHINE = "lxatac"

BAREBOX_IMAGES = "*.stm32"

# barebox DTs are needed in the FIP image, so deploy all built DTs as barebox-*.dtb
BAREBOX_DTBS_TO_DEPLOY = "arch/arm/dts/*.dtb"

do_deploy:append () {
	for DTB in ${BAREBOX_DTBS_TO_DEPLOY}; do
		if [ -e ${DTB} ]; then
			BAREBOX_DTB_BASENAME=barebox-$(basename ${DTB} .dtb)${BAREBOX_IMAGE_SUFFIX}
			install -m 644 -T ${DTB} ${DEPLOYDIR}/${BAREBOX_DTB_BASENAME}-${DATETIME}.dtb
			ln -sf ${BAREBOX_DTB_BASENAME}-${DATETIME}.dtb ${DEPLOYDIR}/${BAREBOX_DTB_BASENAME}.dtb
		fi
	done
}

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${WORKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${WORKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
