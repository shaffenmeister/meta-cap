DESCRIPTION = "Squeezelite v1.9.9"
AUTHOR = "Adrian Smith, Ralph Irving"
HOMEPAGE = "https://github.com/ralph-irving/squeezelite"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0c8c6cd22c1c43af1c36685ade0fe49b"

DEPENDS = "alsa-lib alsa-utils alsa-tools alsa-plugins flac libogg libvorbis libmad faad2 mpg123 ffmpeg sox lirc libsoxr libopus opusfile openssl"
RDEPENDS:${PN} = "flac (>=1.3) libogg (>=1.3.0) libvorbis libmad faad2 mpg123 ffmpeg sox lirc libsoxr (>=0.1.0) libopus opusfile openssl"

OPTS = "-DDSD -DFFMPEG -DRESAMPLE -DGPIO -DIR -DRPI -DOPUS -DUSE_SSL -DLINKALL -I=/usr/include/opus"
#TARGET_CFLAGS  += "-Wall -fPIC -O2 ${OPTS} -g "
#TARGET_LDFLAGS += "-lasound -lpthread "

PR = "r5"
PV = "v1.9.9-1432"

SRCREV = "575b59398dd19945d2038474062240fc527407fb"

SRC_URI = " \
    git://github.com/ralph-irving/squeezelite.git;protocol=https;branch=master \
    file://default \
    file://init \
 "

S = "${WORKDIR}/git"

do_compile () {
    make --file=Makefile OPTS="${OPTS}"
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
