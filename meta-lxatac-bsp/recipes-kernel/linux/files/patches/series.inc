# umpf-base: v6.2
# umpf-name: 6.2/customers/lxa/lxatac
# umpf-version: 6.2/customers/lxa/lxatac/20230220-1
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
# umpf-release: 6.2/customers/lxa/lxatac/20230220-1
# umpf-topic-range: 474e5c8135cd3eb7ae29c9dd945cfecdb7bcc70e..b86b48f9884894b255593a4d90404cdc8cb23308
SRC_URI += "\
  file://patches/0201-Release-6.2-customers-lxa-lxatac-20230220-1.patch \
  "
# umpf-end
