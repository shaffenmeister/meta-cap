SUMMARY = "A minimal console image that runs squeezelite"
HOMEPAGE = ""

# include recipes-core/images/core-image-base.bb

inherit image

COMPATIBLE_MACHINE = "^rpi$"

DEPENDS += "rpi-bootfiles"


CORE_OS = " \
    ifupdown \
    iptables \
    kernel-modules \
    ntp \
    ntp-tickadj \
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    procps \
    tzdata \
    tzdata-europe \
    tzdata-posix \
"

KERNEL_EXTRA = " \
    kernel-modules \
"

ALSA += " \
    libasound \
    libavcodec \
    libavdevice \
    libavfilter \
    libavformat \
    libavutil \
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
    mpd \
    mpc \
"

IMAGE_INSTALL:append = " \
    ${ALSA} \
    ${AUDIO} \
    ${CORE_OS} \
"


set_local_timezone() {
    ln -sf /usr/share/zoneinfo/Europe/Berlin ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

disable_rng_daemon() {
    rm -f ${IMAGE_ROOTFS}/etc/rcS.d/S*rng-tools
    rm -f ${IMAGE_ROOTFS}/etc/rc5.d/S*rng-tools
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
    disable_rng_daemon ; \
"

export IMAGE_BASENAME = "audio-image-cap"
