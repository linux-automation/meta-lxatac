#!/bin/bash

# export labgrid environment to be used with labgrid-client on the lxatac
source /etc/labgrid/environment
export LG_CROSSBAR="ws://${LABGRID_COORDINATOR_IP:?}:${LABGRID_COORDINATOR_PORT:?}/ws"
