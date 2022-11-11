SUMMARY = "Small image to export the kernel with its optional debug symbols"

IMAGE_LINGUAS = "en-us"

IMAGE_INSTALL = "\
    kernel-vmlinux \
"

IMAGE_FSTYPES = "tar.xz"

LICENSE = "MIT"

inherit image
