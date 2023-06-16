SUMMARY = "A console image that runs linux with realtime patches"
HOMEPAGE = ""

require images/basic-dev-image-cap.bb

DEPENDS += "bcm2835-bootfiles"
DEPENDS += "(linux-raspberrypi-rt|linux-raspberrypi-rt-dev)"

python () {                                                                     
    if d.getVar("PREFERRED_PROVIDER_virtual/kernel") != "linux-raspberrypi-rt" and d.getVar("PREFERRED_PROVIDER_virtual/kernel") != "linux-raspberrypi-rt-dev":
        raise bb.parse.SkipPackage("Set PREFERRED_PROVIDER_virtual/kernel to linux-raspberrypi-rt to enable it")
}

WIFI = " \
    crda \
    iw \
    linux-firmware-bcm43430 \
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

IMAGE_INSTALL += " \
    ${WIFI} \
    ${DEV_EXTRAS} \
    ${CAN_TOOLS} \
    rt-app \
    schedtool-dl \
    "
	
export IMAGE_BASENAME = "console-image-cap-rt"
