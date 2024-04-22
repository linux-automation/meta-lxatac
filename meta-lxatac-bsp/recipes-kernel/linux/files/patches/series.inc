# umpf-base: v6.8
# umpf-name: 6.8/customers/lxa/lxatac
# umpf-version: 6.8/customers/lxa/lxatac/20240417-1
# umpf-topic: v6.8/topic/serial-fixes
# umpf-hashinfo: db8e5fbdfa289165f0351629a8359e3fb7835561
# umpf-topic-range: e8f897f4afef0031fe618a8e94127a0934896aba..e2b201ee8ef10f83d89cdce8d1a3f0336fedd5e3
SRC_URI += "\
  file://patches/0001-serial-core-Clearing-the-circular-buffer-before-NULL.patch \
  file://patches/0002-serial-core-Fix-missing-shutdown-and-startup-for-ser.patch \
  file://patches/0003-serial-stm32-Return-IRQ_NONE-in-the-ISR-if-no-handli.patch \
  file://patches/0004-serial-stm32-Reset-.throttled-state-in-.startup.patch \
  "
# umpf-topic: v6.8/topic/reproducible-build
# umpf-hashinfo: 24381dc6edca6d82ecba7fe9842cd8405c6b6d3c
# umpf-topic-range: e2b201ee8ef10f83d89cdce8d1a3f0336fedd5e3..6e4417c4eb74abd44ea86a8bff2e731897147e35
SRC_URI += "\
  file://patches/0101-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  file://patches/0102-lib-build_OID_registry-Don-t-mention-the-full-path-o.patch \
  file://patches/0103-tty-vt-conmakehash-Don-t-mention-the-full-path-of-th.patch \
  file://patches/0104-drivers-video-logo-Don-t-mention-the-full-path-of-th.patch \
  "
# umpf-topic: v6.7/topic/net-ksz-switch
# umpf-hashinfo: dece8110fbc77c4701c16cac2cd3297ff0cbe0ee
# umpf-topic-range: 6e4417c4eb74abd44ea86a8bff2e731897147e35..68affd991c3c38456114003e2fdf72e06b7edfc8
SRC_URI += "\
  file://patches/0201-net-dsa-microchip-make-sure-drive-strength-configura.patch \
  file://patches/0202-net-bridge-switchdev-Improve-error-message-clarity-f.patch \
  file://patches/0203-net-dsa-microchip-add-regmap_range-for-KSZ9563-chip.patch \
  "
# umpf-topic: v6.8/topic/mmc-fix
# umpf-hashinfo: 828f8f71f7ffdfff2298b08fb840232dec3a9fad
# umpf-topic-range: 68affd991c3c38456114003e2fdf72e06b7edfc8..c8c2d0530f72c503537333fcdef3407568b77617
SRC_URI += "\
  file://patches/0301-mmc-core-block.c-initialize-mmc_blk_ioc_data.patch \
  file://patches/0302-mmc-core-block.c-avoid-negative-index-with-array-acc.patch \
  "
# umpf-topic: v6.8/topic/mipi-dbi-memory-leak
# umpf-hashinfo: 973f31c82d0d867af7f0f5559f749d56390a8bc5
# umpf-topic-range: c8c2d0530f72c503537333fcdef3407568b77617..57e3c05e0eea5568ae0ba442e443f6b049bcd3b0
SRC_URI += "\
  file://patches/0401-drm-atomic-helper-fix-parameter-order-in-drm_format_.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: b7d99b8a22130c95b0c6d25d6fb0d4f72bf8322e
# umpf-topic-range: 57e3c05e0eea5568ae0ba442e443f6b049bcd3b0..4f2545b9e604d981d8236a52dfc455a4e94597b9
SRC_URI += "\
  file://patches/0501-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0502-ARM-dts-stm32-lxa-tac-drive-powerboard-lines-as-open.patch \
  file://patches/0503-ARM-dts-stm32-lxa-tac-reduce-RGMII-interface-drive-s.patch \
  file://patches/0504-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  "
# umpf-release: 6.8/customers/lxa/lxatac/20240417-1
# umpf-topic-range: 4f2545b9e604d981d8236a52dfc455a4e94597b9..8367fb420e0d1f3db3dd4fe74f81f70f53f6f610
SRC_URI += "\
  file://patches/0601-Release-6.8-customers-lxa-lxatac-20240417-1.patch \
  "
UMPF_BASE = "6.8"
UMPF_VERSION = "20240417-1"
PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
