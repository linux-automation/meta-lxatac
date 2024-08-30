# umpf-base: v6.11
# umpf-name: 6.11/customers/lxa/lxatac
# umpf-version: 6.11/customers/lxa/lxatac/20240917-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 98f7e32f20d28ec452afb208f9cffc08448a2652..1b888dc7203b47ea21aacbf471cd762f82f36678
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: b7d99b8a22130c95b0c6d25d6fb0d4f72bf8322e
# umpf-topic-range: 1b888dc7203b47ea21aacbf471cd762f82f36678..bb492c850a1e92262b1eece4113fb09a92c0ff1d
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0102-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  "
# umpf-release: 6.11/customers/lxa/lxatac/20240917-1
# umpf-topic-range: bb492c850a1e92262b1eece4113fb09a92c0ff1d..0c61d3807b291bd09fc8550b4be0ba00a0c73321
SRC_URI += "\
  file://patches/0201-Release-6.11-customers-lxa-lxatac-20240917-1.patch \
  "
UMPF_BASE = "6.11"
UMPF_VERSION = "20240917-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
