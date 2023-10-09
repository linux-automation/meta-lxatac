# umpf-base: v6.5
# umpf-name: 6.5/customers/lxa/lxatac
# umpf-version: 6.5/customers/lxa/lxatac/20230927-1
# umpf-topic: v6.5/customers/lxa/lxatac
# umpf-hashinfo: b2b6e05bc53e4dc80c074b4fcaae16364ead92cb
# umpf-topic-range: 2dde18cd1d8fac735875f2e4987f11817cc0bc2c..8547106d90e8c9f4e2c16e7e9ea549d0715a789c
SRC_URI += "\
  file://patches/0001-dt-bindings-can-m_can-change-from-additional-to-unev.patch \
  file://patches/0002-dt-bindings-net-dsa-microchip-add-interrupts-propert.patch \
  file://patches/0003-ARM-dts-stm32-Add-pinmux-groups-for-Linux-Automation.patch \
  file://patches/0004-dt-bindings-arm-stm32-Add-compatible-string-for-Linu.patch \
  file://patches/0005-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  file://patches/0006-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0007-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0008-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  "
# umpf-topic: v6.5/topic/pwm-stm32
# umpf-hashinfo: 0a81cfa2fa0c23e9f0b7cb8fcac647af866b6b5b
# umpf-topic-range: 8547106d90e8c9f4e2c16e7e9ea549d0715a789c..994d8b2552053b897c9c5c74e8177d9024b8b24e
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.5/topic/pwm-backlight
# umpf-hashinfo: 7f684487c94a882dd63183e8d8563c6ae90c983c
# umpf-topic-range: 994d8b2552053b897c9c5c74e8177d9024b8b24e..68e0a242f3f2658670e225d3168428b9fe1b1c2e
SRC_URI += "\
  file://patches/0201-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.5/topic/lmp92064
# umpf-hashinfo: 51bcd7180839086d74c7a74becccdc9e66597502
# umpf-topic-range: 68e0a242f3f2658670e225d3168428b9fe1b1c2e..6416d9d2e0b2a496fe2676b629502fc1aeece9b9
SRC_URI += "\
  file://patches/0301-iio-adc-add-buffering-support-to-the-TI-LMP92064-ADC.patch \
  "
# umpf-topic: v6.5/topic/tty-trigger
# umpf-hashinfo: 634a2550c0ba22171325f847145ad5c8738a3a55
# umpf-topic-range: 6416d9d2e0b2a496fe2676b629502fc1aeece9b9..0b0b4a250e63a357337912cc9bd804dae0dede16
SRC_URI += "\
  file://patches/0401-leds-trigger-tty-Do-not-use-LED_ON-OFF-constants-use.patch \
  file://patches/0402-tty-add-new-helper-function-tty_get_mget.patch \
  file://patches/0403-trigger-ledtrig-tty-add-new-line-mode-to-triggers.patch \
  "
# umpf-release: 6.5/customers/lxa/lxatac/20230927-1
# umpf-topic-range: 0b0b4a250e63a357337912cc9bd804dae0dede16..c50a507cd9f8c499965d08292e2d21255e391c77
SRC_URI += "\
  file://patches/0501-Release-6.5-customers-lxa-lxatac-20230927-1.patch \
  "
# umpf-end
