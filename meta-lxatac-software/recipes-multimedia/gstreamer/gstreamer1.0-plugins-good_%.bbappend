# libsoup is a constant source of vulnerability reports.
# It is a dependency not worth keeping around for this one plugin only.
PACKAGECONFIG:remove = "soup2 soup3"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://CVE-2026-111183.patch"

