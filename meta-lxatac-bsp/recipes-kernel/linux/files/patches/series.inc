# umpf-base: v6.17
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.17/customers/lxa/lxatac
# umpf-version: 6.17/customers/lxa/lxatac/20250930-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: e5f0a698b34ed76002dc5cff3804a61c80233a7a..9b470b1e1ef751cbcdade1b762585cb35ff44a4d
UMPF_SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.15/topic/stm32mp15-m_can-reset
# umpf-hashinfo: 10bf2eb005f552c7afaf0cf1a6274d2974859011
# umpf-topic-range: 9b470b1e1ef751cbcdade1b762585cb35ff44a4d..3e1dc86bdf66fa6b0dba02e70eecd24c13089165
UMPF_SRC_URI += "\
  file://patches/0101-dt-binding-can-m_can-add-optional-resets-property.patch \
  file://patches/0102-ARM-dts-stm32-add-resets-property-to-m_can-nodes-in-.patch \
  "
# umpf-topic: v6.15/topic/m_can-reset
# umpf-hashinfo: 7c84037736b776f7bc8300191cfff83dd137b49a
# umpf-topic-range: 3e1dc86bdf66fa6b0dba02e70eecd24c13089165..28fb3f7408938f2fa315267d32bfd234bb56ed5a
UMPF_SRC_URI += "\
  file://patches/0201-can-m_can-m_can_plat_remove-add-missing-pm_runtime_d.patch \
  file://patches/0202-can-m_can-m_can_rx_handler-only-handle-active-interr.patch \
  file://patches/0203-can-m_can-m_can_handle_state_errors-fix-CAN-state-tr.patch \
  file://patches/0204-can-m_can-m_can_chip_config-bring-up-interface-in-co.patch \
  file://patches/0205-can-m_can-fix-CAN-state-in-system-PM.patch \
  file://patches/0206-can-m_can-m_can_get_berr_counter-don-t-wake-up-contr.patch \
  file://patches/0207-can-m_can-add-optional-support-for-reset.patch \
  "
# umpf-release: 6.17/customers/lxa/lxatac/20250930-1
# umpf-topic-range: 28fb3f7408938f2fa315267d32bfd234bb56ed5a..b9c8fcd27d4c5bb3b8a5024f6ede856334b95b16
UMPF_SRC_URI += "\
  file://patches/0301-Release-6.17-customers-lxa-lxatac-20250930-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "6.17"
UMPF_VERSION = "20250930-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
