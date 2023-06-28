#!/bin/bash

set -e -u -o pipefail

STORAGE=${1:-}
if [ -z $STORAGE ]; then
    echo "ERROR: No medium given. Start again with image location attached to command."
    exit 1
fi

source /usr/share/gadget/gadget-common
source /usr/share/gadget/gadget-reports

DEVDIR=$MAINDIR/gadget-hid-storage

clear_gadget
setup_gadget

# Set up mass storage
mkdir $DEVDIR/functions/mass_storage.usb0
echo $STORAGE > $DEVDIR/functions/mass_storage.usb0/lun.0/file
ln -s $DEVDIR/functions/mass_storage.usb0 $DEVDIR/configs/c.1

# Set up HID
mkdir $DEVDIR/functions/hid.usb0
echo 1 > $DEVDIR/functions/hid.usb0/protocol
echo 1 > $DEVDIR/functions/hid.usb0/subclass
echo 8 > $DEVDIR/functions/hid.usb0/report_length
report_keyboard > $DEVDIR/functions/hid.usb0/report_desc
ln -s $DEVDIR/functions/hid.usb0 $DEVDIR/configs/c.1

start_gadget

exit 0
