#!/usr/bin/env bash
RELEASE="poky"
BRANCH="dunfell"
OPERATION="clone"
IMAGES=("console-image" "console-image-cap" "audio-image-cap" "qt5-basic-image" "qt5-image")

curdir=$(pwd)
pokydir="$1"
boarddir="$2"

RELEASEREPO=("git://git.yoctoproject.org/poky.git")
SUBREPOS=("git://git.openembedded.org/meta-openembedded" "https://github.com/meta-qt5/meta-qt5" "git://git.yoctoproject.org/meta-security" "git://git.yoctoproject.org/meta-raspberrypi" "git://git.yoctoproject.org/meta-realtime" "https://github.com/jumpnow/meta-jumpnow")
BOARDREPOS=("git://github.com/jumpnow/meta-rpi") # "git://github.com/shaffenmeister/meta-cap")

function dooperation {
  local op="$1"
  local branch="$2"
  shift
  shift
  local repos=("$@")

  for repo in ${repos[@]}
  do
    git ${op} -b ${branch} ${repo}
  done
}

echo "Yocto folder: ${pokydir}"
echo "Board folder: ${boarddir}"

if [ ! -d "${pokydir}" ]; then
  mkdir -p "${pokydir}"
fi

if [ ! -d "${boarddir}" ]; then
  mkdir -p "${boarddir}"
fi

cd "${pokydir}"
dooperation ${OPERATION} ${BRANCH} ${RELEASEREPO}
cd "${RELEASE}"
dooperation ${OPERATION} ${BRANCH} "${SUBREPOS[@]}"
cd "${boarddir}"
dooperation ${OPERATION} ${BRANCH} "${BOARDREPOS[@]}"
cd "${curdir}"
