inherit bundle

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://hook.sh"

RAUC_BUNDLE_FORMAT = "verity"

RAUC_BUNDLE_COMPATIBLE = "Linux Automation GmbH - LXA TAC"

RAUC_BUNDLE_VERSION = "${DISTRO_VERSION}-${DATETIME}"
RAUC_BUNDLE_VERSION[vardepsexclude] = "DATETIME"

RAUC_BUNDLE_HOOKS[file] = "hook.sh"

RAUC_BUNDLE_SLOTS ?= "rootfs bootloader"

RAUC_SLOT_rootfs ?= "lxatac-core-image-base"
RAUC_SLOT_rootfs[fstype] = "ext4"
RAUC_SLOT_rootfs[hooks] = "post-install"
RAUC_SLOT_rootfs[adaptive] = "block-hash-index"

RAUC_SLOT_bootloader = "bootloader"
RAUC_SLOT_bootloader[depends] = "emmc-boot-image:do_deploy"
RAUC_SLOT_bootloader[type] = "file"
RAUC_SLOT_bootloader[file] = "emmc-boot-image-lxatac.img"

# smaller chunks for adaptive mode
BUNDLE_ARGS += '--mksquashfs-args="-no-exports -b 128k -comp zstd -Xcompression-level 18"'

# rootfs tar: 639528960 bytes
# rootfs tar.bz2: 214328190 bytes
# default bundle:
#   Filesystem size 233576793 bytes (228102.34 Kbytes / 222.76 Mbytes)
#   Compression gzip
#   rauc install duration 2m28.171s

#BUNDLE_ARGS += '--mksquashfs-args="-no-exports -b 1M -comp lzo"'
#   Filesystem size 256102630 bytes (250100.22 Kbytes / 244.24 Mbytes)
#   Compression lzo
#   Block size 1048576
#   rauc install duration 1m51.601s

#BUNDLE_ARGS += '--mksquashfs-args="-comp zstd -Xcompression-level 9"'
#   Filesystem size 228333394 bytes (222981.83 Kbytes / 217.76 Mbytes)
#   Compression zstd compression-level 9
#   rauc install duration 2m32.911s

#BUNDLE_ARGS += '--mksquashfs-args="-comp zstd"'
#   Filesystem size 215418754 bytes (210369.88 Kbytes / 205.44 Mbytes)
#   Compression zstd compression-level 15 (should be the default)
#   rauc install duration 2m34.787s

#BUNDLE_ARGS += '--mksquashfs-args="-no-exports -comp zstd"'
#   Filesystem size 215418713 bytes (210369.84 Kbytes / 205.44 Mbytes)
#   Compression zstd compression-level 15 (should be the default)
#   Block size 131072
#   Filesystem is not exportable via NFS

#BUNDLE_ARGS += '--mksquashfs-args="-no-exports -b 1M -comp zstd"'
#   Filesystem size 214798756 bytes (209764.41 Kbytes / 204.85 Mbytes)
#   Compression zstd compression-level 15 (should be the default)
#   Block size 1048576
#   rauc install duration 2m2.084s

#BUNDLE_ARGS += '--mksquashfs-args="-no-exports -b 1M -comp zstd -Xcompression-level 16"'
#   Filesystem size 211153742 bytes (206204.83 Kbytes / 201.37 Mbytes)
#   Compression zstd compression-level 16
#   Block size 1048576

#BUNDLE_ARGS += '--mksquashfs-args="-no-exports -b 1M -comp zstd -Xcompression-level 17"'
#   Filesystem size 206658572 bytes (201815.01 Kbytes / 197.08 Mbytes)
#   Compression zstd compression-level 17
#   Block size 1048576

#BUNDLE_ARGS += '--mksquashfs-args="-no-exports -b 1M -comp zstd -Xcompression-level 18"'
#   Filesystem size 197364006 bytes (192738.29 Kbytes / 188.22 Mbytes)
#   Compression zstd compression-level 18
#   Block size 1048576
#   rauc install duration 2m3.739s

#BUNDLE_ARGS += '--mksquashfs-args="-no-exports -b 1M -comp zstd -Xcompression-level 20"'
#   Filesystem size 197081877 bytes (192462.77 Kbytes / 187.95 Mbytes)
#   Compression zstd compression-level 20
#   Block size 1048576
#   rauc install duration 2m3.701s

#BUNDLE_ARGS += '--mksquashfs-args="-no-exports -b 1M -comp zstd -Xcompression-level 22"'
#   Filesystem size 196966738 bytes (192350.33 Kbytes / 187.84 Mbytes)
#   Compression zstd compression-level 22
#   Block size 1048576
#   rauc install duration 2m2.438s

