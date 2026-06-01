FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-contrib-systemd-use-multi-user.target-instead-of-def.patch;patchdir=src/${GO_IMPORT}"
