FILESEXTRAPATHS:prepend := "${THISDIR}/openssh:"

SRC_URI += "file://20-disallow-password.conf"

do_install:append() {
    install -D -m 0644 ${UNPACKDIR}/20-disallow-password.conf \
        ${D}${sysconfdir}/ssh/sshd_config.d/20-disallow-password.conf
}

