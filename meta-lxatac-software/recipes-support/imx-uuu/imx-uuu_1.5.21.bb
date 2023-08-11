SUMMARY = "Universal Update Utility"
DESCRIPTION = "Image deployment tool for i.MX chips"
HOMEPAGE = "https://github.com/NXPmicro/mfgtools"

SRC_URI = "https://github.com/nxp-imx/mfgtools/releases/download/uuu_${PV}/uuu_source-${PV}.tar.gz"
SRC_URI[sha256sum] = "600be50827b52df4dddf0c7d07da27b103a4576eb445890905c61780e3c36871"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=38ec0c18112e9a92cffc4951661e85a5"

inherit cmake pkgconfig

S = "${WORKDIR}/uuu-${PV}"

DEPENDS = "libusb zlib bzip2 openssl"

BBCLASSEXTEND = "native nativesdk"
