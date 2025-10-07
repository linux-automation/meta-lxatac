# The fix for CVE-2025-48945 in meta-openembedded commit 32200384c7
# ("python3-pycares: fix CVE-2025-48945") is broken and results in runtime
# errors:
#
#  File "/usr/lib/python3.13/site-packages/pycares/__init__.py", line 486, in __init__
#      self._event_thread = event_thread
#                           ^^^^^^^^^^^^
#  NameError: name 'event_thread' is not defined
#
# This suggests that maybe a patch for a different pycares version was
# applied to the 4.6.0 tree, resulting in a broken result.
# The commit messages states that the CVE is fixed in pycares version 4.9.0.
# Update to that instead of trying to fix the patch.

PV = "4.9.0"
SRC_URI[sha256sum] = "8ee484ddb23dbec4d88d14ed5b6d592c1960d2e93c385d5e52b6fad564d82395"

SRC_URI:remove = "file://CVE-2025-48945.patch"
