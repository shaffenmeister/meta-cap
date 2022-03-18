# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42fa47330d4051cd219f7d99d023de3a"

SRC_URI = "https://github.com/martinh/libconfuse/releases/download/v${PV}/confuse-${PV}.tar.gz"
SRC_URI[md5sum] = "1ba3b410d8d46f6e74b0d37b4177e13f"
SRC_URI[sha256sum] = "71316b55592f8d0c98924242c98dbfa6252153a8b6e7d89e57fe6923934d77d0"

DEPENDS = "flex-native"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit autotools gettext binconfig pkgconfig lib_package

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--enable-shared"

BBCLASSEXTEND = "native"

