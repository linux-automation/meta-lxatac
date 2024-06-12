# umpf-base: v6.9
# umpf-name: 6.9/customers/lxa/lxatac
# umpf-version: 6.9/customers/lxa/lxatac/20240514-1
# umpf-topic: v6.8/topic/reproducible-build
# umpf-hashinfo: 24381dc6edca6d82ecba7fe9842cd8405c6b6d3c
# umpf-topic-range: a38297e3fb012ddfa7ce0321a7e5a8daeb1872b6..03a2b245ef2f590527a67b8409de6558ac074f78
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  file://patches/0002-lib-build_OID_registry-Don-t-mention-the-full-path-o.patch \
  file://patches/0003-tty-vt-conmakehash-Don-t-mention-the-full-path-of-th.patch \
  file://patches/0004-drivers-video-logo-Don-t-mention-the-full-path-of-th.patch \
  "
# umpf-topic: v6.7/topic/net-ksz-switch
# umpf-hashinfo: dece8110fbc77c4701c16cac2cd3297ff0cbe0ee
# umpf-topic-range: 03a2b245ef2f590527a67b8409de6558ac074f78..3f732991ce21ce85405ceef97ff09b9bf6a49d07
SRC_URI += "\
  file://patches/0101-net-bridge-switchdev-Improve-error-message-clarity-f.patch \
  file://patches/0102-net-dsa-microchip-add-regmap_range-for-KSZ9563-chip.patch \
  "
# umpf-topic: v6.9/topic/stm32mp1-spi-fix-hang
# umpf-hashinfo: 19f3840d3f6fd21640162b109d2c673f20ea5658
# umpf-topic-range: 3f732991ce21ce85405ceef97ff09b9bf6a49d07..6d9914e168edd246120773f977a932ea69a34381
SRC_URI += "\
  file://patches/0201-Revert-spi-stm32-enable-controller-before-asserting-.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: b7d99b8a22130c95b0c6d25d6fb0d4f72bf8322e
# umpf-topic-range: 6d9914e168edd246120773f977a932ea69a34381..f0e1247153c6fc359a6db2ff8cd71ef56a2974e4
SRC_URI += "\
  file://patches/0301-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0302-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  "
# umpf-release: 6.9/customers/lxa/lxatac/20240514-1
# umpf-topic-range: f0e1247153c6fc359a6db2ff8cd71ef56a2974e4..b8419958eb46d6635c1c8c6e904cad5b4255bfdf
SRC_URI += "\
  file://patches/0401-Release-6.9-customers-lxa-lxatac-20240514-1.patch \
  "
UMPF_BASE = "6.9"
UMPF_VERSION = "20240514-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
