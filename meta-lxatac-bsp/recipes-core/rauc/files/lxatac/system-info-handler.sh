#!/bin/bash

# The device serial number (00009.12345) is read from EEPROM by the bootloader
# and passed to the kernel via the devicetree.
SERIAL_FILE=/sys/firmware/devicetree/base/chosen/baseboard-factory-data/serial-number

# Strip the trailing null byte that is inherent to devicetree strings
SERIAL=$(tr -d '\000' < "${SERIAL_FILE}")

echo "RAUC_SYSTEM_SERIAL=${SERIAL}"

# The os-release contains a line with the os version (VERSION_ID=24.09-dev)
# grep it ...
VERSION_ID="$(grep "^VERSION_ID=" /etc/os-release)"

# ... and remove the VERSION_ID= prefix.
VERSION_ID="${VERSION_ID#VERSION_ID=}"

# The RAUC install hook has a better idea of the installed bundle version.
# Hence why it overrides the VERSION_ID here:
# <rauc-install-hook-version-override>

echo "RAUC_SYSTEM_VERSION=${VERSION_ID}"
