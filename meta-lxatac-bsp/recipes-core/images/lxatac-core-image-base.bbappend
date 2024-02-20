inherit bootspec

BOOTSPEC_EXTRALINE = "linux-appendroot true\n"
BOOTSPEC_OPTIONS += "rootwait"

IMAGE_INSTALL:append = "\
    kernel-image \
    kernel-modules \
    kernel-devicetree \
    dt-utils-barebox-state \
"
