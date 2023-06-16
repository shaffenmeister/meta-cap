DESCRIPTION="dsp dsp is an audio processing program with an interactive mode."
HOMEPAGE = "https://github.com/bmc0/dsp/"
SECTION = "audio"

DEPENDS = "alsa-lib "
RDEPENDS:${PN} = ""

inherit pkgconfig

PR = "r1"
PV = "1.9"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e0e9b091d126e6e315e2d3806971e8b3"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "37aafe2b76bac20e49a729d3bf66800d501fa658"
SRC_URI = "git://github.com/bmc0/dsp.git;protocol=https;branch=master"

PACKAGES += "dsp "
FILES:dsp = "${bindir}/dsp"

do_install(){
        install -m 0755 ${S}/dsp ${D}/usr/bin/dsp
}

