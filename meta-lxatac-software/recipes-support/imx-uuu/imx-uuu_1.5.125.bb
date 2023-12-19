SUMMARY = "Universal Update Utility"
DESCRIPTION = "Image deployment tool for i.MX chips"
HOMEPAGE = "https://github.com/NXPmicro/mfgtools"

SRC_URI = "https://github.com/nxp-imx/mfgtools/releases/download/uuu_${PV}/uuu_source-uuu_${PV}.tar.gz"
SRC_URI[sha256sum] = "085d7f6308ee6b77dfb131fac40704575525adf6da45cdc446c00a0b29e4c21a"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38ec0c18112e9a92cffc4951661e85a5"

inherit cmake pkgconfig

S = "${WORKDIR}/uuu-uuu_${PV}"

DEPENDS = "libusb zlib bzip2 openssl"

BBCLASSEXTEND = "native nativesdk"
