
This is a personal project where I will be experimenting with Yocto for Raspberry Pi.

- **Yocto Version:** 2.7 (warrior)
- **Distribution:** rpi-dev (based on poky)
- **Host System:** Ubuntu 20.04
- **Target System:** Raspberry Pi 3B+/4B

# Feateres planned for Integration
- EGLFS for Qt Framework
- 'base64' command for Qt
- Mender Framework
- Pulseaudio
- Custom Startup logo on boot
- Custom App autostart on boot
- Frame buffer control (fbset, fbi)

# Feateres Developed
- Qt Framework

# Helpful Yocto Commands:

## Image/Package Configuration Commands

-  `bitbake -g <image-name> && cat pn-buildlist | grep -ve "native" | sort | uniq` (Get packages for image)
-  `bitbake -e <recipie-name> | grep ^PV` (Check which recipe version will be used)
-  `bitbake -e <recipe-name> | grep ^<VARIABLE-name>` (Get Variable value in recipes)
-  `bitbake-layers show-recipes "*-image-*"` (Show available image for building)
-  `bitbake-layers show-recipes` (Show all available recipes)
-  `bitbake-layers show-layers` (Show all layers)
  
## Devtool for source modification (used in make run_shell)

-  `devtool modify <recipe-name>` (Extract recipe source to workspace for modification)
-  `devtool update-recipe <recipe-name>` (Create patches from modification to source and apply to recipe)
-  `latest-version <recipe-name>` (Get current and latest version of a recipe)
-  `devtool upgrade <recipe-name>` (Upgrade recipe to recent version)
-  `bitbake <recipe-name>`
-  `devtool reset <recipe-name>` (Clean workspace)

## Yocto Independent Package Install/Clean Compile

-  `bitbake <package-name>` (Create package from recipe)
-  `bitbake -c fetch -f <package-name>` (Fetch package source code only)
-  `bitbake -c clean <package-name>` (Clean package from build directory)
-  `bitbake -c cleansstate <package-name>` (Clean compile package again without fetching source)

