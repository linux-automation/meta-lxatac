# umpf-base: v6.14
# umpf-name: 6.14/customers/lxa/lxatac
# umpf-version: 6.14/customers/lxa/lxatac/20250325-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 38fec10eb60d687e30c8c6b5420d86e8149f7557..0df0ed370001fa8e89b05a4171dec57458075fa6
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-release: 6.14/customers/lxa/lxatac/20250325-1
# umpf-topic-range: 0df0ed370001fa8e89b05a4171dec57458075fa6..a376cc6220bf4e6db412dfee2cdafe70805f5c79
SRC_URI += "\
  file://patches/0101-Release-6.14-customers-lxa-lxatac-20250325-1.patch \
  "
UMPF_BASE = "6.14"
UMPF_VERSION = "20250325-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
