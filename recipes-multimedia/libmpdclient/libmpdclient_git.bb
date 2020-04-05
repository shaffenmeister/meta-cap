DESCRIPTION="C library to implement a MPD client "
HOMEPAGE = "https://github.com/MusicPlayerDaemon/libmpdclient"
SECTION = "audio"

DEPENDS = "meson ninja"

PR = "r1"
PV = "2.18"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"

S = "${WORKDIR}/git"

SRCREV = "f5ac35174d1a343c59f55e1135316fae80522465"
SRC_URI = "git://github.com/MusicPlayerDaemon/libmpdclient;protocol=git"

EXTRA_OECMAKE=""

inherit pkgconfig meson

FILES_${PN} += "${datadir}/vala/*"
