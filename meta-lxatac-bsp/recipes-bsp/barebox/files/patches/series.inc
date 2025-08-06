# umpf-base: v2025.07.0
# umpf-flags: upstreamstatus=insert
# umpf-name: 2025.07.0/customers/lxa/tac
# umpf-version: 2025.07.0/customers/lxa/tac/20250806-1
# umpf-topic: v2025.07.0/topic/tlv-mac-address-fix
# umpf-hashinfo: a610eb497bee9169bd5bc3191df7623511f4de0f
# umpf-topic-range: 89bf1fcc998fc5fea0ce613d9930dd9ee39c0fb2..ee49b3c21fb4dfc0f9006d9ca3fec937830b5bfb
UMPF_SRC_URI += "\
  file://patches/0001-tlv-drop-assigned-MAC-addresses-from-fixup.patch \
  "
# umpf-release: 2025.07.0/customers/lxa/tac/20250806-1
# umpf-topic-range: ee49b3c21fb4dfc0f9006d9ca3fec937830b5bfb..197d8621bce3b1e90719524ded61a5ac227c8cdb
UMPF_SRC_URI += "\
  file://patches/0101-Release-2025.07.0-customers-lxa-tac-20250806-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "2025.07.0"
UMPF_VERSION = "20250806-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
# umpf-end
