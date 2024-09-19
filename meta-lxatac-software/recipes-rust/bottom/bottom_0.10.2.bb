inherit cargo

SRC_URI += "git://github.com/ClementTsang/bottom.git;protocol=https;branch=main"
SRCREV = "2ec1fb56c9db0b37acc4eca3230adfb52720376b"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""

# The bottom Cargo.toml strips release builds, why makes it hard to debug.
# Yocto has its own stripping feature, that preserves the debug symbols but
# only installs the stripped version.
# Pre-stripped binaries trigger a yocto QA error.
CARGO_BUILD_FLAGS += "--config profile.release.strip=false"

SRC_URI += " \
    crate://crates.io/addr2line/0.22.0 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/ahash/0.8.11 \
    crate://crates.io/aho-corasick/1.1.3 \
    crate://crates.io/allocator-api2/0.2.18 \
    crate://crates.io/anstream/0.6.15 \
    crate://crates.io/anstyle-parse/0.2.5 \
    crate://crates.io/anstyle-query/1.1.1 \
    crate://crates.io/anstyle-wincon/3.0.4 \
    crate://crates.io/anstyle/1.0.8 \
    crate://crates.io/anyhow/1.0.86 \
    crate://crates.io/assert_cmd/2.0.15 \
    crate://crates.io/autocfg/1.3.0 \
    crate://crates.io/backtrace/0.3.73 \
    crate://crates.io/base64/0.22.1 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bitflags/2.6.0 \
    crate://crates.io/bstr/1.10.0 \
    crate://crates.io/byteorder/1.5.0 \
    crate://crates.io/cargo-husky/1.5.0 \
    crate://crates.io/cassowary/0.3.0 \
    crate://crates.io/castaway/0.2.3 \
    crate://crates.io/cc/1.1.7 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/cfg_aliases/0.1.1 \
    crate://crates.io/cfg_aliases/0.2.1 \
    crate://crates.io/clap/4.5.13 \
    crate://crates.io/clap_builder/4.5.13 \
    crate://crates.io/clap_complete/4.5.12 \
    crate://crates.io/clap_complete_fig/4.5.2 \
    crate://crates.io/clap_complete_nushell/4.5.3 \
    crate://crates.io/clap_derive/4.5.13 \
    crate://crates.io/clap_lex/0.7.2 \
    crate://crates.io/clap_mangen/0.2.23 \
    crate://crates.io/colorchoice/1.0.2 \
    crate://crates.io/compact_str/0.7.1 \
    crate://crates.io/concat-string/1.0.1 \
    crate://crates.io/core-foundation-sys/0.8.6 \
    crate://crates.io/core-foundation/0.9.4 \
    crate://crates.io/crossbeam-deque/0.8.5 \
    crate://crates.io/crossbeam-epoch/0.9.18 \
    crate://crates.io/crossbeam-utils/0.8.20 \
    crate://crates.io/crossterm/0.27.0 \
    crate://crates.io/crossterm_winapi/0.9.1 \
    crate://crates.io/ctrlc/3.4.4 \
    crate://crates.io/darling/0.20.10 \
    crate://crates.io/darling_core/0.20.10 \
    crate://crates.io/darling_macro/0.20.10 \
    crate://crates.io/deranged/0.3.11 \
    crate://crates.io/difflib/0.4.0 \
    crate://crates.io/dirs-sys/0.4.1 \
    crate://crates.io/dirs/5.0.1 \
    crate://crates.io/doc-comment/0.3.3 \
    crate://crates.io/downcast-rs/1.2.1 \
    crate://crates.io/dyn-clone/1.0.17 \
    crate://crates.io/either/1.13.0 \
    crate://crates.io/enum-as-inner/0.6.0 \
    crate://crates.io/equivalent/1.0.1 \
    crate://crates.io/errno/0.3.9 \
    crate://crates.io/fern/0.6.2 \
    crate://crates.io/filedescriptor/0.8.2 \
    crate://crates.io/float-cmp/0.9.0 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/getrandom/0.2.15 \
    crate://crates.io/gimli/0.29.0 \
    crate://crates.io/hashbrown/0.14.5 \
    crate://crates.io/heck/0.4.1 \
    crate://crates.io/heck/0.5.0 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/ident_case/1.0.1 \
    crate://crates.io/indexmap/2.3.0 \
    crate://crates.io/indoc/2.0.5 \
    crate://crates.io/ioctl-rs/0.1.6 \
    crate://crates.io/is_terminal_polyfill/1.70.1 \
    crate://crates.io/itertools/0.13.0 \
    crate://crates.io/itoa/1.0.11 \
    crate://crates.io/lazy_static/1.5.0 \
    crate://crates.io/lazycell/1.3.0 \
    crate://crates.io/libc/0.2.155 \
    crate://crates.io/libloading/0.8.5 \
    crate://crates.io/libredox/0.1.3 \
    crate://crates.io/linux-raw-sys/0.4.14 \
    crate://crates.io/lock_api/0.4.12 \
    crate://crates.io/log/0.4.22 \
    crate://crates.io/lru/0.12.4 \
    crate://crates.io/mach2/0.4.2 \
    crate://crates.io/memchr/2.7.4 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/miniz_oxide/0.7.4 \
    crate://crates.io/mio/0.8.11 \
    crate://crates.io/nix/0.25.1 \
    crate://crates.io/nix/0.28.0 \
    crate://crates.io/nix/0.29.0 \
    crate://crates.io/normalize-line-endings/0.3.0 \
    crate://crates.io/ntapi/0.4.1 \
    crate://crates.io/num-conv/0.1.0 \
    crate://crates.io/num-traits/0.2.19 \
    crate://crates.io/num_threads/0.1.7 \
    crate://crates.io/nvml-wrapper-sys/0.8.0 \
    crate://crates.io/nvml-wrapper/0.10.0 \
    crate://crates.io/object/0.36.2 \
    crate://crates.io/once_cell/1.19.0 \
    crate://crates.io/option-ext/0.2.0 \
    crate://crates.io/parking_lot/0.12.3 \
    crate://crates.io/parking_lot_core/0.9.10 \
    crate://crates.io/paste/1.0.15 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/plist/1.7.0 \
    crate://crates.io/portable-pty/0.8.1 \
    crate://crates.io/powerfmt/0.2.0 \
    crate://crates.io/predicates-core/1.0.8 \
    crate://crates.io/predicates-tree/1.0.11 \
    crate://crates.io/predicates/3.1.2 \
    crate://crates.io/proc-macro2/1.0.86 \
    crate://crates.io/quick-xml/0.32.0 \
    crate://crates.io/quote/1.0.36 \
    crate://crates.io/ratatui/0.27.0 \
    crate://crates.io/rayon-core/1.12.1 \
    crate://crates.io/rayon/1.10.0 \
    crate://crates.io/redox_syscall/0.5.3 \
    crate://crates.io/redox_users/0.4.5 \
    crate://crates.io/regex-automata/0.4.7 \
    crate://crates.io/regex-syntax/0.8.4 \
    crate://crates.io/regex/1.10.5 \
    crate://crates.io/roff/0.2.2 \
    crate://crates.io/rustc-demangle/0.1.24 \
    crate://crates.io/rustix/0.38.34 \
    crate://crates.io/rustversion/1.0.17 \
    crate://crates.io/ryu/1.0.18 \
    crate://crates.io/same-file/1.0.6 \
    crate://crates.io/schemars/0.8.21 \
    crate://crates.io/schemars_derive/0.8.21 \
    crate://crates.io/scopeguard/1.2.0 \
    crate://crates.io/serde/1.0.204 \
    crate://crates.io/serde_derive/1.0.204 \
    crate://crates.io/serde_derive_internals/0.29.1 \
    crate://crates.io/serde_json/1.0.121 \
    crate://crates.io/serde_spanned/0.6.7 \
    crate://crates.io/serial-core/0.4.0 \
    crate://crates.io/serial-unix/0.4.0 \
    crate://crates.io/serial-windows/0.4.0 \
    crate://crates.io/serial/0.4.0 \
    crate://crates.io/shared_library/0.1.9 \
    crate://crates.io/shell-words/1.1.0 \
    crate://crates.io/signal-hook-mio/0.2.4 \
    crate://crates.io/signal-hook-registry/1.4.2 \
    crate://crates.io/signal-hook/0.3.17 \
    crate://crates.io/smallvec/1.13.2 \
    crate://crates.io/stability/0.2.1 \
    crate://crates.io/starship-battery/0.9.1 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.11.1 \
    crate://crates.io/strum/0.26.3 \
    crate://crates.io/strum_macros/0.26.4 \
    crate://crates.io/syn/2.0.72 \
    crate://crates.io/sysctl/0.5.5 \
    crate://crates.io/sysinfo/0.30.13 \
    crate://crates.io/terminal_size/0.3.0 \
    crate://crates.io/termios/0.2.2 \
    crate://crates.io/termtree/0.4.1 \
    crate://crates.io/thiserror-impl/1.0.63 \
    crate://crates.io/thiserror/1.0.63 \
    crate://crates.io/time-core/0.1.2 \
    crate://crates.io/time-macros/0.2.18 \
    crate://crates.io/time/0.3.36 \
    crate://crates.io/toml_datetime/0.6.8 \
    crate://crates.io/toml_edit/0.22.20 \
    crate://crates.io/typenum/1.17.0 \
    crate://crates.io/unicode-ellipsis/0.2.0 \
    crate://crates.io/unicode-ident/1.0.12 \
    crate://crates.io/unicode-segmentation/1.11.0 \
    crate://crates.io/unicode-truncate/1.1.0 \
    crate://crates.io/unicode-width/0.1.13 \
    crate://crates.io/uom/0.36.0 \
    crate://crates.io/utf8parse/0.2.2 \
    crate://crates.io/version_check/0.9.5 \
    crate://crates.io/wait-timeout/0.2.0 \
    crate://crates.io/walkdir/2.5.0 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.8 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-core/0.52.0 \
    crate://crates.io/windows-core/0.58.0 \
    crate://crates.io/windows-implement/0.58.0 \
    crate://crates.io/windows-interface/0.58.0 \
    crate://crates.io/windows-result/0.2.0 \
    crate://crates.io/windows-strings/0.1.0 \
    crate://crates.io/windows-sys/0.48.0 \
    crate://crates.io/windows-sys/0.52.0 \
    crate://crates.io/windows-targets/0.48.5 \
    crate://crates.io/windows-targets/0.52.6 \
    crate://crates.io/windows/0.52.0 \
    crate://crates.io/windows/0.58.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.48.5 \
    crate://crates.io/windows_aarch64_gnullvm/0.52.6 \
    crate://crates.io/windows_aarch64_msvc/0.48.5 \
    crate://crates.io/windows_aarch64_msvc/0.52.6 \
    crate://crates.io/windows_i686_gnu/0.48.5 \
    crate://crates.io/windows_i686_gnu/0.52.6 \
    crate://crates.io/windows_i686_gnullvm/0.52.6 \
    crate://crates.io/windows_i686_msvc/0.48.5 \
    crate://crates.io/windows_i686_msvc/0.52.6 \
    crate://crates.io/windows_x86_64_gnu/0.48.5 \
    crate://crates.io/windows_x86_64_gnu/0.52.6 \
    crate://crates.io/windows_x86_64_gnullvm/0.48.5 \
    crate://crates.io/windows_x86_64_gnullvm/0.52.6 \
    crate://crates.io/windows_x86_64_msvc/0.48.5 \
    crate://crates.io/windows_x86_64_msvc/0.52.6 \
    crate://crates.io/winnow/0.6.18 \
    crate://crates.io/winreg/0.10.1 \
    crate://crates.io/wrapcenum-derive/0.4.1 \
    crate://crates.io/zerocopy-derive/0.7.35 \
    crate://crates.io/zerocopy/0.7.35 \
"

