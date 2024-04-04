#!/bin/sh

if [ "${bootsource}" = serial ]; then
    global.autoboot_timeout=30
fi
