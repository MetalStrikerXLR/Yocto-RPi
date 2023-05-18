This is a personel project where I will be learning and experimenting with Yocto from scratch.

Yocto Version: 2.7 (warrior)
Distribution: poky
Host System: Ubuntu 20.04
Target System: Raspberry Pi 3B+/4B

# Getting started

- Clone the repository
- In repository root, source poky build environemnt:

    source sources/poky/oe-init-build-env   

- Add required layers:

    bitbake-layers add-layer ../sources/meta-raspberrypi    
    bitbake-layers add-layer ../sources/meta-openembedded/meta-oe   
    bitbake-layers add-layer ../sources/meta-openembedded/meta-python   
    bitbake-layers add-layer ../sources/meta-openembedded/meta-networking   
    bitbake-layers add-layer ../sources/meta-openembedded/meta-multimedia   
    bitbake-layers add-layer ../sources/meta-development    

- Define machine configurations:

    MACHINE ??= "raspberrypi3"   
    ENABLE_UART = "1"   

    DISTRO_FEATURES += "systemd bluetooth wifi" 
    DISTRO_FEATURES_remove = "pulseaudio sysvinit"  

    VIRTUAL-RUNTIME_init_manager = "systemd"    
    VIRTUAL-RUNTIME_initscripts = ""    

    PREFERRED_VERSION_alsa-lib = "1.1.8"    
    PREFERRED_VERSION_alsa-utils = "1.1.8"  
    PREFERRED_VERSION_alsa-plugins = "1.1.8"    
    PREFERRED_VERSION_sbc = "2.%"   

    RM_OLD_IMAGE = "1"  
    IMAGE_FSTYPES = "rpi-sdimg" 

Note: Set MACHINE to "raspberrypi4" for Raspberry Pi 4

# Helpful Yocto Commands:
 
## Image/Package Configuration Commands

- `bitbake -g <image-name> && cat pn-buildlist | grep -ve "native" | sort | uniq`  (Get packages for image)
- `bitbake -e <recipie-name> | grep ^PV`                           (Check which recipe version will be used)
- `bitbake -e <recipe-name> | grep ^<VARIABLE-name>`        (Get Variable value in recipes)
- `bitbake-layers show-recipes "*-image-*"`                          (Show available image for building)
- `bitbake-layers show-recipes`                                   (Show all available recipes)
- `bitbake-layers show-layers`                                    (Show all layers)

## Devtool for source modification (used in make run_shell)

- `devtool modify <recipe-name>`             (Extract recipe source to workspace for modification)
- `devtool update-recipe <recipe-name>`            (Create patches from modification to source and apply to recipe)
- `latest-version <recipe-name>`             (Get current and latest version of a recipe)
- `devtool upgrade <recipe-name>`             (Upgrade recipe to recent version)
- `bitbake <recipe-name>`
- `devtool reset <recipe-name>`              (Clean workspace)

## Yocto Independent Package Install/Clean Compile

- `bitbake <package-name>`               (Create package from recipe)
- `bitbake -c fetch -f <package-name>`       (Fetch package source code only)
- `bitbake -c clean <package-name>`       (Clean package from build directory)
- `bitbake -c cleansstate <package-name>`      (Clean compile package again without fetching source)
