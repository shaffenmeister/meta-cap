DESCRIPTION="IQ Amp Control: Control MPD via IR commands and rotary encoders"
HOMEPAGE = "https://github.com/shaffenmeister/iq_amp_control"

DEPENDS = "alsa-lib libmpdclient"
RDEPENDS_${PN} = " mpd libmpdclient"

PR = "r1"
PV = "0.1"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5869cac4966c50d74387d9d08a5bdd12"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "217b539f0c2a9e53972e5692708c0dcb8eaeaa43"
SRC_URI = " \
		git://github.com/shaffenmeister/iq_amp_control.git;protocol=git \
	  "

# update-rc.d
inherit pkgconfig
