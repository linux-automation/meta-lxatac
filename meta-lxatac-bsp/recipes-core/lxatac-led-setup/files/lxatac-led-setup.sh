#!/bin/bash

set -euo pipefail

BASE="/sys/class/leds"

STATUS="rgb:status"

IOBUS="tac:green:iobus"
CAN="tac:green:can"

UART_RX="tac:green:uartrx"
UART_TX="tac:green:uarttx"

USB_HOST1="tac:green:usbh1"
USB_HOST2="tac:green:usbh2"
USB_HOST3="tac:green:usbh3"

# RGB Status LED
if [[ -e "${BASE}/${STATUS}/trigger" ]]
then
    # Light up in a nice yellow, as the "okay green" is a bit overused by
    # the other LEDs.
    echo "65000 12000 2000" > "${BASE}/${STATUS}/multi_intensity"
    echo default-on > "${BASE}/${STATUS}/trigger"
else
    echo "Not setting up Status LED"
fi

# CAN Interface activity
if [[ -e "${BASE}/${IOBUS}/trigger" ]]
then
    echo netdev > "${BASE}/${IOBUS}/trigger"
    echo can0_iobus > "${BASE}/${IOBUS}/device_name"
    echo 1 > "${BASE}/${IOBUS}/link"
    echo 1 > "${BASE}/${IOBUS}/rx"
    echo 1 > "${BASE}/${IOBUS}/tx"
else
    echo "Not setting up IOBus Trigger"
fi

if [[ -e "${BASE}/${CAN}/trigger" ]]
then
    echo netdev > "${BASE}/${CAN}/trigger"
    echo can1 > "${BASE}/${CAN}/device_name"
    echo 1 > "${BASE}/${CAN}/link"
    echo 1 > "${BASE}/${CAN}/rx"
    echo 1 > "${BASE}/${CAN}/tx"
else
    echo "Not setting up CAN Trigger"
fi

# DUT UART activity
if [[ -e "${BASE}/${UART_RX}/trigger" ]]
then
    echo tty > "${BASE}/${UART_RX}/trigger"
    echo ttySTM1 > "${BASE}/${UART_RX}/ttyname"
    echo 1 > "${BASE}/${UART_RX}/rx"
    echo 0 > "${BASE}/${UART_RX}/tx"
else
    echo "Not setting up UART RX Trigger"
fi

if [[ -e "${BASE}/${UART_TX}/trigger" ]]
then
    echo tty > "${BASE}/${UART_TX}/trigger"
    echo ttySTM1 > "${BASE}/${UART_TX}/ttyname"
    echo 0 > "${BASE}/${UART_TX}/rx"
    echo 1 > "${BASE}/${UART_TX}/tx"
else
    echo "Not setting up UART TX Trigger"
fi

# USB Host ports
if [[ -e "${BASE}/${USB_HOST1}/trigger" ]]
then
    echo usbport > "${BASE}/${USB_HOST1}/trigger"
    echo 1 > "${BASE}/${USB_HOST1}/ports/1-1-port1"
else
    echo "Not setting up USB Host 1 Trigger"
fi

if [[ -e "${BASE}/${USB_HOST2}/trigger" ]]
then
    echo usbport > "${BASE}/${USB_HOST2}/trigger"
    echo 1 > "${BASE}/${USB_HOST2}/ports/1-1-port2"
else
    echo "Not setting up USB Host 2 Trigger"
fi

if [[ -e "${BASE}/${USB_HOST3}/trigger" ]]
then
    echo usbport > "${BASE}/${USB_HOST3}/trigger"
    echo 1 > "${BASE}/${USB_HOST3}/ports/1-1-port3"
else
    echo "Not setting up USB Host 3 Trigger"
fi

