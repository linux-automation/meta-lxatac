FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Don't deploy an /etc/hostname. We have unique hostnames derived from factory
# data passed from barebox to linux via systemd.hostname= and written to
# /etc/hostname (if it does not exist) by lxatac-factory-data.
hostname = ""
