#!/usr/bin/env bash
IMAGES=("console-image" "console-image-cap" "audio-image-cap") # "qt5-basic-image" "qt5-image")

curdir=$(pwd)
pokydir=""
builddirs=()

##################################################################################################
# Parse options
while getopts "d:p:i:" OPTION
do
    case $OPTION in
    p)
        pokydir=$OPTARG
        ;;
    d)
        builddirs+=($OPTARG)
        ;;
    i)
        IMAGES+=($OPTARG)
        ;;
    esac
done

echo "Yocto folder: ${pokydir} ($(basename ${pokydir}))"
echo "Build dirs: ${builddirs[@]}"
echo "Build images: ${IMAGES[@]}"

for cdir in ${builddirs[@]}
do
  echo "Processing ${cdir}"

  if [ -d "$cdir" ]; then
    source ${pokydir}/oe-init-build-env $cdir
    echo "$(pwd)"
    echo "Starting build..."
    bitbake "${IMAGES[@]}"
  fi
done

cd "${curdir}"

