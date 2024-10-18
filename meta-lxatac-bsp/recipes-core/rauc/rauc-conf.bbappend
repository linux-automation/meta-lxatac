FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DEPENDS += "openssl-native"
RDEPENDS:${PN} += "bash"

SRC_URI += " \
    file://rauc-disable-cert.sh \
    file://rauc-enable-cert.sh \
    file://devel.cert.pem \
    file://stable.cert.pem \
    file://testing.cert.pem \
    "

do_install:append() {
    install -D -m 0755 ${UNPACKDIR}/rauc-disable-cert.sh \
        ${D}${bindir}/rauc-disable-cert

    install -D -m 0755 ${UNPACKDIR}/rauc-enable-cert.sh \
        ${D}${bindir}/rauc-enable-cert

    install -d ${D}${sysconfdir}/rauc/certificates-available
    install -d ${D}${sysconfdir}/rauc/certificates-enabled

    # Ship the different release channel certificates with each image.
    # Which of these gets activated when updating via RAUC is decided in
    # the RAUC hook.
    # The RAUC hook will activate the certificate matching the key the
    # bundle was signed with.
    for cert in devel stable testing; do
        install -D -m 0644 ${UNPACKDIR}/${cert}.cert.pem \
            ${D}${sysconfdir}/rauc/certificates-available/${cert}.cert.pem
    done

    KEYRING_FILE_NAME=$(basename "${RAUC_KEYRING_FILE}")

    # If RAUC_KEYRING_FILE is not overridden by a customization layer on top
    # of meta-lxatac this will point to devel.cert.pem and the file
    # installed above is overwritten by this mv.
    # If RAUC_KEYRING_FILE is overridden the extra cert will be installed
    # along with the other ones.
    mv ${D}${sysconfdir}/rauc/${KEYRING_FILE_NAME} \
        ${D}${sysconfdir}/rauc/certificates-available/${KEYRING_FILE_NAME}

    # Due to the certificate enable/disable logic in the RAUC hook the
    # following line is only relevant for images _not_ installed via RAUC.
    for cert in ${RAUC_CERT_ENABLE}; do
        ln -s ../certificates-available/${cert} \
            ${D}${sysconfdir}/rauc/certificates-enabled/${cert}
    done

    openssl rehash ${D}${sysconfdir}/rauc/certificates-enabled
}
