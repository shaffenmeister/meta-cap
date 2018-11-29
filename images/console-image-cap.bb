SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = ""
LICENSE = "MIT"

IMAGE_FEATURES += "package-management splash"
IMAGE_LINGUAS = "en-us"

inherit core-image

DEPENDS += "bcm2835-bootfiles"

CORE_OS = " \
    kernel-modules \
    openssh openssh-keygen openssh-sftp-server \
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

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    g++ \
    g++-symlinks \
    gcc \
    gcc-symlinks \
    gdb \
    gdbserver \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    pkgconfig \
    python3-modules \
    python3-pydoc \
"

DEV_EXTRAS = " \
    ntp \
    ntp-tickadj \
    serialecho  \
    spiloop \
"

EXTRA_TOOLS_INSTALL = " \
    bzip2 \
    devmem2 \
    dosfstools \
    ethtool \
    fbset \
    findutils \
    i2c-tools \
    iperf3 \
    iptables \
    iproute2 \
    less \
    memtester \
    nano \
    netcat \
    procps \
    rsync \
    sysfsutils \
    tcpdump \
    unzip \
    util-linux \
    wget \
    zip \
"

CAN_TOOLS = " \
    canutils \
"

RPI_STUFF = " \
    omxplayer \
    raspi2fb \
    rpio \
    rpi-gpio \
    userland \
"

ALSA += " \
    libavcodec \
    libavdevice \
    libavfilter \
    libavformat \
    libavutil \
    libpostproc \
    libswresample \
    libswscale \
    libasound \
    alsa-conf \
    alsa-utils \
    alsa-utils-scripts \
 "

AUDIO = " \
    squeezelite \
    mpc \
    mpd \
 "

IMAGE_INSTALL += " \
    ${CAN_TOOLS} \
    ${CORE_OS} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${ALSA} \
    ${AUDIO} \
    ${RPI_STUFF} \
    ${WIFI_SUPPORT} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/Europe/Paris ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "console-image-cap"
