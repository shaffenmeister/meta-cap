SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = ""
LICENSE = "MIT"

require images/basic-dev-image-cap.bb

DEV_EXTRAS = " \
"

CAN_TOOLS = " \
    canutils \
"

RPI_STUFF = " \
    rpio \
    rpi-gpio \
    userland \
"

IMAGE_INSTALL += " \
    ${DEV_EXTRAS} \
    ${CAN_TOOLS} \
    ${RPI_STUFF} \
"

export IMAGE_BASENAME = "console-image-cap"
