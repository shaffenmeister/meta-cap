SUMMARY = "A minimal console image that runs squeezelite"
HOMEPAGE = ""

require images/basic-dev-image.bb

DEPENDS += "bcm2835-bootfiles"

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
    alsa-state \
    alsa-utils \
    alsa-utils-scripts \
"

AUDIO = " \
    squeezelite \
    ladspa-sdk \
    bmc0-dsp \
    omxplayer \
    mpd \
"

IMAGE_INSTALL += " \
    ${ALSA} \
    ${AUDIO} \
"

export IMAGE_BASENAME = "audio-image-cap"
