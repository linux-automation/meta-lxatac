FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://systemd-growfs-root.service \
"

RRECOMMENDS:${PN}:append = "less"
# Enable lz4 and seccomp for systemd
PACKAGECONFIG:append = "lz4 seccomp coredump elfutils"
PACKAGECONFIG:remove = "networkd"

do_install:append() {
    # We use system-update.target to re-partition the disk on first boot,
    # meaning we do not have all partitions available on the very first boot
    # and need to keep the mountpoints where they should be mounted clean.
    #
    # This breaks a dependency chain that would result in a /srv/journal
    # directory being created in the rootfs's /srv:
    # system-update.target -> sysinit.target -> systemd-journal-flush.service
    # -> var-log-journal.mount
    mv ${D}${systemd_system_unitdir}/sysinit.target.wants/systemd-journal-flush.service	\
       ${D}${systemd_system_unitdir}/multi-user.target.wants/

    # Starting with mickledore this file is provided by systemd and we can
    # remove this.
    install -m 0644 ${WORKDIR}/systemd-growfs-root.service \
       ${D}${systemd_system_unitdir}

    ln -s ../systemd-growfs-root.service \
       ${D}${systemd_system_unitdir}/sysinit.target.wants/
}

FILES:${PN}:append = " ${systemd_system_unitdir}/systemd-growfs-root.service"
