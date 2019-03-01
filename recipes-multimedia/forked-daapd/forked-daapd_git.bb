DESCRIPTION="Linux/FreeBSD DAAP (iTunes) and MPD media server with support for AirPlay devices (multiroom), Apple Remote (and compatibles), Chromecast, Spotify and internet radio."
HOMEPAGE = "http://ejurgensen.github.io/forked-daapd/"
SECTION = "audio"

DEPENDS = "libgcrypt libplist libsodium gperf gperftools libtool gettext gawk libunistring sqlite3 antlr3 libconfuse libunistring"
RDEPENDS_forked_daapd = "libgcrypt libplist libsodium gperf"

PR = "r1"
PV = "26.4"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "e9c74412419726df59d7cc2afb2151b21535e8da"
SRC_URI = " \
		git://github.com/ejurgensen/forked-daapd;protocol=git \
	  "

# update-rc.d
inherit autotools pkgconfig
