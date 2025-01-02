# umpf-base: v6.13
# umpf-name: 6.13/customers/lxa/lxatac
# umpf-version: 6.13/customers/lxa/lxatac/20250120-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: ffd294d346d185b70e28b1a28abe367bbfe53c04..1059a08c2a0d161547106db542662b551619654b
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.12/customers/lxa/lxatac
# umpf-hashinfo: c7dc846896e7c2880071cd9fb4ae9b94d8d9e38e
# umpf-topic-range: 1059a08c2a0d161547106db542662b551619654b..c3630000876e25a75cd5c08808545d39832276e5
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-tac-disable-the-real-time-clock.patch \
  file://patches/0102-ARM-dts-stm32-lxa-tac-extend-the-alias-table.patch \
  file://patches/0103-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0104-dt-bindings-arm-stm32-add-compatible-strings-for-Lin.patch \
  file://patches/0105-ARM-dts-stm32-lxa-tac-move-adc-and-gpio-e-g-to-gen-1.patch \
  file://patches/0106-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  "
# umpf-release: 6.13/customers/lxa/lxatac/20250120-1
# umpf-topic-range: c3630000876e25a75cd5c08808545d39832276e5..e34f9437065fdf86dc3db89b029b5fb9068577e3
SRC_URI += "\
  file://patches/0201-Release-6.13-customers-lxa-lxatac-20250120-1.patch \
  "
UMPF_BASE = "6.13"
UMPF_VERSION = "20250120-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
