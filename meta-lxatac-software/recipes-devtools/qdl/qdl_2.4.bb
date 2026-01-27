SUMMARY = "Qualcomm DownLoader flashing tool"
DESCRIPTION = "Communicate with Qualcomm SoCs to upload new software or \
dump memory"
HOMEPAGE = "https://github.com/linux-msm/qdl.git"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da6bfde9cb5bc5120a51775381f6edf1"

DEPENDS = "libxml2 libusb1"

inherit pkgconfig

SRC_URI = "git://github.com/linux-msm/${BPN}.git;branch=master;protocol=https"
SRCREV = "6eeb866b1503a9219258edbdb72fcd478c20b2d7"

do_install () {
    oe_runmake install DESTDIR=${D} prefix=${prefix}
}

BBCLASSEXTEND = "native nativesdk"
