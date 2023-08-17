# umpf-base: v6.5
# umpf-name: 6.5/customers/lxa/lxatac
# umpf-version: 6.5/customers/lxa/lxatac/20230901-1
# umpf-topic: v6.5/customers/lxa/lxatac
# umpf-hashinfo: 5749e67e0c2004dca628d140cb24009c7cdb51b1
# umpf-topic-range: 2dde18cd1d8fac735875f2e4987f11817cc0bc2c..a13b48119b098c3886901cc46d01a8cd488f53ea
SRC_URI += "\
  file://patches/0001-dt-bindings-can-m_can-change-from-additional-to-unev.patch \
  file://patches/0002-dt-bindings-net-dsa-microchip-add-interrupts-propert.patch \
  file://patches/0003-ARM-dts-stm32-Add-pinmux-groups-for-Linux-Automation.patch \
  file://patches/0004-dt-bindings-arm-stm32-Add-compatible-string-for-Linu.patch \
  file://patches/0005-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  file://patches/0006-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0007-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0008-leds-trigger-tty-Use-led_set_brightness_nosleep-from.patch \
  "
# umpf-topic: v6.5/topic/pwm-stm32
# umpf-hashinfo: 0a81cfa2fa0c23e9f0b7cb8fcac647af866b6b5b
# umpf-topic-range: a13b48119b098c3886901cc46d01a8cd488f53ea..a037f83055cc0511dd0a939f5aea6abcd444f9fa
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.5/topic/pwm-backlight
# umpf-hashinfo: 7f684487c94a882dd63183e8d8563c6ae90c983c
# umpf-topic-range: a037f83055cc0511dd0a939f5aea6abcd444f9fa..d9ba11b8c2d4f94449041ab9d40278e5848b2259
SRC_URI += "\
  file://patches/0201-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.5/topic/lmp92064
# umpf-hashinfo: 51bcd7180839086d74c7a74becccdc9e66597502
# umpf-topic-range: d9ba11b8c2d4f94449041ab9d40278e5848b2259..1023956dbecbb04c6edcb1c38229034800a2b4e9
SRC_URI += "\
  file://patches/0301-iio-adc-add-buffering-support-to-the-TI-LMP92064-ADC.patch \
  "
# umpf-release: 6.5/customers/lxa/lxatac/20230901-1
# umpf-topic-range: 1023956dbecbb04c6edcb1c38229034800a2b4e9..1dd0a96389ccc12d1fe5cb4b15ab0aa7109246f4
SRC_URI += "\
  file://patches/0401-Release-6.5-customers-lxa-lxatac-20230901-1.patch \
  "
# umpf-end
