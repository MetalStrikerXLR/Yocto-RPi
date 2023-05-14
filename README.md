This is a personel project where I will be learning and experimenting with Yocto from scratch.

# Getting started

Source poky environemnt:

`source sources/poky/oe-init-build-env`

Follow any yocto tutorial to add layers and define machine configurations.
A reference can be found in the build/conf folder of this repository

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
