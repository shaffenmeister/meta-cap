SECTION = "console/multimedia"
SUMMARY = "A minimalist command line interface to MPD."
HOMEPAGE = "https://www.musicpd.org/clients/mpc/"

DEPENDS = "libmpdclient"
RRECOMMENDS_${PN} = "mpd"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI="http://www.musicpd.org/download/mpc/0/${BP}.tar.xz"
SRC_URI[md5sum] = "c71693d2f03bd4a4bed96e304b24d906"
SRC_URI[sha256sum] = "65fc5b0a8430efe9acbe6e261127960682764b20ab994676371bdc797d867fce"

inherit pkgconfig meson

