DESCRIPTION="C library to implement a MPD client "
HOMEPAGE = "https://github.com/MusicPlayerDaemon/libmpdclient"
SECTION = "audio"

DEPENDS = "meson ninja"

PR = "r1"
PV = "2.1.3"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=06b9dfd2f197dc514d8ef06549684b77"

S = "${WORKDIR}/git"

SRCREV = "b137dbd55ca1de9f98adc7f4f12c1fead9112c1b"
SRC_URI = "git://github.com/MusicPlayerDaemon/libmpdclient;protocol=git"

EXTRA_OECMAKE=""

inherit pkgconfig meson

FILES_${PN} += "${datadir}/vala/*"
