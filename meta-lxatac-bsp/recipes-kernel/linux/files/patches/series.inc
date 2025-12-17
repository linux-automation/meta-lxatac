# umpf-base: v6.19
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.19/customers/lxa/lxatac
# umpf-version: 6.19/customers/lxa/lxatac/20260218-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 05f7e89ab9731565d8a62e3b5d1ec206485eeb0b..c617c89bf4326a83a52a625272e378f7be9c3363
UMPF_SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-release: 6.19/customers/lxa/lxatac/20260218-1
# umpf-topic-range: c617c89bf4326a83a52a625272e378f7be9c3363..2e959f275bdea6b510bd425ed2655ea560c63d1b
UMPF_SRC_URI += "\
  file://patches/0101-Release-6.19-customers-lxa-lxatac-20260218-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "6.19"
UMPF_VERSION = "20260218-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
