DESCRIPTION="Linux/FreeBSD DAAP (iTunes) and MPD media server with support for AirPlay devices (multiroom), Apple Remote (and compatibles), Chromecast, Spotify and internet radio."
HOMEPAGE = "https://github.com/owntone/"
SECTION = "audio"

DEPENDS = "libgcrypt libunistring zlib confuse libmxml sqlite3 libevent json-c libantlr3c ffmpeg avahi libplist libsodium libwebsockets \
           gperf-native antlr3-native curl protobuf-c \
          "
RDEPENDS:${PN} += " libgcc"

PR = "r1"
PV = "28.3"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "a95b226fdb04654291b3328395ec9f7f52d54f53"
SRC_URI = " \
		git://github.com/owntone/owntone-server.git;protocol=git \
	  "

# update-rc.d
inherit autotools pkgconfig useradd

EXTRA_OECONF = "--disable-dependency-tracking"

do_install:append() {
    chown -R owntone ${D}/${localstatedir}/cache/owntone/
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/build/owntone.service ${D}${systemd_system_unitdir}/owntone.service

}


FILES:${PN} += "${libdir}/owntone/owntone-sqlext.so ${datadir}/owntone/htdocs/* /run ${systemd_system_unitdir}/owntone.service"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM:${PN} = " \
    --system --no-create-home \
    --home ${localstatedir}/cache/owntone \
    --groups audio \
    --user-group owntone"

SYSTEMD_SERVICE:${PN} = "owntone.service"

