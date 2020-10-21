#!/usr/bin/env bash
RELEASE="poky"

echo "Upgrading ${RELEASE} ..."

folders=("meta-cap" "${RELEASE}" "${RELEASE}/meta-openembedded" "${RELEASE}/meta-qt5" "${RELEASE}/meta-raspberrypi" "${RELEASE}/meta-readonly-rootfs-overlay" "${RELEASE}/meta-security" "meta-rpi" "${RELEASE}/meta-jumpnow" "${RELEASE}/meta-realtime")

curfolder=$(pwd)

for i in "${folders[@]}"
do
   cd $curfolder/$i
   echo $(pwd)
   git pull --recurse-submodules
done

cd $curfolder

