#!/bin/bash

set -exu -o pipefail

function migrate () {
	if [ ! -f "$1" ]; then
		return
	fi

	mkdir -p "$(dirname "${RAUC_SLOT_MOUNT_POINT}"/"$1")"
	cp -a "$1" "${RAUC_SLOT_MOUNT_POINT}/$1"
}

case "$1" in
        slot-post-install)
		migrate /etc/machine-id
		migrate /etc/labgrid/environment
		migrate /etc/labgrid/userconfig.yaml
		for x in /etc/ssh/ssh_host*; do
			migrate "$x"
		done
		migrate /var/lib/chrony/drift
		migrate /home/root/.bash_history
		migrate /home/root/.ssh/authorized_keys
		migrate /var/cache/lxa-iobus/lss-cache
                ;;
        *)
                exit 1
                ;;
esac

exit 0
