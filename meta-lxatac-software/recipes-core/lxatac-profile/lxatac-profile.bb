DESCRIPTION = "PTX distro specific profile"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://01-labgrid.sh"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${sysconfdir}/profile.d/
	install -m 0755 ${S}/01-labgrid.sh ${D}${sysconfdir}/profile.d/
}

FILES:${PN} = "${sysconfdir}/profile.d/01-labgrid.sh"
