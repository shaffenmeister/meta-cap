DESCRIPTION="C library to implement a MPD client "
HOMEPAGE = "https://github.com/MusicPlayerDaemon/libmpdclient"
SECTION = "audio"

DEPENDS = "meson ninja"

PR = "r1"
PV = "2.14"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"

S = "${WORKDIR}/git"

SRCREV = "b9b26fd82c87b692a280b21ad88da2902facc915"
SRC_URI = "git://github.com/MusicPlayerDaemon/libmpdclient;protocol=git"

EXTRA_OECMAKE=""

inherit pkgconfig meson

FILES_${PN} += "${datadir}/vala/*"
