DESCRIPTION="ympd MPD Web GUI - written in C, utilizing Websockets and Bootstrap/JS"
HOMEPAGE = "https://www.ympd.org/"
SECTION = "audio"

DEPENDS = "libgcrypt libplist libsodium gperf gperftools libtool gettext gawk libunistring sqlite3"
RDEPENDS_forked_daapd = "libgcrypt libplist libsodium gperf"

PR = "r1"
PV = "25.0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "03ec423f83b5dc3c38962bb481557fcfce248448"
SRC_URI = " \
		git://github.com/ejurgensen/forked-daapd;protocol=git \
	  "

# update-rc.d
inherit autotools pkgconfig
