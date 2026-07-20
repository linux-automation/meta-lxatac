SUMMARY = "Qualcomm DownLoader flashing tool"
DESCRIPTION = "Communicate with Qualcomm SoCs to upload new software or \
dump memory"
HOMEPAGE = "https://github.com/linux-msm/qdl.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da6bfde9cb5bc5120a51775381f6edf1"

DEPENDS = "libusb1 libxml2 libzip"

inherit pkgconfig meson

SRC_URI = "git://github.com/linux-msm/${BPN}.git;branch=${SRCBRANCH};protocol=https;tag=v${PV}"
SRCREV = "a248f28ecd54f66c660bbc3a88657d4c62f1445d"
SRCBRANCH = "qdl-2.7.y"

BBCLASSEXTEND = "native nativesdk"
