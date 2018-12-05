#!/bin/bash
export MACHINE=raspberrypi
export OETMP=${HOME}/dev/rpi/yocto/zero/tmp
export DSTDIR=${HOME}/dev/rpi/yocto/upload
export CARDSIZE=4

TMPDIR=$(pwd)

cd ${HOME}/dev/rpi/yocto/meta-cap/scripts

if [ -z "${1}" ]; then
   IMG="console-image-cap"
else
   IMG="${1}"
fi

export IMG

. create_sdcard_images.sh ${CARDSIZE}

cd ${TMPDIR}
