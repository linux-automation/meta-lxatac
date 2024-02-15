SUMMARY = "LXA TAC image containing a selection of useful development tools"

BAD_RECOMMENDATIONS = "rng-tools"

IMAGE_FEATURES = "ssh-server-openssh empty-root-password"

IMAGE_FSTYPES += "ext4"

# use a fixed directory hash seed to reduce the image delta size
EXTRA_IMAGECMD:ext4 = "-i 4096 -E hash_seed=4267a9cf-754d-4506-9156-d3f4a18842e5"

# Disable the orphan_file feature which is not supported by langdale's
# resize2fs and which would otherwise break installation of new RAUC bundles on
# langdale-based TACs.
# The override can be removed when updates from langedale are no longer needed.
EXTRA_IMAGECMD:ext4 += "-O ^orphan_file"

IMAGE_LINGUAS = "en-us"

IMAGE_INSTALL:append = "\
    alsa-utils \
    atftp \
    atftpd \
    android-tools \
    avahi-utils \
    barebox-tools \
    bcu \
    blktrace \
    bluez5 \
    bmap-tools \
    bonnie++ \
    bottom \
    can-utils \
    chrony \
    chronyc \
    container-control \
    crun \
    curl \
    devmem2 \
    dfu-util \
    e2fsprogs-tune2fs \
    ethtool \
    evtest \
    fb-test \
    fio \
    gdb \
    gdbserver \
    git \
    github-act-runner \
    gitlab-runner \
    gstreamer1.0 \
    gstreamer1.0-plugins-bad-videoparsersbad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    htop \
    i2c-tools \
    imx-uuu \
    iperf3 \
    iproute2 \
    iproute2-bash-completion \
    iproute2-devlink \
    iproute2-ifstat \
    iproute2-lnstat \
    iproute2-nstat \
    iproute2-rtacct \
    iproute2-ss \
    iproute2-tc \
    libdrm-tests \
    libgpiod-tools \
    libiio \
    libiio-iiod \
    libiio-tests \
    libkcapi \
    linuxptp \
    linux-serial-test \
    lldpd \
    lmsensors \
    lxatac-factory-data \
    lxatac-led-setup \
    lxatac-lldpd-config \
    lxatac-nm-config \
    lxatac-persistent-journal \
    lxatac-persistent-labgrid-cache \
    lxatac-persistent-sysstat \
    lxatac-profile \
    lxatac-repart \
    mc \
    memtool \
    microcom \
    mmc-utils \
    nano \
    networkmanager-nmcli \
    networkmanager-nmtui \
    nfs-utils-client \
    nftables \
    openocd \
    openssh-sftp \
    openssh-sftp-server \
    openssl-engines \
    perf \
    ply \
    podman \
    pps-tools \
    pv \
    py-spy \
    python3-labgrid \
    python3-lxa-iobus \
    python3-pygobject \
    python3-usbmuxctl \
    python3-usbsdmux \
    python3-venv \
    rauc \
    ripgrep \
    rsync \
    screen \
    ser2net \
    setserial \
    sigrok-cli \
    sispmctl \
    smemstat \
    socat \
    strace \
    stress-ng \
    sysstat \
    systemd-analyze \
    systemd-conf-lxatac \
    systemd-container \
    tacd \
    tacd-webinterface \
    tac-gadget \
    tcpdump \
    tmux \
    trace-cmd \
    tree \
    tshark \
    udisks2 \
    uhubctl \
    util-linux \
    vim \
    zstd \
"

# is crun needed when using systemd unified hierarcy?

LICENSE = "MIT"

inherit core-image
