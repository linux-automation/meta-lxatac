PV = "9.2.0712"
SRCREV = "5c1b989b4aabf1549910752dcfb44030e64edfcc"

# We do not need these backported CVE fixes from oe-core since we updated
# to a later release instead.
SRC_URI:remove = "\
    file://CVE-2026-44656.patch \
    file://CVE-2026-41411.patch \
    file://CVE-2026-45130.patch \
    file://CVE-2026-46483.patch \
    "
