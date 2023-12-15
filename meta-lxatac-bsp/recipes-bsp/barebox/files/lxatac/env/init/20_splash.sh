#!/bin/sh

# Turn the LCD on with a splash screen
splash /env/data/splash.png

# shellcheck disable=SC2276
fb0.enable=1
