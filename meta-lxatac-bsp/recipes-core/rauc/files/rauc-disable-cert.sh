#!/bin/bash

set -euo pipefail

ENABLED_DIR="/etc/rauc/certificates-enabled"

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 cert.pem"
    echo "Enabled certificates:"
    ls --hide "*.0" "$ENABLED_DIR"
    exit 1
fi

if [ ! -L "$ENABLED_DIR/$1" ]; then
    echo "The certificate to deactivate must be stored in:"
    echo "$ENABLED_DIR"
    exit 1
fi

rm "$ENABLED_DIR/$1"

openssl rehash "$ENABLED_DIR"

