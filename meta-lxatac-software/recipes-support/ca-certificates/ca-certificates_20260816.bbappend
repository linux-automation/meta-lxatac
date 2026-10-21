FILESEXTRAPATHS:prepend := "${THISDIR}/ca-certificates:"

# The eMudhra intermediate CA has used comically small private keys by mistake
# (as in: the number 4).
# Backport the patch made by Debian to denylist the root CAs that signed this
# intermediate:
#
#   https://salsa.debian.org/debian/ca-certificates/-/commit/4a0203e5ce4ce1a064b97387f52ca6a00c97185c
SRC_URI += "file://0001-Blacklist-emSign-ECC-Root-CA-G3-and-Comodo-AAA-Servi.patch"
