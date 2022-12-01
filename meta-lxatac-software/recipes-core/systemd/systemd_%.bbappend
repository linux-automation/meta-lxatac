PACKAGECONFIG[repart] = "-Drepart=true,-Drepart=false"
PACKAGECONFIG[zstd] = "-Dzstd=true,-Dzstd=false,zstd"
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
