# umpf-base: v6.12
# umpf-name: 6.12/customers/lxa/lxatac
# umpf-version: 6.12/customers/lxa/lxatac/20241118-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: adc218676eef25575469234709c2d87185ca223a..8c8650a9514ce98c07b891b95f09da0e05d5913f
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: 41e4da0d7f6a4d2ddef615f2d69fc7d6298e737e
# umpf-topic-range: 8c8650a9514ce98c07b891b95f09da0e05d5913f..d98a39be0cddc9e4a28f9a9758f3d517eb927260
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0102-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  file://patches/0103-ARM-dts-stm32-lxa-tac-extend-the-alias-table.patch \
  file://patches/0104-ARM-dts-stm32-lxa-tac-disable-the-real-time-clock.patch \
  "
# umpf-release: 6.12/customers/lxa/lxatac/20241118-1
# umpf-topic-range: d98a39be0cddc9e4a28f9a9758f3d517eb927260..82d844eb62df33d5f619cda908abf782dea24dac
SRC_URI += "\
  file://patches/0201-Release-6.12-customers-lxa-lxatac-20241118-1.patch \
  "
UMPF_BASE = "6.12"
UMPF_VERSION = "20241118-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
