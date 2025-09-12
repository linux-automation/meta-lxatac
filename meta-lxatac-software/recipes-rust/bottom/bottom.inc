inherit cargo cargo-update-recipe-crates

SRC_URI += "git://github.com/ClementTsang/bottom.git;protocol=https;branch=${SRCBRANCH}"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

# The bottom Cargo.toml strips release builds, why makes it hard to debug.
# Yocto has its own stripping feature, that preserves the debug symbols but
# only installs the stripped version.
# Pre-stripped binaries trigger a yocto QA error.
CARGO_BUILD_FLAGS += "--config profile.release.strip=false"

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=5d45cffa3a75da17d285cc60c0c458cc \
"

SUMMARY = "A customizable cross-platform graphical process/system monitor for the terminal. Supports Linux, macOS, and Windows."
HOMEPAGE = "https://github.com/ClementTsang/bottom"
LICENSE = "MIT"

require bottom-crates.inc
