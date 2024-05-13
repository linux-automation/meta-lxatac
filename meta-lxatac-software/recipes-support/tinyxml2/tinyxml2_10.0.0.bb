LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=135624eef03e1f1101b9ba9ac9b5fffd"

SRC_URI += "git://github.com/leethomason/tinyxml2.git;protocol=https;branch=master"
SRCREV = "321ea883b7190d4e85cae5512a12e5eaa8f8731f"

S = "${WORKDIR}/git"

inherit cmake
