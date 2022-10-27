RRECOMMENDS:${PN}:append = " less"
# Enable lz4 and seccomp for systemd
PACKAGECONFIG:append = " lz4 seccomp coredump elfutils"
PACKAGECONFIG:remove = "networkd"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-hostname-consider-systemd.hostname-static-and-give-i.patch"

