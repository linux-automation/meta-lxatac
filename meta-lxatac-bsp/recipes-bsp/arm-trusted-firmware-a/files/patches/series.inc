# umpf-base: v2.7
# umpf-name: 2.7/customers/lxa/tac
# umpf-version: 2.7/customers/lxa/tac/20220726-1
# umpf-topic: v2.7/customers/lxa/tac
# umpf-hashinfo: 01add11ce2cba0c1c70601f282357731f0774114
# umpf-topic-range: 35f4c7295bafeb32c8bcbdfb6a3f2e74a57e732b..82d65342502fc88dea8572f2696656909cf85f45
SRC_URI += "\
  file://patches/0001-fdts-add-lxa-tac.patch \
  file://patches/0002-lxatac-ETH-PLL-configuration.patch \
  file://patches/0003-lxatac-use-custom-PLL-configuration.patch \
  "
# umpf-topic: v2.7/topic/stm32mp1-ddr-regulator-fix
# umpf-hashinfo: f4d4acf18fd7912cb75b3efc2cbdaa2c4a58dfce
# umpf-topic-range: 82d65342502fc88dea8572f2696656909cf85f45..2ae6db960dac8636404b6a83de598b782a281d54
SRC_URI += "\
  file://patches/0101-fix-stm32mp1-fdts-stm32mp1-align-DDR-regulators-with.patch \
  "
# umpf-topic: v2.7/topic/stm32mp-emmc-boot-fip
# umpf-hashinfo: ca76e3c8c61a38d738324178fa723b3fd8b19caa
# umpf-topic-range: 2ae6db960dac8636404b6a83de598b782a281d54..c00fc3773c634f1d5d60d99f8163d5b71e38a19e
SRC_URI += "\
  file://patches/0201-refactor-mmc-export-user-boot-partition-switch-funct.patch \
  file://patches/0202-refactor-mmc-replace-magic-value-with-new-PART_CFG_B.patch \
  file://patches/0203-feat-stm32mp1-extend-STM32MP_EMMC_BOOT-support-to-FI.patch \
  "
# umpf-end
