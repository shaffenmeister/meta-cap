DESCRIPTION="The SoX Resampler library"
HOMEPAGE = "https://sourceforge.net/projects/soxr/"
SECTION = "audio"

DEPENDS = ""

PR = "r1"
PV = "0.1.3"

${S} = "${WORKDIR}/soxr-${PV}-Source"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://${WORKDIR}/soxr-${PV}-Source/COPYING.LGPL;md5=8c2e1ec1540fb3e0beb68361344cba7e"

SRC_URI = "${SOURCEFORGE_MIRROR}/soxr/files/soxr-${PV}-Source.tar.xz"
SRC_URI[md5sum] = "3f16f4dcb35b471682d4321eda6f6c08"
SRC_URI[sha256sum] = "b111c15fdc8c029989330ff559184198c161100a59312f5dc19ddeb9b5a15889"

EXTRA_OECMAKE="-DWITH_SIMD:BOOL=OFF -DHAVE_WORDS_BIGENDIAN_EXITCODE=1 -DBUILD_TESTS:BOOL=OFF -DCMAKE_BUILD_TYPE="Debug" ../soxr-${PV}-Source "

inherit pkgconfig cmake
