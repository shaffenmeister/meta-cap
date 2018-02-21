DEPENDS_remove = " \
  openal-soft \
  libcdio \
  pulseaudio \
"

RDEPENDS_remove = " \
  omxplayer \
"

PV = "0.20.17"

SRC_URI = " \
    http://www.musicpd.org/download/${BPN}/0.20/${BP}.tar.xz \
    file://mpd.conf.in \
"

SRC_URI[md5sum] = "2b599f617d416b708b9b4856d09143be"
SRC_URI[sha256sum] = "2cb0e7f0e219df60a04b3c997d8ed7ad458ebfd89fd045e03fbe727277d5dac1"
