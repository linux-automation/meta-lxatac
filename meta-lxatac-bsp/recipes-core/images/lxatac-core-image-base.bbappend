inherit bootspec

BOOTSPEC_EXTRALINE = "linux-appendroot true\n"

# The drm_leak_fbdev_smem option is a workaround required since Linux 6.11
# because without it the tacd will crash when attempting to write to the
# framebuffer. This is likely a bug in the panel-mipi-dbi driver or the tacd
# that should be fixed there.
# Once drm_leak_fbdev_smem is removed the kernel config option
# CONFIG_DRM_FBDEV_LEAK_PHYS_SMEM should be disabled as well.
BOOTSPEC_OPTIONS += "rootwait drm_kms_helper.drm_leak_fbdev_smem=1"

IMAGE_INSTALL:append = "\
    kernel-image \
    kernel-modules \
    kernel-devicetree \
    dt-utils-barebox-state \
"
