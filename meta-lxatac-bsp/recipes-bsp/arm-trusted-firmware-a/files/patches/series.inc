# umpf-base: v2.9
# umpf-name: 2.9/customers/lxa/tac
# umpf-version: 2.9/customers/lxa/tac/20240130-1
# umpf-topic: v2.9/customers/lxa/tac
# umpf-hashinfo: 760fec437d17c83e244decd02aafc8b1c5582c9b
# umpf-topic-range: d3e71ead6ea5bc3555ac90a446efec84ef6c6122..c76dadca0b61699e5cfc1b4233faa0019c96bb68
SRC_URI += "\
  file://patches/0001-fdts-add-lxa-tac.patch \
  file://patches/0002-lxatac-ETH-PLL-configuration.patch \
  file://patches/0003-lxatac-use-custom-PLL-configuration.patch \
  "
# umpf-release: 2.9/customers/lxa/tac/20240130-1
# umpf-topic-range: c76dadca0b61699e5cfc1b4233faa0019c96bb68..4c69731e814fca9a47e71cd301368833b0c7ec1d
SRC_URI += "\
  file://patches/0101-Release-2.9-customers-lxa-tac-20240130-1.patch \
  "
# umpf-end
