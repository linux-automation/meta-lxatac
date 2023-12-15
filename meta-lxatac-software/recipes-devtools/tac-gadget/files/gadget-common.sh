#!/bin/bash

MAINDIR=/sys/kernel/config/usb_gadget

# Read factory data that was prepared by
# lxatac-factory-data.service
source /run/lxatac-factory-data/usb-gadget.sh

VENDOR="0x33f7"
VENDORNAME="Linux Automation GmbH"
PRODUCT="0x003"
PRODUCTNAME="LXATAC"
UDC_ADDR="49000000.usb-otg"

clear_gadget () {
    if [[ -s "${DEVDIR}/UDC" ]]; then
        echo "USB Gadget is already set up."
        exit 11
    elif [[ -s "${MAINDIR}"/*/UDC ]]; then
        echo "Remove existing USB Gadgets."
        # when removing a gadget we have to reverse the init process
        for dir in "${MAINDIR}"/*/configs/*/strings/*; do
            test -d "${dir}" && rmdir "${dir}"
        done
        for func in "${MAINDIR}"/*/configs/*.*/*.*; do
            test -e "${func}" && rm "${func}"
        done
        for conf in "${MAINDIR}"/*/configs/*; do
            test -d "${conf}" && rmdir "${conf}"
        done
        for func in "${MAINDIR}"/*/functions/*.*; do
            test -d "${func}" && rmdir "${func}"
        done
        for str in "${MAINDIR}"/*/strings/*; do
            test -d "${str}" && rmdir "${str}"
        done
        rmdir "${MAINDIR}"/*
    elif [[ -n "${DEVDIR}" ]]; then
        modprobe libcomposite
    else
        echo "Nothing to do here."
        exit 1
    fi
}

setup_gadget () {
    echo "Set up new USB Gadget."
    mkdir "${DEVDIR}"
    echo "${VENDOR}" > "${DEVDIR}/idVendor"
    echo "${PRODUCT}" > "${DEVDIR}/idProduct"

    mkdir "${DEVDIR}/strings/0x409" # set language to EN-US
    echo "${SERIAL:?}" > "${DEVDIR}/strings/0x409/serialnumber"
    echo "${VENDORNAME}" > "${DEVDIR}/strings/0x409/manufacturer"
    echo "${PRODUCTNAME}" > "${DEVDIR}/strings/0x409/product"

    mkdir "${DEVDIR}/configs/c.1"
    mkdir "${DEVDIR}/configs/c.1/strings/0x409"
    echo Normal > "${DEVDIR}/configs/c.1/strings/0x409/configuration"
}

start_gadget () {
    echo "${UDC_ADDR}" > "${DEVDIR}/UDC"
}