SRC_URI[addr2line-0.22.0.sha256sum] = "6e4503c46a5c0c7844e948c9a4d6acd9f50cccb4de1c48eb9e291ea17470c678"
SRC_URI[adler-1.0.2.sha256sum] = "f26201604c87b1e01bd3d98f8d5d9a8fcbb815e8cedb41ffccbeb4bf593a35fe"
SRC_URI[ahash-0.8.11.sha256sum] = "e89da841a80418a9b391ebaea17f5c112ffaaa96f621d2c285b5174da76b9011"
SRC_URI[aho-corasick-1.1.3.sha256sum] = "8e60d3430d3a69478ad0993f19238d2df97c507009a52b3c10addcd7f6bcb916"
SRC_URI[allocator-api2-0.2.18.sha256sum] = "5c6cb57a04249c6480766f7f7cef5467412af1490f8d1e243141daddada3264f"
SRC_URI[anstream-0.6.15.sha256sum] = "64e15c1ab1f89faffbf04a634d5e1962e9074f2741eef6d97f3c4e322426d526"
SRC_URI[anstyle-parse-0.2.5.sha256sum] = "eb47de1e80c2b463c735db5b217a0ddc39d612e7ac9e2e96a5aed1f57616c1cb"
SRC_URI[anstyle-query-1.1.1.sha256sum] = "6d36fc52c7f6c869915e99412912f22093507da8d9e942ceaf66fe4b7c14422a"
SRC_URI[anstyle-wincon-3.0.4.sha256sum] = "5bf74e1b6e971609db8ca7a9ce79fd5768ab6ae46441c572e46cf596f59e57f8"
SRC_URI[anstyle-1.0.8.sha256sum] = "1bec1de6f59aedf83baf9ff929c98f2ad654b97c9510f4e70cf6f661d49fd5b1"
SRC_URI[anyhow-1.0.86.sha256sum] = "b3d1d046238990b9cf5bcde22a3fb3584ee5cf65fb2765f454ed428c7a0063da"
SRC_URI[assert_cmd-2.0.15.sha256sum] = "bc65048dd435533bb1baf2ed9956b9a278fbfdcf90301b39ee117f06c0199d37"
SRC_URI[autocfg-1.3.0.sha256sum] = "0c4b4d0bd25bd0b74681c0ad21497610ce1b7c91b1022cd21c80c6fbdd9476b0"
SRC_URI[backtrace-0.3.73.sha256sum] = "5cc23269a4f8976d0a4d2e7109211a419fe30e8d88d677cd60b6bc79c5732e0a"
SRC_URI[base64-0.22.1.sha256sum] = "72b3254f16251a8381aa12e40e3c4d2f0199f8c6508fbecb9d91f575e0fbb8c6"
SRC_URI[bitflags-1.3.2.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[bitflags-2.6.0.sha256sum] = "b048fb63fd8b5923fc5aa7b340d8e156aec7ec02f0c78fa8a6ddc2613f6f71de"
SRC_URI[bstr-1.10.0.sha256sum] = "40723b8fb387abc38f4f4a37c09073622e41dd12327033091ef8950659e6dc0c"
SRC_URI[byteorder-1.5.0.sha256sum] = "1fd0f2584146f6f2ef48085050886acf353beff7305ebd1ae69500e27c67f64b"
SRC_URI[cargo-husky-1.5.0.sha256sum] = "7b02b629252fe8ef6460461409564e2c21d0c8e77e0944f3d189ff06c4e932ad"
SRC_URI[cassowary-0.3.0.sha256sum] = "df8670b8c7b9dae1793364eafadf7239c40d669904660c5960d74cfd80b46a53"
SRC_URI[castaway-0.2.3.sha256sum] = "0abae9be0aaf9ea96a3b1b8b1b55c602ca751eba1b1500220cea4ecbafe7c0d5"
SRC_URI[cc-1.1.7.sha256sum] = "26a5c3fd7bfa1ce3897a3a3501d362b2d87b7f2583ebcb4a949ec25911025cbc"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[cfg_aliases-0.1.1.sha256sum] = "fd16c4719339c4530435d38e511904438d07cce7950afa3718a84ac36c10e89e"
SRC_URI[cfg_aliases-0.2.1.sha256sum] = "613afe47fcd5fac7ccf1db93babcb082c5994d996f20b8b159f2ad1658eb5724"
SRC_URI[clap-4.5.13.sha256sum] = "0fbb260a053428790f3de475e304ff84cdbc4face759ea7a3e64c1edd938a7fc"
SRC_URI[clap_builder-4.5.13.sha256sum] = "64b17d7ea74e9f833c7dbf2cbe4fb12ff26783eda4782a8975b72f895c9b4d99"
SRC_URI[clap_complete-4.5.12.sha256sum] = "a8670053e87c316345e384ca1f3eba3006fc6355ed8b8a1140d104e109e3df34"
SRC_URI[clap_complete_fig-4.5.2.sha256sum] = "d494102c8ff3951810c72baf96910b980fb065ca5d3101243e6a8dc19747c86b"
SRC_URI[clap_complete_nushell-4.5.3.sha256sum] = "5fe32110e006bccf720f8c9af3fee1ba7db290c724eab61544e1d3295be3a40e"
SRC_URI[clap_derive-4.5.13.sha256sum] = "501d359d5f3dcaf6ecdeee48833ae73ec6e42723a1e52419c79abf9507eec0a0"
SRC_URI[clap_lex-0.7.2.sha256sum] = "1462739cb27611015575c0c11df5df7601141071f07518d56fcc1be504cbec97"
SRC_URI[clap_mangen-0.2.23.sha256sum] = "f17415fd4dfbea46e3274fcd8d368284519b358654772afb700dc2e8d2b24eeb"
SRC_URI[colorchoice-1.0.2.sha256sum] = "d3fd119d74b830634cea2a0f58bbd0d54540518a14397557951e79340abc28c0"
SRC_URI[compact_str-0.7.1.sha256sum] = "f86b9c4c00838774a6d902ef931eff7470720c51d90c2e32cfe15dc304737b3f"
SRC_URI[concat-string-1.0.1.sha256sum] = "7439becb5fafc780b6f4de382b1a7a3e70234afe783854a4702ee8adbb838609"
SRC_URI[core-foundation-sys-0.8.6.sha256sum] = "06ea2b9bc92be3c2baa9334a323ebca2d6f074ff852cd1d7b11064035cd3868f"
SRC_URI[core-foundation-0.9.4.sha256sum] = "91e195e091a93c46f7102ec7818a2aa394e1e1771c3ab4825963fa03e45afb8f"
SRC_URI[crossbeam-deque-0.8.5.sha256sum] = "613f8cc01fe9cf1a3eb3d7f488fd2fa8388403e97039e2f73692932e291a770d"
SRC_URI[crossbeam-epoch-0.9.18.sha256sum] = "5b82ac4a3c2ca9c3460964f020e1402edd5753411d7737aa39c3714ad1b5420e"
SRC_URI[crossbeam-utils-0.8.20.sha256sum] = "22ec99545bb0ed0ea7bb9b8e1e9122ea386ff8a48c0922e43f36d45ab09e0e80"
SRC_URI[crossterm-0.27.0.sha256sum] = "f476fe445d41c9e991fd07515a6f463074b782242ccf4a5b7b1d1012e70824df"
SRC_URI[crossterm_winapi-0.9.1.sha256sum] = "acdd7c62a3665c7f6830a51635d9ac9b23ed385797f70a83bb8bafe9c572ab2b"
SRC_URI[ctrlc-3.4.4.sha256sum] = "672465ae37dc1bc6380a6547a8883d5dd397b0f1faaad4f265726cc7042a5345"
SRC_URI[darling-0.20.10.sha256sum] = "6f63b86c8a8826a49b8c21f08a2d07338eec8d900540f8630dc76284be802989"
SRC_URI[darling_core-0.20.10.sha256sum] = "95133861a8032aaea082871032f5815eb9e98cef03fa916ab4500513994df9e5"
SRC_URI[darling_macro-0.20.10.sha256sum] = "d336a2a514f6ccccaa3e09b02d41d35330c07ddf03a62165fcec10bb561c7806"
SRC_URI[deranged-0.3.11.sha256sum] = "b42b6fa04a440b495c8b04d0e71b707c585f83cb9cb28cf8cd0d976c315e31b4"
SRC_URI[difflib-0.4.0.sha256sum] = "6184e33543162437515c2e2b48714794e37845ec9851711914eec9d308f6ebe8"
SRC_URI[dirs-sys-0.4.1.sha256sum] = "520f05a5cbd335fae5a99ff7a6ab8627577660ee5cfd6a94a6a929b52ff0321c"
SRC_URI[dirs-5.0.1.sha256sum] = "44c45a9d03d6676652bcb5e724c7e988de1acad23a711b5217ab9cbecbec2225"
SRC_URI[doc-comment-0.3.3.sha256sum] = "fea41bba32d969b513997752735605054bc0dfa92b4c56bf1189f2e174be7a10"
SRC_URI[downcast-rs-1.2.1.sha256sum] = "75b325c5dbd37f80359721ad39aca5a29fb04c89279657cffdda8736d0c0b9d2"
SRC_URI[dyn-clone-1.0.17.sha256sum] = "0d6ef0072f8a535281e4876be788938b528e9a1d43900b82c2569af7da799125"
SRC_URI[either-1.13.0.sha256sum] = "60b1af1c220855b6ceac025d3f6ecdd2b7c4894bfe9cd9bda4fbb4bc7c0d4cf0"
SRC_URI[enum-as-inner-0.6.0.sha256sum] = "5ffccbb6966c05b32ef8fbac435df276c4ae4d3dc55a8cd0eb9745e6c12f546a"
SRC_URI[equivalent-1.0.1.sha256sum] = "5443807d6dff69373d433ab9ef5378ad8df50ca6298caf15de6e52e24aaf54d5"
SRC_URI[errno-0.3.9.sha256sum] = "534c5cf6194dfab3db3242765c03bbe257cf92f22b38f6bc0c58d59108a820ba"
SRC_URI[fern-0.6.2.sha256sum] = "d9f0c14694cbd524c8720dd69b0e3179344f04ebb5f90f2e4a440c6ea3b2f1ee"
SRC_URI[filedescriptor-0.8.2.sha256sum] = "7199d965852c3bac31f779ef99cbb4537f80e952e2d6aa0ffeb30cce00f4f46e"
SRC_URI[float-cmp-0.9.0.sha256sum] = "98de4bbd547a563b716d8dfa9aad1cb19bfab00f4fa09a6a4ed21dbcf44ce9c4"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[getrandom-0.2.15.sha256sum] = "c4567c8db10ae91089c99af84c68c38da3ec2f087c3f82960bcdbf3656b6f4d7"
SRC_URI[gimli-0.29.0.sha256sum] = "40ecd4077b5ae9fd2e9e169b102c6c330d0605168eb0e8bf79952b256dbefffd"
SRC_URI[hashbrown-0.14.5.sha256sum] = "e5274423e17b7c9fc20b6e7e208532f9b19825d82dfd615708b70edd83df41f1"
SRC_URI[heck-0.4.1.sha256sum] = "95505c38b4572b2d910cecb0281560f54b440a19336cbbcb27bf6ce6adc6f5a8"
SRC_URI[heck-0.5.0.sha256sum] = "2304e00983f87ffb38b55b444b5e3b60a884b5d30c0fca7d82fe33449bbe55ea"
SRC_URI[humantime-2.1.0.sha256sum] = "9a3a5bfb195931eeb336b2a7b4d761daec841b97f947d34394601737a7bba5e4"
SRC_URI[ident_case-1.0.1.sha256sum] = "b9e0384b61958566e926dc50660321d12159025e767c18e043daf26b70104c39"
SRC_URI[indexmap-2.3.0.sha256sum] = "de3fc2e30ba82dd1b3911c8de1ffc143c74a914a14e99514d7637e3099df5ea0"
SRC_URI[indoc-2.0.5.sha256sum] = "b248f5224d1d606005e02c97f5aa4e88eeb230488bcc03bc9ca4d7991399f2b5"
SRC_URI[ioctl-rs-0.1.6.sha256sum] = "f7970510895cee30b3e9128319f2cefd4bde883a39f38baa279567ba3a7eb97d"
SRC_URI[is_terminal_polyfill-1.70.1.sha256sum] = "7943c866cc5cd64cbc25b2e01621d07fa8eb2a1a23160ee81ce38704e97b8ecf"
SRC_URI[itertools-0.13.0.sha256sum] = "413ee7dfc52ee1a4949ceeb7dbc8a33f2d6c088194d9f922fb8318faf1f01186"
SRC_URI[itoa-1.0.11.sha256sum] = "49f1f14873335454500d59611f1cf4a4b0f786f9ac11f4312a78e4cf2566695b"
SRC_URI[lazy_static-1.5.0.sha256sum] = "bbd2bcb4c963f2ddae06a2efc7e9f3591312473c50c6685e1f298068316e66fe"
SRC_URI[lazycell-1.3.0.sha256sum] = "830d08ce1d1d941e6b30645f1a0eb5643013d835ce3779a5fc208261dbe10f55"
SRC_URI[libc-0.2.155.sha256sum] = "97b3888a4aecf77e811145cadf6eef5901f4782c53886191b2f693f24761847c"
SRC_URI[libloading-0.8.5.sha256sum] = "4979f22fdb869068da03c9f7528f8297c6fd2606bc3a4affe42e6a823fdb8da4"
SRC_URI[libredox-0.1.3.sha256sum] = "c0ff37bd590ca25063e35af745c343cb7a0271906fb7b37e4813e8f79f00268d"
SRC_URI[linux-raw-sys-0.4.14.sha256sum] = "78b3ae25bc7c8c38cec158d1f2757ee79e9b3740fbc7ccf0e59e4b08d793fa89"
SRC_URI[lock_api-0.4.12.sha256sum] = "07af8b9cdd281b7915f413fa73f29ebd5d55d0d3f0155584dade1ff18cea1b17"
SRC_URI[log-0.4.22.sha256sum] = "a7a70ba024b9dc04c27ea2f0c0548feb474ec5c54bba33a7f72f873a39d07b24"
SRC_URI[lru-0.12.4.sha256sum] = "37ee39891760e7d94734f6f63fedc29a2e4a152f836120753a72503f09fcf904"
SRC_URI[mach2-0.4.2.sha256sum] = "19b955cdeb2a02b9117f121ce63aa52d08ade45de53e48fe6a38b39c10f6f709"
SRC_URI[memchr-2.7.4.sha256sum] = "78ca9ab1a0babb1e7d5695e3530886289c18cf2f87ec19a575a0abdce112e3a3"
SRC_URI[memoffset-0.6.5.sha256sum] = "5aa361d4faea93603064a027415f07bd8e1d5c88c9fbf68bf56a285428fd79ce"
SRC_URI[miniz_oxide-0.7.4.sha256sum] = "b8a240ddb74feaf34a79a7add65a741f3167852fba007066dcac1ca548d89c08"
SRC_URI[mio-0.8.11.sha256sum] = "a4a650543ca06a924e8b371db273b2756685faae30f8487da1b56505a8f78b0c"
SRC_URI[nix-0.25.1.sha256sum] = "f346ff70e7dbfd675fe90590b92d59ef2de15a8779ae305ebcbfd3f0caf59be4"
SRC_URI[nix-0.28.0.sha256sum] = "ab2156c4fce2f8df6c499cc1c763e4394b7482525bf2a9701c9d79d215f519e4"
SRC_URI[nix-0.29.0.sha256sum] = "71e2746dc3a24dd78b3cfcb7be93368c6de9963d30f43a6a73998a9cf4b17b46"
SRC_URI[normalize-line-endings-0.3.0.sha256sum] = "61807f77802ff30975e01f4f071c8ba10c022052f98b3294119f3e615d13e5be"
SRC_URI[ntapi-0.4.1.sha256sum] = "e8a3895c6391c39d7fe7ebc444a87eb2991b2a0bc718fdabd071eec617fc68e4"
SRC_URI[num-conv-0.1.0.sha256sum] = "51d515d32fb182ee37cda2ccdcb92950d6a3c2893aa280e540671c2cd0f3b1d9"
SRC_URI[num-traits-0.2.19.sha256sum] = "071dfc062690e90b734c0b2273ce72ad0ffa95f0c74596bc250dcfd960262841"
SRC_URI[num_threads-0.1.7.sha256sum] = "5c7398b9c8b70908f6371f47ed36737907c87c52af34c268fed0bf0ceb92ead9"
SRC_URI[nvml-wrapper-sys-0.8.0.sha256sum] = "698d45156f28781a4e79652b6ebe2eaa0589057d588d3aec1333f6466f13fcb5"
SRC_URI[nvml-wrapper-0.10.0.sha256sum] = "0c9bff0aa1d48904a1385ea2a8b97576fbdcbc9a3cfccd0d31fe978e1c4038c5"
SRC_URI[object-0.36.2.sha256sum] = "3f203fa8daa7bb185f760ae12bd8e097f63d17041dcdcaf675ac54cdf863170e"
SRC_URI[once_cell-1.19.0.sha256sum] = "3fdb12b2476b595f9358c5161aa467c2438859caa136dec86c26fdd2efe17b92"
SRC_URI[option-ext-0.2.0.sha256sum] = "04744f49eae99ab78e0d5c0b603ab218f515ea8cfe5a456d7629ad883a3b6e7d"
SRC_URI[parking_lot-0.12.3.sha256sum] = "f1bf18183cf54e8d6059647fc3063646a1801cf30896933ec2311622cc4b9a27"
SRC_URI[parking_lot_core-0.9.10.sha256sum] = "1e401f977ab385c9e4e3ab30627d6f26d00e2c73eef317493c4ec6d468726cf8"
SRC_URI[paste-1.0.15.sha256sum] = "57c0d7b74b563b49d38dae00a0c37d4d6de9b432382b2892f0574ddcae73fd0a"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[plist-1.7.0.sha256sum] = "42cf17e9a1800f5f396bc67d193dc9411b59012a5876445ef450d449881e1016"
SRC_URI[portable-pty-0.8.1.sha256sum] = "806ee80c2a03dbe1a9fb9534f8d19e4c0546b790cde8fd1fea9d6390644cb0be"
SRC_URI[powerfmt-0.2.0.sha256sum] = "439ee305def115ba05938db6eb1644ff94165c5ab5e9420d1c1bcedbba909391"
SRC_URI[predicates-core-1.0.8.sha256sum] = "ae8177bee8e75d6846599c6b9ff679ed51e882816914eec639944d7c9aa11931"
SRC_URI[predicates-tree-1.0.11.sha256sum] = "41b740d195ed3166cd147c8047ec98db0e22ec019eb8eeb76d343b795304fb13"
SRC_URI[predicates-3.1.2.sha256sum] = "7e9086cc7640c29a356d1a29fd134380bee9d8f79a17410aa76e7ad295f42c97"
SRC_URI[proc-macro2-1.0.86.sha256sum] = "5e719e8df665df0d1c8fbfd238015744736151d4445ec0836b8e628aae103b77"
SRC_URI[quick-xml-0.32.0.sha256sum] = "1d3a6e5838b60e0e8fa7a43f22ade549a37d61f8bdbe636d0d7816191de969c2"
SRC_URI[quote-1.0.36.sha256sum] = "0fa76aaf39101c457836aec0ce2316dbdc3ab723cdda1c6bd4e6ad4208acaca7"
SRC_URI[ratatui-0.27.0.sha256sum] = "d16546c5b5962abf8ce6e2881e722b4e0ae3b6f1a08a26ae3573c55853ca68d3"
SRC_URI[rayon-core-1.12.1.sha256sum] = "1465873a3dfdaa8ae7cb14b4383657caab0b3e8a0aa9ae8e04b044854c8dfce2"
SRC_URI[rayon-1.10.0.sha256sum] = "b418a60154510ca1a002a752ca9714984e21e4241e804d32555251faf8b78ffa"
SRC_URI[redox_syscall-0.5.3.sha256sum] = "2a908a6e00f1fdd0dfd9c0eb08ce85126f6d8bbda50017e74bc4a4b7d4a926a4"
SRC_URI[redox_users-0.4.5.sha256sum] = "bd283d9651eeda4b2a83a43c1c91b266c40fd76ecd39a50a8c630ae69dc72891"
SRC_URI[regex-automata-0.4.7.sha256sum] = "38caf58cc5ef2fed281f89292ef23f6365465ed9a41b7a7754eb4e26496c92df"
SRC_URI[regex-syntax-0.8.4.sha256sum] = "7a66a03ae7c801facd77a29370b4faec201768915ac14a721ba36f20bc9c209b"
SRC_URI[regex-1.10.5.sha256sum] = "b91213439dad192326a0d7c6ee3955910425f441d7038e0d6933b0aec5c4517f"
SRC_URI[roff-0.2.2.sha256sum] = "88f8660c1ff60292143c98d08fc6e2f654d722db50410e3f3797d40baaf9d8f3"
SRC_URI[rustc-demangle-0.1.24.sha256sum] = "719b953e2095829ee67db738b3bfa9fa368c94900df327b3f07fe6e794d2fe1f"
SRC_URI[rustix-0.38.34.sha256sum] = "70dc5ec042f7a43c4a73241207cecc9873a06d45debb38b329f8541d85c2730f"
SRC_URI[rustversion-1.0.17.sha256sum] = "955d28af4278de8121b7ebeb796b6a45735dc01436d898801014aced2773a3d6"
SRC_URI[ryu-1.0.18.sha256sum] = "f3cb5ba0dc43242ce17de99c180e96db90b235b8a9fdc9543c96d2209116bd9f"
SRC_URI[same-file-1.0.6.sha256sum] = "93fc1dc3aaa9bfed95e02e6eadabb4baf7e3078b0bd1b4d7b6b0b68378900502"
SRC_URI[schemars-0.8.21.sha256sum] = "09c024468a378b7e36765cd36702b7a90cc3cba11654f6685c8f233408e89e92"
SRC_URI[schemars_derive-0.8.21.sha256sum] = "b1eee588578aff73f856ab961cd2f79e36bc45d7ded33a7562adba4667aecc0e"
SRC_URI[scopeguard-1.2.0.sha256sum] = "94143f37725109f92c262ed2cf5e59bce7498c01bcc1502d7b9afe439a4e9f49"
SRC_URI[serde-1.0.204.sha256sum] = "bc76f558e0cbb2a839d37354c575f1dc3fdc6546b5be373ba43d95f231bf7c12"
SRC_URI[serde_derive-1.0.204.sha256sum] = "e0cd7e117be63d3c3678776753929474f3b04a43a080c744d6b0ae2a8c28e222"
SRC_URI[serde_derive_internals-0.29.1.sha256sum] = "18d26a20a969b9e3fdf2fc2d9f21eda6c40e2de84c9408bb5d3b05d499aae711"
SRC_URI[serde_json-1.0.121.sha256sum] = "4ab380d7d9f22ef3f21ad3e6c1ebe8e4fc7a2000ccba2e4d71fc96f15b2cb609"
SRC_URI[serde_spanned-0.6.7.sha256sum] = "eb5b1b31579f3811bf615c144393417496f152e12ac8b7663bf664f4a815306d"
SRC_URI[serial-core-0.4.0.sha256sum] = "3f46209b345401737ae2125fe5b19a77acce90cd53e1658cda928e4fe9a64581"
SRC_URI[serial-unix-0.4.0.sha256sum] = "f03fbca4c9d866e24a459cbca71283f545a37f8e3e002ad8c70593871453cab7"
SRC_URI[serial-windows-0.4.0.sha256sum] = "15c6d3b776267a75d31bbdfd5d36c0ca051251caafc285827052bc53bcdc8162"
SRC_URI[serial-0.4.0.sha256sum] = "a1237a96570fc377c13baa1b88c7589ab66edced652e43ffb17088f003db3e86"
SRC_URI[shared_library-0.1.9.sha256sum] = "5a9e7e0f2bfae24d8a5b5a66c5b257a83c7412304311512a0c054cd5e619da11"
SRC_URI[shell-words-1.1.0.sha256sum] = "24188a676b6ae68c3b2cb3a01be17fbf7240ce009799bb56d5b1409051e78fde"
SRC_URI[signal-hook-mio-0.2.4.sha256sum] = "34db1a06d485c9142248b7a054f034b349b212551f3dfd19c94d45a754a217cd"
SRC_URI[signal-hook-registry-1.4.2.sha256sum] = "a9e9e0b4211b72e7b8b6e85c807d36c212bdb33ea8587f7569562a84df5465b1"
SRC_URI[signal-hook-0.3.17.sha256sum] = "8621587d4798caf8eb44879d42e56b9a93ea5dcd315a6487c357130095b62801"
SRC_URI[smallvec-1.13.2.sha256sum] = "3c5e1a9a646d36c3599cd173a41282daf47c44583ad367b8e6837255952e5c67"
SRC_URI[stability-0.2.1.sha256sum] = "d904e7009df136af5297832a3ace3370cd14ff1546a232f4f185036c2736fcac"
SRC_URI[starship-battery-0.9.1.sha256sum] = "da7915746794358b8f649d3032c8ce150f55b7a0cd41951f170162e82e6cf43f"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[strsim-0.11.1.sha256sum] = "7da8b5736845d9f2fcb837ea5d9e2628564b3b043a70948a3f0b778838c5fb4f"
SRC_URI[strum-0.26.3.sha256sum] = "8fec0f0aef304996cf250b31b5a10dee7980c85da9d759361292b8bca5a18f06"
SRC_URI[strum_macros-0.26.4.sha256sum] = "4c6bee85a5a24955dc440386795aa378cd9cf82acd5f764469152d2270e581be"
SRC_URI[syn-2.0.72.sha256sum] = "dc4b9b9bf2add8093d3f2c0204471e951b2285580335de42f9d2534f3ae7a8af"
SRC_URI[sysctl-0.5.5.sha256sum] = "ec7dddc5f0fee506baf8b9fdb989e242f17e4b11c61dfbb0635b705217199eea"
SRC_URI[sysinfo-0.30.13.sha256sum] = "0a5b4ddaee55fb2bea2bf0e5000747e5f5c0de765e5a5ff87f4cd106439f4bb3"
SRC_URI[terminal_size-0.3.0.sha256sum] = "21bebf2b7c9e0a515f6e0f8c51dc0f8e4696391e6f1ff30379559f8365fb0df7"
SRC_URI[termios-0.2.2.sha256sum] = "d5d9cf598a6d7ce700a4e6a9199da127e6819a61e64b68609683cc9a01b5683a"
SRC_URI[termtree-0.4.1.sha256sum] = "3369f5ac52d5eb6ab48c6b4ffdc8efbcad6b89c765749064ba298f2c68a16a76"
SRC_URI[thiserror-impl-1.0.63.sha256sum] = "a4558b58466b9ad7ca0f102865eccc95938dca1a74a856f2b57b6629050da261"
SRC_URI[thiserror-1.0.63.sha256sum] = "c0342370b38b6a11b6cc11d6a805569958d54cfa061a29969c3b5ce2ea405724"
SRC_URI[time-core-0.1.2.sha256sum] = "ef927ca75afb808a4d64dd374f00a2adf8d0fcff8e7b184af886c3c87ec4a3f3"
SRC_URI[time-macros-0.2.18.sha256sum] = "3f252a68540fde3a3877aeea552b832b40ab9a69e318efd078774a01ddee1ccf"
SRC_URI[time-0.3.36.sha256sum] = "5dfd88e563464686c916c7e46e623e520ddc6d79fa6641390f2e3fa86e83e885"
SRC_URI[toml_datetime-0.6.8.sha256sum] = "0dd7358ecb8fc2f8d014bf86f6f638ce72ba252a2c3a2572f2a795f1d23efb41"
SRC_URI[toml_edit-0.22.20.sha256sum] = "583c44c02ad26b0c3f3066fe629275e50627026c51ac2e595cca4c230ce1ce1d"
SRC_URI[typenum-1.17.0.sha256sum] = "42ff0bf0c66b8238c6f3b578df37d0b7848e55df8577b3f74f92a69acceeb825"
SRC_URI[unicode-ellipsis-0.2.0.sha256sum] = "924ab5b8c3fed9966b8cde2dc7169146331cba3dacba97cbd0e8866e7cfd4dff"
SRC_URI[unicode-ident-1.0.12.sha256sum] = "3354b9ac3fae1ff6755cb6db53683adb661634f67557942dea4facebec0fee4b"
SRC_URI[unicode-segmentation-1.11.0.sha256sum] = "d4c87d22b6e3f4a18d4d40ef354e97c90fcb14dd91d7dc0aa9d8a1172ebf7202"
SRC_URI[unicode-truncate-1.1.0.sha256sum] = "b3644627a5af5fa321c95b9b235a72fd24cd29c648c2c379431e6628655627bf"
SRC_URI[unicode-width-0.1.13.sha256sum] = "0336d538f7abc86d282a4189614dfaa90810dfc2c6f6427eaf88e16311dd225d"
SRC_URI[uom-0.36.0.sha256sum] = "ffd36e5350a65d112584053ee91843955826bf9e56ec0d1351214e01f6d7cd9c"
SRC_URI[utf8parse-0.2.2.sha256sum] = "06abde3611657adf66d383f00b093d7faecc7fa57071cce2578660c9f1010821"
SRC_URI[version_check-0.9.5.sha256sum] = "0b928f33d975fc6ad9f86c8f283853ad26bdd5b10b7f1542aa2fa15e2289105a"
SRC_URI[wait-timeout-0.2.0.sha256sum] = "9f200f5b12eb75f8c1ed65abd4b2db8a6e1b138a20de009dacee265a2498f3f6"
SRC_URI[walkdir-2.5.0.sha256sum] = "29790946404f91d9c5d06f9874efddea1dc06c5efe94541a7d6863108e3a5e4b"
SRC_URI[wasi-0.11.0+wasi-snapshot-preview1.sha256sum] = "9c8d87e72b64a3b4db28d11ce29237c246188f4f51057d65a7eab63b7987e423"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.8.sha256sum] = "4d4cc384e1e73b93bafa6fb4f1df8c41695c8a91cf9c4c64358067d15a7b6c6b"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-core-0.52.0.sha256sum] = "33ab640c8d7e35bf8ba19b884ba838ceb4fba93a4e8c65a9059d08afcfc683d9"
SRC_URI[windows-core-0.58.0.sha256sum] = "6ba6d44ec8c2591c134257ce647b7ea6b20335bf6379a27dac5f1641fcf59f99"
SRC_URI[windows-implement-0.58.0.sha256sum] = "2bbd5b46c938e506ecbce286b6628a02171d56153ba733b6c741fc627ec9579b"
SRC_URI[windows-interface-0.58.0.sha256sum] = "053c4c462dc91d3b1504c6fe5a726dd15e216ba718e84a0e46a88fbe5ded3515"
SRC_URI[windows-result-0.2.0.sha256sum] = "1d1043d8214f791817bab27572aaa8af63732e11bf84aa21a45a78d6c317ae0e"
SRC_URI[windows-strings-0.1.0.sha256sum] = "4cd9b125c486025df0eabcb585e62173c6c9eddcec5d117d3b6e8c30e2ee4d10"
SRC_URI[windows-sys-0.48.0.sha256sum] = "677d2418bec65e3338edb076e806bc1ec15693c5d0104683f2efe857f61056a9"
SRC_URI[windows-sys-0.52.0.sha256sum] = "282be5f36a8ce781fad8c8ae18fa3f9beff57ec1b52cb3de0789201425d9a33d"
SRC_URI[windows-targets-0.48.5.sha256sum] = "9a2fa6e2155d7247be68c096456083145c183cbbbc2764150dda45a87197940c"
SRC_URI[windows-targets-0.52.6.sha256sum] = "9b724f72796e036ab90c1021d4780d4d3d648aca59e491e6b98e725b84e99973"
SRC_URI[windows-0.52.0.sha256sum] = "e48a53791691ab099e5e2ad123536d0fff50652600abaf43bbf952894110d0be"
SRC_URI[windows-0.58.0.sha256sum] = "dd04d41d93c4992d421894c18c8b43496aa748dd4c081bac0dc93eb0489272b6"
SRC_URI[windows_aarch64_gnullvm-0.48.5.sha256sum] = "2b38e32f0abccf9987a4e3079dfb67dcd799fb61361e53e2882c3cbaf0d905d8"
SRC_URI[windows_aarch64_gnullvm-0.52.6.sha256sum] = "32a4622180e7a0ec044bb555404c800bc9fd9ec262ec147edd5989ccd0c02cd3"
SRC_URI[windows_aarch64_msvc-0.48.5.sha256sum] = "dc35310971f3b2dbbf3f0690a219f40e2d9afcf64f9ab7cc1be722937c26b4bc"
SRC_URI[windows_aarch64_msvc-0.52.6.sha256sum] = "09ec2a7bb152e2252b53fa7803150007879548bc709c039df7627cabbd05d469"
SRC_URI[windows_i686_gnu-0.48.5.sha256sum] = "a75915e7def60c94dcef72200b9a8e58e5091744960da64ec734a6c6e9b3743e"
SRC_URI[windows_i686_gnu-0.52.6.sha256sum] = "8e9b5ad5ab802e97eb8e295ac6720e509ee4c243f69d781394014ebfe8bbfa0b"
SRC_URI[windows_i686_gnullvm-0.52.6.sha256sum] = "0eee52d38c090b3caa76c563b86c3a4bd71ef1a819287c19d586d7334ae8ed66"
SRC_URI[windows_i686_msvc-0.48.5.sha256sum] = "8f55c233f70c4b27f66c523580f78f1004e8b5a8b659e05a4eb49d4166cca406"
SRC_URI[windows_i686_msvc-0.52.6.sha256sum] = "240948bc05c5e7c6dabba28bf89d89ffce3e303022809e73deaefe4f6ec56c66"
SRC_URI[windows_x86_64_gnu-0.48.5.sha256sum] = "53d40abd2583d23e4718fddf1ebec84dbff8381c07cae67ff7768bbf19c6718e"
SRC_URI[windows_x86_64_gnu-0.52.6.sha256sum] = "147a5c80aabfbf0c7d901cb5895d1de30ef2907eb21fbbab29ca94c5b08b1a78"
SRC_URI[windows_x86_64_gnullvm-0.48.5.sha256sum] = "0b7b52767868a23d5bab768e390dc5f5c55825b6d30b86c844ff2dc7414044cc"
SRC_URI[windows_x86_64_gnullvm-0.52.6.sha256sum] = "24d5b23dc417412679681396f2b49f3de8c1473deb516bd34410872eff51ed0d"
SRC_URI[windows_x86_64_msvc-0.48.5.sha256sum] = "ed94fce61571a4006852b7389a063ab983c02eb1bb37b47f8272ce92d06d9538"
SRC_URI[windows_x86_64_msvc-0.52.6.sha256sum] = "589f6da84c646204747d1270a2a5661ea66ed1cced2631d546fdfb155959f9ec"
SRC_URI[winnow-0.6.18.sha256sum] = "68a9bda4691f099d435ad181000724da8e5899daa10713c2d432552b9ccd3a6f"
SRC_URI[winreg-0.10.1.sha256sum] = "80d0f4e272c85def139476380b12f9ac60926689dd2e01d4923222f40580869d"
SRC_URI[wrapcenum-derive-0.4.1.sha256sum] = "a76ff259533532054cfbaefb115c613203c73707017459206380f03b3b3f266e"
SRC_URI[zerocopy-derive-0.7.35.sha256sum] = "fa4f8080344d4671fb4e831a13ad1e68092748387dfc4f55e356242fae12ce3e"
SRC_URI[zerocopy-0.7.35.sha256sum] = "1b9b4fd18abc82b8136838da5d50bae7bdea537c574d8dc1a34ed098d6c166f0"

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=5d45cffa3a75da17d285cc60c0c458cc \
"

SUMMARY = "A customizable cross-platform graphical process/system monitor for the terminal. Supports Linux, macOS, and Windows."
HOMEPAGE = "https://github.com/ClementTsang/bottom"
LICENSE = "MIT"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include bottom-${PV}.inc
include bottom.inc
