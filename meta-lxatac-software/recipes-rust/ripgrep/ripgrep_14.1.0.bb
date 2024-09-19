inherit cargo

SRC_URI += "git://github.com/BurntSushi/ripgrep.git;protocol=https;branch=master"
SRCREV = "e50df40a1967708b9781486b1c017e48040bceb0"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV:append = ".AUTOINC+9c8d873a75"

SRC_URI += " \
    crate://crates.io/aho-corasick/1.1.2 \
    crate://crates.io/anyhow/1.0.79 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/bstr/1.9.0 \
    crate://crates.io/cc/1.0.83 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/crossbeam-channel/0.5.10 \
    crate://crates.io/crossbeam-deque/0.8.4 \
    crate://crates.io/crossbeam-epoch/0.9.17 \
    crate://crates.io/crossbeam-utils/0.8.18 \
    crate://crates.io/encoding_rs/0.8.33 \
    crate://crates.io/encoding_rs_io/0.1.7 \
    crate://crates.io/glob/0.3.1 \
    crate://crates.io/itoa/1.0.10 \
    crate://crates.io/jemalloc-sys/0.5.4+5.3.0-patched \
    crate://crates.io/jemallocator/0.5.4 \
    crate://crates.io/jobserver/0.1.27 \
    crate://crates.io/lexopt/0.3.0 \
    crate://crates.io/libc/0.2.151 \
    crate://crates.io/libm/0.2.8 \
    crate://crates.io/log/0.4.20 \
    crate://crates.io/memchr/2.7.1 \
    crate://crates.io/memmap2/0.9.3 \
    crate://crates.io/num-traits/0.2.17 \
    crate://crates.io/packed_simd/0.3.9 \
    crate://crates.io/pcre2-sys/0.2.8 \
    crate://crates.io/pcre2/0.2.6 \
    crate://crates.io/pkg-config/0.3.28 \
    crate://crates.io/proc-macro2/1.0.76 \
    crate://crates.io/quote/1.0.35 \
    crate://crates.io/regex-automata/0.4.3 \
    crate://crates.io/regex-syntax/0.8.2 \
    crate://crates.io/regex/1.10.2 \
    crate://crates.io/ryu/1.0.16 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/serde/1.0.195 \
    crate://crates.io/serde_derive/1.0.195 \
    crate://crates.io/serde_json/1.0.111 \
    crate://crates.io/syn/2.0.48 \
    crate://crates.io/termcolor/1.4.0 \
    crate://crates.io/textwrap/0.16.0 \
    crate://crates.io/unicode-ident/1.0.12 \
    crate://crates.io/walkdir/2.4.0 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.6 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
"

