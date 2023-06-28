#!/bin/bash

set -e -u -o pipefail

STORAGE=${1:-}
if [ -z $STORAGE ]; then
    echo "ERROR: No medium given. Start again with image location attached to command."
    exit 1
fi

source /usr/share/gadget/gadget-common

DEVDIR=$MAINDIR/gadget-storage

clear_gadget
setup_gadget

# Set up storage
mkdir $DEVDIR/functions/mass_storage.usb0
echo $STORAGE > $DEVDIR/functions/mass_storage.usb0/lun.0/file
ln -s $DEVDIR/functions/mass_storage.usb0 $DEVDIR/configs/c.1

start_gadget

exit 0
