DESCRIPTION="The SoX Resampler library"
HOMEPAGE = "https://sourceforge.net/projects/soxr/"
SECTION = "audio"

DEPENDS = ""

PR = "r1"
PV = "0.1.2"

${S} = "${WORKDIR}/soxr-${PV}-Source"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://${WORKDIR}/soxr-${PV}-Source/COPYING.LGPL;md5=8c2e1ec1540fb3e0beb68361344cba7e"

SRC_URI = "${SOURCEFORGE_MIRROR}/soxr/files/soxr-${PV}-Source.tar.xz"
SRC_URI[md5sum] = "0866fc4320e26f47152798ac000de1c0"
SRC_URI[sha256sum] = "54e6f434f1c491388cd92f0e3c47f1ade082cc24327bdc43762f7d1eefe0c275"

EXTRA_OECMAKE="-DWITH_SIMD:BOOL=OFF -DHAVE_WORDS_BIGENDIAN_EXITCODE=1 -DBUILD_TESTS:BOOL=OFF -DCMAKE_BUILD_TYPE="Debug" ../soxr-${PV}-Source "

inherit pkgconfig cmake
