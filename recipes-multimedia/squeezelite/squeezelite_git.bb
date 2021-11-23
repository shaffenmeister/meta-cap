DESCRIPTION = "Squeezelite v1.9.9"
AUTHOR = "Adrian Smith, Ralph Irving"
HOMEPAGE = "https://github.com/ralph-irving/squeezelite"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=1a2638a748e0524c9fde16d50c85f5d9"

DEPENDS = "alsa-lib alsa-utils alsa-tools alsa-plugins flac libogg libvorbis libmad faad2 mpg123 ffmpeg sox lirc libsoxr libopus opusfile"
RDEPENDS:${PN} = "flac (>=1.3) libogg (>=1.3.0) libvorbis libmad faad2 mpg123 ffmpeg sox lirc libsoxr (>=0.1.0) libopus opusfile"

OPTS = "-DDSD -DFFMPEG -DRESAMPLE -DGPIO -DIR -DRPI -DOPUS -I=/usr/include/opus"
TARGET_CFLAGS  += "-Wall -fPIC -O2 ${OPTS}"
TARGET_LDFLAGS += "-lasound -lpthread -lm -lrt -ldl"

PR = "r5"
PV = "v1.9.9-1392"

SRCREV = "790f8bda0d906e55c813493eae095bc2d295e8da"

SRC_URI = " \
    git://github.com/ralph-irving/squeezelite.git;protocol=git \
    file://default \
    file://init \
 "

S = "${WORKDIR}/git"

do_compile () {
    make OPTS="${OPTS}"
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/git/squeezelite ${D}${bindir}

    install -d ${D}${sysconfdir}/default
    install -m 0664 ${WORKDIR}/default ${D}${sysconfdir}/default/squeezelite

    install -d ${D}${sysconfdir}/init.d
    install -m 0664 ${WORKDIR}/init ${D}${sysconfdir}/init.d/squeezelite
}

RDEPENDS:${PN} += ""

FILES:${PN} = "${bindir} ${sysconfdir}"
