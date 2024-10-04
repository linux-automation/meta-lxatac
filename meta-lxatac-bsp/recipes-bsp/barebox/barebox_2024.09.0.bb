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

SRC_URI[sha256sum] = "4d4ea7e232aeba2b3cb9ccf0dbf8cd8e01c65b6c615f64c3bd0c4f24f23a47da"

COMPATIBLE_MACHINE = "lxatac"

# barebox DTs are needed in the FIP image, so deploy all built DTs as barebox-*.dtb
BAREBOX_DTBS_TO_DEPLOY = "arch/arm/dts/*.dtb"

do_deploy:append () {
	for DTB in ${BAREBOX_DTBS_TO_DEPLOY}; do
		if [ -e ${DTB} ]; then
			BAREBOX_DTB_BASENAME=barebox-$(basename ${DTB} .dtb)${BAREBOX_IMAGE_SUFFIX}
			install -m 644 -T ${DTB} ${DEPLOYDIR}/${BAREBOX_DTB_BASENAME}.dtb
		fi
	done
}

DEPENDS:append = " panel-shineworld-lh133k"

do_copy_fw() {
    mkdir -p ${UNPACKDIR}/env/firmware/
    cp ${RECIPE_SYSROOT}${nonarch_base_libdir}/firmware/shineworld,lh133k.bin ${UNPACKDIR}/env/firmware/
}

addtask copy_fw after do_configure before do_compile
