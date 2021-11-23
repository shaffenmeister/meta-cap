#!/usr/bin/env bash
RELEASE="poky"
branch="dunfell"

curdir=$(pwd)
action=""
opts=""
pokydir=""
boarddir=""

RELEASEREPO=("git://git.yoctoproject.org/poky.git")
SUBREPOS=("git://git.openembedded.org/meta-openembedded" "https://github.com/meta-qt5/meta-qt5" "git://git.yoctoproject.org/meta-security" "git://git.yoctoproject.org/meta-raspberrypi")
BOARDREPOS=("git://github.com/shaffenmeister/meta-cap" "https://github.com/jumpnow/meta-rpi")

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

##################################################################################################
# Parse options
while getopts "a:b:o:p:d:" OPTION
do
    case $OPTION in
    a)
        action=${OPTARG}
        ;;
    b)
        branch=$OPTARG
        ;;
    o)
        opts=$OPTARG
        ;;
    p)
        pokydir=$OPTARG
        ;;
    d)
        boarddir=$OPTARG
        ;;
    esac
done

echo "Yocto folder: ${pokydir} ($(basename ${pokydir}))"
echo "Board folder: ${boarddir}"
echo "Branch: ${branch}"
echo "Action: ${action} (options: ${opts})"


if [ "${action}" = "clone" ]; then
  if [ ! -d "${boarddir}" ]; then
    mkdir -p "${boarddir}"
  fi

  git clone -b ${branch} ${opts} "${RELEASEREPO}" "${pokydir}"
  cd "${pokydir}"
  doclone "${branch}" "${opts}" "${SUBREPOS[@]}"
  cd "${boarddir}"
  doclone "${branch}" "${opts}" "${BOARDREPOS[@]}"
  cd "${curdir}"
elif [ "${action}" = "pull" ]; then
  doupdate "${opts}" "${pokydir}"
  folders=$(getrepofolders "${pokydir}" "${SUBREPOS[@]}")
  doupdate "${opts}" "${folders}"
  folders=$(getrepofolders "${boarddir}" "${BOARDREPOS[@]}")
  doupdate "${opts}" "${folders}"
fi

