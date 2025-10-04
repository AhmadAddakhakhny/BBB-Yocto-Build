SUMMART = "Recipe for HMI application on a Beaglebone Black"
LICENSE = "CLOSED"
SRC_URI = "git://github.com/AhmadAddakhakhny/BBB-Application.git;protocol=https;branch=main"
# SRCREV = "Specify a SHA_1" or get latest
SRCREV = "${AUTOREV}"

# Compile time dependancies
DEPENDS:append = " cmake qtbase qtdeclarative qtdeclarative-native "

# Run time dependancies
RDEPENDS:${PN}:append = " qtbase qtdeclarative "

inherit qt6-cmake pkgconfig

EXTRA_OECMAKE:append = " --debug-find-pkg=Qt6Quick "

S = "${WORKDIR}/git"

# do_compile() {
#    export OECORE_TARGET_SYSROOT=${STAGING_DIR_TARGET}

# }

# do_install() {
#     install -d ${D}${bindir}
#     install -m 0755 ${S}/hmi ${D}${binddir}/hmi
# }