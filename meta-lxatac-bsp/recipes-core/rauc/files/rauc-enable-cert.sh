#!/bin/bash

set -euo pipefail

AVAILABLE_DIRS="/usr/lib/rauc/certificates-available /etc/rauc/certificates-available"
ENABLED_DIR="/etc/rauc/certificates-enabled"

if [[ "$#" -ne 1 ]]; then
    echo "Usage: $0 cert.pem"
    echo "Available certificates:"
    for dir in ${AVAILABLE_DIRS}; do
        test -d "${dir}" && ls "${dir}"
    done
    exit 1
fi

cert=""

for dir in ${AVAILABLE_DIRS}; do
    if [[ -f "${dir}/$1" ]]; then
        cert="${dir}/$1"
        break
    fi
done

if [[ -z "${cert}" ]]; then
    echo "The certificate to activate must be stored in:"
    echo "${AVAILABLE_DIRS}"
    exit 1
fi

rm -f "${ENABLED_DIR}/"*.cert.pem

ln --symbolic --relative "${cert}" "${ENABLED_DIR}/$1"
openssl rehash "${ENABLED_DIR}"

# Ask the tacd to update the list of channels
curl -X PUT -d "true" "http://localhost/v1/tac/update/channels/reload"
