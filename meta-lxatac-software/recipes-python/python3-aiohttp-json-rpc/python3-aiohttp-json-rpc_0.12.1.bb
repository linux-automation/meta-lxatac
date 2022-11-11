SUMMARY = "json rpc for asyncio"
HOMEPAGE = "https://github.com/pengutronix/aiohttp-json-rpc/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=500d879cf7db09f86dc29654f8488e30"

RDEPENDS:${PN} = " \
    ${PYTHON_PN}-aiohttp \
"

inherit pypi setuptools3

SRC_URI[md5sum] = "664a2e0c63225acd9e81aec038afd8e6"
SRC_URI[sha256sum] = "9aa8a897fbe32b343ce7b14121491cc200395161316ca1296c6fab28449886bf"
