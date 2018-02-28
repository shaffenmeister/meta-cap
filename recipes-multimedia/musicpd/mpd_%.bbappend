DEPENDS_remove = " \
  openal-soft \
  libcdio \
  pulseaudio \
"

RDEPENDS_remove = " \
  omxplayer \
"

PV = "0.20.18"

SRC_URI = " \
    http://www.musicpd.org/download/${BPN}/0.20/${BP}.tar.xz \
    file://mpd.conf.in \
"

SRC_URI[md5sum] = "8dc87ba95473fd738f2aff9bd69cc212"
SRC_URI[sha256sum] = "6a582dc2ae90b94ff3853f9ffd7d80b2c2b5fe2e2c35cb1da0b36f3f3dfad434"
