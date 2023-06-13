FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

PANEL_FIRMWARE = "shineworld,lh133k.txt"
SRC_URI = "file://${PANEL_FIRMWARE}"

inherit panel-mipi-dbi

PV = "1.0"

#S = "${WORKDIR}/git"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

