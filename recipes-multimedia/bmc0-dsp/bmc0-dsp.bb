DESCRIPTION="dsp dsp is an audio processing program with an interactive mode."
HOMEPAGE = "https://github.com/bmc0/dsp/"
SECTION = "audio"

DEPENDS = "alsa-lib "
RDEPENDS_${PN} = ""

PR = "r1"
PV = "1.6"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=de2331727b476fb3c5eb43114ccf2f28"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "5af730fa04a512a2881ec67eab6aba2d6c235cea"
SRC_URI = " \
		git://github.com/bmc0/dsp.git;protocol=git \
	  "

# update-rc.d
inherit pkgconfig
