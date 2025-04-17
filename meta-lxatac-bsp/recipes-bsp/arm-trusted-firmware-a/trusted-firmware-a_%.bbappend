FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "lxatac"

DEPENDS = "dtc-native"

TFA_PLATFORM = "stm32mp1"
TFA_BUILD_TARGET = "all"
# Binaries
TFA_INSTALL_TARGET = "tf-a-stm32mp157c-lxa-tac.stm32 bl32"
# DTBs
TFA_INSTALL_TARGET += "stm32mp157c-lxa-tac-bl32 stm32mp157c-lxa-tac-fw-config"

# TODO: Support specifying DTB_FILE_NAME in meta-arm
TFA_DTB_NAME = "stm32mp157c-lxa-tac.dtb"

# TODO: Add upstream TF-A support so we can drop the downstream patches and
#       get rid of the compile switches.
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
