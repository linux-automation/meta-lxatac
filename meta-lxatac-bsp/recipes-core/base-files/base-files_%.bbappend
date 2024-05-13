# Don't deploy an /etc/hostname. We have unique hostnames derived from factory
# data passed from barebox to linux via systemd.hostname= and written to
# /etc/hostname (if it does not exist) by lxatac-factory-data.
hostname = ""

do_install:append() {
    # systemd assumes the root users home directory to be at /root and does
    # not support other configurations.
    # (See the documentation around ROOT_HOME for more information).
    # Our migration scripts do/did however assume roots home to be at
    # /home/root.
    # Add a symlink from /home/root to /root to stay backward compatible to
    # existing bundles.

    ln -sf ../root ${D}/home/root
}
