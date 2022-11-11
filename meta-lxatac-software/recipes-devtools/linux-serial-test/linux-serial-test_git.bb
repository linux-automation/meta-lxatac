DESCRIPTION = "Linux Serial Test Application"
HOMEPAGE = "https://github.com/cbrake/linux-serial-test"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES/MIT;md5=544799d0b492f119fa04641d1b8868ed"

SRC_URI = "git://github.com/cbrake/linux-serial-test.git;protocol=https;branch=master"

PV = "0+git${SRCPV}"
SRCREV = "bf865c37ccf9cbb1826ada61037c036dc1990b7b"

S = "${WORKDIR}/git"

inherit cmake
