# umpf-base: v2024.10.0
# umpf-name: 2024.10.0/customers/lxa/tac
# umpf-version: 2024.10.0/customers/lxa/tac/20241018-1
# umpf-topic: v2024.09.0/topic/tlv
# umpf-hashinfo: 328855e48bdb9912ed99b13d817f79a90347d494
# umpf-topic-range: 1f31cde526d4e251da6464cac42ee2252643b972..9a3e1ac02b877ae8383c77541c63c3f232566eec
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
# umpf-hashinfo: 0400cb4b2d51a576d3fe663bbf74a1c3f5858dc3
# umpf-topic-range: 9a3e1ac02b877ae8383c77541c63c3f232566eec..8f0fd668eb6c040651cffda27e8547108b0f23fe
SRC_URI += "\
  file://patches/0101-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0102-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  file://patches/0103-ARM-stm32mp-add-Linux-Automation-TAC-Generation-3.patch \
  "
# umpf-release: 2024.10.0/customers/lxa/tac/20241018-1
# umpf-topic-range: 8f0fd668eb6c040651cffda27e8547108b0f23fe..d34362cdd815c983aa6216d9c011627f03576180
SRC_URI += "\
  file://patches/0201-Release-2024.10.0-customers-lxa-tac-20241018-1.patch \
  "
UMPF_BASE = "2024.10.0"
UMPF_VERSION = "20241018-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
# umpf-end
