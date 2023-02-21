inherit bootspec

BOOTSPEC_EXTRALINE = "linux-appendroot true\n"
BOOTSPEC_OPTIONS += "rootwait init=/usr/sbin/platsch"

IMAGE_INSTALL:append = "\
    kernel-image \
    kernel-modules \
    kernel-devicetree \
    dt-utils-barebox-state \
"

ROOTFS_POSTPROCESS_COMMAND += " make_zimage_symlink_relative; "
