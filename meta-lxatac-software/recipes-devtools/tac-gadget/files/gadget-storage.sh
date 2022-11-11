#!/bin/bash
set -e -u -o pipefail
STORAGE=${1:-}
if [ $STORAGE ]; then
    source /usr/share/gadget/gadget-common
else
    echo "ERROR: No medium given. Start again with image location attached to command."
    exit 1
fi

DEVDIR=$MAINDIR/gadget-storage
FUNCTION="mass_storage.usb0"

clear_gadget
setup_gadget
echo $STORAGE > $DEVDIR/functions/mass_storage.usb0/lun.0/file
start_gadget
exit 0
