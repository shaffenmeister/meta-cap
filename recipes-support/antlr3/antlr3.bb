LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "file://antlr-3.5.2-complete.jar;unpack=0 \
           file://antlr3 \
          "
SRC_URI[md5sum] = "acfa69f928a0f1653555bda73091efca"
SRC_URI[sha256sum] = "26ca659f47d77384f518cf2b6463892fcd4f0b0d4d8c0de2addf697e63e7326b"

S = "${WORKDIR}"

DEPENDS = "jamvm-native"

do_configure () {
	sed -i -e"s|@JAR_FILE@|${STAGING_DATADIR_NATIVE}/antlr3/antlr3.jar|" ${WORKDIR}/antlr3
}

do_compile () {
	# Specify compilation commands here
	:
}

do_install() {
	install -d ${D}${datadir}/antlr3
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/antlr-3.5.2-complete.jar ${D}${datadir}/antlr3/antlr3.jar
	install -m 0755 ${WORKDIR}/antlr3 ${D}${bindir}
}

BBCLASSEXTEND = "native"