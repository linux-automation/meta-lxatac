# umpf-base: v2023.12.0
# umpf-name: 2023.12.0/customers/lxa/tac
# umpf-version: 2023.12.0/customers/lxa/tac/20231222-1
# umpf-topic: v2023.12.0/topic/tlv
# umpf-hashinfo: 7cb6fc8a43fa1b0b8758ff231e15eb6ae6582e5d
# umpf-topic-range: ed433cbef99860b39dfbc2d36983026cced54583..b99a5285a013ef96fe647965e3f6c4ef2a3381ee
SRC_URI += "\
  file://patches/0001-scripts-implement-slurp-a-read_file-with-fd-as-argum.patch \
  file://patches/0002-of_path-support-phandles-in-of_find_path.patch \
  file://patches/0003-Makefile-add-common-boards-include-to-include-search.patch \
  file://patches/0004-net-add-ethaddr-sequence-handling.patch \
  file://patches/0005-common-add-optional-systemd.hostname-generation.patch \
  file://patches/0006-net-factor-out-eth_of_get_fixup_node.patch \
  file://patches/0007-net-export-list-of-registered-ethernet-addresses.patch \
  file://patches/0008-net-implement-ethaddr_string_cmp.patch \
  file://patches/0009-common-add-barebox-TLV-support.patch \
  file://patches/0010-commands-add-TLV-debugging-command.patch \
  file://patches/0011-scripts-add-bareboxtlv-host-target-tool.patch \
  "
# umpf-topic: v2023.12.0/customers/lxa/tac
# umpf-hashinfo: e68bc9e17a5797c661b499effb2422f80922cd84
# umpf-topic-range: b99a5285a013ef96fe647965e3f6c4ef2a3381ee..e8be1c578bbce8a952b2507b5fd6de2c01c3a07b
SRC_URI += "\
  file://patches/0101-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0102-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  "
# umpf-release: 2023.12.0/customers/lxa/tac/20231222-1
# umpf-topic-range: e8be1c578bbce8a952b2507b5fd6de2c01c3a07b..86f51aa9f707ecf7a8b2236443f84cbd2b750b6a
SRC_URI += "\
  file://patches/0201-Release-2023.12.0-customers-lxa-tac-20231222-1.patch \
  "
# umpf-end
