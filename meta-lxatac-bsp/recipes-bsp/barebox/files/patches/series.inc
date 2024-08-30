# umpf-base: v2024.09.0
# umpf-name: 2024.09.0/customers/lxa/tac
# umpf-version: 2024.09.0/customers/lxa/tac/20240918-1
# umpf-topic: v2024.09.0/topic/tlv
# umpf-hashinfo: 328855e48bdb9912ed99b13d817f79a90347d494
# umpf-topic-range: 7ae6bbdfa69855ee2f46fabda6622875f408fb1c..147c498e71cb5d60b4868c2f3eaf2d5e6ca12540
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
# umpf-topic: v2024.09.0/customers/lxa/tac
# umpf-hashinfo: 716a5ca90640f5aecf0c96e7993d05c2ef885f33
# umpf-topic-range: 147c498e71cb5d60b4868c2f3eaf2d5e6ca12540..430d11d834bc265f559d962a2d22b274791d3b51
SRC_URI += "\
  file://patches/0101-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0102-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  file://patches/0103-ARM-stm32mp-add-Linux-Automation-TAC-Generation-3.patch \
  "
# umpf-release: 2024.09.0/customers/lxa/tac/20240918-1
# umpf-topic-range: 430d11d834bc265f559d962a2d22b274791d3b51..8b188e344eedfdf3f7fc7947f6a99c785ce69bf1
SRC_URI += "\
  file://patches/0201-Release-2024.09.0-customers-lxa-tac-20240918-1.patch \
  "
UMPF_BASE = "2024.09.0"
UMPF_VERSION = "20240918-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
# umpf-end
