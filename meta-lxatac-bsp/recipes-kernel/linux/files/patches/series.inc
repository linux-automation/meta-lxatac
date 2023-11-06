# umpf-base: v6.6
# umpf-name: 6.6/customers/lxa/lxatac
# umpf-version: 6.6/customers/lxa/lxatac/20231106-1
# umpf-topic: v6.6/customers/lxa/lxatac
# umpf-hashinfo: a38dd2129d998c3a219dd888869ce62a141c9228
# umpf-topic-range: ffc253263a1375a65fa6c9f62a893e9767fbebfa..025f23df22fb6dad8c7550dd19cc5e385d5b3a95
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0002-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0003-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0004-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  "
# umpf-topic: v6.6/topic/pwm-stm32
# umpf-hashinfo: 8113fd612e1d9fa2d989b2b9b42acd583f230e7d
# umpf-topic-range: 025f23df22fb6dad8c7550dd19cc5e385d5b3a95..d73242652ccc22630b7cf0f9b5b0d98111658480
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.6/topic/pwm-backlight
# umpf-hashinfo: edc89c044be3756604c3fd3e599199e8a3f111a5
# umpf-topic-range: d73242652ccc22630b7cf0f9b5b0d98111658480..76a6821c6be05b63f268b911e686806d0aef950e
SRC_URI += "\
  file://patches/0201-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.6/topic/tty-trigger
# umpf-hashinfo: d1c6bf0847bc14b653cd41d1cd6e96f0e4f57cac
# umpf-topic-range: 76a6821c6be05b63f268b911e686806d0aef950e..581ada6665f36a0a22c54dfee69dcef4e078d483
SRC_URI += "\
  file://patches/0301-tty-add-new-helper-function-tty_get_mget.patch \
  file://patches/0302-trigger-ledtrig-tty-add-new-line-mode-to-triggers.patch \
  "
# umpf-release: 6.6/customers/lxa/lxatac/20231106-1
# umpf-topic-range: 581ada6665f36a0a22c54dfee69dcef4e078d483..b7d4fb8bbb6f614775301e01156f5faaf2c55777
SRC_URI += "\
  file://patches/0401-Release-6.6-customers-lxa-lxatac-20231106-1.patch \
  "
# umpf-end
