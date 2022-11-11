# The iiod service is not currently used and will likely conflict with
# the tacd anyways, but there is no harm (except for a few kb of eMMC space)
# in installing it but not enabling the service.
SYSTEMD_AUTO_ENABLE = "disable"

# 90-libiio.rules runs iio_info -s on every USB event, which causes simple add
# events to take several seconds. As it only modifies the permissions to 0666,
# we don't need it.
do_install:append() {
    rm ${D}${nonarch_base_libdir}/udev/rules.d/90-libiio.rules
}
