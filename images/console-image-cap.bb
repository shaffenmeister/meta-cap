SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = ""
LICENSE = "MIT"

require images/basic-dev-image.bb

DEPENDS += "rpi-bootfiles"

WIFI = " \
    crda \
    iw \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455 \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    wpa-supplicant \
"

DEV_EXTRAS = " \
    serialecho  \
    spiloop \
"

CAN_TOOLS = " \
    canutils \
"

RPI_STUFF = " \
    raspi2fb \
    rpio \
    rpi-gpio \
    userland \
"

IMAGE_INSTALL += " \
    ${WIFI} \
    ${DEV_EXTRAS} \
    ${CAN_TOOLS} \
    ${RPI_STUFF} \
"

export IMAGE_BASENAME = "console-image-cap"
