SUMMARY = "ARM Trusted Firmware-A"
DESCRIPTION = " \
    Trusted Firmware-A (TF-A) is a reference implementation of secure world \
    software for Arm A-Profile architectures (Armv8-A and Armv7-A), including \
    an Exception Level 3 (EL3) Secure Monitor. It provides a suitable starting \
    point for productization of secure world boot and runtime firmware, in \
    either the AArch32 or AArch64 execution states. \
"
HOMEPAGE = "https://developer.trustedfirmware.org/dashboard/view/6/"
SECTION = "bootloaders"

LICENSE = " \
    BSD-3-Clause & \
    BSD-2-Clause & \
    (GPL-2.0-only | GPL-3.0-only | BSD-2-Clause) & \
    (NCSA | MIT) & \
    Zlib & \
    (GPL-2.0-only | GPL-3.0-only | BSD-3-Clause) \
"
LIC_FILES_CHKSUM = "file://docs/license.rst;md5=713afe122abbe07f067f939ca3c480c5"

DEPENDS = "dtc-native"
PROVIDES = "virtual/ARM-tf-a"

SRC_URI = "https://git.trustedfirmware.org/TF-A/trusted-firmware-a.git/snapshot/${PV}.tar.gz"

S = "${WORKDIR}/${PV}"
B = "${WORKDIR}/build"

inherit deploy

COMPATIBLE_MACHINE = "none"
PLATFORM = "none"

EXTRA_OEMAKE = " \
    BUILD_BASE=${B} \
    CROSS_COMPILE=${TARGET_PREFIX} \
    PLAT=${PLATFORM} \
    DEBUG=0 \
    LOG_LEVEL=40 \
"

do_compile() {
    export TARGETCFLAGS="${TARGET_LDFLAGS}${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}"
    export TF_LDFLAGS=" -z noexecstack --no-warn-rwx-segment "
    unset LDFLAGS
    unset CFLAGS
    unset CPPFLAGS
    unset CXXFLAGS
    unset MACHINE

    oe_runmake -C ${S} all
}

do_deploy[vardepsexclude] = "DATETIME"
do_deploy() {
    install -d "${DEPLOYDIR}"
    cd ${B}/${PLATFORM}/release
    for IMAGE in ${TFA_IMAGES}; do
        TFA_IMAGE_EXT="${IMAGE##*.}"
        TFA_IMAGE_BASENAME=$(basename "${IMAGE}" ."${TFA_IMAGE_EXT}")
        TFA_IMAGE_WITH_DATE="${TFA_IMAGE_BASENAME}-${DATETIME}.${TFA_IMAGE_EXT}"
        install -m 644 -T "${IMAGE}" "${DEPLOYDIR}/${TFA_IMAGE_WITH_DATE}"
        ln -sf "${TFA_IMAGE_WITH_DATE}" "${DEPLOYDIR}/${TFA_IMAGE_BASENAME}.${TFA_IMAGE_EXT}"
    done
}

addtask deploy after do_compile

PACKAGE_ARCH = "${MACHINE_ARCH}"
