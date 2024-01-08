# Fix Build error due to:
#
#  make[3]: *** No rule to make target '.../perf-1.0/arch/arm64/tools/gen-sysreg.awk',
#  needed by '.../perf-1.0/arch/arm64/include/generated/asm/sysreg-defs.h'.  Stop.
#
# This can be removed once commit 683aff7a08 (poky commit hash)
# ("perf: fix build with latest kernel") is in a release.

PERF_SRC:append = " arch/arm64/tools "
