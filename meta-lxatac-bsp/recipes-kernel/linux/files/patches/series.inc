# umpf-base: v6.7
# umpf-name: 6.7/customers/lxa/lxatac
# umpf-version: 6.7/customers/lxa/lxatac/20240108-1
# umpf-topic: v6.7/customers/lxa/lxatac
# umpf-hashinfo: 3ba44c61703527a12a3954a58619d5fdc8cb5c8a
# umpf-topic-range: 0dd3ee31125508cd67f7e7172247f05b7fd1753a..c4dd70cd661f9ffa4e8f758513560ec9c6095d37
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0002-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0003-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0004-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  "
# umpf-topic: v6.7/topic/pwm-stm32
# umpf-hashinfo: 1efb7b81bb21e83f236a735f867cd2386f1dc59b
# umpf-topic-range: c4dd70cd661f9ffa4e8f758513560ec9c6095d37..4f61a661dc5e06f3b5bdd2707c15ff088645872f
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.7/topic/pwm-backlight
# umpf-hashinfo: 264f4a613475def4ed75da53dcbce6bfe7a646b6
# umpf-topic-range: 4f61a661dc5e06f3b5bdd2707c15ff088645872f..02580b8d0aa0f8fa1fb3f87a4a17ce6b79cdf57f
SRC_URI += "\
  file://patches/0201-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.7/topic/tty-trigger
# umpf-hashinfo: 563ec9d4944c63c3aea141e75dcbd6917057b5f4
# umpf-topic-range: 02580b8d0aa0f8fa1fb3f87a4a17ce6b79cdf57f..e00a88532e8d211d430ad8e493929539993f6b72
SRC_URI += "\
  file://patches/0301-tty-add-new-helper-function-tty_get_mget.patch \
  file://patches/0302-trigger-ledtrig-tty-add-new-line-mode-to-triggers.patch \
  "
# umpf-release: 6.7/customers/lxa/lxatac/20240108-1
# umpf-topic-range: e00a88532e8d211d430ad8e493929539993f6b72..0109ccc2ad62fbe5d7b1159ded24cc62c539fc1b
SRC_URI += "\
  file://patches/0401-Release-6.7-customers-lxa-lxatac-20240108-1.patch \
  "
# umpf-end
