DESCRIPTION="dsp dsp is an audio processing program with an interactive mode."
HOMEPAGE = "https://github.com/bmc0/dsp/"
SECTION = "audio"

DEPENDS = "alsa-lib ladspa-sdk libsndfile1 libmad libtool"

PR = "r1"
PV = "1.8"

LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e0e9b091d126e6e315e2d3806971e8b3"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "f3ac94b546361260349edeea5f1ee0ce7fac322a"
SRC_URI = " \
		git://github.com/bmc0/dsp.git;protocol=git \
	  "

TARGET_LDFLAGS += " -lfftw3f "

# update-rc.d
inherit pkgconfig

do_configure() {
    oe_runmake clean
    ./configure --prefix="${D}/usr"
}

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake install
}

FILES:${PN} += "${mandir}/* ${libdir}/*"
