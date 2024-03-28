# umpf-base: v2023.10.0
# umpf-name: 2023.10.0/customers/lxa/tac
# umpf-version: 2023.10.0/customers/lxa/tac/20231024-1
# umpf-topic: v2023.10.0/topic/tlv
# umpf-hashinfo: dc2c1cf14ce0dceb10a10874d3e41f7aacbba6a4
# umpf-topic-range: bc5e49335067d0c6c6e97c082a0368fe9d86b725..795783323c2d9c7890ba52382ba50e081a40e076
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
# umpf-topic: v2023.10.0/customers/lxa/tac
# umpf-hashinfo: ef3992fcd189834e633f466bd6d68b5512162726
# umpf-topic-range: 795783323c2d9c7890ba52382ba50e081a40e076..a5d76ea4f6f84917216011ee6d6a519e69a58c26
SRC_URI += "\
  file://patches/0101-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0102-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  "
# umpf-release: 2023.10.0/customers/lxa/tac/20231024-1
# umpf-topic-range: a5d76ea4f6f84917216011ee6d6a519e69a58c26..a8fe26cc7bef670597217cc9842e3d08fe0d7733
SRC_URI += "\
  file://patches/0201-Release-2023.10.0-customers-lxa-tac-20231024-1.patch \
  "
# umpf-end
