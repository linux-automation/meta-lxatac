SUMMARY = "canopen implementation for python"
HOMEPAGE = "https://github.com/christiansandberg/canopen/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=97f135a6ee6f800c377b5512122c7a8d"

RDEPENDS:${PN} = " \
    ${PYTHON_PN}-can \
"

inherit pypi setuptools3

SRC_URI[md5sum] = "688d793aa584cdd5b11267ecaad1749b"
SRC_URI[sha256sum] = "b4f114542fae4390f9930a8adfccaa10fef888113dac38bd03009d87c7250a3b"
