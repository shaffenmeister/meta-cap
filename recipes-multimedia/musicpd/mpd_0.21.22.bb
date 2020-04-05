SUMMARY = "Music Player Daemon"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
HOMEPAGE ="http://www.musicpd.org"

inherit meson useradd systemd pkgconfig

DEPENDS += " \
    curl \
    sqlite3 \
    ${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)} \
    yajl \
    boost \
    icu \
    dbus \
    expat \
"

SRC_URI = " \
    git://github.com/MusicPlayerDaemon/MPD;branch=v0.21.x \
    file://mpd.conf.in \
"
SRCREV = "5ccfcffcc124e406233359fe8fe65b704b98b8c8"
S = "${WORKDIR}/git"

EXTRA_OEMESON += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '-Dsystemd_system_unit_dir=${systemd_unitdir}/system -Dsystemd_user_unit_dir=${systemd_unitdir}/user', '', d)}"

PACKAGECONFIG ??= "alsa ao bzip2 daemon ffmpeg fifo flac fluidsynth iso9660 jack libsamplerate httpd mms mpg123 sndfile upnp openal opus oss recorder vorbis wavpack zlib"
PACKAGECONFIG += "${@bb.utils.contains('LICENSE_FLAGS', 'commercial', 'aac', '', d)}"

PACKAGECONFIG[aac] = "-Dfaad=enabled,-Dfaad=disabled,faad2"
PACKAGECONFIG[alsa] = "-Dalsa=enabled,-Dalsa=disabled,alsa-lib"
PACKAGECONFIG[ao] = "-Dao=enabled,-Dao=disabled,libao"
PACKAGECONFIG[audiofile] = "-Daudiofile=enabled,-Daudiofile=disabled,audiofile"
PACKAGECONFIG[bzip2] = "-Dbzip2=enabled,-Dbzip2=disabled,bzip2"
PACKAGECONFIG[daemon] = "-Ddaemon=true,-Ddaemon=false"
PACKAGECONFIG[database] = "-Ddatabase=true,-Ddatabase=false"
PACKAGECONFIG[dsd] = "-Ddsd=true,-Ddsd=false"
PACKAGECONFIG[ffmpeg] = "-Dffmpeg=enabled,-Dffmpeg=disabled,ffmpeg"
PACKAGECONFIG[fifo] = "-Dfifo=true,-Dfifo=false"
PACKAGECONFIG[flac] = "-Dflac=enabled,-Dflac=disabled,flac"
PACKAGECONFIG[fluidsynth] = "-Dfluidsynth=enabled,-Dfluidsynth=disabled,fluidsynth"
PACKAGECONFIG[httpd] = "-Dhttpd=true,-Dhttpd=false"
PACKAGECONFIG[id3tag] = "-Did3tag=enabled,-Did3tag=disabled,libid3tag"
PACKAGECONFIG[iso9660] = "-Diso9660=enabled,-Diso9660=disabled,libcdio"
PACKAGECONFIG[jack] = "-Djack=enabled,-Djack=disabled,jack"
PACKAGECONFIG[lame] = "-Dlame=enabled,-Dlame=disabled,lame"
PACKAGECONFIG[libsamplerate] = "-Dlibsamplerate=enabled,-Dlibsamplerate=disabled,libsamplerate0"
PACKAGECONFIG[mad] = "-Dmad=enabled,-Dmad=disabled,libmad"
PACKAGECONFIG[mms] = "-Dmms=enabled,-Dmms=disabled,libmms"
PACKAGECONFIG[modplug] = "-Dmodplug=enabled,-Dmodplug=disabled,libmodplug"
PACKAGECONFIG[mpg123] = "-Dmpg123=enabled,-Dmpg123=disabled,mpg123"
PACKAGECONFIG[openal] = "-Dopenal=enabled,-Dopenal=disabled,openal-soft"
PACKAGECONFIG[opus] = "-Dopus=enabled,-Dopus=disabled,libopus libogg"
PACKAGECONFIG[oss] = "-Doss=enabled,-Doss=disabled,"
PACKAGECONFIG[qobuz] = "-Dqobuz=enabled,-Dqobuz=disabled,curl yajl libgcrypt"
PACKAGECONFIG[recorder] = "-Drecorder=true,-Drecorder=false"
PACKAGECONFIG[smb] = "-Dsmbclient=enabled,-Dsmbclient=disabled,samba"
PACKAGECONFIG[sndfile] = "-Dsndfile=enabled,-Dsndfile=disabled,libsndfile1"
PACKAGECONFIG[tidal] = "-Dtidal=enabled,-Dtidal=disabled,curl yajl"
PACKAGECONFIG[udisks] = "-Dudisks=enabled,-Dudisks=disabled,dbus,udisks2"
PACKAGECONFIG[upnp] = "-Dupnp=enabled,-Dupnp=disabled,libupnp"
PACKAGECONFIG[vorbis] = "-Dvorbis=enabled,-Dvorbis=disabled,libvorbis libogg"
PACKAGECONFIG[wavpack] = "-Dwavpack=enabled,-Dwavpack=disabled,wavpack"
PACKAGECONFIG[zlib] = "-Dzlib=enabled,-Dzlib=disabled,zlib"

do_install_append() {
    install -o mpd -d \
        ${D}/${localstatedir}/lib/mpd \
        ${D}/${localstatedir}/lib/mpd/playlists
    install -m775 -o mpd -g mpd -d \
        ${D}/${localstatedir}/lib/mpd/music

    install -d ${D}/${sysconfdir}
    install -m 644 ${WORKDIR}/mpd.conf.in ${D}/${sysconfdir}/mpd.conf
    sed -i \
        -e 's|%music_directory%|${localstatedir}/lib/mpd/music|' \
        -e 's|%playlist_directory%|${localstatedir}/lib/mpd/playlists|' \
        -e 's|%db_file%|${localstatedir}/lib/mpd/mpd.db|' \
        -e 's|%log_file%|${localstatedir}/log/mpd.log|' \
        -e 's|%state_file%|${localstatedir}/lib/mpd/state|' \
        ${D}/${sysconfdir}/mpd.conf

    # we don't need the icon
    rm -rf ${D}${datadir}/icons

    # we don't need the systemd user unit
    rm -rf ${D}${systemd_unitdir}/user
}

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE_${PN} = "mpd.socket"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = " \
    --system --no-create-home \
    --home ${localstatedir}/lib/mpd \
    --groups audio \
    --user-group mpd"

