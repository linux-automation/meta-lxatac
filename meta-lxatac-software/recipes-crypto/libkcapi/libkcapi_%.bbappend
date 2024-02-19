PACKAGECONFIG = "testapp apps"

do_install:append() {
    # avoid conflicts with busybox and coreutils
    for x in fipscheck fipshmac md5sum sha1hmac sha1sum sha224hmac sha224sum sha256hmac sha256sum sha384hmac sha384sum sha512hmac sha512sum; do
        mv ${D}${bindir}/$x ${D}${bindir}/kcapi-$x
    done
}
