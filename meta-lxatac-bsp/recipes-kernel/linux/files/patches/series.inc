# umpf-base: v6.7
# umpf-name: 6.7/customers/lxa/lxatac
# umpf-version: 6.7/customers/lxa/lxatac/20240213-1
# umpf-topic: v6.7/topic/reproducible-build
# umpf-hashinfo: d313a8ff84dc39d70aa91df0fd78f8df643f0d1c
# umpf-topic-range: 0dd3ee31125508cd67f7e7172247f05b7fd1753a..b16e94460bdcef2303c9af731d73b94dac3204dc
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  file://patches/0002-vt-conmakehash-improve-reproducibility.patch \
  file://patches/0003-lib-build_OID_registry-fix-reproducibility-issues.patch \
  "
# umpf-topic: v6.7/customers/lxa/lxatac
# umpf-hashinfo: 65acf36d24b3cf1964d37ee9a9ebc220e1c49f6d
# umpf-topic-range: b16e94460bdcef2303c9af731d73b94dac3204dc..57e0561ea46bf2f20e7f4d47012c5257ba2e7bf7
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0102-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0103-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0104-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  "
# umpf-topic: v6.7/topic/pwm-stm32
# umpf-hashinfo: d11fc1b76a295d643d17314df8f3a4c815900e4b
# umpf-topic-range: 57e0561ea46bf2f20e7f4d47012c5257ba2e7bf7..7963e1ff8ebe30574ac8065e51490d239500dc6f
SRC_URI += "\
  file://patches/0201-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0202-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0203-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0204-pwm-stm32-Implement-.get_state.patch \
  file://patches/0205-pwm-stm32-Fix-enable-count-for-clk-in-.probe.patch \
  "
# umpf-topic: v6.7/topic/tty-trigger
# umpf-hashinfo: 6c436e04db10c52d628131d3645ed0e98e8609b7
# umpf-topic-range: 7963e1ff8ebe30574ac8065e51490d239500dc6f..d71d5e0c446248c3e62f4f719f618870402bdfac
SRC_URI += "\
  file://patches/0301-tty-add-new-helper-function-tty_get_tiocm.patch \
  file://patches/0302-leds-ledtrig-tty-Free-allocated-ttyname-buffer-on-de.patch \
  file://patches/0303-leds-ledtrig-tty-Replace-mutex-with-completion.patch \
  file://patches/0304-leds-ledtrig-tty-Make-rx-tx-activitate-configurable.patch \
  file://patches/0305-leds-ledtrig-tty-Add-additional-line-state-evaluatio.patch \
  "
# umpf-release: 6.7/customers/lxa/lxatac/20240213-1
# umpf-topic-range: d71d5e0c446248c3e62f4f719f618870402bdfac..4ea732c93541a067022a4c74cfe3586084fd96ee
SRC_URI += "\
  file://patches/0401-Release-6.7-customers-lxa-lxatac-20240213-1.patch \
  "
# umpf-end
