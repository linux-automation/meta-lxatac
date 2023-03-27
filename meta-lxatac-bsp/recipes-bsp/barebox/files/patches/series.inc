# umpf-base: v2023.03.0
# umpf-name: 2023.03.0/customers/lxa/tac
# umpf-version: 2023.03.0/customers/lxa/tac/20230327-1
# umpf-topic: v2023.03.0/topic/tlv
# umpf-hashinfo: 38338204f9113c23c5d5f667cc209fe3a9476456
# umpf-topic-range: e068bbf6a3608351484567af19da68e0e382fa0f..77abc3a4c4e8d2b240ac1edac15337d1132b0f19
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
# umpf-topic: v2023.03.0/customers/lxa/tac
# umpf-hashinfo: af487478881365b49c8b616ce15d6a8bd09cab1a
# umpf-topic-range: 77abc3a4c4e8d2b240ac1edac15337d1132b0f19..a22d3f82a1fca1759c3ecdec9b29f0b4e83eef45
SRC_URI += "\
  file://patches/0101-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  file://patches/0102-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0103-ARM-stm32mp-dts-lxa-tac-wire-in-factory-data.patch \
  file://patches/0104-ARM-lxatac-register-TLV-decoder-and-print-out-serial.patch \
  "
# umpf-release: 2023.03.0/customers/lxa/tac/20230327-1
# umpf-topic-range: a22d3f82a1fca1759c3ecdec9b29f0b4e83eef45..f9f0cf3e45009b351a46340a488d8d432150b7bb
SRC_URI += "\
  file://patches/0201-Release-2023.03.0-customers-lxa-tac-20230327-1.patch \
  "
# umpf-end
