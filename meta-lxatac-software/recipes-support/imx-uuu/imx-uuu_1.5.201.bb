SUMMARY = "Universal Update Utility"
DESCRIPTION = "Image deployment tool for i.MX chips"
HOMEPAGE = "https://github.com/NXPmicro/mfgtools"

SRC_URI = "https://github.com/nxp-imx/mfgtools/releases/download/uuu_${PV}/uuu_source-uuu_${PV}.tar.gz"
SRC_URI[sha256sum] = "c763b87ffdf10ac5499a0c319463759caa336bc6567b56d6d0ef448590c1a76d"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38ec0c18112e9a92cffc4951661e85a5"

inherit cmake pkgconfig

S = "${WORKDIR}/uuu-uuu_${PV}"

DEPENDS = "libusb zlib bzip2 openssl libtinyxml2"

BBCLASSEXTEND = "native nativesdk"
