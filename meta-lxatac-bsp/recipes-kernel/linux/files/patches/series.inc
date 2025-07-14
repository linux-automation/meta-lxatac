# umpf-base: v6.16-rc6
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.16/customers/lxa/lxatac
# umpf-version: 6.16/customers/lxa/lxatac/20250714-1
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 347e9f5043c89695b01e66b3ed111755afcf1911..944cd6cacfc9dd16c6b33f54f1469c8a7a262639
UMPF_SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.16/topic/new-sysfs-gpio
# umpf-hashinfo: 0f612a45e557168745aae68b0d7e94860f978260
# umpf-topic-range: 944cd6cacfc9dd16c6b33f54f1469c8a7a262639..585f269c99e6ffee9baa836bb7ff75138d13c9d0
UMPF_SRC_URI += "\
  file://patches/0101-gpio-sysfs-call-mutex_destroy-in-gpiod_unexport.patch \
  file://patches/0102-gpio-sysfs-refactor-the-coding-style.patch \
  file://patches/0103-gpio-sysfs-remove-the-mockdev-pointer-from-struct-gp.patch \
  file://patches/0104-gpio-sysfs-fix-use-after-free-in-error-path.patch \
  file://patches/0105-gpio-sysfs-use-gpiod_is_equal-to-compare-GPIO-descri.patch \
  file://patches/0106-gpio-sysfs-add-a-parallel-class-device-for-each-GPIO.patch \
  file://patches/0107-gpio-sysfs-only-get-the-dirent-reference-for-the-val.patch \
  file://patches/0108-gpio-sysfs-pass-gpiod_data-directly-to-internal-GPIO.patch \
  file://patches/0109-gpio-sysfs-rename-the-data-variable-in-gpiod_-un-exp.patch \
  file://patches/0110-gpio-sysfs-don-t-use-driver-data-in-sysfs-callbacks-.patch \
  file://patches/0111-gpio-sysfs-don-t-look-up-exported-lines-as-class-dev.patch \
  file://patches/0112-gpio-sysfs-export-the-GPIO-directory-locally-in-the-.patch \
  file://patches/0113-gpio-sysfs-allow-disabling-the-legacy-parts-of-the-G.patch \
  file://patches/0114-gpio-TODO-remove-the-task-for-the-sysfs-rework.patch \
  "
# umpf-release: 6.16/customers/lxa/lxatac/20250714-1
# umpf-topic-range: 585f269c99e6ffee9baa836bb7ff75138d13c9d0..cb357ef2b9098046e741be50c95302b3562878c1
UMPF_SRC_URI += "\
  file://patches/0201-Release-6.16-customers-lxa-lxatac-20250714-1.patch \
  "
SRC_URI += "${UMPF_SRC_URI}"

UMPF_BASE = "6.16-rc6"
UMPF_VERSION = "20250714-1"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
