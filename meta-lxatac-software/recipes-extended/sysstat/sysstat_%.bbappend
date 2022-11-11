FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG = "systemd cron lm-sensors"

SRC_URI += "file://sysstat.conf file://sysstat-collect.timer"

do_install:append() {
	install -m 0644 ${WORKDIR}/sysstat.conf ${D}/etc/sysconfig/sysstat
	install -m 0644 ${WORKDIR}/sysstat-collect.timer -D -t ${D}${sysconfdir}/systemd/system
}

SYSTEMD_SERVICE:${PN} = "sysstat.service sysstat-collect.timer sysstat-summary.timer"
