SUMMARY = "Bluetooth Audio ALSA Backend"
HOMEPAGE = "https://github.com/Arkq/bluez-alsa"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=72d868d66bdd5bf51fe67734431de057"

SRC_URI = " \
    git://github.com/Arkq/bluez-alsa.git;protocol=https;branch=master"
#    file://0001-Fix-linkage-mark-external-variable-as-extern.patch \
#"

SRCREV = "b09f373ea7dbc6e3ecbcb74d7299f5230cdc6e59"

SRC_URI += "file://bluealsa.service"

S  = "${WORKDIR}/git"

DEPENDS += "alsa-lib bluez5 systemd glib-2.0 sbc ofono"

PACKAGECONFIG[aac]  = "--enable-aac, --disable-aac, "
PACKAGECONFIG[aptx] = "--enable-aptx,--disable-aptx,"
PACKAGECONFIG[hcitop]   = "--enable-hcitop, --disable-hcitop,  libbsd ncurses"
PACKAGECONFIG[debug] = "--enable-debug, --disable-debug, "
PACKAGECONFIG[ofono] = "--enable-ofono, --disable-ofono, "

inherit autotools pkgconfig systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "bluealsa.service"

PACKAGECONFIG += "hcitop"
PACKAGECONFIG += "debug"
PACKAGECONFIG += "ofono"

do_install_append () {
    install -d ${D}${base_libdir}/systemd/system
    install -m 0644 ${WORKDIR}/bluealsa.service ${D}${base_libdir}/systemd/system
}

FILES_${PN} += "\
    ${datadir}/alsa/alsa.conf.d/20-bluealsa.conf\
    ${libdir}/alsa-lib/libasound_module_ctl_bluealsa.so\
    ${libdir}/alsa-lib/libasound_module_pcm_bluealsa.so\
"

FILES_${PN}-staticdev += "\
    ${libdir}/alsa-lib/libasound_module_ctl_bluealsa.a\
    ${libdir}/alsa-lib/libasound_module_pcm_bluealsa.a\
"
