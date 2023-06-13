# umpf-base: v6.3
# umpf-name: 6.3/customers/lxa/lxatac
# umpf-version: 6.3/customers/lxa/lxatac/20230509-1
# umpf-topic: v6.3/customers/lxa/lxatac
# umpf-hashinfo: 4383573e189caef3064d7c84c7f6e8567d59f398
# umpf-topic-range: 457391b0380335d5e9a5babdec90ac53928b23b4..d48712de5a77e9de6dd27abaf592a1c7d9b512ef
SRC_URI += "\
  file://patches/0001-ARM-dts-stm32-Add-coprocessor-detach-mbox-on-stm32mp.patch \
  file://patches/0002-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0003-leds-trigger-tty-Use-led_set_brightness_nosleep-from.patch \
  file://patches/0004-ARM-dts-stm32-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  file://patches/0005-ARM-dts-stm32-lxa-tac-add-Gen-2-support.patch \
  file://patches/0006-ARM-dts-stm32-lxa-tac-mark-vuart-supply-as-not-alway.patch \
  "
# umpf-topic: v6.3/topic/stm32mp1-spi
# umpf-hashinfo: 64ec89b9d7e36d36be0aa7a8170e9a08088af684
# umpf-topic-range: d48712de5a77e9de6dd27abaf592a1c7d9b512ef..8c56521c26f97c9316d6fb6131eea85ec60508e9
SRC_URI += "\
  file://patches/0101-spi-core-add-spi_split_transfers_maxwords.patch \
  file://patches/0102-spi-stm32-split-large-transfers-based-on-word-size-i.patch \
  "
# umpf-topic: v6.3/topic/pwm-stm32
# umpf-hashinfo: 859e310b9003dcd4b904e4377a746fd38eb643a4
# umpf-topic-range: 8c56521c26f97c9316d6fb6131eea85ec60508e9..f4c59c9e32d3054b2f3467c40b895e0701e94410
SRC_URI += "\
  file://patches/0201-pwm-stm32-Implement-.get_state.patch \
  "
# umpf-topic: v6.3/topic/pwm-backlight
# umpf-hashinfo: 239364388603f521a7d549bc21ecb0d3eeb9e561
# umpf-topic-range: f4c59c9e32d3054b2f3467c40b895e0701e94410..c6d811a33f2e14a8985d1983f134a0ef84ec4f1d
SRC_URI += "\
  file://patches/0301-backlight-pwm_bl-Avoid-backlight-flicker-applying-in.patch \
  "
# umpf-release: 6.3/customers/lxa/lxatac/20230509-1
# umpf-topic-range: c6d811a33f2e14a8985d1983f134a0ef84ec4f1d..083aeb334e29ac26574ff8215b0dda2925e7c999
SRC_URI += "\
  file://patches/0401-Release-6.3-customers-lxa-lxatac-20230509-1.patch \
  "
# umpf-end
