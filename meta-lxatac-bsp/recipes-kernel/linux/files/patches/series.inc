# umpf-base: v6.12-rc1
# umpf-name: 6.12/customers/lxa/lxatac
# umpf-version: 6.12/customers/lxa/lxatac/20241001-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 9852d85ec9d492ebef56dc5f229416c925758edc..0669b98604924bac886c4911e59c9b1049c6d93d
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: b7d99b8a22130c95b0c6d25d6fb0d4f72bf8322e
# umpf-topic-range: 0669b98604924bac886c4911e59c9b1049c6d93d..ea631fc9f2d1a587d675f8b4d6a47e3fe3763441
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0102-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  "
# umpf-release: 6.12/customers/lxa/lxatac/20241001-1
# umpf-topic-range: ea631fc9f2d1a587d675f8b4d6a47e3fe3763441..8a7a3e11c4c16290ab76e0dbca45ac641894d19b
SRC_URI += "\
  file://patches/0201-Release-6.12-customers-lxa-lxatac-20241001-1.patch \
  "
UMPF_BASE = "6.12-rc1"
UMPF_VERSION = "20241001-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
