SUMMARY = "Universal Update Utility"
DESCRIPTION = "Image deployment tool for i.MX chips"
HOMEPAGE = "https://github.com/NXPmicro/mfgtools"

SRC_URI = "git://github.com/nxp-imx/mfgtools.git;protocol=https;branch=master;tag=uuu_${PV}"

# Commit created 0000-00-00 00:00:00 +0000
SRCREV = "79ce7d2b2e7459e7b7c94f902d172c30b08884ab"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38ec0c18112e9a92cffc4951661e85a5"

inherit cmake pkgconfig

DEPENDS = "libusb zlib bzip2 openssl libtinyxml2"

BBCLASSEXTEND = "native nativesdk"
