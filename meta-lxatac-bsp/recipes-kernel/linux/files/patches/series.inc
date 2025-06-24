# umpf-base: v6.15
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.15/customers/lxa/lxatac
# umpf-version: 6.15/customers/lxa/lxatac/20250617-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 0ff41df1cb268fc69e703a08a57ee14ae967d0ca..194577539982ccd0506aa559ef7d68d24a2a03c7
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.14/topic/dwc2_clock_gating
# umpf-hashinfo: c1c67a4b104b8eb5a959a04554689c4e927307a6
# umpf-topic-range: 194577539982ccd0506aa559ef7d68d24a2a03c7..2be5cba9bbaec5a1d9655ee05d3801a92649a29f
SRC_URI += "\
  file://patches/0101-usb-dwc2-also-exit-clock_gating-when-stopping-udc-wh.patch \
  "
# umpf-release: 6.15/customers/lxa/lxatac/20250617-1
# umpf-topic-range: 2be5cba9bbaec5a1d9655ee05d3801a92649a29f..74e39d62de86684b3a200f2dce53fe45caa7fd20
SRC_URI += "\
  file://patches/0201-Release-6.15-customers-lxa-lxatac-20250617-1.patch \
  "
UMPF_BASE = "6.15"
UMPF_VERSION = "20250617-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
