DESCRIPTION="libConfuse is a configuration file parser library."
HOMEPAGE = "https://github.com/martinh/libconfuse"
#SECTION = ""

DEPENDS = "meson ninja"

PR = "r1"
PV = "3.2.2"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42fa47330d4051cd219f7d99d023de3a"

S = "${WORKDIR}/git"

SRCREV = "8dc469dcce4d19379caff2d2cbf68f38af034210"
SRC_URI = "git://github.com/martinh/libconfuse;protocol=git"

inherit pkgconfig
