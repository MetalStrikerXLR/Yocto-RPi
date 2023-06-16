# meta-mender-octavo-osd32mp

Mender integration layer for Octavo Systems OSD32MP1-RED board with eMMC boot.

The supported and tested boards are:
 
- [OSD32MP1-RED](https://octavosystems.com/octavo_products/osd32mp1-red/)

Although this integration is focused on a specific board, it is largely
compatible with other boards based on ST's STM32MP1 SoC and may be integrated
into meta-mender-st-stm32mp in the future.

Visit the individual board links above for more information on status of the
integration and more detailed instructions on how to build and use images
together with Mender for the mentioned boards.

## Useful resources

- [Mender Documentation](https://docs.mender.io/) - General Mender documentation;
- [OpenSTLinux Distribution Package](https://wiki.st.com/stm32mpu/wiki/STM32MP1_Distribution_Package) -
General documentation regarding ST's distribution for the STM32MP1, which is
the SoC the OSD32MP module is based upon.
- [Octavo Systems OSD32MP1-RED](https://octavosystems.com/octavo_products/osd32mp1-red/) -
product page of the OSD32MP1-RED board.
- [OSD32MP1-RED Getting Started](https://octavosystems.com/app_notes/osd32mp1-red-getting-started/) - information about the board connectors and
DIP switches, including references to further information resources.
- [STM32CubeProgrammer](https://wiki.st.com/stm32mpu/wiki/STM32CubeProgrammer) -
information about the `STM32_Cube_Programmer` including installation instructions.

## Using this layer

1. Download the source:

```
mkdir mender-osd32mp
cd mender-osd32mp
repo init \
    -u https://github.com/mendersoftware/meta-mender-community \
    -m meta-mender-octavo-osd32mp/scripts/manifest-octavo-osd32mp.xml \
    -b kirkstone
repo sync
```

2. Setup environment:

```
    $ . setup-environment octavo-osd32mp
```

3. Build:

```
    $ bitbake st-image-core
```

## Flashing the image

Once the build completes, enter the image deploy dubdirectory and use `STM32_Cube_Programmer`
to flash the board:

1. Set all the board DIP switches to the **OFF** position
2. Attach the board to the computer using a USB-C cable
3. (Optional) Attach a serial adapter (TTL levels) to the debug header on the board
4. Run the STM32_Cube_Programmer
```
    $ cd tmp-glibc/deploy/images/osd32mp1-emmc-mender
    $ STM32_Programmer_CLI -c port=usb1 -w flashlayout_st-image-core/trusted/FlashLayout_emmc_stm32mp157c-osd32mp1-red-trusted.tsv
```

### Making image metadata compatible with ST flashlayout

OpenSTLinux uses some non-trivial logic to process the OE metadata and the files
generated during the build to create the flashlayout file. This flashlayout is
thoroughly documented in ST's wiki (see above). Its contents determine what will
be flashed onto the eMMC on the target board.

This integration assumes that the image being built is `st-image-core`. There
is an append to the image recipe whose purpose is to ensure that the dataimg
image file ends up with an extension recognized by ST's SDK when the flashlayout
is being generated - `.ext4`

When using a different image, (core-image-minimal or your own) make sure that
there is a link to the dataimg file that ends with the `.ext4` extension by
appending to `IMAGE_CMD:dataimg` in your image recipe.
