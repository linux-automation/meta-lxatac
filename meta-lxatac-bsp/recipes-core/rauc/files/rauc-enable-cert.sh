#!/bin/bash

set -euo pipefail

AVAILABLE_DIR="/etc/rauc/certificates-available"
ENABLED_DIR="/etc/rauc/certificates-enabled"

if [[ "$#" -ne 1 ]]; then
    echo "Usage: $0 cert.pem"
    echo "Available certificates:"
    ls "${AVAILABLE_DIR}"
    exit 1
fi

if [[ ! -f "${AVAILABLE_DIR}/$1" ]]; then
    echo "The certificate to activate must be stored in:"
    echo "${AVAILABLE_DIR}"
    exit 1
fi

if [[ -L "${ENABLED_DIR}/$1" ]]; then
    rm "${ENABLED_DIR}/$1"
fi

ln -s "../certificates-available/$1" "${ENABLED_DIR}/$1"
openssl rehash "${ENABLED_DIR}"

# Ask the tacd to update the list of channels
curl -X PUT -d "true" "http://localhost/v1/tac/update/channels/reload"
