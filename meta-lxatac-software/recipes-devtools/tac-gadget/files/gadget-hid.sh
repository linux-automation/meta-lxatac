#!/bin/bash
set -e -u -o pipefail
source /usr/share/gadget/gadget-common
source /usr/share/gadget/gadget-reports

DEVDIR=$MAINDIR/gadget-hid
FUNCTION="hid.usb0"

echo "Will export keyboard configuration."
clear_gadget
setup_gadget
echo 1 > $DEVDIR/functions/hid.usb0/protocol
echo 1 > $DEVDIR/functions/hid.usb0/subclass
echo 8 > $DEVDIR/functions/hid.usb0/report_length
report_keyboard > $DEVDIR/functions/hid.usb0/report_desc
start_gadget
exit 0
