inherit cargo

SRC_URI += "git://github.com/BurntSushi/ripgrep.git;protocol=https;branch=master"
SRCREV = "4649aa9700619f94cf9c66876e9549d83420e16c"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

SRC_URI += " \
    crate://crates.io/aho-corasick/1.1.3 \
    crate://crates.io/anyhow/1.0.87 \
    crate://crates.io/bstr/1.10.0 \
    crate://crates.io/cc/1.1.18 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/crossbeam-channel/0.5.13 \
    crate://crates.io/crossbeam-deque/0.8.5 \
    crate://crates.io/crossbeam-epoch/0.9.18 \
    crate://crates.io/crossbeam-utils/0.8.20 \
    crate://crates.io/encoding_rs/0.8.34 \
    crate://crates.io/encoding_rs_io/0.1.7 \
    crate://crates.io/glob/0.3.1 \
    crate://crates.io/itoa/1.0.11 \
    crate://crates.io/jemalloc-sys/0.5.4+5.3.0-patched \
    crate://crates.io/jemallocator/0.5.4 \
    crate://crates.io/jobserver/0.1.32 \
    crate://crates.io/lexopt/0.3.0 \
    crate://crates.io/libc/0.2.158 \
    crate://crates.io/log/0.4.22 \
    crate://crates.io/memchr/2.7.4 \
    crate://crates.io/memmap2/0.9.4 \
    crate://crates.io/pcre2-sys/0.2.9 \
    crate://crates.io/pcre2/0.2.9 \
    crate://crates.io/pkg-config/0.3.30 \
    crate://crates.io/proc-macro2/1.0.86 \
    crate://crates.io/quote/1.0.37 \
    crate://crates.io/regex-automata/0.4.7 \
    crate://crates.io/regex-syntax/0.8.4 \
    crate://crates.io/regex/1.10.6 \
    crate://crates.io/ryu/1.0.18 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/serde/1.0.210 \
    crate://crates.io/serde_derive/1.0.210 \
    crate://crates.io/serde_json/1.0.128 \
    crate://crates.io/shlex/1.3.0 \
    crate://crates.io/syn/2.0.77 \
    crate://crates.io/termcolor/1.4.1 \
    crate://crates.io/textwrap/0.16.1 \
    crate://crates.io/unicode-ident/1.0.12 \
    crate://crates.io/walkdir/2.5.0 \
    crate://crates.io/winapi-util/0.1.9 \
    crate://crates.io/windows-sys/0.59.0 \
    crate://crates.io/windows-targets/0.52.6 \
    crate://crates.io/windows_aarch64_gnullvm/0.52.6 \
    crate://crates.io/windows_aarch64_msvc/0.52.6 \
    crate://crates.io/windows_i686_gnu/0.52.6 \
    crate://crates.io/windows_i686_gnullvm/0.52.6 \
    crate://crates.io/windows_i686_msvc/0.52.6 \
    crate://crates.io/windows_x86_64_gnu/0.52.6 \
    crate://crates.io/windows_x86_64_gnullvm/0.52.6 \
    crate://crates.io/windows_x86_64_msvc/0.52.6 \
"

