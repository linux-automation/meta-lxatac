SUMMARY = "The LXA TAC System Daemon - Web Interface"
SRC_URI = "git://github.com/linux-automation/tacd.git;protocol=https;branch=main"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = " \
    file://../LICENSE;md5=570a9b3749dd0463a1778803b12a6dce \
"

# Commit created 2026-06-23 10:27:11 +0200
SRCREV = "b8a9d111a3f6cb3a9d2f33977def393e10a9c38a"
PV = "0.1.0+git${SRCPV}"

S = "${UNPACKDIR}/${BP}/web"

DEPENDS += "nodejs-native"

# Allow npm to download packages from the internet, since the npmsw fetcher
# is no longer supported and we use npm to fetch packages instead.
do_compile[network] = "1"

do_compile() {
    npm ci .
    npm run build

    # Provide compressed variants of all files worth compressing
    find build/ -type f \
        \( -name "*.html" -or -name "*.css" -or -name "*.js" -or -name "*.svg" \) \
        -exec gzip -fk9 {} \;
}

do_install() {
    install -d "${D}${datadir}/tacd"
    cp -r "${S}/build" "${D}${datadir}/tacd/webui"
}

FILES:${PN} = "${datadir}/tacd"
