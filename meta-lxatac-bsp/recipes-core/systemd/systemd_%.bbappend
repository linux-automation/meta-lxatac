RRECOMMENDS:${PN}:append = "less"
# Enable lz4 and seccomp for systemd
PACKAGECONFIG:append = "lz4 seccomp coredump elfutils"
PACKAGECONFIG:remove = "networkd"
