# umpf-base: v6.4
# umpf-name: 6.4/customers/lxa/lxatac
# umpf-version: 6.4/customers/lxa/lxatac/20230627-1
# umpf-topic: v6.4/customers/lxa/lxatac
# umpf-hashinfo: 927820f53568ba95758663f0de98d7cbd7d9b911
# umpf-topic-range: 6995e2de6891c724bfeb2db33d7b87775f913ad1..678243c254e6835b25e29f8ccf8a52d6b67174b1
SRC_URI += "\
  file://patches/0001-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0002-leds-trigger-tty-Use-led_set_brightness_nosleep-from.patch \
  "
# umpf-topic: v6.4/topic/lxa-tac-dts-mainlining
# umpf-hashinfo: 43263feecafa4a0443b19179931545b2a055427f
# umpf-topic-range: 678243c254e6835b25e29f8ccf8a52d6b67174b1..a42d782080c1185c058d7957c3270cf81a07927a
SRC_URI += "\
  file://patches/0101-dt-bindings-vendor-prefixes-Add-prefix-for-ShineWorl.patch \
  file://patches/0102-dt-bindings-display-panel-mipi-dbi-spi-add-shineworl.patch \
  file://patches/0103-dt-bindings-display-panel-mipi-dbi-spi-add-spi-3wire.patch \
  file://patches/0104-dt-bindings-can-m_can-change-from-additional-to-unev.patch \
  file://patches/0105-dt-bindings-net-dsa-microchip-add-interrupts-propert.patch \
  file://patches/0106-ARM-dts-stm32-Add-pinmux-groups-for-Linux-Automation.patch \
  file://patches/0107-dt-bindings-arm-stm32-Add-compatible-string-for-Linu.patch \
  file://patches/0108-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  "
# umpf-topic: v6.4/topic/pwm-stm32
# umpf-hashinfo: 8b37f8455f4ff559c4ab91dd240329fe68ca606e
# umpf-topic-range: a42d782080c1185c058d7957c3270cf81a07927a..0e7415245e0ccca6b31a1fd6aaf3a243d5993843
SRC_URI += "\
  file://patches/0201-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.4/topic/pwm-backlight
# umpf-hashinfo: f5aa96f6c59d482b4d67776b4c79746b5567b92a
# umpf-topic-range: 0e7415245e0ccca6b31a1fd6aaf3a243d5993843..2defd6502d2b3f5251749f9f621e69f5b2bca5e7
SRC_URI += "\
  file://patches/0301-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-release: 6.4/customers/lxa/lxatac/20230627-1
# umpf-topic-range: 2defd6502d2b3f5251749f9f621e69f5b2bca5e7..c47d8de008eda2fd9248482ee04d40f32ad0a85b
SRC_URI += "\
  file://patches/0401-Release-6.4-customers-lxa-lxatac-20230627-1.patch \
  "
# umpf-end
