#!/bin/bash
RELEASE="poky"
BUILDDIR=$1

if [ ! -d "$BUILDDIR" ]; then
  exit 1
fi

echo Build dir: $BUILDDIR
source ${RELEASE}/oe-init-build-env $BUILDDIR
echo $(pwd)
echo Starting builds...
bitbake console-image-cap
bitbake audio-image-cap
bitbake console-image
bitbake qt5-basic-image
bitbake qt5-image
bitbake py3qt-image
