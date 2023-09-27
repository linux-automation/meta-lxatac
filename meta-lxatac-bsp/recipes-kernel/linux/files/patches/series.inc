# umpf-base: v6.4
# umpf-name: 6.4/customers/lxa/lxatac
# umpf-version: 6.4/customers/lxa/lxatac/20230628-1
# umpf-topic: v6.4/customers/lxa/lxatac
# umpf-hashinfo: 927820f53568ba95758663f0de98d7cbd7d9b911
# umpf-topic-range: 6995e2de6891c724bfeb2db33d7b87775f913ad1..678243c254e6835b25e29f8ccf8a52d6b67174b1
SRC_URI += "\
  file://patches/0001-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0002-leds-trigger-tty-Use-led_set_brightness_nosleep-from.patch \
  "
# umpf-topic: v6.4/topic/lxa-tac-dts-mainlining
# umpf-hashinfo: bd4961142956aad55805e3cb3e6f4f792ce208ff
# umpf-topic-range: 678243c254e6835b25e29f8ccf8a52d6b67174b1..bd79efc530ede8973a3586b016271eac7783e9b8
SRC_URI += "\
  file://patches/0101-dt-bindings-vendor-prefixes-Add-prefix-for-ShineWorl.patch \
  file://patches/0102-dt-bindings-display-panel-mipi-dbi-spi-add-shineworl.patch \
  file://patches/0103-dt-bindings-display-panel-mipi-dbi-spi-add-spi-3wire.patch \
  file://patches/0104-dt-bindings-can-m_can-change-from-additional-to-unev.patch \
  file://patches/0105-dt-bindings-net-dsa-microchip-add-interrupts-propert.patch \
  file://patches/0106-ARM-dts-stm32-Add-pinmux-groups-for-Linux-Automation.patch \
  file://patches/0107-dt-bindings-arm-stm32-Add-compatible-string-for-Linu.patch \
  file://patches/0108-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  file://patches/0109-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  "
# umpf-topic: v6.4/topic/pwm-stm32
# umpf-hashinfo: 8b37f8455f4ff559c4ab91dd240329fe68ca606e
# umpf-topic-range: bd79efc530ede8973a3586b016271eac7783e9b8..1f344a16e141d133734fc0d62c981d2c643dfb9a
SRC_URI += "\
  file://patches/0201-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.4/topic/pwm-backlight
# umpf-hashinfo: f5aa96f6c59d482b4d67776b4c79746b5567b92a
# umpf-topic-range: 1f344a16e141d133734fc0d62c981d2c643dfb9a..7af7f4e3209bb6a4f2310ea11904a7a77bde3e8d
SRC_URI += "\
  file://patches/0301-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.4/topic/lmp92064
# umpf-hashinfo: 8a6b5ffc4c09287732c41b3f4106097d5aea6c68
# umpf-topic-range: 7af7f4e3209bb6a4f2310ea11904a7a77bde3e8d..a132785e7274e184caa36be02592ab239a5f83d5
SRC_URI += "\
  file://patches/0401-iio-adc-add-buffering-support-to-the-TI-LMP92064-ADC.patch \
  "
# umpf-release: 6.4/customers/lxa/lxatac/20230628-1
# umpf-topic-range: a132785e7274e184caa36be02592ab239a5f83d5..dbeb021b81e1c1959fb3aaea69abcf3e0c9bcfc0
SRC_URI += "\
  file://patches/0501-Release-6.4-customers-lxa-lxatac-20230628-1.patch \
  "
# umpf-end
