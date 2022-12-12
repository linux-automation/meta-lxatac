SRC_URI = " \
    git://git@github.com/linux-automation/tacd.git;protocol=ssh;branch=main \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    "

PV = "0.1.0+git${SRCPV}"
SRCREV = "08b911104ba2539cfc0b9e95cf160d81b6c8a494"

S = "${WORKDIR}/git/web"

inherit npm

# Remove the runtime dependency on nodejs. We only use it during the
# build process to generate static html, js and css files.
RDEPENDS:${PN}:append:class-target = ""

WEBUI_INSTALL_DIR="${NPM_BUILD}/lib/node_modules/tacd-web"

npm_run_build () {
    cd "${WEBUI_INSTALL_DIR}"
    npm run build
}

do_compile:append() {
    bb.build.exec_func("npm_run_build", d)
}

do_install() {
    install -d "${D}${datadir}/tacd"
    cp -r "${WEBUI_INSTALL_DIR}/build" "${D}${datadir}/tacd/webui"
}

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = " \
    file://../LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

FILES:${PN} = "${datadir}/tacd"
