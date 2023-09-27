#!/bin/bash

set -e -u -o pipefail

source /usr/share/gadget/gadget-common

DEVDIR=$MAINDIR/gadget-audio

clear_gadget
setup_gadget

# Set up audio
mkdir $DEVDIR/functions/uac2.usb0
ln -s $DEVDIR/functions/uac2.usb0 $DEVDIR/configs/c.1

start_gadget

exit 0
