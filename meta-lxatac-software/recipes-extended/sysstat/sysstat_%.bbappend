FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG = "systemd cron lm-sensors"

SRC_URI += "file://sysstat.conf file://sysstat-collect.timer"

# Our sysstat.conf file includes ZIP="xz"
RDEPENDS:${PN} += "xz"

do_install:append() {
	install -m 0644 ${UNPACKDIR}/sysstat.conf ${D}/etc/sysconfig/sysstat
	install -m 0644 ${UNPACKDIR}/sysstat-collect.timer -D -t ${D}${sysconfdir}/systemd/system
}

SYSTEMD_SERVICE:${PN} = "sysstat.service sysstat-collect.timer sysstat-summary.timer"
