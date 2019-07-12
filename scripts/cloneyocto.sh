#!/bin/bash
BRANCH="warrior"
RELEASE="poky"
OPERATION="clone -b"
#OPERATION="checkout"

echo "Operation ${OPERATION} on ${RELEASE} ..."

git ${OPERATION} ${BRANCH} git://git.yoctoproject.org/poky.git ${RELEASE}
cd ${RELEASE}
git ${OPERATION} ${BRANCH} git://git.openembedded.org/meta-openembedded
git ${OPERATION} ${BRANCH} https://github.com/meta-qt5/meta-qt5
git ${OPERATION} ${BRANCH} git://git.yoctoproject.org/meta-security
git ${OPERATION} ${BRANCH} git://git.yoctoproject.org/meta-raspberrypi
git ${OPERATION} ${BRANCH} git://git.yoctoproject.org/meta-realtime
git ${OPERATION} master https://github.com/cmhe/meta-readonly-rootfs-overlay.git

cd ..
#git ${OPERATION} -b ${BRANCH} git://github.com/jumpnow/meta-rpi
#git ${OPERATION} -b ${BRANCH} git://github.com/shaffenmeister/meta-cap
