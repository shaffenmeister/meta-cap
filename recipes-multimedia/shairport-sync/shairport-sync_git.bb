DESCRIPTION="AirPlay audio player. Shairport Sync adds multi-room capability with Audio Synchronisation"
HOMEPAGE = "https://github.com/mikebrady/shairport-sync/"
SECTION = "audio"

DEPENDS = "libsoxr openssl avahi alsa-lib alsa-utils alsa-tools alsa-plugins libdaemon autoconf automake libtool popt libconfig"
RDEPENDS_${PN} = "libsoxr (>=0.1.2)"

PR = "r2"
PV = "3.3.8"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSES;md5=9f329b7b34fcd334fb1f8e2eb03d33ff"

#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
EXTRA_OECONF += " --with-ssl=openssl --with-avahi --with-alsa --with-soxr --with-metadata --with-configfiles=no"

S = "${WORKDIR}/git"

SRCREV = "c19f697be2b6761616876787064d6b067cf87089"

SRC_URI = " \
		git://github.com/mikebrady/shairport-sync;protocol=git \
	  "

inherit autotools pkgconfig
