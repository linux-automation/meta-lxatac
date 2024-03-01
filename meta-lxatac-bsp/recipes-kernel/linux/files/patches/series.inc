# umpf-base: v6.8
# umpf-name: 6.8/customers/lxa/lxatac
# umpf-version: 6.8/customers/lxa/lxatac/20240321-1
# umpf-topic: v6.8/topic/reproducible-build
# umpf-hashinfo: f6d939fc20195e315035607c0c72d358f0bb73e3
# umpf-topic-range: e8f897f4afef0031fe618a8e94127a0934896aba..8ad3d577c03c3e815d8a493f94f9762b74a6b3c6
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  file://patches/0002-lib-build_OID_registry-Don-t-mention-the-full-path-o.patch \
  file://patches/0003-tty-vt-conmakehash-Don-t-mention-the-full-path-of-th.patch \
  "
# umpf-topic: v6.7/topic/net-ksz-switch
# umpf-hashinfo: dece8110fbc77c4701c16cac2cd3297ff0cbe0ee
# umpf-topic-range: 8ad3d577c03c3e815d8a493f94f9762b74a6b3c6..f7fee7ab4b141f28acda48eff1dd8f2c80b2bfae
SRC_URI += "\
  file://patches/0101-net-dsa-microchip-make-sure-drive-strength-configura.patch \
  file://patches/0102-net-bridge-switchdev-Improve-error-message-clarity-f.patch \
  file://patches/0103-net-dsa-microchip-add-regmap_range-for-KSZ9563-chip.patch \
  "
# umpf-topic: v6.8/topic/mmc-fix
# umpf-hashinfo: 828f8f71f7ffdfff2298b08fb840232dec3a9fad
# umpf-topic-range: f7fee7ab4b141f28acda48eff1dd8f2c80b2bfae..27dbef9799e218300fd3f8843edcd24a91a258be
SRC_URI += "\
  file://patches/0201-mmc-core-block.c-initialize-mmc_blk_ioc_data.patch \
  file://patches/0202-mmc-core-block.c-avoid-negative-index-with-array-acc.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: fda5ce9210c0279e8902f12179f2c00f9f214653
# umpf-topic-range: 27dbef9799e218300fd3f8843edcd24a91a258be..d8efdb1b43b959f3358bfe44d9017053db3dbf6c
SRC_URI += "\
  file://patches/0301-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0302-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0303-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  "
# umpf-release: 6.8/customers/lxa/lxatac/20240321-1
# umpf-topic-range: d8efdb1b43b959f3358bfe44d9017053db3dbf6c..f6bb1566d4d8ec6c3d634740e665aea78a466bd6
SRC_URI += "\
  file://patches/0401-Release-6.8-customers-lxa-lxatac-20240321-1.patch \
  "
UMPF_BASE = "6.8"
UMPF_VERSION = "20240321-1"
PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
