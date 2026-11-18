FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PACKAGECONFIG = "automated-sar systemd lm-sensors"

SRC_URI += "file://sysstat.conf"

# Our sysstat.conf file includes ZIP="xz"
RDEPENDS:${PN} += "xz"

do_install:append() {
	install -m 0644 ${UNPACKDIR}/sysstat.conf ${D}/etc/sysconfig/sysstat
}

SYSTEMD_SERVICE:${PN} = "sysstat.service sysstat-collect.timer sysstat-summary.timer"
