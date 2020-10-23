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
  local dir="$1"
  local opts="$2"
  shift
  shift
  local repos=("$@")

  for repo in ${repos[@]}
  do
    folder=$(sed -e "s/\.git$//" <<< $(basename "${repo}"))
    repodir="${dir}/${folder}"
    cd "${repodir}"
    echo "Folder: $(pwd)"
    git pull ${opts} 
  done
}

echo "Yocto folder: ${pokydir}"
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
  doupdate "${pokydir}/.." "${opts}" "${RELEASEREPO}"
  doupdate "${pokydir}" "${opts}" "${SUBREPOS[@]}"
  doupdate "${boarddir}" "${opts}" "${BOARDREPOS[@]}"
fi

