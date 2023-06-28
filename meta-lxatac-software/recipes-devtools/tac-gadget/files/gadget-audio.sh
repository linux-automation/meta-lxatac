#!/bin/bash

set -e -u -o pipefail

source /usr/share/gadget/gadget-common

DEVDIR=$MAINDIR/gadget-audio
FUNCTION="uac2.usb0"

clear_gadget
setup_gadget
start_gadget

exit 0
