#!/bin/bash

set -e -u -o pipefail

source /usr/share/gadget/gadget-common

DEVDIR="${MAINDIR:?}/gadget-serial"

clear_gadget
setup_gadget

# Set up serial
mkdir "${DEVDIR}/functions/acm.usb0"
ln -s "${DEVDIR}/functions/acm.usb0" "${DEVDIR}/configs/c.1"

start_gadget

exit 0
