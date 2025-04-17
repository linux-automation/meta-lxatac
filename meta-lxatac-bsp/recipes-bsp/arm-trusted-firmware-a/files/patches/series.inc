# umpf-base: v2.10
# umpf-flags: upstreamstatus=insert
# umpf-name: 2.10/customers/lxa/tac
# umpf-version: 2.10/customers/lxa/tac/20250401-1
# umpf-topic: v2.10/customers/lxa/tac
# umpf-hashinfo: 3f333dd1c360e5e1ef4a7a6f304084e57a24a626
# umpf-topic-range: b6c0948400594e3cc4dbb5a4ef04b815d2675808..202b627af576235d643b39d70c66f6ee974345d3
SRC_URI += "\
  file://patches/0001-fdts-lxa-tac-add-Linux-Automation-GmbH-TAC.patch \
  "
# umpf-release: 2.10/customers/lxa/tac/20250401-1
# umpf-topic-range: 202b627af576235d643b39d70c66f6ee974345d3..84949c56efa5fb7a20685baa2da15b9081d474d6
SRC_URI += "\
  file://patches/0101-Release-2.10-customers-lxa-tac-20250401-1.patch \
  "
UMPF_BASE = "2.10"
UMPF_VERSION = "20250401-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
# umpf-end
