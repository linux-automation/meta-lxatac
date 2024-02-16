SUMMARY = "Board Remote Control Utilities"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=884d48c2aa7b82e1ad4a33909fab24b6"

SRC_URI = "git://github.com/nxp-imx/bcu;protocol=https;branch=master \
           file://0001-CMakeLists-do-not-use-vendored-libcurl.patch \
           "
SRCREV = "e3f9a83210260783e901d4973da8600be03bcf04"

S = "${WORKDIR}/git"

DEPENDS = "curl libyaml libusb1 openssl libftdi"

inherit cmake pkgconfig

