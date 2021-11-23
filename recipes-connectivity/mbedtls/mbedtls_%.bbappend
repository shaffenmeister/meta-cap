LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=384d14e85a436385716abe91e41ae9cd"

#PV = "1.3.19"
PV = "2.5.1"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
		https://tls.mbed.org/download/mbedtls-${PV}-gpl.tgz \
	        file://0001.patch \
		"

#SRC_URI[md5sum] = "f1af54d23b0ce6a2021e4bede6fd4d44"
#SRC_URI[sha256sum] = "59654984c5a30575142fb30ed04c2c3ac3c94f1c27843a04bce80ca111a4b00e"

SRC_URI[md5sum] = "313f637f65b5f6d74d45310482a9c84f"
SRC_URI[sha256sum] = "312f020006f0d8e9ede3ed8e73d907a629baf6475229703941769372ab0adee2"

