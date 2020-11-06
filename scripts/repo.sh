#!/usr/bin/env bash
RELEASE="poky"
BRANCH="dunfell"

curdir=$(pwd)
op="$1"
opts="$2"
pokydir="$3"
boarddir="$4"

RELEASEREPO=("git://git.yoctoproject.org/poky.git")
SUBREPOS=("git://git.openembedded.org/meta-openembedded" "https://github.com/meta-qt5/meta-qt5" "git://git.yoctoproject.org/meta-security" "git://git.yoctoproject.org/meta-raspberrypi" "git://git.yoctoproject.org/meta-realtime" "https://github.com/jumpnow/meta-jumpnow")
BOARDREPOS=("git://github.com/jumpnow/meta-rpi" "git://github.com/shaffenmeister/meta-cap")

function getfolderfromgituri {
  local gituri="$1"
  folder=$(sed -e "s/\.git$//" <<< $(basename "${gituri}"))
  echo "${folder}"
}

function doclone {
  local branch="$1"
  local opts="$2"
  shift
  shift
  local repos=("$@")

  for repo in ${repos[@]}
  do
    git clone -b ${branch} ${opts} ${repo}
  done
}

function doupdate {
  local opts="$1"
  shift
  local folders=("$@")

  for folder in ${folders[@]}
  do
    cd "${folder}"
    echo "Updating: $(pwd)"
    git pull ${opts}
  done
}

function getrepofolders {
  local basefolder="$1"
  shift
  local repolist=("$@")
  local result=()

  for repo in ${repolist[@]}
  do
    folder=$(sed -e "s/\.git$//" <<< $(basename "${repo}"))
    repofolder="${basefolder}/${folder}"
    result+=(${repofolder})
  done

  echo "${result[@]}"
}

echo "Yocto folder: ${pokydir} ($(basename ${pokydir}))"
echo "Board folder: ${boarddir}"

if [ "${op}" = "clone" ]; then
  if [ ! -d "${pokydir}" ]; then
    mkdir -p "${pokydir}"
  fi

  if [ ! -d "${boarddir}" ]; then
    mkdir -p "${boarddir}"
  fi

  cd "${pokydir}"
  doclone "${BRANCH}" "${opts}" "${RELEASEREPO}"
  cd "${RELEASE}"
  doclone "${BRANCH}" "${opts}" "${SUBREPOS[@]}"
  cd "${boarddir}"
  doclone "${BRANCH}" "${opts}" "${BOARDREPOS[@]}"
  cd "${curdir}"
elif [ "${op}" = "pull" ]; then
  doupdate "${opts}" "${pokydir}"
  folders=$(getrepofolders "${pokydir}" "${SUBREPOS[@]}")
  doupdate "${opts}" "${folders}"
  folders=$(getrepofolders "${boarddir}" "${BOARDREPOS[@]}")
  doupdate "${opts}" "${folders}"
fi

