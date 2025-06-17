# umpf-base: v6.15
# umpf-flags: upstreamstatus=insert
# umpf-name: 6.15/customers/lxa/lxatac
# umpf-version: 6.15/customers/lxa/lxatac/20250617-2
# umpf-topic: v6.11/topic/reproducible-build
# umpf-hashinfo: d6ed6f191343a77bfe41d7436b51dffe8bcac441
# umpf-topic-range: 0ff41df1cb268fc69e703a08a57ee14ae967d0ca..194577539982ccd0506aa559ef7d68d24a2a03c7
SRC_URI += "\
  file://patches/0001-ARM-Don-t-mention-the-full-path-of-the-source-direct.patch \
  "
# umpf-topic: v6.14/topic/dwc2_clock_gating
# umpf-hashinfo: c1c67a4b104b8eb5a959a04554689c4e927307a6
# umpf-topic-range: 194577539982ccd0506aa559ef7d68d24a2a03c7..2be5cba9bbaec5a1d9655ee05d3801a92649a29f
SRC_URI += "\
  file://patches/0101-usb-dwc2-also-exit-clock_gating-when-stopping-udc-wh.patch \
  "
# umpf-topic: v6.15/topic/new-sysfs-gpio
# umpf-hashinfo: 8d878adb132d50d207ec18cea809a74d869c2cb0
# umpf-topic-range: 2be5cba9bbaec5a1d9655ee05d3801a92649a29f..e6afe76bebe230de3cdf8ef8dd2ae21fea8f1d8b
SRC_URI += "\
  file://patches/0201-Documentation-gpio-undocument-removed-behavior.patch \
  file://patches/0202-Documentation-gpio-document-the-active_low-field-in-.patch \
  file://patches/0203-gpio-sysfs-call-mutex_destroy-in-gpiod_unexport.patch \
  file://patches/0204-gpio-sysfs-refactor-the-coding-style.patch \
  file://patches/0205-gpio-sysfs-remove-unneeded-headers.patch \
  file://patches/0206-gpio-sysfs-remove-the-mockdev-pointer-from-struct-gp.patch \
  file://patches/0207-gpio-sysfs-add-a-parallel-class-device-for-each-GPIO.patch \
  file://patches/0208-gpio-sysfs-only-get-the-dirent-reference-for-the-val.patch \
  file://patches/0209-gpio-sysfs-pass-gpiod_data-directly-to-internal-GPIO.patch \
  file://patches/0210-gpio-sysfs-don-t-use-driver-data-in-sysfs-callbacks-.patch \
  file://patches/0211-gpio-sysfs-rename-the-data-variable-in-gpiod_-un-exp.patch \
  file://patches/0212-gpio-sysfs-don-t-look-up-exported-lines-as-class-dev.patch \
  file://patches/0213-gpio-sysfs-export-the-GPIO-directory-locally-in-the-.patch \
  file://patches/0214-gpio-sysfs-allow-disabling-the-legacy-parts-of-the-G.patch \
  file://patches/0215-gpio-TODO-remove-the-task-for-the-sysfs-rework.patch \
  "
# umpf-release: 6.15/customers/lxa/lxatac/20250617-2
# umpf-topic-range: e6afe76bebe230de3cdf8ef8dd2ae21fea8f1d8b..b5fc1f106e7364ae60da33aef4b70b2d56924671
SRC_URI += "\
  file://patches/0301-Release-6.15-customers-lxa-lxatac-20250617-2.patch \
  "
UMPF_BASE = "6.15"
UMPF_VERSION = "20250617-2"
UMPF_PV = "${UMPF_BASE}-${UMPF_VERSION}"
LINUX_VERSION ?= "${UMPF_BASE}"
# umpf-end
