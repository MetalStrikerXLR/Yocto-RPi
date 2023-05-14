# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
	"

SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += "ssh-server-dropbear splash"

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
    bluealsa \
    alsa-utils \
    alsa-plugins \
    packagegroup-tools-bluetooth \
"

PKGS_BLUEALSAORG = " \
    ofono \
    bluez-alsa \
    alsa-utils-aplay \
    alsa-utils-amixer \
    alsa-utils-alsamixer \
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


IMAGE_INSTALL += "\
 systemd \
 ${PKGS_BLUEALSAORG} \
"

do_image_prepend() {
    bb.warn("The image 'rpi-dev-image' is a development image used for testing purposes!")
}
