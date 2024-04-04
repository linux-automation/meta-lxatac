# umpf-base: v6.8
# umpf-name: 6.8/customers/lxa/lxatac
# umpf-version: 6.8/customers/lxa/lxatac/20240403-1
# umpf-topic: v6.8/topic/reproducible-build
# umpf-hashinfo: 24381dc6edca6d82ecba7fe9842cd8405c6b6d3c
# umpf-topic-range: e8f897f4afef0031fe618a8e94127a0934896aba..5f75d667537d1586bfe150f515b68417f0d3a7d6
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  file://patches/0002-lib-build_OID_registry-Don-t-mention-the-full-path-o.patch \
  file://patches/0003-tty-vt-conmakehash-Don-t-mention-the-full-path-of-th.patch \
  file://patches/0004-drivers-video-logo-Don-t-mention-the-full-path-of-th.patch \
  "
# umpf-topic: v6.7/topic/net-ksz-switch
# umpf-hashinfo: dece8110fbc77c4701c16cac2cd3297ff0cbe0ee
# umpf-topic-range: 5f75d667537d1586bfe150f515b68417f0d3a7d6..1c878acf5ccfcf0b132ff15cd0f87eceddb3c4f7
SRC_URI += "\
  file://patches/0101-net-dsa-microchip-make-sure-drive-strength-configura.patch \
  file://patches/0102-net-bridge-switchdev-Improve-error-message-clarity-f.patch \
  file://patches/0103-net-dsa-microchip-add-regmap_range-for-KSZ9563-chip.patch \
  "
# umpf-topic: v6.8/topic/mmc-fix
# umpf-hashinfo: 828f8f71f7ffdfff2298b08fb840232dec3a9fad
# umpf-topic-range: 1c878acf5ccfcf0b132ff15cd0f87eceddb3c4f7..7a95689a730eac173febdda111d813d476933426
SRC_URI += "\
  file://patches/0201-mmc-core-block.c-initialize-mmc_blk_ioc_data.patch \
  file://patches/0202-mmc-core-block.c-avoid-negative-index-with-array-acc.patch \
  "
# umpf-topic: v6.8/topic/mipi-dbi-memory-leak
# umpf-hashinfo: 973f31c82d0d867af7f0f5559f749d56390a8bc5
# umpf-topic-range: 7a95689a730eac173febdda111d813d476933426..879fb3f71005ab971e7d8a4b103e8f66d602c7d7
SRC_URI += "\
  file://patches/0301-drm-atomic-helper-fix-parameter-order-in-drm_format_.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: b7d99b8a22130c95b0c6d25d6fb0d4f72bf8322e
# umpf-topic-range: 879fb3f71005ab971e7d8a4b103e8f66d602c7d7..6dd6f2431ae453c890bf19afbe20f74fe76824c9
SRC_URI += "\
  file://patches/0401-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0402-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0403-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0404-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  "
# umpf-release: 6.8/customers/lxa/lxatac/20240403-1
# umpf-topic-range: 6dd6f2431ae453c890bf19afbe20f74fe76824c9..7c28d6be263a148c5485a41c71512b91bc1366a9
SRC_URI += "\
  file://patches/0501-Release-6.8-customers-lxa-lxatac-20240403-1.patch \
  "
UMPF_BASE = "6.8"
UMPF_VERSION = "20240403-1"
PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
