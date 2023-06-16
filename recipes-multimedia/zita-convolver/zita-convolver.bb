DESCRIPTION = "Convolution library by Fons Adriaensen."
#SRC_URI = "https://sources.voidlinux.org/zita-convolver-3.1.0/zita-convolver-3.1.0.tar.bz2"
SRC_URI= "https://kokkinizita.linuxaudio.org/linuxaudio/downloads/zita-convolver-4.0.3.tar.bz2"

#SRCREV = "c724d33aa66fa8c45310664e594945bd0c84137c"
LICENSE = "GPL-3.0-only" 

LIC_FILES_CHKSUM = "file://../COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = " fftwf libsndfile1 "
RPROVIDES:${PN} = "libzita-convolver4"

SRC_URI[md5sum] = "a357f6ff8588eb53af5335968cfacf3a"
SRC_URI[sha256sum] = "9aa11484fb30b4e6ef00c8a3281eebcfad9221e3937b1beb5fe21b748d89325f"

S = "${WORKDIR}/zita-convolver-4.0.3/source"

FILES:${PN} = " ${libdir} "

do_compile() {
 ${CXX} ${CXXFLAGS} -I. -D_REENTRANT -D_POSIX_PTHREAD_SEMANTICS -DENABLE_VECTOR_MODE -ffast-math -fPIC -c zita-convolver.cc
 ${CXX} ${LDFLAGS} -lfftw3f -lpthread -shared -Wl,-soname,libzita-convolver.so.4 -o libzita-convolver.so.4.0.3 zita-convolver.o
}

do_install() {
 install -d ${D}${libdir}
 install -d ${D}${includedir} 
 install -m 0755 libzita-convolver.so.4.0.3 ${D}${libdir}
 install -m 0755 zita-convolver.h ${D}${includedir}
 ln -s libzita-convolver.so.4.0.3 ${D}/${libdir}/libzita-convolver.so.4.0
 ln -s libzita-convolver.so.4.0 ${D}/${libdir}/libzita-convolver.so.4
 ln -s libzita-convolver.so.4 ${D}/${libdir}/libzita-convolver.so
}

