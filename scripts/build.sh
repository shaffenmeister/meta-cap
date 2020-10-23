#!/bin/bash
IMAGES=("console-image" "console-image-cap" "audio-image-cap" "qt5-basic-image" "qt5-image")

curdir=$(pwd)
pokydir=$1
shift
builddirs="$*"

echo "Poky dir: ${pokydir}"

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



