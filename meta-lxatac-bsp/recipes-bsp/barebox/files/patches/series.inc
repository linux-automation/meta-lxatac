# umpf-base: v2024.10.0
# umpf-flags: upstreamstatus=insert
# umpf-name: 2024.10.0/customers/lxa/tac
# umpf-version: 2024.10.0/customers/lxa/tac/20241121-2
# umpf-topic: v2024.10.0/topic/tlv
# umpf-hashinfo: 6d130e9537b785ad42b8bfb6d0d9c91fd70a3eea
# umpf-topic-range: 1f31cde526d4e251da6464cac42ee2252643b972..3b1c5b6c26759c488ca8aa83e9145972d229eea7
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
# umpf-topic: v2024.10.0/customers/lxa/tac
# umpf-hashinfo: 1413c76bc3233a8732a51c3010d6a8433e2b7e3a
# umpf-topic-range: 3b1c5b6c26759c488ca8aa83e9145972d229eea7..df227f29447718518a7bb92954fc4f74aa58d77f
SRC_URI += "\
    file://patches/0101-boards-add-decoder-for-LXA-TLV-v1-format.patch \
    file://patches/0102-ARM-dts-stm32-lxa-tac-fix-gen-1-2-boards-and-add-gen.patch \
    file://patches/0103-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
"
# umpf-release: 2024.10.0/customers/lxa/tac/20241121-2
# umpf-topic-range: df227f29447718518a7bb92954fc4f74aa58d77f..be16d68f8fa1f5197557d48c1f0b9f50cc342895
SRC_URI += "\
    file://patches/0201-Release-2024.10.0-customers-lxa-tac-20241121-2.patch \
"
UMPF_BASE = "2024.10.0"
UMPF_VERSION = "20241121-2"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
# umpf-end
