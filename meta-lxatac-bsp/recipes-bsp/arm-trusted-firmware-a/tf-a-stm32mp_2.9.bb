require arm-trusted-firmware-a.inc

SUMMARY = "ARM Trusted Firmware-A for STM32MP1"
LIC_FILES_CHKSUM = "file://docs/license.rst;md5=b2c740efedc159745b9b31f88ff03dde"

SRC_URI[sha256sum] = "bca3d122ae4552677a77a70076bb229fa8b8c0358ab85ec964666bb386a9cf1b"


COMPATIBLE_MACHINE = "lxatac"
PLATFORM = "stm32mp1"

require files/patches/series.inc

EXTRA_OEMAKE:append = " \
    ARCH=aarch32 \
    ARM_ARCH_MAJOR=7 \
    AARCH32_SP=sp_min \
    STM32MP_SDMMC=1 \
    STM32MP_EMMC=1 \
    STM32MP_EMMC_BOOT=1 \
    STM32MP_USB_PROGRAMMER=1 \
    STM32MP_RAW_NAND=0 \
    STM32MP_SPI_NAND=0 \
    STM32MP_SPI_NOR=0 \
    DTB_FILE_NAME=${TFA_DTB_NAME} \
"
