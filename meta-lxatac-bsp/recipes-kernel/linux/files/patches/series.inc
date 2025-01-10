# umpf-base: v6.12
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.12/customers/lxa/lxatac
# umpf-version: 6.12/customers/lxa/lxatac/20241121-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: adc218676eef25575469234709c2d87185ca223a..8c8650a9514ce98c07b891b95f09da0e05d5913f
SRC_URI:append = " \
    file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
"
# umpf-topic: v6.12/customers/lxa/lxatac
# umpf-hashinfo: c7dc846896e7c2880071cd9fb4ae9b94d8d9e38e
# umpf-topic-range: 8c8650a9514ce98c07b891b95f09da0e05d5913f..c1a85acf9596faad5cd2df730cdbb2eb937c8418
SRC_URI:append = " \
    file://patches/0101-ARM-dts-stm32-lxa-tac-disable-the-real-time-clock.patch \
    file://patches/0102-ARM-dts-stm32-lxa-tac-extend-the-alias-table.patch \
    file://patches/0103-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
    file://patches/0104-dt-bindings-arm-stm32-add-compatible-strings-for-Lin.patch \
    file://patches/0105-ARM-dts-stm32-lxa-tac-move-adc-and-gpio-e-g-to-gen-1.patch \
    file://patches/0106-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
"
# umpf-release: 6.12/customers/lxa/lxatac/20241121-1
# umpf-topic-range: c1a85acf9596faad5cd2df730cdbb2eb937c8418..177206858679e0e2f5e0ef4bf5dfe093120c3cc0
SRC_URI:append = " \
    file://patches/0201-Release-6.12-customers-lxa-lxatac-20241121-1.patch \
"
UMPF_BASE = "6.12"
UMPF_VERSION = "20241121-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
