LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=13c502aaa9b2ca91d01a3aae44d899b4"

SRC_URI = "https://github.com/antlr/website-antlr3/raw/gh-pages/download/C/libantlr3c-${PV}.tar.gz \
           file://0001-fix-bitbake-package-error.patch \
           "
SRC_URI[md5sum] = "08b1420129d5dccd0f4461cedf2a0d7d"
SRC_URI[sha256sum] = "ca914a97f1a2d2f2c8e1fca12d3df65310ff0286d35c48b7ae5f11dcc8b2eb52"

inherit autotools pkgconfig gettext lib_package

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "  --enable-64bit"

#SOLIBSDEV = ""
FILES:${PN}-dev=" ${includedir}/*.h ${libdir}*.so"
FILES:${PN} += "${libdir}/*.so"
