# umpf-base: v6.16
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.16/customers/lxa/lxatac
# umpf-version: 6.16/customers/lxa/lxatac/20250909-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 038d61fd642278bab63ee8ef722c50d10ab01e8f..5f055ff61436b3dda83708bdff3477a786a96795
UMPF_SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.15/topic/stm32mp15-m_can-reset
# umpf-hashinfo: 10bf2eb005f552c7afaf0cf1a6274d2974859011
# umpf-topic-range: 5f055ff61436b3dda83708bdff3477a786a96795..42c68959da5cd1f909b30469bfddbf6e49411aed
UMPF_SRC_URI += "\
  file://patches/0101-dt-binding-can-m_can-add-optional-resets-property.patch \
  file://patches/0102-ARM-dts-stm32-add-resets-property-to-m_can-nodes-in-.patch \
  "
# umpf-topic: v6.15/topic/m_can-reset
# umpf-hashinfo: 7c84037736b776f7bc8300191cfff83dd137b49a
# umpf-topic-range: 42c68959da5cd1f909b30469bfddbf6e49411aed..a7ea150cc295d1400c0a0cce0a30859a92023716
UMPF_SRC_URI += "\
  file://patches/0201-can-m_can-m_can_plat_remove-add-missing-pm_runtime_d.patch \
  file://patches/0202-can-m_can-m_can_rx_handler-only-handle-active-interr.patch \
  file://patches/0203-can-m_can-m_can_handle_state_errors-fix-CAN-state-tr.patch \
  file://patches/0204-can-m_can-m_can_chip_config-bring-up-interface-in-co.patch \
  file://patches/0205-can-m_can-fix-CAN-state-in-system-PM.patch \
  file://patches/0206-can-m_can-m_can_get_berr_counter-don-t-wake-up-contr.patch \
  file://patches/0207-can-m_can-add-optional-support-for-reset.patch \
  "
# umpf-release: 6.16/customers/lxa/lxatac/20250909-1
# umpf-topic-range: a7ea150cc295d1400c0a0cce0a30859a92023716..7c3057bb4f5efe9a8cda9bc07e1b3c58d7512b05
UMPF_SRC_URI += "\
  file://patches/0301-Release-6.16-customers-lxa-lxatac-20250909-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "6.16"
UMPF_VERSION = "20250909-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
