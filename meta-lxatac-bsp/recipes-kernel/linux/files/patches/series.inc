# umpf-base: v6.2
# umpf-name: 6.2/customers/lxa/lxatac-lcd
# umpf-version: 6.2/customers/lxa/lxatac-lcd/20230220-1
# umpf-topic: v6.2/topic/ti-lmp92064-adc
# umpf-hashinfo: 8c50518d88c052cb91bc739e9528e80ca7c4a835
# umpf-topic-range: c9c3395d5e3dcc6daee66c6908354d47bf98cb0c..d5bbd0f5c302ca29a73417ac4fa52a8c3ef38531
SRC_URI += "\
  file://patches/0001-dt-bindings-iio-adc-add-TI-LMP92064-controller.patch \
  file://patches/0002-iio-adc-add-ADC-driver-for-the-TI-LMP92064-controlle.patch \
  "
# umpf-topic: v6.2/customers/lxa/lxatac
# umpf-hashinfo: 92939aeea31924eaea122ac3285055c596d4114a
# umpf-topic-range: d5bbd0f5c302ca29a73417ac4fa52a8c3ef38531..474e5c8135cd3eb7ae29c9dd945cfecdb7bcc70e
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-Add-coprocessor-detach-mbox-on-stm32mp.patch \
  file://patches/0102-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0103-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  "
# umpf-topic: v6.2/topic/stm32mp1-spi
# umpf-hashinfo: 57897a31e9ea63d1b2000af373205efa76849756
# umpf-topic-range: 474e5c8135cd3eb7ae29c9dd945cfecdb7bcc70e..ce6855141ea0523c92445a0912723ed50985a385
SRC_URI += "\
  file://patches/0201-spi-core-add-spi_split_transfers_maxwords.patch \
  file://patches/0202-spi-stm32-split-large-transfers-based-on-word-size-i.patch \
  "
# umpf-topic: v6.2/topic/lxatac-lcd
# umpf-hashinfo: 2e17436957b04a7835a0a41f7eace162a1706041
# umpf-topic-range: ce6855141ea0523c92445a0912723ed50985a385..214085a11144acec4d5a5e3ecd0f47692001a4a0
SRC_URI += "\
  file://patches/0301-ARM-dts-stm32-lxa-tac-switch-from-OLED-to-LCD.patch \
  file://patches/0302-ARM-dts-stm32-lxa-tac-Enable-TE-pin-and-up-SPI-freq-.patch \
  file://patches/0303-ARM-dts-stm32-lxa-tac-Add-Backlight-for-LCD.patch \
  "
# umpf-release: 6.2/customers/lxa/lxatac-lcd/20230220-1
# umpf-topic-range: 214085a11144acec4d5a5e3ecd0f47692001a4a0..b852832ac0c009e134817f4b09454f4b856750a7
SRC_URI += "\
  file://patches/0401-Release-6.2-customers-lxa-lxatac-lcd-20230220-1.patch \
  "
# umpf-end
