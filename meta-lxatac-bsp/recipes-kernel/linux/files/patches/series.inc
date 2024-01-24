# umpf-base: v6.7
# umpf-name: 6.7/customers/lxa/lxatac
# umpf-version: 6.7/customers/lxa/lxatac/20240129-1
# umpf-topic: v6.7/customers/lxa/lxatac
# umpf-hashinfo: 0d265df5d410a153a00c1df71f837d0575c46521
# umpf-topic-range: 0dd3ee31125508cd67f7e7172247f05b7fd1753a..267c5d7c1bd2a55accd9522beacb95a14cd7a1f4
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0002-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0003-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0004-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  "
# umpf-topic: v6.7/topic/pwm-stm32
# umpf-hashinfo: d11fc1b76a295d643d17314df8f3a4c815900e4b
# umpf-topic-range: 267c5d7c1bd2a55accd9522beacb95a14cd7a1f4..94e5887c843f6598eb3e2ef7f5a525533cc6888a
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  file://patches/0105-pwm-stm32-Fix-enable-count-for-clk-in-.probe.patch \
  "
# umpf-topic: v6.7/topic/pwm-backlight
# umpf-hashinfo: 264f4a613475def4ed75da53dcbce6bfe7a646b6
# umpf-topic-range: 94e5887c843f6598eb3e2ef7f5a525533cc6888a..266a578d413f743d2fc76912841acfb936db668d
SRC_URI += "\
  file://patches/0201-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.7/topic/tty-trigger
# umpf-hashinfo: 6c436e04db10c52d628131d3645ed0e98e8609b7
# umpf-topic-range: 266a578d413f743d2fc76912841acfb936db668d..11bea3b3e0a3facb8779149d285c00c00886e722
SRC_URI += "\
  file://patches/0301-tty-add-new-helper-function-tty_get_tiocm.patch \
  file://patches/0302-leds-ledtrig-tty-Free-allocated-ttyname-buffer-on-de.patch \
  file://patches/0303-leds-ledtrig-tty-Replace-mutex-with-completion.patch \
  file://patches/0304-leds-ledtrig-tty-Make-rx-tx-activitate-configurable.patch \
  file://patches/0305-leds-ledtrig-tty-Add-additional-line-state-evaluatio.patch \
  "
# umpf-release: 6.7/customers/lxa/lxatac/20240129-1
# umpf-topic-range: 11bea3b3e0a3facb8779149d285c00c00886e722..e602f3a6a07eccc9b0ec86e2eca466a499f66c80
SRC_URI += "\
  file://patches/0401-Release-6.7-customers-lxa-lxatac-20240129-1.patch \
  "
# umpf-end
