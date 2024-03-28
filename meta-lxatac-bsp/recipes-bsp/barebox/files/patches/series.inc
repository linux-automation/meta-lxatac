# umpf-base: v2024.03.0
# umpf-name: 2024.03.0/customers/lxa/tac
# umpf-version: 2024.03.0/customers/lxa/tac/20240326-1
# umpf-topic: v2024.03.0/topic/tlv
# umpf-hashinfo: 7cda350efdca11246b5cba188e3becd8a9219cd9
# umpf-topic-range: c6d055d224e0b3a0aff638a05a367c30d2d0310e..c54d19b9a08f94b0fd087e2e827b428cdb1e5ea1
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
# umpf-topic: v2024.03.0/customers/lxa/tac
# umpf-hashinfo: 51f3fc6f2857242ccc14b9ee28d7a9ebb2c80a03
# umpf-topic-range: c54d19b9a08f94b0fd087e2e827b428cdb1e5ea1..eea999a4d27fb1030c5b4ee8a6d4fccccd716e9d
SRC_URI += "\
  file://patches/0101-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0102-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  file://patches/0103-ARM-stm32mp-add-Linux-Automation-TAC-Generation-3.patch \
  "
# umpf-release: 2024.03.0/customers/lxa/tac/20240326-1
# umpf-topic-range: eea999a4d27fb1030c5b4ee8a6d4fccccd716e9d..17d5969a47cf7da3829b417a9d2056bd20afb0f7
SRC_URI += "\
  file://patches/0201-Release-2024.03.0-customers-lxa-tac-20240326-1.patch \
  "
UMPF_BASE = "2024.03.0"
UMPF_VERSION = "20240326-1"
# Manually comment out the PV assignment to not break the SRC_URI in barebox.inc
# PV = "${UMPF_BASE}-${UMPF_VERSION}"
# umpf-end
