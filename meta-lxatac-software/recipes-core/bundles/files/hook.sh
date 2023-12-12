#!/bin/bash

set -exu -o pipefail

EXTRA_MIGRATE_LISTS_DIR="/etc/rauc/migrate.d"
CERT_AVAILABLE_DIR="${RAUC_SLOT_MOUNT_POINT}/etc/rauc/certificates-available"
CERT_ENABLED_DIR="${RAUC_SLOT_MOUNT_POINT}/etc/rauc/certificates-enabled"

function enable_certificates () {
	# Ignore the enabled certifcates from the bundle
	rm "${CERT_ENABLED_DIR}"/*

	for cert in "${CERT_AVAILABLE_DIR}"/*; do
		cert_name=$(basename "${cert}")

		cert_hash=$(openssl x509 -pubkey -noout -in "${cert}" \
			| openssl pkey -pubin -outform der \
			| openssl dgst -sha256 -c -hex \
			| awk '{print toupper($2)}')

		# Enable certificates that match the hash of the public key(s)
		# that the current bundle is signed with.
		# This means that a bundle signed with e.g. an official stable
		# channel certificate will only be able to install other
		# bundles from the same release channel.
		for bundle_hash in ${RAUC_BUNDLE_SPKI_HASHES}; do
			if [[ "${bundle_hash}" == "${cert_hash}" ]]; then
				echo "Enable certificate ${cert_name}"
				ln -s \
				   "../certificates-available/${cert_name}"\
				   "${CERT_ENABLED_DIR}/${cert_name}"
			fi
		done
	done

	openssl rehash "${CERT_ENABLED_DIR}"
}

function migrate () {
	if [[ ! -f "$1" ]]; then
		return
	fi

	mkdir -p "$(dirname "${RAUC_SLOT_MOUNT_POINT}"/"$1")"
	cp -a "$1" "${RAUC_SLOT_MOUNT_POINT}/$1"
}

function process_migrate_lists () {
	if [ ! -d "${EXTRA_MIGRATE_LISTS_DIR}" ]; then
		return
	fi

	for migrate_list in "${EXTRA_MIGRATE_LISTS_DIR}"/*.conf; do
		# Migrate files in the list line by line
		while read -r line; do
			migrate "${line}"
		done < "${migrate_list}"

		# Also migrate the list itself
		migrate "${migrate_list}"
	done
}

case "$1" in
	slot-post-install)
		enable_certificates

		# The repartitioning triggered by the existence of
		# /system-update is only required on the first boot after
		# installing from an eMMC image.
		rm -f "${RAUC_SLOT_MOUNT_POINT}/system-update"

		migrate /etc/machine-id
		migrate /etc/labgrid/environment
		migrate /etc/labgrid/userconfig.yaml
		for x in /etc/ssh/ssh_host*; do
			migrate "${x}"
		done
		migrate /var/lib/chrony/drift
		migrate /home/root/.bash_history
		migrate /home/root/.ssh/authorized_keys
		migrate /var/cache/lxa-iobus/lss-cache

		# Also allow the running system to specify additional files to
		# migrate to the new slot via files in /etc/rauc/migrate.d.
                # The files should contain one file per line that should be
                # migrated to the new slot.
		process_migrate_lists
		;;
	*)
		exit 1
		;;
esac

exit 0
