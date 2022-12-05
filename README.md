Linux Automation GmbH Test Automation Controller Base Image
===========================================================

Main topics:

  - [Installing official Images](#installing-official-images)
  - [Building the image as-is](#building-the-image-as-is)
  - [Customization](#customization)

This set of recipes is used to build the software images and update bundles
for the LXATAC provided by the Linux Automation GmbH and can be used to
derive customized and pre-configured images for use in your infrastructure.

Installing official Images
--------------------------

If you came here looking for the most recent software bundle for you LXA TAC
and have no actual interest in building your own custom bundles (yet) there is
great news for you. You do not have to follow this long README at all!
The following command automatically installs the most recent stable software
bundle on your TAC:

    $ rauc install https://downloads.linux-automation.com/software/lxatac/stable/lxatac-core-bundle-base-lxatac.raucb

The same can be achieved by entering the same URL into the updating area of the
LXA TAC webinterface.

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

### Generating RAUC signing keys

In order to be able to build [RAUC](https://rauc.readthedocs.io/) bundles to
update your TAC you will need cryptographic keys to sign said bundles.
We can, for obvious reasons, not provide you with the keys we use to sign
the official bundles, so you will have to generate your own:

    $ openssl req -x509 -newkey rsa:4096 -days 36500 -nodes \
      -keyout meta-lxatac-software/files/rauc.key.pem \
      -out meta-lxatac-software/files/rauc.cert.pem
    […]
    Country Name (2 letter code) [AU]:DE
    State or Province Name (full name) [Some-State]:
    Locality Name (eg, city) []:
    Organization Name (eg, company) [Internet Widgits Pty Ltd]:Example Project
    Organizational Unit Name (eg, section) []:
    Common Name (e.g. server FQDN or YOUR name) []:
    Email Address []:

You will be asked a few questions about who the keys are generated for.
You can however leave most of the fields empty, as shown above.

There is a section later in the README that shows one method to store keys
to use during development.

### Setting up the build environment

To use `bitbake` and other commands you will need to source the
[OpenEmbedded](https://www.openembedded.org/) build environment using:

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

After some time you should end up with with a rauc bundle in:

    $ ls tmp/deploy/images/lxatac/lxatac-core-bundle-base-lxatac.raucb
    tmp/deploy/images/lxatac/lxatac-core-bundle-base-lxatac.raucb@

You can install this via the LXA TAC web interface, by selecting the
"Ignore Bundle Signature" option in the updater interface.

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

    $ bitbake-layers create-layer meta-lxatac-example

    $ ls meta-lxatac-*
    meta-lxatac-bsp:
    conf/  recipes-bsp/  recipes-core/  recipes-devtools/ …

    meta-lxatac-example:
    conf/ COPYING.MIT  README  recipes-example/

    meta-lxatac-software:
    conf/  files/  recipes-backports/  recipes-core/ …

Populate the layer with sample configs to use when first setting up a build
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

Next *open a new terminal*, where you have not yet sourced the build envionment
and use the new script to initialize the environment:

    # In a new terminal window
    $ source ./meta-lxatac-example/oe-init-build-env

The build of a new bundle should be rather quick, as we did not change
anything yet. See below on how to create custom recipes.

    # Should be faster than initial build:
    $ bitbake lxatac-core-bundle-base

The next section describes another way to maintain your custom layer,
if you have followed the instructions above you can skip right over it
to learn how to persist your bundle signing keys and write custom recipes.

### Option B - `meta-lxatac` as git submodule in custom layer

Create a new empty `meta-lxatac-example` layer inside a new project
somewhere outside the already cloned `meta-lxatac` hierarchy.

    # We can reuse the artifacts we have already built.
    # Just store its location in a envionment variable for now
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

    $ bitbake-layers create-layer meta-lxatac-example

    $ ls
    build/ meta-lxatac/ meta-lxatac-example/

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
envionment, and use the new script to initialize the environment:

    # In a new terminal window
    $ source ./oe-init-build-env

Remember how we crated a set of cryptographic keys to sign the bundle with
when first compiling meta-lxatac? We will need to do so again before building
a new bundle. But this time we will do so the semi proper way.

### RAUC signing keys in your layer

There are different approaches to storing cryptographic keys.
Some, like using a hardware security module (HSM),
are considered better in terms of security than others.
What we are about to do is an approach from the opposite side of the security
spectrum, that trades security for ease of development.

First we are going to generate new keys to sign bundles with,
like we did in the first step, but this time inside your new custom layer
(if you prefer to do so you can also copy over the keys you have generated
in the first step):

    $ mkdir meta-lxatac-example/files
    $ openssl req -x509 -newkey rsa:4096 -days 36500 -nodes \
      -keyout meta-lxatac-example/files/rauc.key.pem \
      -out meta-lxatac-example/files/rauc.cert.pem
    […]
    Country Name (2 letter code) [AU]:DE
    State or Province Name (full name) [Some-State]:
    Locality Name (eg, city) []:
    Organization Name (eg, company) [Internet Widgits Pty Ltd]:Example Project
    Organizational Unit Name (eg, section) []:
    Common Name (e.g. server FQDN or YOUR name) []:
    Email Address []:

If you follwed customization Opton A you will also likely want to remove the
keys that were generated in the first step, just to make sure that you will not
accidently include them in a future meta-lxatac pull request:

    $ git restore --staged --worktree meta-lxatac-software/files

Next you should add the following lines to `meta-lxatac-example/conf/layer.conf`:

    RAUC_KEY_FILE = "${LAYERDIR}/files/rauc.key.pem"
    RAUC_CERT_FILE = "${LAYERDIR}/files/rauc.cert.pem"
    RAUC_KEYRING_FILE = "${LAYERDIR}/files/rauc.cert.pem"

Now you should be able to build bundles signed using your own keys,
that you can share with other developers using git:

    $ bitbake lxatac-core-bundle-base

### Custom Recipes

What belongs where?

If you want to add a development tool you need or want to change something
in the images that could be useful to the general public, you should consider
changing it directly in `meta-lxatac` and submitting a pull request instead of
adding a recipe to your custom layer.

A custom layer is mostly useful for software that is not publicly available or
configuration that is specific to your deployment.

An example for such a site specific configuration would be to deploy a set
of ssh public keys on your LXA TACs:

    $ mkdir -p meta-lxatac-example/recipes-core/ssh-keys/files
    # Add all public keys that you want to deploy:
    $ $EDITOR meta-lxatac-example/recipes-core/ssh-keys/files/authorized_keys

You can now paste the following recipe to
`meta-lxatac-example/recipes-core/ssh-keys/ssh-keys.bb`:

    LICENSE = "CLOSED"

    inherit allarch

    SRC_URI += " authorized_keys "

    do_install() {
        install -D -m0600 ${WORKDIR}/authorized_keys ${D}/home/root/.ssh/authorized_keys
    }

    FILES:${PN} += "/home/root/.ssh/authorized_keys"

Next you want to tell bitbake to build the recipe and install the result to
the default image:

    $ mkdir -p meta-lxatac-ptx/recipes-core/images
    $ cat > meta-lxatac-ptx/recipes-core/images/lxatac-core-image-base.bbappend <<EOF
    IMAGE_INSTALL:append = "\
        ssh-keys \
    "
    EOF

A newly built update bundle should now contain your specified ssh keys:

    $ bitbake lxatac-core-bundle-base
