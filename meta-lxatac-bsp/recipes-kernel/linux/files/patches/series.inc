# umpf-base: v6.5
# umpf-name: 6.5/customers/lxa/lxatac
# umpf-version: 6.5/customers/lxa/lxatac/20240124-1
# umpf-topic: v6.5/customers/lxa/lxatac
# umpf-hashinfo: 00cc91ff4ae50fe60f09e43b8760ca71d93f03f5
# umpf-topic-range: 2dde18cd1d8fac735875f2e4987f11817cc0bc2c..b87c8b6a72317760fdf1c466e6bfb65b0d0ad524
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
# umpf-hashinfo: baebf4dcf7590fa024d7e534a53c813d0c081075
# umpf-topic-range: b87c8b6a72317760fdf1c466e6bfb65b0d0ad524..3b7be719131bc3dc665ec5b5071166b9993f6b12
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  file://patches/0105-pwm-stm32-Fix-enable-count-for-clk-in-.probe.patch \
  "
# umpf-topic: v6.5/topic/pwm-backlight
# umpf-hashinfo: b2fbd4752f683d1c231d85417d61e1fa9671d6f2
# umpf-topic-range: 3b7be719131bc3dc665ec5b5071166b9993f6b12..330435d05f328967705adbd7156fea1b43ca3f07
SRC_URI += "\
  file://patches/0201-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.5/topic/lmp92064
# umpf-hashinfo: 7cc9bf8839008f191c5f766faf9fc0dc5b21c28f
# umpf-topic-range: 330435d05f328967705adbd7156fea1b43ca3f07..339c7ece41ea146ef4c3af9e783ec945fc1fc616
SRC_URI += "\
  file://patches/0301-iio-adc-ti-lmp92064-add-buffering-support.patch \
  "
# umpf-topic: v6.5/topic/tty-trigger
# umpf-hashinfo: d3c10f9f59bcbe48740453bc85949e3315668db7
# umpf-topic-range: 339c7ece41ea146ef4c3af9e783ec945fc1fc616..f09f5b574126e33deeac43d15293db527edd14de
SRC_URI += "\
  file://patches/0401-leds-trigger-tty-Do-not-use-LED_ON-OFF-constants-use.patch \
  file://patches/0402-tty-whitespaces-in-descriptions-corrected-by-replaci.patch \
  file://patches/0403-tty-add-new-helper-function-tty_get_tiocm.patch \
  file://patches/0404-leds-ledtrig-tty-add-new-line-mode-evaluation.patch \
  "
# umpf-release: 6.5/customers/lxa/lxatac/20240124-1
# umpf-topic-range: f09f5b574126e33deeac43d15293db527edd14de..3d035fd4276a3115fd92a1547003a908069c9877
SRC_URI += "\
  file://patches/0501-Release-6.5-customers-lxa-lxatac-20240124-1.patch \
  "
# umpf-end
