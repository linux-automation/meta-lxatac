#!/bin/sh

# Disable DUT power and enable discharge resistor (both lines are active low).
# What we would want here is a fire-and-forget gpioset that sets the desired
# value and exits.
# Sadly that does not exist (by design - the character device based gpio
# interface expects you to keep the file descriptor open as long as you want
# a defined GPIO state). This is why gpioset does not exit by itself.
# So we:
#   1) Keep the output in the safe state for 10s to prevent damage to the
#      DUT/TAC from e.g. a long-lasting overcurrent event.
#   2) Give back control to the tacd.
#   3) If that fails (fails to start or watchdog hits) go back to 1)

gpioset DUT_PWR_DISCH=0 DUT_PWR_EN=1 &
sleep 10
kill %1
