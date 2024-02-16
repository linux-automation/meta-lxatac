#!/bin/bash

set -e -u -o pipefail

source /usr/share/gadget/gadget-common
source /usr/share/gadget/gadget-reports

DEVDIR="${MAINDIR:?}/gadget-hid"

echo "Will export keyboard configuration."
clear_gadget
setup_gadget

# Set up HID
mkdir "${DEVDIR}/functions/hid.usb0"
echo 1 > "${DEVDIR}/functions/hid.usb0/protocol"
echo 1 > "${DEVDIR}/functions/hid.usb0/subclass"
echo 8 > "${DEVDIR}/functions/hid.usb0/report_length"
report_keyboard > "${DEVDIR}/functions/hid.usb0/report_desc"
ln -s "${DEVDIR}/functions/hid.usb0" "${DEVDIR}/configs/c.1"

start_gadget

exit 0
