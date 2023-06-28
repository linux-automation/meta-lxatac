#!/bin/bash

set -e -u -o pipefail

source /usr/share/gadget/gadget-common

DEVDIR=$MAINDIR/gadget-serial
FUNCTION="acm.usb0"

clear_gadget
setup_gadget
start_gadget

exit 0
