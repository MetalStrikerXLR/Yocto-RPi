
SUMMARY = "Bluetooth Audio ALSA Backend"
HOMEPAGE = "https://github.com/Arkq/bluez-alsa"
SECTION = "devel"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8449a4f133a93f6254b496d4fb476e83"

DEPENDS = "alsa-lib bluez5 dbus glib-2.0 systemd sbc ofono"

SRCREV = "master"
#SRCREV = "1219b1deb67147db4930217a5ff15647cfa1bf56"
SRC_URI = "git://github.com/Arkq/bluez-alsa.git;branch=master;protocol=https \
           file://bluez-alsa.service"

S = "${WORKDIR}/git"

PACKAGECONFIG[aac]  = "--enable-aac, --disable-aac, "
PACKAGECONFIG[aptx] = "--enable-aptx,--disable-aptx,"
PACKAGECONFIG[hcitop]   = "--enable-hcitop, --disable-hcitop, libbsd ncurses"
PACKAGECONFIG[debug] = "--enable-debug, --disable-debug, "
PACKAGECONFIG[ofono] = "--enable-ofono, --disable-ofono, "
PACKAGECONFIG[cli] = "--enable-cli, --disable-cli"
PACKAGECONFIG[test] = "--enable-test, --disable-test,l ibcheck libsndfile1"
PACKAGECONFIG[msbc] = "--enable-msbc, --disable-msbc, spandsp"

PACKAGECONFIG += "hcitop"
PACKAGECONFIG += "debug"
PACKAGECONFIG += "ofono"
PACKAGECONFIG += "cli"
PACKAGECONFIG += "msbc"

inherit systemd pkgconfig autotools

do_install_append () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/bluez-alsa.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += "${libdir}/alsa-lib/lib*.so ${datadir}/alsa"
FILES_${PN}-dev += "${libdir}/alsa-lib/*.la"
FILES_${PN}-staticdev += "${libdir}/alsa-lib/lib*.a"
FILES_${PN}-dbg += "${libdir}/alsa-lib/.debug/*.so"

SYSTEMD_SERVICE_${PN} = "bluez-alsa.service"
