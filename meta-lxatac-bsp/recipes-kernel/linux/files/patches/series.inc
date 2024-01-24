# umpf-base: v6.6
# umpf-name: 6.6/customers/lxa/lxatac
# umpf-version: 6.6/customers/lxa/lxatac/20240125-1
# umpf-topic: v6.6/customers/lxa/lxatac
# umpf-hashinfo: 97604e9ac95ee19b0be445926137ef83f7957303
# umpf-topic-range: ffc253263a1375a65fa6c9f62a893e9767fbebfa..8f94470ff537760ea763a32b035911fbedde1202
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0002-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0003-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0004-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  "
# umpf-topic: v6.6/topic/pwm-stm32
# umpf-hashinfo: 04a447a2a5fe4f558b0415663e725fa0ef7888ab
# umpf-topic-range: 8f94470ff537760ea763a32b035911fbedde1202..d2f04a87baa80c149a7a4007b492322927c6944f
SRC_URI += "\
  file://patches/0101-pwm-stm32-Replace-write_ccrx-with-regmap_write.patch \
  file://patches/0102-pwm-stm32-Make-ch-parameter-unsigned.patch \
  file://patches/0103-pwm-stm32-Use-hweight32-in-stm32_pwm_detect_channels.patch \
  file://patches/0104-pwm-stm32-Implement-.get_state.patch \
  file://patches/0105-pwm-stm32-Fix-enable-count-for-clk-in-.probe.patch \
  "
# umpf-topic: v6.6/topic/pwm-backlight
# umpf-hashinfo: edc89c044be3756604c3fd3e599199e8a3f111a5
# umpf-topic-range: d2f04a87baa80c149a7a4007b492322927c6944f..20d5df18ff8a0c67d1a902ec2691e28653a8d9ad
SRC_URI += "\
  file://patches/0201-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-topic: v6.6/topic/tty-trigger
# umpf-hashinfo: 642aeee7fd080600b6be90e0de6d7313f41fabf0
# umpf-topic-range: 20d5df18ff8a0c67d1a902ec2691e28653a8d9ad..426ad31f7e9273b4e8e0a256674685263e88191f
SRC_URI += "\
  file://patches/0301-tty-whitespaces-in-descriptions-corrected-by-replaci.patch \
  file://patches/0302-tty-add-new-helper-function-tty_get_tiocm.patch \
  file://patches/0303-leds-ledtrig-tty-Free-allocated-ttyname-buffer-on-de.patch \
  file://patches/0304-leds-ledtrig-tty-Replace-mutex-with-completion.patch \
  file://patches/0305-leds-ledtrig-tty-Make-rx-tx-activitate-configurable.patch \
  file://patches/0306-leds-ledtrig-tty-Add-additional-line-state-evaluatio.patch \
  "
# umpf-release: 6.6/customers/lxa/lxatac/20240125-1
# umpf-topic-range: 426ad31f7e9273b4e8e0a256674685263e88191f..af8bc68189839b73deabde369fac549e4d561bd6
SRC_URI += "\
  file://patches/0401-Release-6.6-customers-lxa-lxatac-20240125-1.patch \
  "
# umpf-end
