FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://no-klogd.cfg"

# We need the no-syslogd.cfg to disable syslogd, which was enabled in
# 4335cd240c30db677fdd1849eefe9ed3277681a8.
SRC_URI:remove = "file://syslog.cfg"
SRC_URI += "file://no-syslogd.cfg"
