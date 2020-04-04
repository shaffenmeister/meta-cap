#!/bin/bash
BRANCH="warrior"
NEWBRANCH="zeus"
RELEASE="poky"

OPERATION="checkout"

echo "Operation ${OPERATION} on ${RELEASE} ..."

for pkt in ${RELEASE} ${RELEASE}/meta-qt5 ${RELEASE}/meta-security ${RELEASE}/meta-raspberrypi ${RELEASE}/meta-openembedded
do
  cd "/home/cappel/rpi/${pkt}"
  pwd
  git ${OPERATION} ${NEWBRANCH}
done

#git ${OPERATION} -b ${BRANCH} git://github.com/jumpnow/meta-rpi
#git ${OPERATION} -b ${BRANCH} git://github.com/shaffenmeister/meta-cap