SRC_URI[aho-corasick-1.1.2.sha256sum] = "b2969dcb958b36655471fc61f7e416fa76033bdd4bfed0678d8fee1e2d07a1f0"
SRC_URI[anyhow-1.0.79.sha256sum] = "080e9890a082662b09c1ad45f567faeeb47f22b5fb23895fbe1e651e718e25ca"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[bstr-1.9.0.sha256sum] = "c48f0051a4b4c5e0b6d365cd04af53aeaa209e3cc15ec2cdb69e73cc87fbd0dc"
SRC_URI[cc-1.0.83.sha256sum] = "f1174fb0b6ec23863f8b971027804a42614e347eafb0a95bf0b12cdae21fc4d0"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[crossbeam-channel-0.5.10.sha256sum] = "82a9b73a36529d9c47029b9fb3a6f0ea3cc916a261195352ba19e770fc1748b2"
SRC_URI[crossbeam-deque-0.8.4.sha256sum] = "fca89a0e215bab21874660c67903c5f143333cab1da83d041c7ded6053774751"
SRC_URI[crossbeam-epoch-0.9.17.sha256sum] = "0e3681d554572a651dda4186cd47240627c3d0114d45a95f6ad27f2f22e7548d"
SRC_URI[crossbeam-utils-0.8.18.sha256sum] = "c3a430a770ebd84726f584a90ee7f020d28db52c6d02138900f22341f866d39c"
SRC_URI[encoding_rs-0.8.33.sha256sum] = "7268b386296a025e474d5140678f75d6de9493ae55a5d709eeb9dd08149945e1"
SRC_URI[encoding_rs_io-0.1.7.sha256sum] = "1cc3c5651fb62ab8aa3103998dade57efdd028544bd300516baa31840c252a83"
SRC_URI[glob-0.3.1.sha256sum] = "d2fabcfbdc87f4758337ca535fb41a6d701b65693ce38287d856d1674551ec9b"
SRC_URI[itoa-1.0.10.sha256sum] = "b1a46d1a171d865aa5f83f92695765caa047a9b4cbae2cbf37dbd613a793fd4c"
SRC_URI[jemalloc-sys-0.5.4+5.3.0-patched.sha256sum] = "ac6c1946e1cea1788cbfde01c993b52a10e2da07f4bac608228d1bed20bfebf2"
SRC_URI[jemallocator-0.5.4.sha256sum] = "a0de374a9f8e63150e6f5e8a60cc14c668226d7a347d8aee1a45766e3c4dd3bc"
SRC_URI[jobserver-0.1.27.sha256sum] = "8c37f63953c4c63420ed5fd3d6d398c719489b9f872b9fa683262f8edd363c7d"
SRC_URI[lexopt-0.3.0.sha256sum] = "baff4b617f7df3d896f97fe922b64817f6cd9a756bb81d40f8883f2f66dcb401"
SRC_URI[libc-0.2.151.sha256sum] = "302d7ab3130588088d277783b1e2d2e10c9e9e4a16dd9050e6ec93fb3e7048f4"
SRC_URI[libm-0.2.8.sha256sum] = "4ec2a862134d2a7d32d7983ddcdd1c4923530833c9f2ea1a44fc5fa473989058"
SRC_URI[log-0.4.20.sha256sum] = "b5e6163cb8c49088c2c36f57875e58ccd8c87c7427f7fbd50ea6710b2f3f2e8f"
SRC_URI[memchr-2.7.1.sha256sum] = "523dc4f511e55ab87b694dc30d0f820d60906ef06413f93d4d7a1385599cc149"
SRC_URI[memmap2-0.9.3.sha256sum] = "45fd3a57831bf88bc63f8cebc0cf956116276e97fef3966103e96416209f7c92"
SRC_URI[num-traits-0.2.17.sha256sum] = "39e3200413f237f41ab11ad6d161bc7239c84dcb631773ccd7de3dfe4b5c267c"
SRC_URI[packed_simd-0.3.9.sha256sum] = "1f9f08af0c877571712e2e3e686ad79efad9657dbf0f7c3c8ba943ff6c38932d"
SRC_URI[pcre2-sys-0.2.8.sha256sum] = "25b8a7b5253a4465b873a21ee7e8d6ec561a57eed5d319621bec36bea35c86ae"
SRC_URI[pcre2-0.2.6.sha256sum] = "4c9d53a8ea5fc3d3568d3de4bebc12606fd0eb8234c602576f1f1ee4880488a7"
SRC_URI[pkg-config-0.3.28.sha256sum] = "69d3587f8a9e599cc7ec2c00e331f71c4e69a5f9a4b8a6efd5b07466b9736f9a"
SRC_URI[proc-macro2-1.0.76.sha256sum] = "95fc56cda0b5c3325f5fbbd7ff9fda9e02bb00bb3dac51252d2f1bfa1cb8cc8c"
SRC_URI[quote-1.0.35.sha256sum] = "291ec9ab5efd934aaf503a6466c5d5251535d108ee747472c3977cc5acc868ef"
SRC_URI[regex-automata-0.4.3.sha256sum] = "5f804c7828047e88b2d32e2d7fe5a105da8ee3264f01902f796c8e067dc2483f"
SRC_URI[regex-syntax-0.8.2.sha256sum] = "c08c74e62047bb2de4ff487b251e4a92e24f48745648451635cec7d591162d9f"
SRC_URI[regex-1.10.2.sha256sum] = "380b951a9c5e80ddfd6136919eef32310721aa4aacd4889a8d39124b026ab343"
SRC_URI[ryu-1.0.16.sha256sum] = "f98d2aa92eebf49b69786be48e4477826b256916e84a57ff2a4f21923b48eb4c"
SRC_URI[same-file-1.0.6.sha256sum] = "93fc1dc3aaa9bfed95e02e6eadabb4baf7e3078b0bd1b4d7b6b0b68378900502"
SRC_URI[serde-1.0.195.sha256sum] = "63261df402c67811e9ac6def069e4786148c4563f4b50fd4bf30aa370d626b02"
SRC_URI[serde_derive-1.0.195.sha256sum] = "46fe8f8603d81ba86327b23a2e9cdf49e1255fb94a4c5f297f6ee0547178ea2c"
SRC_URI[serde_json-1.0.111.sha256sum] = "176e46fa42316f18edd598015a5166857fc835ec732f5215eac6b7bdbf0a84f4"
SRC_URI[syn-2.0.48.sha256sum] = "0f3531638e407dfc0814761abb7c00a5b54992b849452a0646b7f65c9f770f3f"
SRC_URI[termcolor-1.4.0.sha256sum] = "ff1bc3d3f05aff0403e8ac0d92ced918ec05b666a43f83297ccef5bea8a3d449"
SRC_URI[textwrap-0.16.0.sha256sum] = "222a222a5bfe1bba4a77b45ec488a741b3cb8872e5e499451fd7d0129c9c7c3d"
SRC_URI[unicode-ident-1.0.12.sha256sum] = "3354b9ac3fae1ff6755cb6db53683adb661634f67557942dea4facebec0fee4b"
SRC_URI[walkdir-2.4.0.sha256sum] = "d71d857dc86794ca4c280d616f7da00d2dbfd8cd788846559a6813e6aa4b54ee"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.6.sha256sum] = "f29e6f9198ba0d26b4c9f07dbe6f9ed633e1f3d5b8b414090084349e46a52596"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"

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
