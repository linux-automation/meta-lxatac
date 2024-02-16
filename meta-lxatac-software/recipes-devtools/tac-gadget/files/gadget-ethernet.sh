#!/bin/bash

set -e -u -o pipefail

source /usr/share/gadget/gadget-common

DEVDIR="${MAINDIR:?}/gadget-ethernet"

clear_gadget
setup_gadget

# Set up ethernet
mkdir "${DEVDIR}/functions/ecm.usb0"
echo "${HOST_MAC:?}" > "${DEVDIR}/functions/ecm.usb0/host_addr"
echo "${DEV_MAC:?}" > "${DEVDIR}/functions/ecm.usb0/dev_addr"
ln -s "${DEVDIR}/functions/ecm.usb0" "${DEVDIR}/configs/c.1"

start_gadget

exit 0
