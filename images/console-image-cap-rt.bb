inherit image

IMAGE_FEATURES += "package-management splash"

DEPENDS += "bcm2835-bootfiles"
DEPENDS += "(linux-raspberrypi-rt|linux-raspberrypi-rt-dev)"

python () {                                                                     
    if d.getVar("PREFERRED_PROVIDER_virtual/kernel") != "linux-raspberrypi-rt" and d.getVar("PREFERRED_PROVIDER_virtual/kernel") != "linux-raspberrypi-rt-dev":
        raise bb.parse.SkipPackage("Set PREFERRED_PROVIDER_virtual/kernel to linux-raspberrypi-rt to enable it")
}

CORE_OS = " \
    kernel-modules \
    openssh openssh-keygen openssh-sftp-server \
    term-prompt \
    tzdata \
    tzdata-europe \
    tzdata-posix \
    ntp \
    ntp-tickadj \
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

WIREGUARD_SUPPORT = " \
    wireguard-init \
    wireguard-module \
    wireguard-tools \
"

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    elfutils elfutils-binutils \
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
    ltrace \
    make \
    pkgconfig \
    python3-modules \
    strace \
"

DEV_EXTRAS = " \
    serialecho  \
    spiloop \
"

CAN_TOOLS = " \
    canutils \
"

IMAGE_INSTALL = " \
    ${CORE_OS} \
    ${WIFI_SUPPORT} \
    ${WIREGUARD_SUPPORT} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRAS} \
    ${CAN_TOOLS} \
    rt-app \
    schedtool-dl \
    "
	
export IMAGE_BASENAME = "console-image-cap-rt"
