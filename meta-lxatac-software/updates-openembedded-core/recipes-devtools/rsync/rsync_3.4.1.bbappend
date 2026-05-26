PV = "3.4.4"
SRC_URI[sha256sum] = "bd88cf82fa653da32314fb229136407c5c90f80d1758d8f4b091767877d8fa96"

SRC_URI:remove = "\
    file://0001-Add-missing-prototypes-to-function-declarations.patch \
    file://CVE-2025-10158.patch \
"
