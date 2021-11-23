DESCRIPTION="Linux/FreeBSD DAAP (iTunes) and MPD media server with support for AirPlay devices (multiroom), Apple Remote (and compatibles), Chromecast, Spotify and internet radio."
HOMEPAGE = "https://github.com/owntone/"
SECTION = "audio"

DEPENDS = "libgcrypt libplist libsodium gperf gperftools libtool gettext gawk libunistring sqlite3 antlr3 libconfuse libunistring "
RDEPENDS:forked_daapd = "libgcrypt libplist libsodium gperf gperftools libconfuse "

PR = "r1"
PV = "27.4"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "0d1e22496c339dcae69517283856328343d7a44b"
SRC_URI = " \
		git://github.com/owntone/owntone-server.git;protocol=git \
	  "

# update-rc.d
inherit autotools pkgconfig