SRC_URI[aho-corasick-1.1.3.sha256sum] = "8e60d3430d3a69478ad0993f19238d2df97c507009a52b3c10addcd7f6bcb916"
SRC_URI[anyhow-1.0.87.sha256sum] = "10f00e1f6e58a40e807377c75c6a7f97bf9044fab57816f2414e6f5f4499d7b8"
SRC_URI[bstr-1.10.0.sha256sum] = "40723b8fb387abc38f4f4a37c09073622e41dd12327033091ef8950659e6dc0c"
SRC_URI[cc-1.1.18.sha256sum] = "b62ac837cdb5cb22e10a256099b4fc502b1dfe560cb282963a974d7abd80e476"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[crossbeam-channel-0.5.13.sha256sum] = "33480d6946193aa8033910124896ca395333cae7e2d1113d1fef6c3272217df2"
SRC_URI[crossbeam-deque-0.8.5.sha256sum] = "613f8cc01fe9cf1a3eb3d7f488fd2fa8388403e97039e2f73692932e291a770d"
SRC_URI[crossbeam-epoch-0.9.18.sha256sum] = "5b82ac4a3c2ca9c3460964f020e1402edd5753411d7737aa39c3714ad1b5420e"
SRC_URI[crossbeam-utils-0.8.20.sha256sum] = "22ec99545bb0ed0ea7bb9b8e1e9122ea386ff8a48c0922e43f36d45ab09e0e80"
SRC_URI[encoding_rs-0.8.34.sha256sum] = "b45de904aa0b010bce2ab45264d0631681847fa7b6f2eaa7dab7619943bc4f59"
SRC_URI[encoding_rs_io-0.1.7.sha256sum] = "1cc3c5651fb62ab8aa3103998dade57efdd028544bd300516baa31840c252a83"
SRC_URI[glob-0.3.1.sha256sum] = "d2fabcfbdc87f4758337ca535fb41a6d701b65693ce38287d856d1674551ec9b"
SRC_URI[itoa-1.0.11.sha256sum] = "49f1f14873335454500d59611f1cf4a4b0f786f9ac11f4312a78e4cf2566695b"
SRC_URI[jemalloc-sys-0.5.4+5.3.0-patched.sha256sum] = "ac6c1946e1cea1788cbfde01c993b52a10e2da07f4bac608228d1bed20bfebf2"
SRC_URI[jemallocator-0.5.4.sha256sum] = "a0de374a9f8e63150e6f5e8a60cc14c668226d7a347d8aee1a45766e3c4dd3bc"
SRC_URI[jobserver-0.1.32.sha256sum] = "48d1dbcbbeb6a7fec7e059840aa538bd62aaccf972c7346c4d9d2059312853d0"
SRC_URI[lexopt-0.3.0.sha256sum] = "baff4b617f7df3d896f97fe922b64817f6cd9a756bb81d40f8883f2f66dcb401"
SRC_URI[libc-0.2.158.sha256sum] = "d8adc4bb1803a324070e64a98ae98f38934d91957a99cfb3a43dcbc01bc56439"
SRC_URI[log-0.4.22.sha256sum] = "a7a70ba024b9dc04c27ea2f0c0548feb474ec5c54bba33a7f72f873a39d07b24"
SRC_URI[memchr-2.7.4.sha256sum] = "78ca9ab1a0babb1e7d5695e3530886289c18cf2f87ec19a575a0abdce112e3a3"
SRC_URI[memmap2-0.9.4.sha256sum] = "fe751422e4a8caa417e13c3ea66452215d7d63e19e604f4980461212f3ae1322"
SRC_URI[pcre2-sys-0.2.9.sha256sum] = "550f5d18fb1b90c20b87e161852c10cde77858c3900c5059b5ad2a1449f11d8a"
SRC_URI[pcre2-0.2.9.sha256sum] = "3be55c43ac18044541d58d897e8f4c55157218428953ebd39d86df3ba0286b2b"
SRC_URI[pkg-config-0.3.30.sha256sum] = "d231b230927b5e4ad203db57bbcbee2802f6bce620b1e4a9024a07d94e2907ec"
SRC_URI[proc-macro2-1.0.86.sha256sum] = "5e719e8df665df0d1c8fbfd238015744736151d4445ec0836b8e628aae103b77"
SRC_URI[quote-1.0.37.sha256sum] = "b5b9d34b8991d19d98081b46eacdd8eb58c6f2b201139f7c5f643cc155a633af"
SRC_URI[regex-automata-0.4.7.sha256sum] = "38caf58cc5ef2fed281f89292ef23f6365465ed9a41b7a7754eb4e26496c92df"
SRC_URI[regex-syntax-0.8.4.sha256sum] = "7a66a03ae7c801facd77a29370b4faec201768915ac14a721ba36f20bc9c209b"
SRC_URI[regex-1.10.6.sha256sum] = "4219d74c6b67a3654a9fbebc4b419e22126d13d2f3c4a07ee0cb61ff79a79619"
SRC_URI[ryu-1.0.18.sha256sum] = "f3cb5ba0dc43242ce17de99c180e96db90b235b8a9fdc9543c96d2209116bd9f"
SRC_URI[same-file-1.0.6.sha256sum] = "93fc1dc3aaa9bfed95e02e6eadabb4baf7e3078b0bd1b4d7b6b0b68378900502"
SRC_URI[serde-1.0.210.sha256sum] = "c8e3592472072e6e22e0a54d5904d9febf8508f65fb8552499a1abc7d1078c3a"
SRC_URI[serde_derive-1.0.210.sha256sum] = "243902eda00fad750862fc144cea25caca5e20d615af0a81bee94ca738f1df1f"
SRC_URI[serde_json-1.0.128.sha256sum] = "6ff5456707a1de34e7e37f2a6fd3d3f808c318259cbd01ab6377795054b483d8"
SRC_URI[shlex-1.3.0.sha256sum] = "0fda2ff0d084019ba4d7c6f371c95d8fd75ce3524c3cb8fb653a3023f6323e64"
SRC_URI[syn-2.0.77.sha256sum] = "9f35bcdf61fd8e7be6caf75f429fdca8beb3ed76584befb503b1569faee373ed"
SRC_URI[termcolor-1.4.1.sha256sum] = "06794f8f6c5c898b3275aebefa6b8a1cb24cd2c6c79397ab15774837a0bc5755"
SRC_URI[textwrap-0.16.1.sha256sum] = "23d434d3f8967a09480fb04132ebe0a3e088c173e6d0ee7897abbdf4eab0f8b9"
SRC_URI[unicode-ident-1.0.12.sha256sum] = "3354b9ac3fae1ff6755cb6db53683adb661634f67557942dea4facebec0fee4b"
SRC_URI[walkdir-2.5.0.sha256sum] = "29790946404f91d9c5d06f9874efddea1dc06c5efe94541a7d6863108e3a5e4b"
SRC_URI[winapi-util-0.1.9.sha256sum] = "cf221c93e13a30d793f7645a0e7762c55d169dbb0a49671918a2319d289b10bb"
SRC_URI[windows-sys-0.59.0.sha256sum] = "1e38bc4d79ed67fd075bcc251a1c39b32a1776bbe92e5bef1f0bf1f8c531853b"
SRC_URI[windows-targets-0.52.6.sha256sum] = "9b724f72796e036ab90c1021d4780d4d3d648aca59e491e6b98e725b84e99973"
SRC_URI[windows_aarch64_gnullvm-0.52.6.sha256sum] = "32a4622180e7a0ec044bb555404c800bc9fd9ec262ec147edd5989ccd0c02cd3"
SRC_URI[windows_aarch64_msvc-0.52.6.sha256sum] = "09ec2a7bb152e2252b53fa7803150007879548bc709c039df7627cabbd05d469"
SRC_URI[windows_i686_gnu-0.52.6.sha256sum] = "8e9b5ad5ab802e97eb8e295ac6720e509ee4c243f69d781394014ebfe8bbfa0b"
SRC_URI[windows_i686_gnullvm-0.52.6.sha256sum] = "0eee52d38c090b3caa76c563b86c3a4bd71ef1a819287c19d586d7334ae8ed66"
SRC_URI[windows_i686_msvc-0.52.6.sha256sum] = "240948bc05c5e7c6dabba28bf89d89ffce3e303022809e73deaefe4f6ec56c66"
SRC_URI[windows_x86_64_gnu-0.52.6.sha256sum] = "147a5c80aabfbf0c7d901cb5895d1de30ef2907eb21fbbab29ca94c5b08b1a78"
SRC_URI[windows_x86_64_gnullvm-0.52.6.sha256sum] = "24d5b23dc417412679681396f2b49f3de8c1473deb516bd34410872eff51ed0d"
SRC_URI[windows_x86_64_msvc-0.52.6.sha256sum] = "589f6da84c646204747d1270a2a5661ea66ed1cced2631d546fdfb155959f9ec"

LIC_FILES_CHKSUM = " \
    file://LICENSE-MIT;md5=8d0d0aa488af0ab9aafa3b85a7fc8e12 \
    file://UNLICENSE;md5=7246f848faa4e9c9fc0ea91122d6e680 \
"

SUMMARY = "ripgrep is a line-oriented search tool that recursively searches your current \
directory for a regex pattern while respecting your gitignore rules. ripgrep \
has first class support on Windows, macOS and Linux."
HOMEPAGE = "https://github.com/BurntSushi/ripgrep"
LICENSE = "Unlicense | MIT"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include ripgrep-${PV}.inc
include ripgrep.inc
