# umpf-base: v6.0
# umpf-name: 6.0/customers/lxa/lxatac
# umpf-version: 6.0/customers/lxa/lxatac/20221004-1
# umpf-topic: v6.0/topic/ti-lmp92064-adc
# umpf-hashinfo: 7c6a8df21e78e50638a9843052bef508914084ee
# umpf-topic-range: 4fe89d07dcc2804c8b562f6c7896a45643d34b2f..352a3628f4de00d1cdbfd5e8f1bda5142edbaef2
SRC_URI += "\
  file://patches/0001-dt-bindings-iio-adc-add-documentation-for-TI-LMP9206.patch \
  file://patches/0002-iio-adc-add-ADC-driver-for-the-TI-LMP92064-controlle.patch \
  "
# umpf-topic: v6.0/customers/lxa/lxatac
# umpf-hashinfo: d32a885223ffb597eb578c96030fc0104f333089
# umpf-topic-range: 352a3628f4de00d1cdbfd5e8f1bda5142edbaef2..7970d664dfbd11aae9320fe2be7496d5477f80ba
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
  "
# umpf-release: 6.0/customers/lxa/lxatac/20221004-1
# umpf-topic-range: 7970d664dfbd11aae9320fe2be7496d5477f80ba..47f5f0c17396f0178b2355b6d5b83ba6c327f415
SRC_URI += "\
  file://patches/0201-Release-6.0-customers-lxa-lxatac-20221004-1.patch \
  "
# umpf-end
