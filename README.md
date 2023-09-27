Linux Automation GmbH Test Automation Controller Base Image
===========================================================

Main topics:

  - [Installing official Images](#installing-official-images)
  - [Building the image as-is](#building-the-image-as-is)
  - [Customization](#customization)
  - [Setting up a Bundle Server](#bundle-server)
  - [Installing Images via USB](#installing-images-via-usb)

This set of recipes is used to build the software images and update bundles
for the LXATAC provided by the Linux Automation GmbH. It can be used to
derive customized and pre-configured images for use in your infrastructure.

Installing official Images
--------------------------

If you came here looking for the most recent software bundle for you LXA TAC
and have no actual interest in building your own custom bundles (yet) there is
great news for you. You do not have to follow this long README at all!
The following command automatically installs the most recent stable software
bundle on your TAC:

    $ rauc install https://downloads.linux-automation.com/lxatac/software/stable/latest/lxatac-core-bundle-base-lxatac.raucb

Building the image as-is
------------------------

This chapter describes building rougly the same RAUC bundles as the ones
available from the official mirror mentioned above.

> The image building process will compile a lot of software from source code,
> including the Linux kernel, language interpreters and development tools.
> This will take some time, use quite a bit of RAM and consume a lot of storage
> space. You should preferably do this on a powerful build server with a lot of
> SSD storage instead of on a laptop.

### Getting the sources

Obtaining the recipes and required git submodules:

    $ git clone --recursive --branch langdale \
      https://github.com/linux-automation/meta-lxatac.git
    $ cd meta-lxatac

### Setting up the build environment

To use `bitbake` and other commands you will need to source the
[OpenEmbedded](https://www.openembedded.org/) build environment:

    $ source oe-init-build-env

This will set up a `build` directory and `cd` into it.
Similar to a python `venv` it will also add new paths to your `PATH`
environment variable, making e.g. the `bitbake` command available.

If you want to share downloaded files with other Yocto projects you can
now specify a `DL_DIR` in `conf/site.conf`.
You can also add `INHERIT += "rm_work"` to clean up build artifacts after
building a package to save storage space and
`OPKGBUILDCMD = 'opkg-build -Z gzip -a "-1n"'` to use faster compression
while packing packages.

### Building a bundle

Now you can start the compilation and build the bundle:

    $ bitbake lxatac-core-bundle-base

After some time you should end up with with a RAUC bundle in:

    $ ls tmp/deploy/images/lxatac/lxatac-core-bundle-base-lxatac.raucb
    tmp/deploy/images/lxatac/lxatac-core-bundle-base-lxatac.raucb@

To install the RAUC bundle you will have to enable the devel rauc certificate
on your TAC:

    # The "private" key for the devel certificate is contained in the public
    # meta-lxatac repository, so _anyone_ can create bundles signed with this
    # key.
    $ rauc-enable-cert devel.cert.pem

Afterwards you can install the bundle on your LXA TAC, using either the web
interface or the command line:

    root@lxatac-00010:~ rauc install [PATH_TO_BUNDLE].raucb

Customization
-------------

We will explore two approaches to maintaining a custom layer.
The former provides a cleaner layer layout and the latter makes it easier to
track a specific version of `meta-lxatac` along with a version of your layer.

### Option A - Custom layer inside of `meta-lxatac`

Create a new layer inside of the already cloned `meta-lxatac` next to the
existing `meta-lxatac-bsp` and `meta-lxatac-software` e.g.
`meta-lxatac-example` (a good alternative to `example` may be your companies
name or your own name):

    $ ls meta-lxatac-*
    meta-lxatac-bsp:
    conf/  recipes-bsp/  recipes-core/  recipes-devtools/ …

    meta-lxatac-software:
    conf/  files/  recipes-backports/  recipes-core/ …

    $ bitbake-layers create-layer --priority 12 meta-lxatac-example

    $ ls meta-lxatac-*
    meta-lxatac-bsp:
    conf/  recipes-bsp/  recipes-core/  recipes-devtools/ …

    meta-lxatac-example:
    conf/ COPYING.MIT  README  recipes-example/

    meta-lxatac-software:
    conf/  files/  recipes-backports/  recipes-core/ …

> [!Note]
> The `--priority 12` argument to `bitbake-layers create-layer` gives
> your custom layer a higher priority than all other layers,
> allowing you to override the defaults of all recipes.
> Use `bitbake-layers show-layers` to view the layer priorities.

Populate the layer with sample config files to use when first setting up a build
directory and remove the config files that were already generated when building
the first time:

    $ mkdir -p meta-lxatac-example/conf/templates/default
    $ cp meta-lxatac-software/conf/templates/default/*.sample \
        meta-lxatac-example/conf/templates/default
    # Add "##OEROOT##/../meta-lxatac-example \" to the list of layers:
    $ $EDITOR meta-lxatac-example/conf/templates/default/bblayers.conf.sample
    $ rm -rv build/conf

And then create a script to set up the build environment including the
example layer:

    $ sed "s/lxatac-software/lxatac-example/" \
        oe-init-build-env > meta-lxatac-example/oe-init-build-env
    $ chmod +x meta-lxatac-example/oe-init-build-env

Every layer called `meta-lxatac-*` (except for `-bsp` and `-software`) is
ignored by git via `.gitignore`, as the intention is for you to maintain your
custom layer as a separate git repository.
Initialize `meta-lxatac-example` as its own independent git repository:

    $ cd meta-lxatac-example
    $ git init
    $ git add .
    $ git commit -m "Initial Commit"
    $ cd ..

Next *open a new terminal*, where you have not yet sourced the build environment
and use the new script to initialize the environment:

    # In a new terminal window
    $ source ./meta-lxatac-example/oe-init-build-env

The build of a new bundle should be rather quick, as we did not change
anything yet. See below on how to create custom recipes.

    # Should be faster than initial build:
    $ bitbake lxatac-core-bundle-base

The next section describes another way to maintain your custom layer,
if you have followed the instructions above you can skip right over it
to learn how to use your own bundle signing keys and write custom recipes.

### Option B - `meta-lxatac` as git submodule in custom layer

Create a new empty `meta-lxatac-example` layer in a new repository
placed outside the already cloned `meta-lxatac` repository.

    # We can reuse the artifacts we have already built.
    # Just store its location in a environment variable for now
    $ PREV_SSTATE_DIR=$(readlink -e sstate-cache)
    $ test -z $PREV_SSTATE_DIR && echo \
      "sstate-cache directory does not exist. " \
      "If you have not built meta-lxatac by itself you can skip the moving. " \
      "Otherwise please set PREV_SSTATE_DIR manually now"

    # Do the same for the download directory
    $ PREV_DL_DIR=$(readlink -e downloads)
    $ test -z $PREV_DL_DIR && echo \
      "downloads directory does not exist. " \
      "If you have not built meta-lxatac by itself you can skip the moving. " \
      "If you have set DL_DIR in your site.conf you should do so again. "
      "Otherwise please set PREV_DL_DIR manually now"

    $ cd ${SOMEWHERE_ELSE}
    $ mkdir lxatac-yocto
    $ cd lxatac-yocto
    $ git init

Add `meta-lxatac` as git submodule and initialize _its_ submodules:

    $ git submodule add --branch langdale https://github.com/linux-automation/meta-lxatac.git
    $ git submodule update --init --recursive
    $ cp meta-lxatac/.gitignore .
    $ git add .
    $ git commit -m "Initial commit"

Re-use the sstate (build artifacts) from the previous build directory so we do
not have to re-build everything, and the download directory so we do not have
to re-download when patching an already built package:

    $ mkdir build
    $ mv ${PREV_SSTATE_DIR} build/sstate-cache
    $ mv ${PREV_DL_DIR} build/downloads

Now we will create a new layer for our custom recipes:

    $ ls
    build/ meta-lxatac/

    $ bitbake-layers create-layer --priority 12 meta-lxatac-example

    $ ls
    build/ meta-lxatac/ meta-lxatac-example/

> [!Note]
> The `--priority 12` argument to `bitbake-layers create-layer` gives
> your custom layer a higher priority than all other layers,
> allowing you to override the defaults of all recipes.
> Use `bitbake-layers show-layers` to view the layer priorities.

Populate the layer with sample configs to use when first setting up a build
directory:

    $ mkdir -p meta-lxatac-example/conf/templates/default
    $ cp meta-lxatac/meta-lxatac-software/conf/templates/default/*.sample \
        meta-lxatac-example/conf/templates/default
    # Add "##OEROOT##/../../meta-lxatac-example \" to the list of layers:
    $ $EDITOR meta-lxatac-example/conf/templates/default/bblayers.conf.sample

And then create a script to set up the build environment including the
example layer:

    $ sed "s|lxatac-software|lxatac-example|; s|poky|meta-lxatac/poky|"
        meta-lxatac/oe-init-build-env > oe-init-build-env
    $ chmod +x oe-init-build-env

Next *open a new terminal*, where you have not yet sourced the build
environment, and use the new script to initialize the environment:

    # In a new terminal window
    $ source ./oe-init-build-env

Now that we have a place to put custom configuration and build recipes we can
start customizing the generated bundles.
The first step is to sign the generated bundles using your own keys.

### RAUC signing keys in your layer

There are different approaches to storing cryptographic keys.
Some, like using a hardware security module (HSM),
are considered better in terms of security than others.
What we are about to do is an approach from the opposite side of the security
spectrum, that trades security for ease of development by storing the keys
inside the `meta-lxatac-example` git repository.

First we are going to generate new keys to sign bundles with:

    $ mkdir meta-lxatac-example/files
    $ openssl req -x509 -newkey rsa:4096 -days 36500 -nodes \
      -keyout meta-lxatac-example/files/example.key.pem \
      -out meta-lxatac-example/files/example.cert.pem
    […]
    Country Name (2 letter code) [AU]:DE
    State or Province Name (full name) [Some-State]:
    Locality Name (eg, city) []:
    Organization Name (eg, company) [Internet Widgits Pty Ltd]:Example Project
    Organizational Unit Name (eg, section) []:
    Common Name (e.g. server FQDN or YOUR name) []:
    Email Address []:

Next you should add the following lines to `meta-lxatac-example/conf/layer.conf`:

    RAUC_KEY_FILE = "${LAYERDIR}/files/example.key.pem"
    RAUC_CERT_FILE = "${LAYERDIR}/files/example.cert.pem"
    RAUC_KEYRING_FILE = "${LAYERDIR}/files/example.cert.pem"

Now you should be able to build bundles signed using your own keys,
that you can share with other developers using git:

    $ bitbake lxatac-core-bundle-base

To install the bundle on a new TAC you will need to deploy and enable the
`example.cert.pem` on it first:

    $ scp meta-lxatac-example/files/example.cert.pem \
        root@lxatac-00010:/etc/rauc/certificates-available/example.cert.pem
    $ ssh root@lxatac-00010 rauc-enable-cert example.cert.pem

Afterwards you will be able to install the bundle via the commandline or
the web interface.

### Custom Recipes

What belongs where?

If you want to add a development tool you need or if you want to change something
in the images that could be useful to the general public, you should consider
changing it directly in `meta-lxatac` and submitting a pull request instead of
adding a recipe to your custom layer.

A custom layer is mostly useful for software that is not publicly available or
configuration that is specific to your deployment.

An example for such a site specific configuration would be to deploy a set
of ssh public keys on your LXA TACs:

    $ mkdir -p meta-lxatac-example/recipes-core/ssh-keys/files
    # Add all public keys that you want to deploy:
    $ $EDITOR meta-lxatac-example/recipes-core/ssh-keys/files/authorized_keys.root
    # Add a ssh config snippet that makes use of said keys:
    $ echo "AuthorizedKeysFile .ssh/authorized_keys /etc/ssh/authorized_keys.%u" >
        meta-lxatac-example/recipes-core/ssh-keys/files/ssh-keys.conf

You can now paste the following recipe to
`meta-lxatac-example/recipes-core/ssh-keys/ssh-keys.bb`:

    LICENSE = "CLOSED"

    inherit allarch

    SRC_URI += "file://authorized_keys.root file://ssh-keys.conf"

    do_install() {
        install -D -m0600 ${WORKDIR}/authorized_keys.root \
            ${D}${sysconfdir}/ssh/authorized_keys.root

        install -D -m 0644 ${WORKDIR}/ssh-keys.conf \
            ${D}${sysconfdir}/ssh/sshd_config.d/ssh-keys.conf
    }

Next you want to tell bitbake to build the recipe and install the result to
the default image:

    $ mkdir -p meta-lxatac-example/recipes-core/images
    $ cat > meta-lxatac-example/recipes-core/images/lxatac-core-image-base.bbappend <<EOF
    IMAGE_INSTALL:append = "\
        ssh-keys \
    "
    EOF

A newly built update bundle should now contain your specified ssh keys:

    $ bitbake lxatac-core-bundle-base

Setting up a Bundle Server
--------------------------

Now that you have built your own custom RAUC bundles you may want to deploy
them via your own update bundle server.
For that to work you only need a normal HTTP server that you can deploy your
most recent `.raucb` bundles to and two small bits of configuration in your
OS images.

    $ mkdir -p meta-lxatac-example/recipes-rust/tacd/files/
    $ cat > meta-lxatac-example/recipes-rust/tacd/files/02_example.yaml <<EOF
    name: example
    display_name: Example
    description: |
      An update channel created for exemplary purposes only.
    url: |
      http://YOUR_SERVERS_HOSTNAME/PATH_TO_THE.raucb
    polling_interval: "24h"
    EOF
    $ cat > meta-lxatac-example/recipes-rust/tacd/tacd_%.bbappend <<EOF
    FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

    SRC_URI += "\
        file://02_example.yaml \
        "

    do_install:append() {
        install -D -m 0644 ${WORKDIR}/02_example.yaml \
            ${D}${datadir}/tacd/update_channels/02_example.yaml
    }
    EOF

Replace `YOUR_SERVERS_HOSTNAME` and `PATH_TO_THE.raucb` according to your
servers location and the location of the bundle on the server.
Make sure the configured `name` matches the name of the certificate file you
have generated, e.g. `example.cert.pem` in this example, as the existence of
said certificates in the `certificates-enabled` directory determines if an
update channel is considered active.

Installing Images via USB
-------------------------

This process mirrors the steps we use when we bring up the LXA TAC for the
first time, so it should always work, even if the device is completely bricked
software-wise and you can no longer deploy any RAUC bundles.

### Build the Firmware Files

Flashing the LXA TAC from scratch requires a different set of firmware files
than installing a RAUC update bundle. To build these files run:

    $ bitbake emmc-image emmc-boot-image tf-a-stm32mp

The required files should then appear in `tmp/deploy/images/lxatac/`.

### Bring the Device into USB Boot Mode

The first step is to bring the LXA TAC into the USB bootmode and load a
preliminary bootloader into RAM, which we will use to flash the new image.
The USB bootmode is implemented in the SoC bootrom and can thus not be
corrupted by software running on the TAC.

Lay the device onto the top side (with the rubber feet facing up).
Loosen the four lower screws just one or two threads.
Unscrew the four upper screws.
You can now lift the part with the rubber feet upwards.
Make sure not to put too much strain on the flat flex cable connecting
the lower and upper part.

Connect the mainboard to your computer using a USB-C cable.

Identify the (possibly unpopulated) connector `P4` in the lower left corner of
the LXA TAC mainboard.
It should have pins `GND`, `BT0`, `BT1` and `BT2` marked on the PCB silkscreen.
These `BT?` pins correspond to the boot mode pins of the STM32MP1 and are
usually strapped to be `LOW`, `HIGH` and `LOW` respectively,
instructing the SoC to boot from the eMMC.
Pull pin `BT1` to `GND` by using e.g. a set of tweezers to connect it to `GND`.
This tells the device to boot into the serial update bootrom.

![LXA TAC Bootmode Pins BT0-BT2](readme-assets/bootmode-pins.jpg?raw=true "LXA TAC Bootmode Pins")

Power on the device. It should show up in `lsusb` and `dmesg` on your host
computer.
The device shows up as a `STMicroelectronics` `STM32  BOOTLOADER`.
Next you can upload the required pieces of software:

### Flashing the software

    $ lsusb | grep DFU
    Bus 001 Device 038: ID 0483:df11 STMicroelectronics STM Device in DFU Mode

    $ cd tmp/deploy/images/lxatac/

    # Trusted Firmware-A handles some early hardware setup and then jumps
    # into the actual bootloader
    $ dfu-util --alt 1 -D tf-a-stm32mp157c-lxa-tac.stm32

    # The Barebox bootloader. This command only loads the bootloader into RAM.
    # Nothing is being flashed permanently yet.
    $ dfu-util --alt 3 -D emmc-boot-image-lxatac.fip

    # Exit the USB Boot mode. The TF-A will run and jump into the Barebox in
    # RAM.
    $ dfu-util --alt 0 -e

    # Write the TF-A and bootloader to one of the two redundant eMMC boot
    # partitions. These partitions are not partitions in the normal software
    # sense but a special eMMC hardware feature to provide atomic updates.
    $ fastboot flash bbu-mmc emmc-boot-image-lxatac.img

    # Use the Android fastboot support in Barebox to write the firmware image
    # (in the form of an Android sparse image (.simg)) to the eMMC storage.
    # This will overwrite the data you've stored there.
    $ fastboot flash mmc emmc-image-lxatac.simg


You are now done flashing the LXA TAC and can remove the pull-down on `BT1`
and power cycle it to boot into your newly flashed image.

#### Troubleshooting

##### The device should be in bootrom but does not show up on the Host

Disconnect the USB-C cable from the TAC and power cycle the TAC.
One of the LEDs on the `DUT` Ethernet port should now blink in quick succession.
The LED is connected to the `PA13` pin of the STM32MP1, which is used for debug
output from the bootrom. The LED not blinking means that either the wrong boot
mode is selected or there is some hardware fault.
Check the bootmode pins and the 5V and 3.3V LEDs inside of the device.
If you connect the USB-C cable the blinking should stop and the device should
show up on the host. Otherwise there might be something wrong with the USB-C cable.

##### Fastboot keeps `< waiting for any device >`

If `fastboot` sits idle `< waiting for any device >`, this can be an error with
the permissions on the USB device. Any easy check for this is to run `fastboot`
as `root` using e.g. `sudo`.

##### The TAC disconnects during fastboot

This can happen when the watchdog timer is set up in the barebox bootloader
loaded into RAM via `dfu-util`.
To prevent the TAC from rebooting during fastboot connect to the barebox
console via the debug UART adapter / the USB console provided by barebox
and execute `wd -x` on the shell. E.g.:

    barebox@Linux Automation Test Automation Controller (TAC):/ wd -x

##### The installed bundle does not start

When flashing the emmc-image only the first of two update partitions is
initialized. The second one is set up on first boot and filled for the first time
once you install a RAUC bundle on the system for the first time.
There is a 50/50 chance that barebox is currently set up to boot from this
non-existing partition, which will fail and reduce its retry counter.
If the TAC does not boot after flashing you should power cycle the device
about four times in slow succession to make sure the wrong partition is marked
as bad and the correct partition is used.

Alternatively you can choose the correct partition using the barebox console
via a UART debug adapter:

    # state.bootstate.system1.remaining_attempts=0
    # state.bootstate.system1.priority=0
    # state.bootstate.system0.remaining_attempts=3
    # state.bootstate.system0.priority=1
    # state -s
    # reset
