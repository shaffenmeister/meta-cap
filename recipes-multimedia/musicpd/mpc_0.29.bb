SECTION = "console/multimedia"
SUMMARY = "A minimalist command line interface to MPD."
HOMEPAGE = "https://www.musicpd.org/clients/mpc/"

DEPENDS = "libmpdclient"
RRECOMMENDS_${PN} = "mpd"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI="http://www.musicpd.org/download/mpc/0/${BP}.tar.xz"
SRC_URI[md5sum] = "0c4a880d65c10ca6e5209ba6886e9832"
SRC_URI[sha256sum] = "02f1daec902cb48f8cdaa6fe21c7219f6231b091dddbe437a3a4fb12cb07b9d3"

inherit pkgconfig meson

