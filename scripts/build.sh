#!/bin/bash
RELEASE="poky"
IMAGES=("console-image" "console-image-cap" "audio-image-cap" "qt5-basic-image" "qt5-image")

curdir=$(pwd)
startdir=$1
shift
args="$*"

echo "Start dir: ${startdir}"

for cdir in ${args[@]}
do
  echo "Processing ${cdir}"
  cd "${startdir}"

  if [ -d "$cdir" ]; then
    source ${RELEASE}/oe-init-build-env $cdir
    echo "$(pwd)"
    echo "Starting build..."
    bitbake "${IMAGES[@]}"
  fi
done

cd "${curdir}"



