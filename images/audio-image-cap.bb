SUMMARY = "minimal image running squeezelite"
HOMEPAGE = ""
LICENSE = "MIT"

IMAGE_LINGUAS = "en-us"

inherit core-image

DEPENDS += "bcm2835-bootfiles"

CORE_OS = " \
    ntp \
    ntp-tickadj \
    openssh openssh-keygen openssh-sftp-server \
    procps \
    term-prompt \
    tzdata \
    tzdata-europe \
    tzdata-posix \
"

WIFI_SUPPORT = " \
    crda \
    iw \
    linux-firmware-bcm43430 \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    wpa-supplicant \
"

ALSA += " \
    libasound \
    libavcodec \
    libavdevice \
    libavfilter \
    libavformat \
    libavutil \
    libpostproc \
    libswresample \
    libswscale \
    alsa-conf \
    alsa-utils \
    alsa-utils-scripts \
"

RPI_STUFF = " \
    omxplayer \
"

AUDIO = " \
    squeezelite \
"

MUSICPD = " \
    mpd \
    mpc \
"

IMAGE_INSTALL += " \
    ${ALSA} \
    ${AUDIO} \
    ${MUSICPD} \
    ${CORE_OS} \
    ${RPI_STUFF} \
    ${WIFI_SUPPORT} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/Europe/Berlin ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "audio-image-cap"
