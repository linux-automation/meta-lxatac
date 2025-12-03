# umpf-base: v6.18
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.18/customers/lxa/lxatac
# umpf-version: 6.18/customers/lxa/lxatac/20251203-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 7d0a66e4bb9081d75c82ec4957c50034cb0ea449..8fdf882be296703026eb9f1a8005e90911344b11
UMPF_SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.17/topic/lxa-usb-dt
# umpf-hashinfo: 0c8f0f8768142a042609b245b31df880345e0396
# umpf-topic-range: 8fdf882be296703026eb9f1a8005e90911344b11..252d462693657f340ea80ec585898b84398e2558
UMPF_SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-drop-unnecessary-vusb_d-a-supply.patch \
  "
# umpf-release: 6.18/customers/lxa/lxatac/20251203-1
# umpf-topic-range: 252d462693657f340ea80ec585898b84398e2558..31d771933418a4aea0e18d6c3f62a8895b63523f
UMPF_SRC_URI += "\
  file://patches/0201-Release-6.18-customers-lxa-lxatac-20251203-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "6.18"
UMPF_VERSION = "20251203-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
