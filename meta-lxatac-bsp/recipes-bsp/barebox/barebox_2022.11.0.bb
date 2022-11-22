require recipes-bsp/barebox/barebox.inc

SRC_URI += " \
    file://defconfig \
    file://env \
"
require files/patches/series.inc

SRC_URI[sha256sum] = "d026885b8b541def59b44d691b8c52ff4d19c61ba5d0de96afee9b93a19ecffe"

COMPATIBLE_MACHINE = "lxatac"

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
