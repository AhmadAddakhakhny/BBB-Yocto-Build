SUMMARY = "Recipe for HMI application on a Beaglebone Black"
LICENSE = "CLOSED"
SRC_URI = "file://hmi.sh \
           file://hmi.service "

# Compile time dependancies
DEPENDS += " "

# Run time dependancies
RDEPENDS:${PN} += " bash   "

inherit systemd

S = "${WORKDIR}"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "hmi.service"

do_install() {
    # install bash scrip under /usr/bin
    install -d ${D}${bindir}
    install -m 0755 ${S}/hmi.sh ${D}${bindir}/hmi.sh

    # install service unit file under /lib/systemd/system
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/hmi.service  ${D}${systemd_system_unitdir}/hmi.service
}