SUMMARY = "barebox bootloader -- host and target tools"
HOMEPAGE = "https://barebox.org/"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=f5125d13e000b9ca1f0d3364286c4192"

DEPENDS = "libusb1 libusb1-native lzop-native bison-native flex-native pkgconfig-native"
BBCLASSEXTEND = "native"

SRC_URI = "http://barebox.org/download/barebox-${PV}.tar.bz2"
SRC_URI[sha256sum] = "955b20bfa7358732d2c0c09ccfd4c1a69087b7e2c610b16dee7442d71a5af88d"

S = "${WORKDIR}/barebox-${PV}"

EXTRA_OEMAKE = " \
    ARCH=sandbox \
    CROSS_COMPILE=${TARGET_PREFIX} -C ${S} O=${B} \
    CROSS_PKG_CONFIG=pkg-config \
    "

do_compile:class-target () {
    export userccflags="${TARGET_CC_ARCH}${TOOLCHAIN_OPTIONS}"
    # we need TUNE_CCARGS to ensure that we link against the correct ld-linux
    # for our ABI (/usr/lib/ld-linux.so.3 vs. /usr/lib/ld-linux-armhf.so.3)
    export userldflags="${TARGET_LDFLAGS}${TUNE_CCARGS}${TOOLCHAIN_OPTIONS}"
    oe_runmake targettools_defconfig
    oe_runmake scripts
}

do_compile:class-native () {
    oe_runmake hosttools_defconfig
    oe_runmake scripts
}

TOOLS = " \
    bareboxenv \
    bareboxcrc32 \
    kernel-install \
    bareboximd \
    omap3-usb-loader \
    omap4_usbboot \
    imx/imx-usb-loader \
    kwboot \
    rk-usb-loader \
"

do_install:class-target () {
    install -d -m 0755 ${D}${bindir}/

    for tool in ${TOOLS}; do
        # install files leaving out -target suffix and stripping
        # components before / from target path
        install -m 0755 ${B}/scripts/${tool}-target ${D}${bindir}/${tool##*/}
    done
}

do_install:class-native () {
    install -d -m 0755 ${D}${bindir}/

    for tool in ${TOOLS}; do
        # install files stripping components before / from target path
        install -m 0755 ${B}/scripts/${tool} ${D}${bindir}/${tool##*/}
    done
}
