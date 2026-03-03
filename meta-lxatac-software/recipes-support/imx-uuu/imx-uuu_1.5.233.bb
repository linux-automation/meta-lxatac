SUMMARY = "Universal Update Utility"
DESCRIPTION = "Image deployment tool for i.MX chips"
HOMEPAGE = "https://github.com/NXPmicro/mfgtools"

SRC_URI = "git://github.com/nxp-imx/mfgtools.git;protocol=https;branch=master;tag=uuu_${PV}"

# Commit created 2025-08-28 15:09:42 +0000
SRCREV = "395e793b8821392ebc5ce47d852c3557b62e9f51"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38ec0c18112e9a92cffc4951661e85a5"

inherit cmake pkgconfig

DEPENDS = "libusb zlib bzip2 openssl libtinyxml2"

BBCLASSEXTEND = "native nativesdk"
