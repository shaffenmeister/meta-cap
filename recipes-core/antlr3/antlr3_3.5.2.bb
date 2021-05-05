SUMMARY = "Framework for constructing recognizers, interpreters, compilers, and translators"
HOMEPAGE = "http://www.antlr3.org"
# see http://www.antlr2.org/license.html
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://tool/LICENSE.txt;md5=3c9a0198d8bd12abeca838bae15ffdc4"

SRC_URI = "https://github.com/antlr/antlr3/archive/refs/tags/${PV}.tar.gz"
SRC_URI_append_class-native = " file://runantlr"

inherit java-library

do_configure_class-native() {
    sed -i -e"s|@JAR_FILE@|${STAGING_DATADIR_JAVA_NATIVE}/antlr.jar|" ${WORKDIR}/runantlr
}

do_compile() {
    mkdir -p build

    javac -sourcepath . -d build `find antlr -name "*.java"`

    fastjar cf ${JARFILENAME} -C build .
}

do_install_class-native() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/runantlr ${D}${bindir}/
}

SRC_URI[md5sum] = "4306429698d04d761887592ce9889ce9"
SRC_URI[sha256sum] = "a66d12fd5ca052fdd2b0a64b70d0c58db40e6dec72c3f4497934203090d92808"

BBCLASSEXTEND = "native"
