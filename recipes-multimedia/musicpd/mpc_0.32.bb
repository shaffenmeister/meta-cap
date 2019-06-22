SECTION = "console/multimedia"
SUMMARY = "A minimalist command line interface to MPD."
HOMEPAGE = "https://www.musicpd.org/clients/mpc/"

DEPENDS = "libmpdclient"
RRECOMMENDS_${PN} = "mpd"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI="http://www.musicpd.org/download/mpc/0/${BP}.tar.xz"
SRC_URI[md5sum] = "a921749b37caa9a486e41b354b9e0060"
SRC_URI[sha256sum] = "7961d95b7ce019996beab281cf957e905667c989c53fffd13ade5e62fea331c7"

inherit pkgconfig meson

