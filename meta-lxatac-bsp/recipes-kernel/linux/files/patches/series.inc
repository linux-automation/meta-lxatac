# umpf-base: v6.14
# umpf-name: 6.14/customers/lxa/lxatac
# umpf-version: 6.14/customers/lxa/lxatac/20250422-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 38fec10eb60d687e30c8c6b5420d86e8149f7557..0df0ed370001fa8e89b05a4171dec57458075fa6
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.14/topic/dwc2_clock_gating
# umpf-hashinfo: c1c67a4b104b8eb5a959a04554689c4e927307a6
# umpf-topic-range: 0df0ed370001fa8e89b05a4171dec57458075fa6..3d75e99fdc24c874f64364d6ddd0761c60f43244
SRC_URI += "\
  file://patches/0101-usb-dwc2-also-exit-clock_gating-when-stopping-udc-wh.patch \
  "
# umpf-release: 6.14/customers/lxa/lxatac/20250422-1
# umpf-topic-range: 3d75e99fdc24c874f64364d6ddd0761c60f43244..d954ed78834876ace0f3d430a537b557915e64fb
SRC_URI += "\
  file://patches/0201-Release-6.14-customers-lxa-lxatac-20250422-1.patch \
  "
UMPF_BASE = "6.14"
UMPF_VERSION = "20250422-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
