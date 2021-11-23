SECTION = "console/multimedia"
SUMMARY = "A minimalist command line interface to MPD."
HOMEPAGE = "https://www.musicpd.org/clients/mpc/"

DEPENDS = "libmpdclient"
RRECOMMENDS:${PN} = "mpd"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI="http://www.musicpd.org/download/mpc/0/${BP}.tar.xz"
SRC_URI[md5sum] = "7d1f5c308b5df1f2af0a01360a235af2"
SRC_URI[sha256sum] = "4f40ccbe18f5095437283cfc525a97815e983cbfd3a29e48ff610fa4f1bf1296"

inherit pkgconfig meson

