#!/bin/bash
set -e -u -o pipefail
source /usr/share/gadget/gadget-common

DEVDIR=$MAINDIR/gadget-ethernet
FUNCTION="ecm.usb0"

clear_gadget
setup_gadget
echo $HOST_MAC > $DEVDIR/functions/$FUNCTION/host_addr
echo $DEV_MAC > $DEVDIR/functions/$FUNCTION/dev_addr
start_gadget
exit 0
