DESCRIPTION="ympd MPD Web GUI - written in C, utilizing Websockets and Bootstrap/JS"
HOMEPAGE = "https://www.ympd.org/"
SECTION = "audio"

DEPENDS = "libmpdclient"
RDEPENDS_ympd = "libmpdclient (>=2.0)"

PR = "r3"
PV = "1.3.0m"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eb723b61539feef013de476e68b5c50a"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "612f8fc0b2c47fc89d403e4a044541c6b2b238c8"
SRC_URI = " \
		git://github.com/notandy/ympd;protocol=git \
	  "

#file://150.patch
#SRCREV = "6cbb61107bfb3f92e2ad7dfdc7ae4493812d8835"
#SRC_URI = "git://github.com/shaffenmeister/ympd;protocol=git"

inherit pkgconfig cmake
