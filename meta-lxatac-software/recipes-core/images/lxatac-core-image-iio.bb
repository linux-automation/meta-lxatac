SUMMARY = "Image used to build an SDK including libiio but not much else (for tacd dev)"

IMAGE_LINGUAS = "en-us"

IMAGE_INSTALL = "\
    libiio \
"

LICENSE = "MIT"

inherit image
