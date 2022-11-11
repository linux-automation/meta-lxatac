LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/ColinIanKing/smemstat.git;protocol=https;branch=master"

PV = "0.02.11+git${SRCPV}"
SRCREV = "9eea7504ab33783d804c4ed9237e299effb68874"

S = "${WORKDIR}/git"

DEPENDS = "ncurses"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d -m 755 ${D}${sbindir}
	install -m 755 ${B}/smemstat ${D}${sbindir}/
	install -d -m 755 ${D}${mandir}/man8
	install -m 644 ${S}/smemstat.8 ${D}${mandir}/man8/
}
