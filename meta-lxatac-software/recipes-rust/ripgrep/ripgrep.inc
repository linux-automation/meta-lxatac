inherit cargo cargo-update-recipe-crates

SRC_URI += "git://github.com/BurntSushi/ripgrep.git;protocol=https;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

LIC_FILES_CHKSUM = " \
    file://LICENSE-MIT;md5=8d0d0aa488af0ab9aafa3b85a7fc8e12 \
    file://UNLICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680 \
"

SUMMARY = "ripgrep is a line-oriented search tool that recursively searches your current \
directory for a regex pattern while respecting your gitignore rules. ripgrep \
has first class support on Windows, macOS and Linux."
HOMEPAGE = "https://github.com/BurntSushi/ripgrep"
LICENSE = "Unlicense | MIT"

require ripgrep-crates.inc
