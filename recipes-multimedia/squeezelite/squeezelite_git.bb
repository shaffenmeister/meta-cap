DESCRIPTION = "Squeezelite v1.9"
AUTHOR = "Adrian Smith, Ralph Irving"
HOMEPAGE = "https://github.com/ralph-irving/squeezelite"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4a6efe45e946fda532470a3da05195c3"

DEPENDS = "alsa-lib alsa-utils alsa-tools alsa-plugins flac libogg libvorbis libmad faad2 mpg123 ffmpeg sox lirc libsoxr"
RDEPENDS_${PN} = "flac (>=1.3) libogg (>=1.3.0) libvorbis libmad faad2 mpg123 ffmpeg sox lirc libsoxr (>=0.1.0)"

OPTS = "-DDSD -DFFMPEG -DRESAMPLE"
TARGET_CFLAGS  += "-Wall -fPIC -O2 ${OPTS}"
TARGET_LDFLAGS += "-lasound -lpthread -lm -lrt"

PR = "r5"
PV = "v1.9.0-1111"

SRCREV = "763c71baf33efdac6993bb38c68dab252869e617"

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

RDEPENDS_${PN} += ""

FILES_${PN} = "${bindir} ${sysconfdir}"
