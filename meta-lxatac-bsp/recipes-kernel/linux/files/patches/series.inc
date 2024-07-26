# umpf-base: v6.10
# umpf-name: 6.10/customers/lxa/lxatac
# umpf-version: 6.10/customers/lxa/lxatac/20240726-1
# umpf-topic: v6.8/topic/reproducible-build
# umpf-hashinfo: 80b65016ce3a5ee2d383964372f1a035206ca2d7
# umpf-topic-range: 0c3836482481200ead7b416ca80c68a29cfdaabd..3e601acab42266f4e14d74d29c0938ffecea1709
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.8/customers/lxa/lxatac
# umpf-hashinfo: b7d99b8a22130c95b0c6d25d6fb0d4f72bf8322e
# umpf-topic-range: 3e601acab42266f4e14d74d29c0938ffecea1709..789188fff1c5200656b345f88c468354e45ce037
SRC_URI += "\
  file://patches/0101-ARM-dts-stm32-lxa-tac-adjust-USB-gadget-fifo-sizes-f.patch \
  file://patches/0102-ARM-dts-stm32-lxa-tac-Add-support-for-generation-3-d.patch \
  "
# umpf-release: 6.10/customers/lxa/lxatac/20240726-1
# umpf-topic-range: 789188fff1c5200656b345f88c468354e45ce037..9aaf0788e3b70b7f6690a2f7fe5dc7356e418069
SRC_URI += "\
  file://patches/0201-Release-6.10-customers-lxa-lxatac-20240726-1.patch \
  "
UMPF_BASE = "6.10"
UMPF_VERSION = "20240726-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION = "${UMPF_BASE}"
# umpf-end
