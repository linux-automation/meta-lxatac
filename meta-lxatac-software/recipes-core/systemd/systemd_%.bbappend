PACKAGECONFIG[repart] = "-Drepart=true,-Drepart=false"
PACKAGECONFIG[zstd] = "-Dzstd=true,-Dzstd=false,zstd"
PACKAGECONFIG[pstore] = "-Dpstore=true,-Dpstore=false"

# repart needs openssl and libfdisk
PACKAGECONFIG:append = " openssl repart cgroupv2"

PACKAGECONFIG:append = " zstd"

PACKAGECONFIG:append = " pstore"

PACKAGECONFIG:remove = "ima"
