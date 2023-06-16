DESCRIPTION="libConfuse is a configuration file parser library."
HOMEPAGE = "https://github.com/martinh/libconfuse"
#SECTION = ""

DEPENDS = "meson ninja"

PR = "r1"
PV = "3.3"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42fa47330d4051cd219f7d99d023de3a"

S = "${WORKDIR}/git"

SRCREV = "a42aebf13db33afd575da6e63f55163d371f776d"
SRC_URI = "git://github.com/martinh/libconfuse;protocol=https;branch=master"

inherit pkgconfig
