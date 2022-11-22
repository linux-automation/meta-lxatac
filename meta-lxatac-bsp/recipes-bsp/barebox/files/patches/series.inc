# umpf-base: v2022.11.0
# umpf-name: 2022.11/customers/lxa/tac
# umpf-version: 2022.11/customers/lxa/tac/20221121-1
# umpf-topic: v2022.11.0/topic/tlv
# umpf-hashinfo: 0d2369b5e4506860b717a24872df277ce5cdedcf
# umpf-topic-range: f1b22deeb6ed8bfef865990b8404874e66f9b4d7..110bbde10a2f1db8277a1f3d2328c5a5f6dceffa
SRC_URI += "\
  file://patches/0001-scripts-implement-slurp-a-read_file-with-fd-as-argum.patch \
  file://patches/0002-of_path-support-phandles-in-of_find_path.patch \
  file://patches/0003-Makefile-add-common-boards-include-to-include-search.patch \
  file://patches/0004-net-add-ethaddr-sequence-handling.patch \
  file://patches/0005-common-add-global.serial_number-with-device-tree-fix.patch \
  file://patches/0006-common-add-optional-systemd.hostname-generation.patch \
  file://patches/0007-net-factor-out-eth_of_get_fixup_node.patch \
  file://patches/0008-net-export-list-of-registered-ethernet-addresses.patch \
  file://patches/0009-net-implement-ethaddr_string_cmp.patch \
  file://patches/0010-common-add-barebox-TLV-support.patch \
  file://patches/0011-commands-add-TLV-debugging-command.patch \
  file://patches/0012-scripts-add-bareboxtlv-host-target-tool.patch \
  "
# umpf-topic: v2022.11.0/customers/lxa/tac
# umpf-hashinfo: eb4c6d6fd9afa4a427e4c483acd01a620ed61e4c
# umpf-topic-range: 110bbde10a2f1db8277a1f3d2328c5a5f6dceffa..a5da7cf2a3cd2414d57d3f937351060a2c0b2182
SRC_URI += "\
  file://patches/0101-WIP-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  file://patches/0102-ARM-dts-LXATAC-enable-ohci.patch \
  file://patches/0103-ARM-stm32mp-dk2-add-barebox-env-and-state-on-SD.patch \
  file://patches/0104-ARM-stm32mp-lxa-tac-add-barebox-env-and-state-on-eMM.patch \
  file://patches/0105-ARM-stm32mp-lxa-tac-add-properties-for-ssd1306.patch \
  file://patches/0106-HACK-video-ssd1307fb-increase-VCOMH-to-0x40.patch \
  file://patches/0107-ARM-lxatac-add-FIP-barebox-update-handler.patch \
  file://patches/0108-ARM-stm32mp-lxa-tac-enable-access-to-ramoops.patch \
  file://patches/0109-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0110-ARM-stm32mp-dts-lxa-tac-wire-in-factory-data.patch \
  file://patches/0111-ARM-lxatac-register-TLV-decoder-and-print-out-serial.patch \
  file://patches/0112-HACK-Workaround-timeout-after-core-reset-on-some-lxa.patch \
  "
# umpf-topic: v2022.11.0/topic/stm32mp-bbu-fip
# umpf-hashinfo: f16096380bd60209269a8b016dd68234fa81ad6d
# umpf-topic-range: a5da7cf2a3cd2414d57d3f937351060a2c0b2182..f6f088bacaf30b5385d75e2a1cbbea06d8e103da
SRC_URI += "\
  file://patches/0201-fastboot-inform-user-if-barebox-update-falls-back-to.patch \
  "
# umpf-topic: 2022.11.0/topic/compressed-dtb-no-lzo
# umpf-hashinfo: 9ba1489e7cc9b5630f8eea09a69c0567ddbbf7bd
# umpf-topic-range: f6f088bacaf30b5385d75e2a1cbbea06d8e103da..8a12e9c81a9a1626c5a5351be9722e8c76c3daf7
SRC_URI += "\
  file://patches/0301-kbuild-gen-dtb-s-refactor-to-allow-different-compres.patch \
  file://patches/0302-scripts-gen-dtb-s-fallback-to-LZ4-if-lzop-is-unavail.patch \
  "
# umpf-release: 2022.11/customers/lxa/tac/20221121-1
# umpf-topic-range: 8a12e9c81a9a1626c5a5351be9722e8c76c3daf7..709d8e0b74506bfe4907936f843849f8d27d7cfa
SRC_URI += "\
  file://patches/0401-Release-2022.11-customers-lxa-tac-20221121-1.patch \
  "
# umpf-end
