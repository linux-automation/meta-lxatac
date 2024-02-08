# umpf-base: v6.7
# umpf-name: 6.7/customers/lxa/lxatac
# umpf-version: 6.7/customers/lxa/lxatac/20240208-1
# umpf-topic: v6.7/customers/lxa/lxatac
# umpf-hashinfo: 65acf36d24b3cf1964d37ee9a9ebc220e1c49f6d
# umpf-topic-range: 0dd3ee31125508cd67f7e7172247f05b7fd1753a..f10020eca8231159dcd18c2c63fa3b553b392bfb
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0002-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0003-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0004-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  "
# umpf-topic: v6.7/topic/pwm-stm32
# umpf-hashinfo: d11fc1b76a295d643d17314df8f3a4c815900e4b
# umpf-topic-range: f10020eca8231159dcd18c2c63fa3b553b392bfb..f3a9a0f9423ec10328d08d294f1d1778dbdb1dc0
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  file://patches/0105-pwm-stm32-Fix-enable-count-for-clk-in-.probe.patch \
  "
# umpf-topic: v6.7/topic/tty-trigger
# umpf-hashinfo: 6c436e04db10c52d628131d3645ed0e98e8609b7
# umpf-topic-range: f3a9a0f9423ec10328d08d294f1d1778dbdb1dc0..c1e9027f7c56f9f24f671589406c195f2108b616
SRC_URI += "\
  file://patches/0201-tty-add-new-helper-function-tty_get_tiocm.patch \
  file://patches/0202-leds-ledtrig-tty-Free-allocated-ttyname-buffer-on-de.patch \
  file://patches/0203-leds-ledtrig-tty-Replace-mutex-with-completion.patch \
  file://patches/0204-leds-ledtrig-tty-Make-rx-tx-activitate-configurable.patch \
  file://patches/0205-leds-ledtrig-tty-Add-additional-line-state-evaluatio.patch \
  "
# umpf-release: 6.7/customers/lxa/lxatac/20240208-1
# umpf-topic-range: c1e9027f7c56f9f24f671589406c195f2108b616..61fe68067d88dcf210fbb52607002f0dd5dca2b3
SRC_URI += "\
  file://patches/0301-Release-6.7-customers-lxa-lxatac-20240208-1.patch \
  "
# umpf-end
