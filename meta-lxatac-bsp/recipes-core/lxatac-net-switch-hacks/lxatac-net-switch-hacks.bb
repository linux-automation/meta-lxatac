SUMMARY = "Hacks that make communication with the switch more reliable under load."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit allarch systemd

SRC_URI:append = " \
    file://01-increase-atomic-mem-pool-size.conf \
    file://60-spi-device.rules \
    file://spi-irq-prio-44009000.service \
"

do_install() {
    # Increase the kernel atomic memory pool size.
    # This pool is used for allocations in the hot path.
    # It seems like the kernel sometimes runs out of memory in this pool when
    # under high load.
    install -D -m0644 ${WORKDIR}/01-increase-atomic-mem-pool-size.conf \
        ${D}${libdir}/sysctl.d/01-increase-atomic-mem-pool-size.conf

    # Tag the SPI bus controllers with the `systemd` udev tag.
    # This makes systemd create units like
    #   sys-devices-platform-soc-5c007000.bus-44009000.spi.device
    # that we can use as `Requires=` and `After=` in other units.
    install -D -m0644 ${WORKDIR}/60-spi-device.rules \
        ${D}${sysconfdir}/udev/rules.d/60-spi-device.rules

    # Increase the priority of the kernel thread that handles the
    # interrupts for the SPI controller the ethernet switch is connected to.
    # This prevents timeouts when communicating with the switch while the
    # system is under high load.
    install -D -m0644 ${WORKDIR}/spi-irq-prio-44009000.service \
        ${D}${systemd_system_unitdir}/spi-irq-prio-44009000.service
}

SYSTEMD_SERVICE:${PN} = "spi-irq-prio-44009000.service"

# For pgrep and chrt in spi-irq-prio-44009000.service
RDEPENDS:${PN} += "busybox util-linux-chrt"

FILES:${PN} += "${libdir}/sysctl.d/"
