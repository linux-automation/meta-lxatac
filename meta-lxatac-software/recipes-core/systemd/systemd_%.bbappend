PACKAGECONFIG[pstore] = "-Dpstore=true,-Dpstore=false"

# repart needs openssl and libfdisk
PACKAGECONFIG:append = " \
  cgroupv2 \
  ima \
  openssl \
  pstore \
  repart \
  zstd \
"
