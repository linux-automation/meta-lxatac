# umpf-base: v2026.01.0
# umpf-flags: upstreamstatus=insert
# umpf-name: 2025.01.0/customers/lxa/tac
# umpf-version: 2025.01.0/customers/lxa/tac/20260121-1
# umpf-topic: v2026.01.0/customers/lxa/tac
# umpf-hashinfo: a7ac06f54e96e1e6a01f42a1a8fc9f799f08e4ec
# umpf-topic-range: 0024921364eb4c8bc8089fdc198440b0d67a239f..b80b79aa8d32c9f49d6a26cfe1a4b4723c451bfc
UMPF_SRC_URI += "\
  file://patches/0001-ARM-stm32mp-lxa-reuse-USB-nodes-from-upstream-DT.patch \
  file://patches/0002-efi-loader-protocol-gop-guard-behind-CONFIG_EFI_LOAD.patch \
  file://patches/0003-efi-loader-remove-dependency-on-LIBFDT.patch \
  "
# umpf-release: 2025.01.0/customers/lxa/tac/20260121-1
# umpf-topic-range: b80b79aa8d32c9f49d6a26cfe1a4b4723c451bfc..fe5ad23670403c391d400b26aa2a5fd4b41faac4
UMPF_SRC_URI += "\
  file://patches/0101-Release-2025.01.0-customers-lxa-tac-20260121-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "2026.01.0"
UMPF_VERSION = "20260121-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
# umpf-end
