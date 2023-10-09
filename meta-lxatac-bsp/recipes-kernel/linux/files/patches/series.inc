# umpf-base: v6.5
# umpf-name: 6.5/customers/lxa/lxatac
# umpf-version: 6.5/customers/lxa/lxatac/20230901-2
# umpf-topic: v6.5/customers/lxa/lxatac
# umpf-hashinfo: 3709235f8c53fc9b6f027de3390dfc59755a59aa
# umpf-topic-range: 2dde18cd1d8fac735875f2e4987f11817cc0bc2c..3cb5f5381dd8aeff16f98be5e4084040d919429d
SRC_URI += "\
  file://patches/0001-dt-bindings-can-m_can-change-from-additional-to-unev.patch \
  file://patches/0002-dt-bindings-net-dsa-microchip-add-interrupts-propert.patch \
  file://patches/0003-ARM-dts-stm32-Add-pinmux-groups-for-Linux-Automation.patch \
  file://patches/0004-dt-bindings-arm-stm32-Add-compatible-string-for-Linu.patch \
  file://patches/0005-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  file://patches/0006-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0007-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0008-leds-trigger-tty-Use-led_set_brightness_nosleep-from.patch \
  file://patches/0009-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  "
# umpf-topic: v6.5/topic/pwm-stm32
# umpf-hashinfo: 0a81cfa2fa0c23e9f0b7cb8fcac647af866b6b5b
# umpf-topic-range: 3cb5f5381dd8aeff16f98be5e4084040d919429d..17bbf2c7ec8a501b06316e26bf153b59b2a51a67
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.5/topic/pwm-backlight
# umpf-hashinfo: 7f684487c94a882dd63183e8d8563c6ae90c983c
# umpf-topic-range: 17bbf2c7ec8a501b06316e26bf153b59b2a51a67..c0f576f113c2d9ea6050f2f35c7a2f7c716606d1
SRC_URI += "\
  file://patches/0201-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.5/topic/lmp92064
# umpf-hashinfo: 51bcd7180839086d74c7a74becccdc9e66597502
# umpf-topic-range: c0f576f113c2d9ea6050f2f35c7a2f7c716606d1..5f3889a4a5231c48c036f8f1f951344f29da1dc9
SRC_URI += "\
  file://patches/0301-iio-adc-add-buffering-support-to-the-TI-LMP92064-ADC.patch \
  "
# umpf-release: 6.5/customers/lxa/lxatac/20230901-2
# umpf-topic-range: 5f3889a4a5231c48c036f8f1f951344f29da1dc9..6eb45c5edee20824a6ce46a025f26af1c6367362
SRC_URI += "\
  file://patches/0401-Release-6.5-customers-lxa-lxatac-20230901-2.patch \
  "
# umpf-end
