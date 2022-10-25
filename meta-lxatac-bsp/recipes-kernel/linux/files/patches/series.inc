# umpf-base: v6.1.8
# umpf-name: 6.1/customers/lxa/lxatac
# umpf-version: 6.1/customers/lxa/lxatac/20230201-1
# umpf-topic: v6.1/topic/ti-lmp92064-adc
# umpf-hashinfo: cfeee400f2cd418c398c821e2c961e9fbaea65f5
# umpf-topic-range: 93f875a8526a291005e7f38478079526c843cbec..db76a5ac18ee65de16cf960f8b3347f9112e6369
SRC_URI += "\
  file://patches/0001-dt-bindings-iio-adc-add-TI-LMP92064-controller.patch \
  file://patches/0002-iio-adc-add-ADC-driver-for-the-TI-LMP92064-controlle.patch \
  "
# umpf-topic: v6.1/customers/lxa/lxatac
# umpf-hashinfo: a45b1cc9d5c9084f4667f1297a6ef8df61d75571
# umpf-topic-range: db76a5ac18ee65de16cf960f8b3347f9112e6369..8192c57032142a9c2b01dbe01f68c8d22c7262fe
SRC_URI += "\
  file://patches/0101-WIP-add-LXATAC-DTS.patch \
  file://patches/0102-linux-lxatac-enable-usart3-with-flow-control.patch \
  file://patches/0103-linux-lxatac-fit-i2c-pinmux.patch \
  file://patches/0104-WIP-lxatac-add-ADC-to-DT.patch \
  file://patches/0105-WIP-lxatac-ADC-change-reference-voltage-to-2v5.patch \
  file://patches/0106-lxatac-add-ADC-to-DT-modify-Ethernet-pinmux.patch \
  file://patches/0107-ARM-tac-reorder-USB-nodes-add-supply-handles.patch \
  file://patches/0108-lxatac-disable-dma-for-i2c.patch \
  file://patches/0109-lxatac-add-display.patch \
  file://patches/0110-lxatac-disable-gpu.patch \
  file://patches/0111-lxatac-fix-ETH-PLL-configuration.patch \
  file://patches/0112-lxatac-add-gpio-line-names.patch \
  file://patches/0113-lxatac-introduce-IOBUS_FLT_FB.patch \
  file://patches/0114-lxatac-activate-Digital-Temperature-Sensor-DTS.patch \
  file://patches/0115-lxatac-add-ADC-ambient-temperature-sensor.patch \
  file://patches/0116-DT-indentation-fix-whitespaces.patch \
  file://patches/0117-lxatac-change-label-for-Ethernet-ports.patch \
  file://patches/0118-lxatac-add-missing-alias-for-usart3.patch \
  file://patches/0119-lxatac-add-more-gpio-line-names.patch \
  file://patches/0120-lxatac-add-gpio-key.patch \
  file://patches/0121-lxatac-label-ADC-inputs-and-map-some-via-iio-rescale.patch \
  file://patches/0122-lxatac-enable-crypto-accelerators.patch \
  file://patches/0123-lxatac-add-rtc-and-timer-nodes.patch \
  file://patches/0124-lxatac-label-u-s-arts-and-enable-uart-has-rtscts.patch \
  file://patches/0125-lxatac-remove-dma-allocation-for-switch-SPI-bus.patch \
  file://patches/0126-ARM-dts-stm32-fix-whitespace-issues-in-LXATAC-device.patch \
  file://patches/0127-ARM-dts-stm32-remove-obsolete-comment-about-vrefbuf-.patch \
  file://patches/0128-ARM-dts-stm32-make-the-voltage-regulator-hierarchy-m.patch \
  file://patches/0129-ARM-dts-stm32-add-the-ethernet-port-LEDs-present-on-.patch \
  file://patches/0130-ARM-dts-stm32-supply-correct-number-of-names-for-GPI.patch \
  file://patches/0131-ARM-dts-stm32-force-peripheral-mode-for-LXATAC-USB-O.patch \
  file://patches/0132-net-dsa-microchip-HACK-in-drive-strength-settings-to.patch \
  file://patches/0133-ARM-dts-stm32-reduce-LXA-TAC-RGMII-drive-strength.patch \
  file://patches/0134-ARM-stm32mp-lxa-tac-introduce-hardware-watchdog.patch \
  file://patches/0135-ARM-dts-stm32-Update-to-the-new-and-improved-power-b.patch \
  file://patches/0136-lxatac-make-DT-extension-in-bootloader-easier.patch \
  file://patches/0137-lxatac-assign-shorter-label-to-internal-temperature-.patch \
  file://patches/0138-lxatac-fix-device-tree-compiler-warnings.patch \
  file://patches/0139-lxatac-move-to-new-usart3_pins_e-pinmux-as-usart3_pi.patch \
  file://patches/0140-ARM-dts-stm32-keep-uart-nodes-behavior-on-stm32mp157.patch \
  file://patches/0141-ARM-dts-stm32-lxa-tac-add-regulators-on-power-board-.patch \
  file://patches/0142-ARM-dts-stm32-lxa-tac-add-voltage-supply-for-on-boar.patch \
  file://patches/0143-ARM-dts-stm32-lxa-tac-manually-set-RGMII-delay-for-o.patch \
  "
# umpf-release: 6.1/customers/lxa/lxatac/20230201-1
# umpf-topic-range: 8192c57032142a9c2b01dbe01f68c8d22c7262fe..d3e766d97443337606f2bf6219a977ee4b14cabd
SRC_URI += "\
  file://patches/0201-Release-6.1-customers-lxa-lxatac-20230201-1.patch \
  "
# umpf-end
