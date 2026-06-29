#!/bin/bash

set -exu -o pipefail
shopt -s nullglob

EXTRA_MIGRATE_LISTS_DIR="/etc/rauc/migrate.d"
CERT_AVAILABLE_DIRS="${RAUC_SLOT_MOUNT_POINT:?}/etc/rauc/certificates-available ${RAUC_SLOT_MOUNT_POINT:?}/usr/lib/rauc/certificates-available"
CERT_ENABLED_DIR="${RAUC_SLOT_MOUNT_POINT:?}/etc/rauc/certificates-enabled"
BUNDLE_SPKI_HASHES="${RAUC_BUNDLE_SPKI_HASHES:?}"

function enable_certificates () {
	# Ignore the enabled certificates from the bundle
	rm "${CERT_ENABLED_DIR}"/*

	for available_dir in ${CERT_AVAILABLE_DIRS}; do
		for cert in "${available_dir}"/*; do
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
			for bundle_hash in ${BUNDLE_SPKI_HASHES}; do
				if [[ "${bundle_hash}" == "${cert_hash}" ]]; then
					echo "Enable certificate ${cert_name}"
					ln --symbolic --relative \
					   "${cert}" \
					   "${CERT_ENABLED_DIR}/${cert_name}"
				fi
			done
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
	for migrate_list in "${EXTRA_MIGRATE_LISTS_DIR}"/*.conf; do
		# Migrate files in the list line by line
		while read -r line; do
			migrate "${line}"
		done < "${migrate_list}"

		# Also migrate the list itself
		migrate "${migrate_list}"
	done
}

function insert_bundle_version () {
	# The running system will not have a good idea about its current RAUC
	# bundle version, which it does however need to check for updates.
	# Provide the version by extracting it from the current manifest file and
	# placing an override in the system-info handler.
	VERSION_ID=$(grep '^version=' "${RAUC_BUNDLE_MOUNT_POINT:?}/manifest.raucm" | cut -d'=' -f2)

	sed -i "s/^# <rauc-install-hook-version-override>/VERSION_ID=${VERSION_ID}/" \
		"${RAUC_SLOT_MOUNT_POINT}/usr/lib/rauc/system-info-handler.sh"
}

case "$1" in
	slot-post-install)
		enable_certificates

		# The repartitioning triggered by the existence of
		# /system-update is only required on the first boot after
		# installing from an eMMC image.
		rm -f "${RAUC_SLOT_MOUNT_POINT}/system-update"

		migrate /etc/hostname
		migrate /etc/machine-id
		migrate /etc/labgrid/environment
		migrate /etc/labgrid/userconfig.yaml
		migrate /etc/github-act-runner/sessions.json
		migrate /etc/github-act-runner/settings.json
		migrate /etc/gitlab-runner/config.toml
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

		insert_bundle_version
		;;
	*)
		exit 1
		;;
esac

exit 0
