DESCRIPTION="dsp dsp is an audio processing program with an interactive mode."
HOMEPAGE = "https://github.com/bmc0/dsp/"
SECTION = "audio"

DEPENDS = "alsa-lib "
RDEPENDS_${PN} = ""

PR = "r1"
PV = "1.5"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "4169d70b7d577dac6e4e87871ccde6bdcd221c3b"
SRC_URI = " \
		git://github.com/bmc0/dsp.git;protocol=git \
	  "

# update-rc.d
inherit pkgconfig
