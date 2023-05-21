# Base this image on core-image-base
include recipes-core/images/core-image-base.bb

SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += "ssh-server-dropbear splash"

PKGS_QT5 = " \
    qtbase-tools \
    qtbase \
    qtdeclarative \
    qtimageformats \
    qtmultimedia \
    qtquickcontrols2 \
    qtquickcontrols \
    qtbase-plugins \
    cinematicexperience \
    liberation-fonts \
"

PACKAGECONFIG_FONTS_append_pn-qtbase = " fontconfig"

PKGS_PULSEAUDIO = " \
    ofono \
    pulseaudio \
    libpulsecore \
    pulseaudio-server \
    pulseaudio-module-dbus-protocol \
    pulseaudio-module-bluetooth-discover \
    pulseaudio-module-bluetooth-policy \
    pulseaudio-module-bluez5-device \
    pulseaudio-module-bluez5-discover \
    pulseaudio-module-loopback\
    pulseaudio-misc \
    pulseaudio-module-alsa-card \
    pulseaudio-module-alsa-source \
    pulseaudio-module-alsa-sink \
    pulseaudio-module-cli \
    alsa-utils \
    alsa-plugins \
    packagegroup-tools-bluetooth \
"

PKGS_BLUEALSA = " \
    ofono \
    bluez-alsa \
    alsa-utils \
    alsa-plugins \
    packagegroup-tools-bluetooth \
"

PKGS_MENDER = " \
    mender \
    mender-artifact \
    mender-artifact-info \
    mender-connect \
    mender-configure \
    mender-test-dependencies \
"

## Not available:
# mender-client
# mender-client-modify
# mender-image
# mender-systemd

# Include modules in rootfs
IMAGE_INSTALL += "\
    kernel-modules \
    linux-firmware-rpidistro-bcm43430 \
    systemd \
    make \
    cmake \
    usbutils \
    openssh-sftp-server \
    rsync \
    hostapd \
    wpa-supplicant \
    ${PKGS_BLUEALSA} \
    ${PKGS_QT5} \
"

#linux-firmware-rpidistro-bcm43430

do_image_prepend() {
    bb.warn("The image 'rpi-dev-image' is a development image used for testing purposes!")
}
