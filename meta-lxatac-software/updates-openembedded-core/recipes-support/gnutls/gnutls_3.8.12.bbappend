# This fixes a couple of CVEs, namely:
#   CVE-2026-33845
#   CVE-2026-3833
#   CVE-2026-3832

PV = "3.8.13"
SRC_URI[sha256sum] = "ffed8ec1bf09c2426d4f14aae377de4753b53e537d685e604e99a8b16ca9c97e"

SRC_URI:remove = "file://c99.patch"

do_configure:prepend() {
	for dir in . lib; do
		rm -f ${dir}/aclocal.m4 ${dir}/m4/libtool.m4 ${dir}/m4/lt*.m4
	done
}
