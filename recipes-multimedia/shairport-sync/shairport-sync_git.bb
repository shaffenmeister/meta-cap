DESCRIPTION="AirPlay audio player. Shairport Sync adds multi-room capability with Audio Synchronisation"
HOMEPAGE = "https://github.com/mikebrady/shairport-sync/"
SECTION = "audio"

DEPENDS = "libsoxr openssl avahi alsa-lib alsa-utils alsa-tools alsa-plugins libdaemon autoconf automake libtool popt libconfig"
RDEPENDS_${PN} = "libsoxr (>=0.1.2)"

PR = "r1"
PV = "3.1"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES;md5=07500f0fdc8de2e270a9f0b8b1857ecd"

#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
EXTRA_OECONF += " --with-ssl=openssl --with-avahi --with-alsa --with-soxr --with-metadata --with-configfiles=no"

S = "${WORKDIR}/git"

SRCREV = "46f5632af1dff351d8d615f3da7c4a885dd0b7be"
SRC_URI = " \
		git://github.com/mikebrady/shairport-sync;protocol=git \
	  "

inherit autotools pkgconfig
