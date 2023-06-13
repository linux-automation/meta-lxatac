#!/bin/sh

# Disable DUT power and enable discharge resistor (both lines are active low).
# gpiofind returns a chip + id pair in the form of: gpiochip0 2.
# We can not use quoting here as the command should be: gpioset gpiochip0 2=1.
gpioset $(gpiofind DUT_PWR_EN)=1
gpioset $(gpiofind DUT_PWR_DISCH)=0
