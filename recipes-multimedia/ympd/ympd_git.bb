DESCRIPTION="ympd MPD Web GUI - written in C, utilizing Websockets and Bootstrap/JS"
HOMEPAGE = "https://www.ympd.org/"
SECTION = "audio"

DEPENDS = "libmpdclient"
RDEPENDS_ympd = "libmpdclient (>=2.0)"

PR = "r1"
PV = "1.2.3"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb723b61539feef013de476e68b5c50a"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "ec008a4995666d673bd4cb3926fae7f4b6aa3239"
SRC_URI = " \
		git://github.com/notandy/ympd;protocol=git \
	        file://150.patch \
	  "

#SRCREV = "6cbb61107bfb3f92e2ad7dfdc7ae4493812d8835"
#SRC_URI = "git://github.com/shaffenmeister/ympd;protocol=git"

# EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE:STRING="

inherit pkgconfig cmake
