SUMMARY = "Universal Update Utility"
DESCRIPTION = "Image deployment tool for i.MX chips"
HOMEPAGE = "https://github.com/NXPmicro/mfgtools"

SRC_URI = "https://github.com/nxp-imx/mfgtools/releases/download/uuu_${PV}/uuu_source-uuu_${PV}.tar.gz"
SRC_URI[sha256sum] = "723d3da358e6af974a056e3adbcb105fac9dad4b87544de0d22b8c974a8037aa"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38ec0c18112e9a92cffc4951661e85a5"

inherit cmake pkgconfig

S = "${WORKDIR}/uuu-uuu_${PV}"

DEPENDS = "libusb zlib bzip2 openssl tinyxml2"

BBCLASSEXTEND = "native nativesdk"
