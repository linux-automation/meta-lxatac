# umpf-base: v6.15
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.15/customers/lxa/lxatac
# umpf-version: 6.15/customers/lxa/lxatac/20250813-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 0ff41df1cb268fc69e703a08a57ee14ae967d0ca..194577539982ccd0506aa559ef7d68d24a2a03c7
UMPF_SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.14/topic/dwc2_clock_gating
# umpf-hashinfo: c1c67a4b104b8eb5a959a04554689c4e927307a6
# umpf-topic-range: 194577539982ccd0506aa559ef7d68d24a2a03c7..2be5cba9bbaec5a1d9655ee05d3801a92649a29f
UMPF_SRC_URI += "\
  file://patches/0101-usb-dwc2-also-exit-clock_gating-when-stopping-udc-wh.patch \
  "
# umpf-topic: v6.15/topic/stm32mp15-m_can-reset
# umpf-hashinfo: 10bf2eb005f552c7afaf0cf1a6274d2974859011
# umpf-topic-range: 2be5cba9bbaec5a1d9655ee05d3801a92649a29f..624ad1f4ffd0ef66e7c15618bccc7fa12493eea4
UMPF_SRC_URI += "\
  file://patches/0201-dt-binding-can-m_can-add-optional-resets-property.patch \
  file://patches/0202-ARM-dts-stm32-add-resets-property-to-m_can-nodes-in-.patch \
  "
# umpf-topic: v6.15/topic/m_can-reset
# umpf-hashinfo: 7c84037736b776f7bc8300191cfff83dd137b49a
# umpf-topic-range: 624ad1f4ffd0ef66e7c15618bccc7fa12493eea4..dbc506d15cdc8d17ddda785a238a1a0788146bf8
UMPF_SRC_URI += "\
  file://patches/0301-can-m_can-m_can_plat_remove-add-missing-pm_runtime_d.patch \
  file://patches/0302-can-m_can-m_can_rx_handler-only-handle-active-interr.patch \
  file://patches/0303-can-m_can-m_can_handle_state_errors-fix-CAN-state-tr.patch \
  file://patches/0304-can-m_can-m_can_chip_config-bring-up-interface-in-co.patch \
  file://patches/0305-can-m_can-fix-CAN-state-in-system-PM.patch \
  file://patches/0306-can-m_can-m_can_get_berr_counter-don-t-wake-up-contr.patch \
  file://patches/0307-can-m_can-add-optional-support-for-reset.patch \
  "
# umpf-release: 6.15/customers/lxa/lxatac/20250813-1
# umpf-topic-range: dbc506d15cdc8d17ddda785a238a1a0788146bf8..4bb6711f7467d5a2978024fdc8f12d1f54050d4d
UMPF_SRC_URI += "\
  file://patches/0401-Release-6.15-customers-lxa-lxatac-20250813-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "6.15"
UMPF_VERSION = "20250813-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
