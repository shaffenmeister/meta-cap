DESCRIPTION="C library to implement a MPD client "
HOMEPAGE = "https://github.com/MusicPlayerDaemon/libmpdclient"
SECTION = "audio"

DEPENDS = "meson ninja"

PR = "r1"
PV = "2.16"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"

S = "${WORKDIR}/git"

SRCREV = "4e8d990eb5239566ee948f1cd79b7248e008620a"
SRC_URI = "git://github.com/MusicPlayerDaemon/libmpdclient;protocol=git"

EXTRA_OECMAKE=""

inherit pkgconfig meson

FILES_${PN} += "${datadir}/vala/*"
