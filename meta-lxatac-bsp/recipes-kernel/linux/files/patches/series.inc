# umpf-base: v6.18
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.18/customers/lxa/lxatac
# umpf-version: 6.18/customers/lxa/lxatac/20251204-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 7d0a66e4bb9081d75c82ec4957c50034cb0ea449..8fdf882be296703026eb9f1a8005e90911344b11
UMPF_SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.18/topic/m_can-reset
# umpf-hashinfo: 4c84adb7af808cbfa92eb50d5d8365a1ea110e1f
# umpf-topic-range: 8fdf882be296703026eb9f1a8005e90911344b11..7929e1c7cd2230df1428fa45701bd7de86735d91
UMPF_SRC_URI += "\
  file://patches/0101-can-m_can-m_can_rx_handler-only-handle-active-interr.patch \
  file://patches/0102-can-m_can-m_can_get_berr_counter-don-t-wake-up-contr.patch \
  file://patches/0103-can-m_can-add-optional-support-for-reset.patch \
  "
# umpf-topic: v6.17/topic/lxa-usb-dt
# umpf-hashinfo: 0c8f0f8768142a042609b245b31df880345e0396
# umpf-topic-range: 7929e1c7cd2230df1428fa45701bd7de86735d91..ffb3c3c39705c3b4b978028c826a94bc35fc36be
UMPF_SRC_URI += "\
  file://patches/0201-ARM-dts-stm32-lxa-drop-unnecessary-vusb_d-a-supply.patch \
  "
# umpf-release: 6.18/customers/lxa/lxatac/20251204-1
# umpf-topic-range: ffb3c3c39705c3b4b978028c826a94bc35fc36be..96edb288711a647eeba672fe70ebef0051a819b9
UMPF_SRC_URI += "\
  file://patches/0301-Release-6.18-customers-lxa-lxatac-20251204-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "6.18"
UMPF_VERSION = "20251204-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
