inherit cargo

DEFAULT_PREFERENCE = "-1"

SRC_URI += "git://github.com/linux-automation/tacd.git;protocol=https;branch=main"
SRCREV = "16391c2af5798f9ddcef36f3e26c0510e80a538a"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV = "0.1.0+git${SRCPV}"

SRC_URI += " \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/aead/0.3.2 \
    crate://crates.io/aes-gcm/0.8.0 \
    crate://crates.io/aes-soft/0.6.4 \
    crate://crates.io/aes/0.6.0 \
    crate://crates.io/aesni/0.10.0 \
    crate://crates.io/aho-corasick/1.0.1 \
    crate://crates.io/android_system_properties/0.1.5 \
    crate://crates.io/anyhow/1.0.71 \
    crate://crates.io/arrayref/0.3.7 \
    crate://crates.io/arrayvec/0.5.2 \
    crate://crates.io/async-attributes/1.1.2 \
    crate://crates.io/async-broadcast/0.5.1 \
    crate://crates.io/async-channel/1.8.0 \
    crate://crates.io/async-dup/1.2.2 \
    crate://crates.io/async-executor/1.5.1 \
    crate://crates.io/async-fs/1.6.0 \
    crate://crates.io/async-global-executor/2.3.1 \
    crate://crates.io/async-h1/2.3.3 \
    crate://crates.io/async-io/1.13.0 \
    crate://crates.io/async-lock/2.7.0 \
    crate://crates.io/async-process/1.7.0 \
    crate://crates.io/async-recursion/1.0.4 \
    crate://crates.io/async-session/2.0.1 \
    crate://crates.io/async-sse/4.1.0 \
    crate://crates.io/async-sse/5.1.0 \
    crate://crates.io/async-std/1.12.0 \
    crate://crates.io/async-task/4.4.0 \
    crate://crates.io/async-trait/0.1.68 \
    crate://crates.io/async-tungstenite/0.20.0 \
    crate://crates.io/atomic-waker/1.1.1 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/az/1.2.1 \
    crate://crates.io/base-x/0.2.11 \
    crate://crates.io/base64/0.12.3 \
    crate://crates.io/base64/0.13.1 \
    crate://crates.io/base64/0.21.0 \
    crate://crates.io/bincode/1.3.3 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bitvec/1.0.1 \
    crate://crates.io/blake3/0.3.8 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/block-buffer/0.9.0 \
    crate://crates.io/blocking/1.3.1 \
    crate://crates.io/build-env/0.3.1 \
    crate://crates.io/bumpalo/3.12.2 \
    crate://crates.io/byteorder/1.4.3 \
    crate://crates.io/bytes/1.4.0 \
    crate://crates.io/cc/1.0.79 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/chrono/0.4.24 \
    crate://crates.io/cipher/0.2.5 \
    crate://crates.io/codespan-reporting/0.11.1 \
    crate://crates.io/concurrent-queue/2.2.0 \
    crate://crates.io/config/0.10.1 \
    crate://crates.io/const_fn/0.4.9 \
    crate://crates.io/constant_time_eq/0.1.5 \
    crate://crates.io/cookie/0.14.4 \
    crate://crates.io/core-foundation-sys/0.8.4 \
    crate://crates.io/cpufeatures/0.2.7 \
    crate://crates.io/cpuid-bool/0.2.0 \
    crate://crates.io/crc32fast/1.3.2 \
    crate://crates.io/crossbeam-queue/0.3.8 \
    crate://crates.io/crossbeam-utils/0.8.15 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/crypto-mac/0.10.1 \
    crate://crates.io/crypto-mac/0.8.0 \
    crate://crates.io/cstr-argument/0.1.2 \
    crate://crates.io/ctor/0.1.26 \
    crate://crates.io/ctr/0.6.0 \
    crate://crates.io/cxx-build/1.0.94 \
    crate://crates.io/cxx/1.0.94 \
    crate://crates.io/cxxbridge-flags/1.0.94 \
    crate://crates.io/cxxbridge-macro/1.0.94 \
    crate://crates.io/dashmap/5.4.0 \
    crate://crates.io/deadpool/0.7.0 \
    crate://crates.io/derivative/2.2.0 \
    crate://crates.io/digest/0.10.6 \
    crate://crates.io/digest/0.9.0 \
    crate://crates.io/discard/1.0.4 \
    crate://crates.io/embedded-graphics-core/0.3.3 \
    crate://crates.io/embedded-graphics/0.7.1 \
    crate://crates.io/enumflags2/0.7.7 \
    crate://crates.io/enumflags2_derive/0.7.7 \
    crate://crates.io/env_logger/0.10.0 \
    crate://crates.io/erased-serde/0.3.25 \
    crate://crates.io/errno-dragonfly/0.1.2 \
    crate://crates.io/errno/0.2.8 \
    crate://crates.io/errno/0.3.1 \
    crate://crates.io/evdev/0.12.1 \
    crate://crates.io/event-listener/2.5.3 \
    crate://crates.io/fastrand/1.9.0 \
    crate://crates.io/fdeflate/0.3.0 \
    crate://crates.io/femme/2.2.1 \
    crate://crates.io/flate2/1.0.26 \
    crate://crates.io/float-cmp/0.8.0 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/foreign-types-macros/0.2.3 \
    crate://crates.io/foreign-types-shared/0.3.1 \
    crate://crates.io/foreign-types/0.5.0 \
    crate://crates.io/form_urlencoded/1.1.0 \
    crate://crates.io/framebuffer/0.3.1 \
    crate://crates.io/funty/2.0.0 \
    crate://crates.io/futures-channel/0.3.28 \
    crate://crates.io/futures-core/0.3.28 \
    crate://crates.io/futures-executor/0.3.28 \
    crate://crates.io/futures-io/0.3.28 \
    crate://crates.io/futures-lite/1.13.0 \
    crate://crates.io/futures-macro/0.3.28 \
    crate://crates.io/futures-sink/0.3.28 \
    crate://crates.io/futures-task/0.3.28 \
    crate://crates.io/futures-util/0.3.28 \
    crate://crates.io/futures/0.3.28 \
    crate://crates.io/generic-array/0.14.7 \
    crate://crates.io/getrandom/0.1.16 \
    crate://crates.io/getrandom/0.2.9 \
    crate://crates.io/ghash/0.3.1 \
    crate://crates.io/gloo-timers/0.2.6 \
    crate://crates.io/gpio-cdev/0.5.1 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/hermit-abi/0.2.6 \
    crate://crates.io/hermit-abi/0.3.1 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/hkdf/0.10.0 \
    crate://crates.io/hmac/0.10.1 \
    crate://crates.io/hmac/0.8.1 \
    crate://crates.io/html-escape/0.2.13 \
    crate://crates.io/http-client/6.5.3 \
    crate://crates.io/http-types/2.12.0 \
    crate://crates.io/http/0.2.9 \
    crate://crates.io/httparse/1.8.0 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/iana-time-zone-haiku/0.1.1 \
    crate://crates.io/iana-time-zone/0.1.56 \
    crate://crates.io/idna/0.3.0 \
    crate://crates.io/indexmap/1.9.3 \
    crate://crates.io/industrial-io/0.5.2 \
    crate://crates.io/infer/0.2.3 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/io-lifetimes/1.0.10 \
    crate://crates.io/is-terminal/0.4.7 \
    crate://crates.io/itoa/1.0.6 \
    crate://crates.io/js-sys/0.3.62 \
    crate://crates.io/kv-log-macro/1.0.7 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/lexical-core/0.7.6 \
    crate://crates.io/libc/0.2.144 \
    crate://crates.io/libiio-sys/0.3.1 \
    crate://crates.io/libsystemd-sys/0.9.3 \
    crate://crates.io/link-cplusplus/1.0.8 \
    crate://crates.io/linux-raw-sys/0.3.7 \
    crate://crates.io/lock_api/0.4.9 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/memmap/0.7.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/memoffset/0.7.1 \
    crate://crates.io/micromath/1.1.1 \
    crate://crates.io/mime/0.3.17 \
    crate://crates.io/mime_guess/2.0.4 \
    crate://crates.io/miniz_oxide/0.7.1 \
    crate://crates.io/mqtt-protocol/0.11.2 \
    crate://crates.io/nix/0.23.2 \
    crate://crates.io/nix/0.26.2 \
    crate://crates.io/nom/5.1.3 \
    crate://crates.io/num-integer/0.1.45 \
    crate://crates.io/num-traits/0.2.15 \
    crate://crates.io/num_cpus/1.15.0 \
    crate://crates.io/numtoa/0.2.4 \
    crate://crates.io/once_cell/1.17.1 \
    crate://crates.io/opaque-debug/0.3.0 \
    crate://crates.io/ordered-stream/0.2.0 \
    crate://crates.io/parking/2.1.0 \
    crate://crates.io/parking_lot_core/0.9.7 \
    crate://crates.io/percent-encoding/2.2.0 \
    crate://crates.io/pin-project-internal/1.0.12 \
    crate://crates.io/pin-project-lite/0.1.12 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-project/1.0.12 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkg-config/0.3.27 \
    crate://crates.io/png/0.17.8 \
    crate://crates.io/polling/2.8.0 \
    crate://crates.io/polyval/0.4.5 \
    crate://crates.io/ppv-lite86/0.2.17 \
    crate://crates.io/proc-macro-crate/1.3.1 \
    crate://crates.io/proc-macro-hack/0.5.20+deprecated \
    crate://crates.io/proc-macro2/1.0.56 \
    crate://crates.io/quote/1.0.27 \
    crate://crates.io/radium/0.7.0 \
    crate://crates.io/rand/0.7.3 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.2.2 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.5.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/rand_hc/0.2.0 \
    crate://crates.io/redox_syscall/0.2.16 \
    crate://crates.io/redox_syscall/0.3.5 \
    crate://crates.io/regex-syntax/0.7.1 \
    crate://crates.io/regex/1.8.1 \
    crate://crates.io/route-recognizer/0.2.0 \
    crate://crates.io/rustc_version/0.2.3 \
    crate://crates.io/rustix/0.37.19 \
    crate://crates.io/rustversion/1.0.12 \
    crate://crates.io/ryu/1.0.13 \
    crate://crates.io/scopeguard/1.1.0 \
    crate://crates.io/scratch/1.0.5 \
    crate://crates.io/semver-parser/0.7.0 \
    crate://crates.io/semver/0.9.0 \
    crate://crates.io/serde/1.0.162 \
    crate://crates.io/serde_derive/1.0.162 \
    crate://crates.io/serde_fmt/1.0.3 \
    crate://crates.io/serde_json/1.0.96 \
    crate://crates.io/serde_qs/0.8.5 \
    crate://crates.io/serde_repr/0.1.12 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/serde_yaml/0.9.21 \
    crate://crates.io/sha-1/0.10.1 \
    crate://crates.io/sha1/0.10.5 \
    crate://crates.io/sha1/0.6.1 \
    crate://crates.io/sha1_smol/1.0.0 \
    crate://crates.io/sha2/0.9.9 \
    crate://crates.io/signal-hook-registry/1.4.1 \
    crate://crates.io/signal-hook/0.3.15 \
    crate://crates.io/simd-adler32/0.3.5 \
    crate://crates.io/simple-mutex/1.1.5 \
    crate://crates.io/slab/0.4.8 \
    crate://crates.io/smallvec/1.10.0 \
    crate://crates.io/socket2/0.4.9 \
    crate://crates.io/standback/0.2.17 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/stdweb-derive/0.5.3 \
    crate://crates.io/stdweb-internal-macros/0.2.9 \
    crate://crates.io/stdweb-internal-runtime/0.1.5 \
    crate://crates.io/stdweb/0.4.20 \
    crate://crates.io/subtle/2.4.1 \
    crate://crates.io/surf/2.3.2 \
    crate://crates.io/sval/1.0.0-alpha.5 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/syn/2.0.15 \
    crate://crates.io/sysfs-class/0.1.3 \
    crate://crates.io/systemd/0.10.0 \
    crate://crates.io/tap/1.0.1 \
    crate://crates.io/tempfile/3.5.0 \
    crate://crates.io/termcolor/1.2.0 \
    crate://crates.io/thiserror-impl/1.0.40 \
    crate://crates.io/thiserror/1.0.40 \
    crate://crates.io/thread-priority/0.13.1 \
    crate://crates.io/tide/0.16.0 \
    crate://crates.io/time-macros-impl/0.1.2 \
    crate://crates.io/time-macros/0.1.1 \
    crate://crates.io/time/0.1.45 \
    crate://crates.io/time/0.2.27 \
    crate://crates.io/tinyvec/1.6.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio/1.28.0 \
    crate://crates.io/toml_datetime/0.6.1 \
    crate://crates.io/toml_edit/0.19.8 \
    crate://crates.io/tracing-attributes/0.1.24 \
    crate://crates.io/tracing-core/0.1.30 \
    crate://crates.io/tracing/0.1.37 \
    crate://crates.io/tungstenite/0.18.0 \
    crate://crates.io/typenum/1.16.0 \
    crate://crates.io/uds_windows/1.0.2 \
    crate://crates.io/unicase/2.6.0 \
    crate://crates.io/unicode-bidi/0.3.13 \
    crate://crates.io/unicode-ident/1.0.8 \
    crate://crates.io/unicode-normalization/0.1.22 \
    crate://crates.io/unicode-width/0.1.10 \
    crate://crates.io/unique-token/0.2.0 \
    crate://crates.io/universal-hash/0.4.1 \
    crate://crates.io/unsafe-libyaml/0.2.8 \
    crate://crates.io/url/2.3.1 \
    crate://crates.io/utf-8/0.7.6 \
    crate://crates.io/utf8-cstr/0.1.6 \
    crate://crates.io/utf8-width/0.1.6 \
    crate://crates.io/value-bag/1.0.0-alpha.9 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/waker-fn/1.1.0 \
    crate://crates.io/wasi/0.10.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.9.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.85 \
    crate://crates.io/wasm-bindgen-futures/0.4.35 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.85 \
    crate://crates.io/wasm-bindgen-macro/0.2.85 \
    crate://crates.io/wasm-bindgen-shared/0.2.85 \
    crate://crates.io/wasm-bindgen/0.2.85 \
    crate://crates.io/web-sys/0.3.62 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-sys/0.45.0 \
    crate://crates.io/windows-sys/0.48.0 \
    crate://crates.io/windows-targets/0.42.2 \
    crate://crates.io/windows-targets/0.48.0 \
    crate://crates.io/windows/0.48.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.2 \
    crate://crates.io/windows_aarch64_gnullvm/0.48.0 \
    crate://crates.io/windows_aarch64_msvc/0.42.2 \
    crate://crates.io/windows_aarch64_msvc/0.48.0 \
    crate://crates.io/windows_i686_gnu/0.42.2 \
    crate://crates.io/windows_i686_gnu/0.48.0 \
    crate://crates.io/windows_i686_msvc/0.42.2 \
    crate://crates.io/windows_i686_msvc/0.48.0 \
    crate://crates.io/windows_x86_64_gnu/0.42.2 \
    crate://crates.io/windows_x86_64_gnu/0.48.0 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.2 \
    crate://crates.io/windows_x86_64_gnullvm/0.48.0 \
    crate://crates.io/windows_x86_64_msvc/0.42.2 \
    crate://crates.io/windows_x86_64_msvc/0.48.0 \
    crate://crates.io/winnow/0.4.1 \
    crate://crates.io/wyz/0.5.1 \
    crate://crates.io/xdg-home/1.0.0 \
    crate://crates.io/zbus/3.12.0 \
    crate://crates.io/zbus_macros/3.12.0 \
    crate://crates.io/zbus_names/2.5.0 \
    crate://crates.io/zvariant/3.12.0 \
    crate://crates.io/zvariant_derive/3.12.0 \
    crate://crates.io/zvariant_utils/1.0.0 \
"

SRC_URI[adler-1.0.2.sha256sum] = "f26201604c87b1e01bd3d98f8d5d9a8fcbb815e8cedb41ffccbeb4bf593a35fe"
SRC_URI[aead-0.3.2.sha256sum] = "7fc95d1bdb8e6666b2b217308eeeb09f2d6728d104be3e31916cc74d15420331"
SRC_URI[aes-gcm-0.8.0.sha256sum] = "5278b5fabbb9bd46e24aa69b2fdea62c99088e0a950a9be40e3e0101298f88da"
SRC_URI[aes-soft-0.6.4.sha256sum] = "be14c7498ea50828a38d0e24a765ed2effe92a705885b57d029cd67d45744072"
SRC_URI[aes-0.6.0.sha256sum] = "884391ef1066acaa41e766ba8f596341b96e93ce34f9a43e7d24bf0a0eaf0561"
SRC_URI[aesni-0.10.0.sha256sum] = "ea2e11f5e94c2f7d386164cc2aa1f97823fed6f259e486940a71c174dd01b0ce"
SRC_URI[aho-corasick-1.0.1.sha256sum] = "67fc08ce920c31afb70f013dcce1bfc3a3195de6a228474e45e1f145b36f8d04"
SRC_URI[android_system_properties-0.1.5.sha256sum] = "819e7219dbd41043ac279b19830f2efc897156490d7fd6ea916720117ee66311"
SRC_URI[anyhow-1.0.71.sha256sum] = "9c7d0618f0e0b7e8ff11427422b64564d5fb0be1940354bfe2e0529b18a9d9b8"
SRC_URI[arrayref-0.3.7.sha256sum] = "6b4930d2cb77ce62f89ee5d5289b4ac049559b1c45539271f5ed4fdc7db34545"
SRC_URI[arrayvec-0.5.2.sha256sum] = "23b62fc65de8e4e7f52534fb52b0f3ed04746ae267519eef2a83941e8085068b"
SRC_URI[async-attributes-1.1.2.sha256sum] = "a3203e79f4dd9bdda415ed03cf14dae5a2bf775c683a00f94e9cd1faf0f596e5"
SRC_URI[async-broadcast-0.5.1.sha256sum] = "7c48ccdbf6ca6b121e0f586cbc0e73ae440e56c67c30fa0873b4e110d9c26d2b"
SRC_URI[async-channel-1.8.0.sha256sum] = "cf46fee83e5ccffc220104713af3292ff9bc7c64c7de289f66dae8e38d826833"
SRC_URI[async-dup-1.2.2.sha256sum] = "7427a12b8dc09291528cfb1da2447059adb4a257388c2acd6497a79d55cf6f7c"
SRC_URI[async-executor-1.5.1.sha256sum] = "6fa3dc5f2a8564f07759c008b9109dc0d39de92a88d5588b8a5036d286383afb"
SRC_URI[async-fs-1.6.0.sha256sum] = "279cf904654eeebfa37ac9bb1598880884924aab82e290aa65c9e77a0e142e06"
SRC_URI[async-global-executor-2.3.1.sha256sum] = "f1b6f5d7df27bd294849f8eec66ecfc63d11814df7a4f5d74168a2394467b776"
SRC_URI[async-h1-2.3.3.sha256sum] = "8101020758a4fc3a7c326cb42aa99e9fa77cbfb76987c128ad956406fe1f70a7"
SRC_URI[async-io-1.13.0.sha256sum] = "0fc5b45d93ef0529756f812ca52e44c221b35341892d3dcc34132ac02f3dd2af"
SRC_URI[async-lock-2.7.0.sha256sum] = "fa24f727524730b077666307f2734b4a1a1c57acb79193127dcc8914d5242dd7"
SRC_URI[async-process-1.7.0.sha256sum] = "7a9d28b1d97e08915212e2e45310d47854eafa69600756fc735fb788f75199c9"
SRC_URI[async-recursion-1.0.4.sha256sum] = "0e97ce7de6cf12de5d7226c73f5ba9811622f4db3a5b91b55c53e987e5f91cba"
SRC_URI[async-session-2.0.1.sha256sum] = "345022a2eed092cd105cc1b26fd61c341e100bd5fcbbd792df4baf31c2cc631f"
SRC_URI[async-sse-4.1.0.sha256sum] = "53bba003996b8fd22245cd0c59b869ba764188ed435392cf2796d03b805ade10"
SRC_URI[async-sse-5.1.0.sha256sum] = "2e6fa871e4334a622afd6bb2f611635e8083a6f5e2936c0f90f37c7ef9856298"
SRC_URI[async-std-1.12.0.sha256sum] = "62565bb4402e926b29953c785397c6dc0391b7b446e45008b0049eb43cec6f5d"
SRC_URI[async-task-4.4.0.sha256sum] = "ecc7ab41815b3c653ccd2978ec3255c81349336702dfdf62ee6f7069b12a3aae"
SRC_URI[async-trait-0.1.68.sha256sum] = "b9ccdd8f2a161be9bd5c023df56f1b2a0bd1d83872ae53b71a84a12c9bf6e842"
SRC_URI[async-tungstenite-0.20.0.sha256sum] = "1e0388bb7a400072bbb41ceb75d65c3baefb2ea99672fa22e85278452cd9b58b"
SRC_URI[atomic-waker-1.1.1.sha256sum] = "1181e1e0d1fce796a03db1ae795d67167da795f9cf4a39c37589e85ef57f26d3"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[az-1.2.1.sha256sum] = "7b7e4c2464d97fe331d41de9d5db0def0a96f4d823b8b32a2efd503578988973"
SRC_URI[base-x-0.2.11.sha256sum] = "4cbbc9d0964165b47557570cce6c952866c2678457aca742aafc9fb771d30270"
SRC_URI[base64-0.12.3.sha256sum] = "3441f0f7b02788e948e47f457ca01f1d7e6d92c693bc132c22b087d3141c03ff"
SRC_URI[base64-0.13.1.sha256sum] = "9e1b586273c5702936fe7b7d6896644d8be71e6314cfe09d3167c95f712589e8"
SRC_URI[base64-0.21.0.sha256sum] = "a4a4ddaa51a5bc52a6948f74c06d20aaaddb71924eab79b8c97a8c556e942d6a"
SRC_URI[bincode-1.3.3.sha256sum] = "b1f45e9417d87227c7a56d22e471c6206462cba514c7590c09aff4cf6d1ddcad"
SRC_URI[bitflags-1.3.2.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[bitvec-1.0.1.sha256sum] = "1bc2832c24239b0141d5674bb9174f9d68a8b5b3f2753311927c172ca46f7e9c"
SRC_URI[blake3-0.3.8.sha256sum] = "b64485778c4f16a6a5a9d335e80d449ac6c70cdd6a06d2af18a6f6f775a125b3"
SRC_URI[block-buffer-0.10.4.sha256sum] = "3078c7629b62d3f0439517fa394996acacc5cbc91c5a20d8c658e77abd503a71"
SRC_URI[block-buffer-0.9.0.sha256sum] = "4152116fd6e9dadb291ae18fc1ec3575ed6d84c29642d97890f4b4a3417297e4"
SRC_URI[blocking-1.3.1.sha256sum] = "77231a1c8f801696fc0123ec6150ce92cffb8e164a02afb9c8ddee0e9b65ad65"
SRC_URI[build-env-0.3.1.sha256sum] = "1522ac6ee801a11bf9ef3f80403f4ede6eb41291fac3dde3de09989679305f25"
SRC_URI[bumpalo-3.12.2.sha256sum] = "3c6ed94e98ecff0c12dd1b04c15ec0d7d9458ca8fe806cea6f12954efe74c63b"
SRC_URI[byteorder-1.4.3.sha256sum] = "14c189c53d098945499cdfa7ecc63567cf3886b3332b312a5b4585d8d3a6a610"
SRC_URI[bytes-1.4.0.sha256sum] = "89b2fd2a0dcf38d7971e2194b6b6eebab45ae01067456a7fd93d5547a61b70be"
SRC_URI[cc-1.0.79.sha256sum] = "50d30906286121d95be3d479533b458f87493b30a4b5f79a607db8f5d11aa91f"
SRC_URI[cfg-if-0.1.10.sha256sum] = "4785bdd1c96b2a846b2bd7cc02e86b6b3dbf14e7e53446c4f54c92a361040822"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[chrono-0.4.24.sha256sum] = "4e3c5919066adf22df73762e50cffcde3a758f2a848b113b586d1f86728b673b"
SRC_URI[cipher-0.2.5.sha256sum] = "12f8e7987cbd042a63249497f41aed09f8e65add917ea6566effbc56578d6801"
SRC_URI[codespan-reporting-0.11.1.sha256sum] = "3538270d33cc669650c4b093848450d380def10c331d38c768e34cac80576e6e"
SRC_URI[concurrent-queue-2.2.0.sha256sum] = "62ec6771ecfa0762d24683ee5a32ad78487a3d3afdc0fb8cae19d2c5deb50b7c"
SRC_URI[config-0.10.1.sha256sum] = "19b076e143e1d9538dde65da30f8481c2a6c44040edb8e02b9bf1351edb92ce3"
SRC_URI[const_fn-0.4.9.sha256sum] = "fbdcdcb6d86f71c5e97409ad45898af11cbc995b4ee8112d59095a28d376c935"
SRC_URI[constant_time_eq-0.1.5.sha256sum] = "245097e9a4535ee1e3e3931fcfcd55a796a44c643e8596ff6566d68f09b87bbc"
SRC_URI[cookie-0.14.4.sha256sum] = "03a5d7b21829bc7b4bf4754a978a241ae54ea55a40f92bb20216e54096f4b951"
SRC_URI[core-foundation-sys-0.8.4.sha256sum] = "e496a50fda8aacccc86d7529e2c1e0892dbd0f898a6b5645b5561b89c3210efa"
SRC_URI[cpufeatures-0.2.7.sha256sum] = "3e4c1eaa2012c47becbbad2ab175484c2a84d1185b566fb2cc5b8707343dfe58"
SRC_URI[cpuid-bool-0.2.0.sha256sum] = "dcb25d077389e53838a8158c8e99174c5a9d902dee4904320db714f3c653ffba"
SRC_URI[crc32fast-1.3.2.sha256sum] = "b540bd8bc810d3885c6ea91e2018302f68baba2129ab3e88f32389ee9370880d"
SRC_URI[crossbeam-queue-0.3.8.sha256sum] = "d1cfb3ea8a53f37c40dea2c7bedcbd88bdfae54f5e2175d6ecaff1c988353add"
SRC_URI[crossbeam-utils-0.8.15.sha256sum] = "3c063cd8cc95f5c377ed0d4b49a4b21f632396ff690e8470c29b3359b346984b"
SRC_URI[crypto-common-0.1.6.sha256sum] = "1bfb12502f3fc46cca1bb51ac28df9d618d813cdc3d2f25b9fe775a34af26bb3"
SRC_URI[crypto-mac-0.10.1.sha256sum] = "bff07008ec701e8028e2ceb8f83f0e4274ee62bd2dbdc4fefff2e9a91824081a"
SRC_URI[crypto-mac-0.8.0.sha256sum] = "b584a330336237c1eecd3e94266efb216c56ed91225d634cb2991c5f3fd1aeab"
SRC_URI[cstr-argument-0.1.2.sha256sum] = "b6bd9c8e659a473bce955ae5c35b116af38af11a7acb0b480e01f3ed348aeb40"
SRC_URI[ctor-0.1.26.sha256sum] = "6d2301688392eb071b0bf1a37be05c469d3cc4dbbd95df672fe28ab021e6a096"
SRC_URI[ctr-0.6.0.sha256sum] = "fb4a30d54f7443bf3d6191dcd486aca19e67cb3c49fa7a06a319966346707e7f"
SRC_URI[cxx-build-1.0.94.sha256sum] = "12cee708e8962df2aeb38f594aae5d827c022b6460ac71a7a3e2c3c2aae5a07b"
SRC_URI[cxx-1.0.94.sha256sum] = "f61f1b6389c3fe1c316bf8a4dccc90a38208354b330925bce1f74a6c4756eb93"
SRC_URI[cxxbridge-flags-1.0.94.sha256sum] = "7944172ae7e4068c533afbb984114a56c46e9ccddda550499caa222902c7f7bb"
SRC_URI[cxxbridge-macro-1.0.94.sha256sum] = "2345488264226bf682893e25de0769f3360aac9957980ec49361b083ddaa5bc5"
SRC_URI[dashmap-5.4.0.sha256sum] = "907076dfda823b0b36d2a1bb5f90c96660a5bbcd7729e10727f07858f22c4edc"
SRC_URI[deadpool-0.7.0.sha256sum] = "3d126179d86aee4556e54f5f3c6bf6d9884e7cc52cef82f77ee6f90a7747616d"
SRC_URI[derivative-2.2.0.sha256sum] = "fcc3dd5e9e9c0b295d6e1e4d811fb6f157d5ffd784b8d202fc62eac8035a770b"
SRC_URI[digest-0.10.6.sha256sum] = "8168378f4e5023e7218c89c891c0fd8ecdb5e5e4f18cb78f38cf245dd021e76f"
SRC_URI[digest-0.9.0.sha256sum] = "d3dd60d1080a57a05ab032377049e0591415d2b31afd7028356dbf3cc6dcb066"
SRC_URI[discard-1.0.4.sha256sum] = "212d0f5754cb6769937f4501cc0e67f4f4483c8d2c3e1e922ee9edbe4ab4c7c0"
SRC_URI[embedded-graphics-core-0.3.3.sha256sum] = "b8b1239db5f3eeb7e33e35bd10bd014e7b2537b17e071f726a09351431337cfa"
SRC_URI[embedded-graphics-0.7.1.sha256sum] = "750082c65094fbcc4baf9ba31583ce9a8bb7f52cadfb96f6164b1bc7f922f32b"
SRC_URI[enumflags2-0.7.7.sha256sum] = "c041f5090df68b32bcd905365fd51769c8b9d553fe87fde0b683534f10c01bd2"
SRC_URI[enumflags2_derive-0.7.7.sha256sum] = "5e9a1f9f7d83e59740248a6e14ecf93929ade55027844dfcea78beafccc15745"
SRC_URI[env_logger-0.10.0.sha256sum] = "85cdab6a89accf66733ad5a1693a4dcced6aeff64602b634530dd73c1f3ee9f0"
SRC_URI[erased-serde-0.3.25.sha256sum] = "4f2b0c2380453a92ea8b6c8e5f64ecaafccddde8ceab55ff7a8ac1029f894569"
SRC_URI[errno-dragonfly-0.1.2.sha256sum] = "aa68f1b12764fab894d2755d2518754e71b4fd80ecfb822714a1206c2aab39bf"
SRC_URI[errno-0.2.8.sha256sum] = "f639046355ee4f37944e44f60642c6f3a7efa3cf6b78c78a0d989a8ce6c396a1"
SRC_URI[errno-0.3.1.sha256sum] = "4bcfec3a70f97c962c307b2d2c56e358cf1d00b558d74262b5f929ee8cc7e73a"
SRC_URI[evdev-0.12.1.sha256sum] = "2bed59fcc8cfd6b190814a509018388462d3b203cf6dd10db5c00087e72a83f3"
SRC_URI[event-listener-2.5.3.sha256sum] = "0206175f82b8d6bf6652ff7d71a1e27fd2e4efde587fd368662814d6ec1d9ce0"
SRC_URI[fastrand-1.9.0.sha256sum] = "e51093e27b0797c359783294ca4f0a911c270184cb10f85783b118614a1501be"
SRC_URI[fdeflate-0.3.0.sha256sum] = "d329bdeac514ee06249dabc27877490f17f5d371ec693360768b838e19f3ae10"
SRC_URI[femme-2.2.1.sha256sum] = "cc04871e5ae3aa2952d552dae6b291b3099723bf779a8054281c1366a54613ef"
SRC_URI[flate2-1.0.26.sha256sum] = "3b9429470923de8e8cbd4d2dc513535400b4b3fef0319fb5c4e1f520a7bef743"
SRC_URI[float-cmp-0.8.0.sha256sum] = "e1267f4ac4f343772758f7b1bdcbe767c218bbab93bb432acbf5162bbf85a6c4"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[foreign-types-macros-0.2.3.sha256sum] = "1a5c6c585bc94aaf2c7b51dd4c2ba22680844aba4c687be581871a6f518c5742"
SRC_URI[foreign-types-shared-0.3.1.sha256sum] = "aa9a19cbb55df58761df49b23516a86d432839add4af60fc256da840f66ed35b"
SRC_URI[foreign-types-0.5.0.sha256sum] = "d737d9aa519fb7b749cbc3b962edcf310a8dd1f4b67c91c4f83975dbdd17d965"
SRC_URI[form_urlencoded-1.1.0.sha256sum] = "a9c384f161156f5260c24a097c56119f9be8c798586aecc13afbcbe7b7e26bf8"
SRC_URI[framebuffer-0.3.1.sha256sum] = "878caaaf1bb92c9f707dc6eef90933e07e913dac4bb8e11e145eaabaa94ef149"
SRC_URI[funty-2.0.0.sha256sum] = "e6d5a32815ae3f33302d95fdcb2ce17862f8c65363dcfd29360480ba1001fc9c"
SRC_URI[futures-channel-0.3.28.sha256sum] = "955518d47e09b25bbebc7a18df10b81f0c766eaf4c4f1cccef2fca5f2a4fb5f2"
SRC_URI[futures-core-0.3.28.sha256sum] = "4bca583b7e26f571124fe5b7561d49cb2868d79116cfa0eefce955557c6fee8c"
SRC_URI[futures-executor-0.3.28.sha256sum] = "ccecee823288125bd88b4d7f565c9e58e41858e47ab72e8ea2d64e93624386e0"
SRC_URI[futures-io-0.3.28.sha256sum] = "4fff74096e71ed47f8e023204cfd0aa1289cd54ae5430a9523be060cdb849964"
SRC_URI[futures-lite-1.13.0.sha256sum] = "49a9d51ce47660b1e808d3c990b4709f2f415d928835a17dfd16991515c46bce"
SRC_URI[futures-macro-0.3.28.sha256sum] = "89ca545a94061b6365f2c7355b4b32bd20df3ff95f02da9329b34ccc3bd6ee72"
SRC_URI[futures-sink-0.3.28.sha256sum] = "f43be4fe21a13b9781a69afa4985b0f6ee0e1afab2c6f454a8cf30e2b2237b6e"
SRC_URI[futures-task-0.3.28.sha256sum] = "76d3d132be6c0e6aa1534069c705a74a5997a356c0dc2f86a47765e5617c5b65"
SRC_URI[futures-util-0.3.28.sha256sum] = "26b01e40b772d54cf6c6d721c1d1abd0647a0106a12ecaa1c186273392a69533"
SRC_URI[futures-0.3.28.sha256sum] = "23342abe12aba583913b2e62f22225ff9c950774065e4bfb61a19cd9770fec40"
SRC_URI[generic-array-0.14.7.sha256sum] = "85649ca51fd72272d7821adaf274ad91c288277713d9c18820d8499a7ff69e9a"
SRC_URI[getrandom-0.1.16.sha256sum] = "8fc3cb4d91f53b50155bdcfd23f6a4c39ae1969c2ae85982b135750cccaf5fce"
SRC_URI[getrandom-0.2.9.sha256sum] = "c85e1d9ab2eadba7e5040d4e09cbd6d072b76a557ad64e797c2cb9d4da21d7e4"
SRC_URI[ghash-0.3.1.sha256sum] = "97304e4cd182c3846f7575ced3890c53012ce534ad9114046b0a9e00bb30a375"
SRC_URI[gloo-timers-0.2.6.sha256sum] = "9b995a66bb87bebce9a0f4a95aed01daca4872c050bfcb21653361c03bc35e5c"
SRC_URI[gpio-cdev-0.5.1.sha256sum] = "409296415b8abc7b47e5b77096faae14595c53724972da227434fc8f4b05ec8b"
SRC_URI[hashbrown-0.12.3.sha256sum] = "8a9ee70c43aaf417c914396645a0fa852624801b24ebb7ae78fe8272889ac888"
SRC_URI[hermit-abi-0.2.6.sha256sum] = "ee512640fe35acbfb4bb779db6f0d80704c2cacfa2e39b601ef3e3f47d1ae4c7"
SRC_URI[hermit-abi-0.3.1.sha256sum] = "fed44880c466736ef9a5c5b5facefb5ed0785676d0c02d612db14e54f0d84286"
SRC_URI[hex-0.4.3.sha256sum] = "7f24254aa9a54b5c858eaee2f5bccdb46aaf0e486a595ed5fd8f86ba55232a70"
SRC_URI[hkdf-0.10.0.sha256sum] = "51ab2f639c231793c5f6114bdb9bbe50a7dbbfcd7c7c6bd8475dec2d991e964f"
SRC_URI[hmac-0.10.1.sha256sum] = "c1441c6b1e930e2817404b5046f1f989899143a12bf92de603b69f4e0aee1e15"
SRC_URI[hmac-0.8.1.sha256sum] = "126888268dcc288495a26bf004b38c5fdbb31682f992c84ceb046a1f0fe38840"
SRC_URI[html-escape-0.2.13.sha256sum] = "6d1ad449764d627e22bfd7cd5e8868264fc9236e07c752972b4080cd351cb476"
SRC_URI[http-client-6.5.3.sha256sum] = "1947510dc91e2bf586ea5ffb412caad7673264e14bb39fb9078da114a94ce1a5"
SRC_URI[http-types-2.12.0.sha256sum] = "6e9b187a72d63adbfba487f48095306ac823049cb504ee195541e91c7775f5ad"
SRC_URI[http-0.2.9.sha256sum] = "bd6effc99afb63425aff9b05836f029929e345a6148a14b7ecd5ab67af944482"
SRC_URI[httparse-1.8.0.sha256sum] = "d897f394bad6a705d5f4104762e116a75639e470d80901eed05a860a95cb1904"
SRC_URI[humantime-2.1.0.sha256sum] = "9a3a5bfb195931eeb336b2a7b4d761daec841b97f947d34394601737a7bba5e4"
SRC_URI[iana-time-zone-haiku-0.1.1.sha256sum] = "0703ae284fc167426161c2e3f1da3ea71d94b21bedbcc9494e92b28e334e3dca"
SRC_URI[iana-time-zone-0.1.56.sha256sum] = "0722cd7114b7de04316e7ea5456a0bbb20e4adb46fd27a3697adb812cff0f37c"
SRC_URI[idna-0.3.0.sha256sum] = "e14ddfc70884202db2244c223200c204c2bda1bc6e0998d11b5e024d657209e6"
SRC_URI[indexmap-1.9.3.sha256sum] = "bd070e393353796e801d209ad339e89596eb4c8d430d18ede6a1cced8fafbd99"
SRC_URI[industrial-io-0.5.2.sha256sum] = "3948a8818efcd4e0e189df60d79b58a9f4ae20b87437b2fde4dc4ca5b520c4ed"
SRC_URI[infer-0.2.3.sha256sum] = "64e9829a50b42bb782c1df523f78d332fe371b10c661e78b7a3c34b0198e9fac"
SRC_URI[instant-0.1.12.sha256sum] = "7a5bbe824c507c5da5956355e86a746d82e0e1464f65d862cc5e71da70e94b2c"
SRC_URI[io-lifetimes-1.0.10.sha256sum] = "9c66c74d2ae7e79a5a8f7ac924adbe38ee42a859c6539ad869eb51f0b52dc220"
SRC_URI[is-terminal-0.4.7.sha256sum] = "adcf93614601c8129ddf72e2d5633df827ba6551541c6d8c59520a371475be1f"
SRC_URI[itoa-1.0.6.sha256sum] = "453ad9f582a441959e5f0d088b02ce04cfe8d51a8eaf077f12ac6d3e94164ca6"
SRC_URI[js-sys-0.3.62.sha256sum] = "68c16e1bfd491478ab155fd8b4896b86f9ede344949b641e61501e07c2b8b4d5"
SRC_URI[kv-log-macro-1.0.7.sha256sum] = "0de8b303297635ad57c9f5059fd9cee7a47f8e8daa09df0fcd07dd39fb22977f"
SRC_URI[lazy_static-1.4.0.sha256sum] = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646"
SRC_URI[lexical-core-0.7.6.sha256sum] = "6607c62aa161d23d17a9072cc5da0be67cdfc89d3afb1e8d9c842bebc2525ffe"
SRC_URI[libc-0.2.144.sha256sum] = "2b00cc1c228a6782d0f076e7b232802e0c5689d41bb5df366f2a6b6621cfdfe1"
SRC_URI[libiio-sys-0.3.1.sha256sum] = "6d6c255d73b8f345bb10550b44e93b2b5c910a31ce72ee2528c5dbc028cf24ec"
SRC_URI[libsystemd-sys-0.9.3.sha256sum] = "ed080163caa59cc29b34bce2209b737149a4bac148cd9a8b04e4c12822798119"
SRC_URI[link-cplusplus-1.0.8.sha256sum] = "ecd207c9c713c34f95a097a5b029ac2ce6010530c7b49d7fea24d977dede04f5"
SRC_URI[linux-raw-sys-0.3.7.sha256sum] = "ece97ea872ece730aed82664c424eb4c8291e1ff2480247ccf7409044bc6479f"
SRC_URI[lock_api-0.4.9.sha256sum] = "435011366fe56583b16cf956f9df0095b405b82d76425bc8981c0e22e60ec4df"
SRC_URI[log-0.4.17.sha256sum] = "abb12e687cfb44aa40f41fc3978ef76448f9b6038cad6aef4259d3c095a2382e"
SRC_URI[memchr-2.5.0.sha256sum] = "2dffe52ecf27772e601905b7522cb4ef790d2cc203488bbd0e2fe85fcb74566d"
SRC_URI[memmap-0.7.0.sha256sum] = "6585fd95e7bb50d6cc31e20d4cf9afb4e2ba16c5846fc76793f11218da9c475b"
SRC_URI[memoffset-0.6.5.sha256sum] = "5aa361d4faea93603064a027415f07bd8e1d5c88c9fbf68bf56a285428fd79ce"
SRC_URI[memoffset-0.7.1.sha256sum] = "5de893c32cde5f383baa4c04c5d6dbdd735cfd4a794b0debdb2bb1b421da5ff4"
SRC_URI[micromath-1.1.1.sha256sum] = "bc4010833aea396656c2f91ee704d51a6f1329ec2ab56ffd00bfd56f7481ea94"
SRC_URI[mime-0.3.17.sha256sum] = "6877bb514081ee2a7ff5ef9de3281f14a4dd4bceac4c09388074a6b5df8a139a"
SRC_URI[mime_guess-2.0.4.sha256sum] = "4192263c238a5f0d0c6bfd21f336a313a4ce1c450542449ca191bb657b4642ef"
SRC_URI[miniz_oxide-0.7.1.sha256sum] = "e7810e0be55b428ada41041c41f32c9f1a42817901b4ccf45fa3d4b6561e74c7"
SRC_URI[mqtt-protocol-0.11.2.sha256sum] = "ca0b17380dc69fbcf5f967828cfd10e55028ba83a57da1f580c5b0792ab807ac"
SRC_URI[nix-0.23.2.sha256sum] = "8f3790c00a0150112de0f4cd161e3d7fc4b2d8a5542ffc35f099a2562aecb35c"
SRC_URI[nix-0.26.2.sha256sum] = "bfdda3d196821d6af13126e40375cdf7da646a96114af134d5f417a9a1dc8e1a"
SRC_URI[nom-5.1.3.sha256sum] = "08959a387a676302eebf4ddbcbc611da04285579f76f88ee0506c63b1a61dd4b"
SRC_URI[num-integer-0.1.45.sha256sum] = "225d3389fb3509a24c93f5c29eb6bde2586b98d9f016636dff58d7c6f7569cd9"
SRC_URI[num-traits-0.2.15.sha256sum] = "578ede34cf02f8924ab9447f50c28075b4d3e5b269972345e7e0372b38c6cdcd"
SRC_URI[num_cpus-1.15.0.sha256sum] = "0fac9e2da13b5eb447a6ce3d392f23a29d8694bff781bf03a16cd9ac8697593b"
SRC_URI[numtoa-0.2.4.sha256sum] = "6aa2c4e539b869820a2b82e1aef6ff40aa85e65decdd5185e83fb4b1249cd00f"
SRC_URI[once_cell-1.17.1.sha256sum] = "b7e5500299e16ebb147ae15a00a942af264cf3688f47923b8fc2cd5858f23ad3"
SRC_URI[opaque-debug-0.3.0.sha256sum] = "624a8340c38c1b80fd549087862da4ba43e08858af025b236e509b6649fc13d5"
SRC_URI[ordered-stream-0.2.0.sha256sum] = "9aa2b01e1d916879f73a53d01d1d6cee68adbb31d6d9177a8cfce093cced1d50"
SRC_URI[parking-2.1.0.sha256sum] = "14f2252c834a40ed9bb5422029649578e63aa341ac401f74e719dd1afda8394e"
SRC_URI[parking_lot_core-0.9.7.sha256sum] = "9069cbb9f99e3a5083476ccb29ceb1de18b9118cafa53e90c9551235de2b9521"
SRC_URI[percent-encoding-2.2.0.sha256sum] = "478c572c3d73181ff3c2539045f6eb99e5491218eae919370993b890cdbdd98e"
SRC_URI[pin-project-internal-1.0.12.sha256sum] = "069bdb1e05adc7a8990dce9cc75370895fbe4e3d58b9b73bf1aee56359344a55"
SRC_URI[pin-project-lite-0.1.12.sha256sum] = "257b64915a082f7811703966789728173279bdebb956b143dbcd23f6f970a777"
SRC_URI[pin-project-lite-0.2.9.sha256sum] = "e0a7ae3ac2f1173085d398531c705756c94a4c56843785df85a60c1a0afac116"
SRC_URI[pin-project-1.0.12.sha256sum] = "ad29a609b6bcd67fee905812e544992d216af9d755757c05ed2d0e15a74c6ecc"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[pkg-config-0.3.27.sha256sum] = "26072860ba924cbfa98ea39c8c19b4dd6a4a25423dbdf219c1eca91aa0cf6964"
SRC_URI[png-0.17.8.sha256sum] = "aaeebc51f9e7d2c150d3f3bfeb667f2aa985db5ef1e3d212847bdedb488beeaa"
SRC_URI[polling-2.8.0.sha256sum] = "4b2d323e8ca7996b3e23126511a523f7e62924d93ecd5ae73b333815b0eb3dce"
SRC_URI[polyval-0.4.5.sha256sum] = "eebcc4aa140b9abd2bc40d9c3f7ccec842679cd79045ac3a7ac698c1a064b7cd"
SRC_URI[ppv-lite86-0.2.17.sha256sum] = "5b40af805b3121feab8a3c29f04d8ad262fa8e0561883e7653e024ae4479e6de"
SRC_URI[proc-macro-crate-1.3.1.sha256sum] = "7f4c021e1093a56626774e81216a4ce732a735e5bad4868a03f3ed65ca0c3919"
SRC_URI[proc-macro-hack-0.5.20+deprecated.sha256sum] = "dc375e1527247fe1a97d8b7156678dfe7c1af2fc075c9a4db3690ecd2a148068"
SRC_URI[proc-macro2-1.0.56.sha256sum] = "2b63bdb0cd06f1f4dedf69b254734f9b45af66e4a031e42a7480257d9898b435"
SRC_URI[quote-1.0.27.sha256sum] = "8f4f29d145265ec1c483c7c654450edde0bfe043d3938d6972630663356d9500"
SRC_URI[radium-0.7.0.sha256sum] = "dc33ff2d4973d518d823d61aa239014831e521c75da58e3df4840d3f47749d09"
SRC_URI[rand-0.7.3.sha256sum] = "6a6b1679d49b24bbfe0c803429aa1874472f50d9b363131f0e89fc356b544d03"
SRC_URI[rand-0.8.5.sha256sum] = "34af8d1a0e25924bc5b7c43c079c942339d8f0a8b57c39049bef581b46327404"
SRC_URI[rand_chacha-0.2.2.sha256sum] = "f4c8ed856279c9737206bf725bf36935d8666ead7aa69b52be55af369d193402"
SRC_URI[rand_chacha-0.3.1.sha256sum] = "e6c10a63a0fa32252be49d21e7709d4d4baf8d231c2dbce1eaa8141b9b127d88"
SRC_URI[rand_core-0.5.1.sha256sum] = "90bde5296fc891b0cef12a6d03ddccc162ce7b2aff54160af9338f8d40df6d19"
SRC_URI[rand_core-0.6.4.sha256sum] = "ec0be4795e2f6a28069bec0b5ff3e2ac9bafc99e6a9a7dc3547996c5c816922c"
SRC_URI[rand_hc-0.2.0.sha256sum] = "ca3129af7b92a17112d59ad498c6f81eaf463253766b90396d39ea7a39d6613c"
SRC_URI[redox_syscall-0.2.16.sha256sum] = "fb5a58c1855b4b6819d59012155603f0b22ad30cad752600aadfcb695265519a"
SRC_URI[redox_syscall-0.3.5.sha256sum] = "567664f262709473930a4bf9e51bf2ebf3348f2e748ccc50dea20646858f8f29"
SRC_URI[regex-syntax-0.7.1.sha256sum] = "a5996294f19bd3aae0453a862ad728f60e6600695733dd5df01da90c54363a3c"
SRC_URI[regex-1.8.1.sha256sum] = "af83e617f331cc6ae2da5443c602dfa5af81e517212d9d611a5b3ba1777b5370"
SRC_URI[route-recognizer-0.2.0.sha256sum] = "56770675ebc04927ded3e60633437841581c285dc6236109ea25fbf3beb7b59e"
SRC_URI[rustc_version-0.2.3.sha256sum] = "138e3e0acb6c9fb258b19b67cb8abd63c00679d2851805ea151465464fe9030a"
SRC_URI[rustix-0.37.19.sha256sum] = "acf8729d8542766f1b2cf77eb034d52f40d375bb8b615d0b147089946e16613d"
SRC_URI[rustversion-1.0.12.sha256sum] = "4f3208ce4d8448b3f3e7d168a73f5e0c43a61e32930de3bceeccedb388b6bf06"
SRC_URI[ryu-1.0.13.sha256sum] = "f91339c0467de62360649f8d3e185ca8de4224ff281f66000de5eb2a77a79041"
SRC_URI[scopeguard-1.1.0.sha256sum] = "d29ab0c6d3fc0ee92fe66e2d99f700eab17a8d57d1c1d3b748380fb20baa78cd"
SRC_URI[scratch-1.0.5.sha256sum] = "1792db035ce95be60c3f8853017b3999209281c24e2ba5bc8e59bf97a0c590c1"
SRC_URI[semver-parser-0.7.0.sha256sum] = "388a1df253eca08550bef6c72392cfe7c30914bf41df5269b68cbd6ff8f570a3"
SRC_URI[semver-0.9.0.sha256sum] = "1d7eb9ef2c18661902cc47e535f9bc51b78acd254da71d375c2f6720d9a40403"
SRC_URI[serde-1.0.162.sha256sum] = "71b2f6e1ab5c2b98c05f0f35b236b22e8df7ead6ffbf51d7808da7f8817e7ab6"
SRC_URI[serde_derive-1.0.162.sha256sum] = "a2a0814352fd64b58489904a44ea8d90cb1a91dcb6b4f5ebabc32c8318e93cb6"
SRC_URI[serde_fmt-1.0.3.sha256sum] = "e1d4ddca14104cd60529e8c7f7ba71a2c8acd8f7f5cfcdc2faf97eeb7c3010a4"
SRC_URI[serde_json-1.0.96.sha256sum] = "057d394a50403bcac12672b2b18fb387ab6d289d957dab67dd201875391e52f1"
SRC_URI[serde_qs-0.8.5.sha256sum] = "c7715380eec75f029a4ef7de39a9200e0a63823176b759d055b613f5a87df6a6"
SRC_URI[serde_repr-0.1.12.sha256sum] = "bcec881020c684085e55a25f7fd888954d56609ef363479dc5a1305eb0d40cab"
SRC_URI[serde_urlencoded-0.7.1.sha256sum] = "d3491c14715ca2294c4d6a88f15e84739788c1d030eed8c110436aafdaa2f3fd"
SRC_URI[serde_yaml-0.9.21.sha256sum] = "d9d684e3ec7de3bf5466b32bd75303ac16f0736426e5a4e0d6e489559ce1249c"
SRC_URI[sha-1-0.10.1.sha256sum] = "f5058ada175748e33390e40e872bd0fe59a19f265d0158daa551c5a88a76009c"
SRC_URI[sha1-0.10.5.sha256sum] = "f04293dc80c3993519f2d7f6f511707ee7094fe0c6d3406feb330cdb3540eba3"
SRC_URI[sha1-0.6.1.sha256sum] = "c1da05c97445caa12d05e848c4a4fcbbea29e748ac28f7e80e9b010392063770"
SRC_URI[sha1_smol-1.0.0.sha256sum] = "ae1a47186c03a32177042e55dbc5fd5aee900b8e0069a8d70fba96a9375cd012"
SRC_URI[sha2-0.9.9.sha256sum] = "4d58a1e1bf39749807d89cf2d98ac2dfa0ff1cb3faa38fbb64dd88ac8013d800"
SRC_URI[signal-hook-registry-1.4.1.sha256sum] = "d8229b473baa5980ac72ef434c4415e70c4b5e71b423043adb4ba059f89c99a1"
SRC_URI[signal-hook-0.3.15.sha256sum] = "732768f1176d21d09e076c23a93123d40bba92d50c4058da34d45c8de8e682b9"
SRC_URI[simd-adler32-0.3.5.sha256sum] = "238abfbb77c1915110ad968465608b68e869e0772622c9656714e73e5a1a522f"
SRC_URI[simple-mutex-1.1.5.sha256sum] = "38aabbeafa6f6dead8cebf246fe9fae1f9215c8d29b3a69f93bd62a9e4a3dcd6"
SRC_URI[slab-0.4.8.sha256sum] = "6528351c9bc8ab22353f9d776db39a20288e8d6c37ef8cfe3317cf875eecfc2d"
SRC_URI[smallvec-1.10.0.sha256sum] = "a507befe795404456341dfab10cef66ead4c041f62b8b11bbb92bffe5d0953e0"
SRC_URI[socket2-0.4.9.sha256sum] = "64a4a911eed85daf18834cfaa86a79b7d266ff93ff5ba14005426219480ed662"
SRC_URI[standback-0.2.17.sha256sum] = "e113fb6f3de07a243d434a56ec6f186dfd51cb08448239fe7bcae73f87ff28ff"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[stdweb-derive-0.5.3.sha256sum] = "c87a60a40fccc84bef0652345bbbbbe20a605bf5d0ce81719fc476f5c03b50ef"
SRC_URI[stdweb-internal-macros-0.2.9.sha256sum] = "58fa5ff6ad0d98d1ffa8cb115892b6e69d67799f6763e162a1c9db421dc22e11"
SRC_URI[stdweb-internal-runtime-0.1.5.sha256sum] = "213701ba3370744dcd1a12960caa4843b3d68b4d1c0a5d575e0d65b2ee9d16c0"
SRC_URI[stdweb-0.4.20.sha256sum] = "d022496b16281348b52d0e30ae99e01a73d737b2f45d38fed4edf79f9325a1d5"
SRC_URI[subtle-2.4.1.sha256sum] = "6bdef32e8150c2a081110b42772ffe7d7c9032b606bc226c8260fd97e0976601"
SRC_URI[surf-2.3.2.sha256sum] = "718b1ae6b50351982dedff021db0def601677f2120938b070eadb10ba4038dd7"
SRC_URI[sval-1.0.0-alpha.5.sha256sum] = "45f6ee7c7b87caf59549e9fe45d6a69c75c8019e79e212a835c5da0e92f0ba08"
SRC_URI[syn-1.0.109.sha256sum] = "72b64191b275b66ffe2469e8af2c1cfe3bafa67b529ead792a6d0160888b4237"
SRC_URI[syn-2.0.15.sha256sum] = "a34fcf3e8b60f57e6a14301a2e916d323af98b0ea63c599441eec8558660c822"
SRC_URI[sysfs-class-0.1.3.sha256sum] = "5e1bbcf869732c45a77898f7f61ed6d411dfc37613517e444842f58d428856d1"
SRC_URI[systemd-0.10.0.sha256sum] = "afec0101d9ae8ab26aedf0840109df689938ea7e538aa03df4369f1854f11562"
SRC_URI[tap-1.0.1.sha256sum] = "55937e1799185b12863d447f42597ed69d9928686b8d88a1df17376a097d8369"
SRC_URI[tempfile-3.5.0.sha256sum] = "b9fbec84f381d5795b08656e4912bec604d162bff9291d6189a78f4c8ab87998"
SRC_URI[termcolor-1.2.0.sha256sum] = "be55cf8942feac5c765c2c993422806843c9a9a45d4d5c407ad6dd2ea95eb9b6"
SRC_URI[thiserror-impl-1.0.40.sha256sum] = "f9456a42c5b0d803c8cd86e73dd7cc9edd429499f37a3550d286d5e86720569f"
SRC_URI[thiserror-1.0.40.sha256sum] = "978c9a314bd8dc99be594bc3c175faaa9794be04a5a5e153caba6915336cebac"
SRC_URI[thread-priority-0.13.1.sha256sum] = "0c56ce92f1285eaaa11fc1a3201e25de97898c50e87caa4c2aee836fe05288de"
SRC_URI[tide-0.16.0.sha256sum] = "c459573f0dd2cc734b539047f57489ea875af8ee950860ded20cf93a79a1dee0"
SRC_URI[time-macros-impl-0.1.2.sha256sum] = "fd3c141a1b43194f3f56a1411225df8646c55781d5f26db825b3d98507eb482f"
SRC_URI[time-macros-0.1.1.sha256sum] = "957e9c6e26f12cb6d0dd7fc776bb67a706312e7299aed74c8dd5b17ebb27e2f1"
SRC_URI[time-0.1.45.sha256sum] = "1b797afad3f312d1c66a56d11d0316f916356d11bd158fbc6ca6389ff6bf805a"
SRC_URI[time-0.2.27.sha256sum] = "4752a97f8eebd6854ff91f1c1824cd6160626ac4bd44287f7f4ea2035a02a242"
SRC_URI[tinyvec-1.6.0.sha256sum] = "87cc5ceb3875bb20c2890005a4e226a4651264a5c75edb2421b52861a0a0cb50"
SRC_URI[tinyvec_macros-0.1.1.sha256sum] = "1f3ccbac311fea05f86f61904b462b55fb3df8837a366dfc601a0161d0532f20"
SRC_URI[tokio-1.28.0.sha256sum] = "c3c786bf8134e5a3a166db9b29ab8f48134739014a3eca7bc6bfa95d673b136f"
SRC_URI[toml_datetime-0.6.1.sha256sum] = "3ab8ed2edee10b50132aed5f331333428b011c99402b5a534154ed15746f9622"
SRC_URI[toml_edit-0.19.8.sha256sum] = "239410c8609e8125456927e6707163a3b1fdb40561e4b803bc041f466ccfdc13"
SRC_URI[tracing-attributes-0.1.24.sha256sum] = "0f57e3ca2a01450b1a921183a9c9cbfda207fd822cef4ccb00a65402cbba7a74"
SRC_URI[tracing-core-0.1.30.sha256sum] = "24eb03ba0eab1fd845050058ce5e616558e8f8d8fca633e6b163fe25c797213a"
SRC_URI[tracing-0.1.37.sha256sum] = "8ce8c33a8d48bd45d624a6e523445fd21ec13d3653cd51f681abf67418f54eb8"
SRC_URI[tungstenite-0.18.0.sha256sum] = "30ee6ab729cd4cf0fd55218530c4522ed30b7b6081752839b68fcec8d0960788"
SRC_URI[typenum-1.16.0.sha256sum] = "497961ef93d974e23eb6f433eb5fe1b7930b659f06d12dec6fc44a8f554c0bba"
SRC_URI[uds_windows-1.0.2.sha256sum] = "ce65604324d3cce9b966701489fbd0cf318cb1f7bd9dd07ac9a4ee6fb791930d"
SRC_URI[unicase-2.6.0.sha256sum] = "50f37be617794602aabbeee0be4f259dc1778fabe05e2d67ee8f79326d5cb4f6"
SRC_URI[unicode-bidi-0.3.13.sha256sum] = "92888ba5573ff080736b3648696b70cafad7d250551175acbaa4e0385b3e1460"
SRC_URI[unicode-ident-1.0.8.sha256sum] = "e5464a87b239f13a63a501f2701565754bae92d243d4bb7eb12f6d57d2269bf4"
SRC_URI[unicode-normalization-0.1.22.sha256sum] = "5c5713f0fc4b5db668a2ac63cdb7bb4469d8c9fed047b1d0292cc7b0ce2ba921"
SRC_URI[unicode-width-0.1.10.sha256sum] = "c0edd1e5b14653f783770bce4a4dabb4a5108a5370a5f5d8cfe8710c361f6c8b"
SRC_URI[unique-token-0.2.0.sha256sum] = "d3be9e39e944fa35b07f5eb280902bf4d2dc29dfbc26175230a0d0ea124a7b66"
SRC_URI[universal-hash-0.4.1.sha256sum] = "9f214e8f697e925001e66ec2c6e37a4ef93f0f78c2eed7814394e10c62025b05"
SRC_URI[unsafe-libyaml-0.2.8.sha256sum] = "1865806a559042e51ab5414598446a5871b561d21b6764f2eabb0dd481d880a6"
SRC_URI[url-2.3.1.sha256sum] = "0d68c799ae75762b8c3fe375feb6600ef5602c883c5d21eb51c09f22b83c4643"
SRC_URI[utf-8-0.7.6.sha256sum] = "09cc8ee72d2a9becf2f2febe0205bbed8fc6615b7cb429ad062dc7b7ddd036a9"
SRC_URI[utf8-cstr-0.1.6.sha256sum] = "55bcbb425141152b10d5693095950b51c3745d019363fc2929ffd8f61449b628"
SRC_URI[utf8-width-0.1.6.sha256sum] = "5190c9442dcdaf0ddd50f37420417d219ae5261bbf5db120d0f9bab996c9cba1"
SRC_URI[value-bag-1.0.0-alpha.9.sha256sum] = "2209b78d1249f7e6f3293657c9779fe31ced465df091bbd433a1cf88e916ec55"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"
SRC_URI[waker-fn-1.1.0.sha256sum] = "9d5b2c62b4012a3e1eca5a7e077d13b3bf498c4073e33ccd58626607748ceeca"
SRC_URI[wasi-0.10.0+wasi-snapshot-preview1.sha256sum] = "1a143597ca7c7793eff794def352d41792a93c481eb1042423ff7ff72ba2c31f"
SRC_URI[wasi-0.11.0+wasi-snapshot-preview1.sha256sum] = "9c8d87e72b64a3b4db28d11ce29237c246188f4f51057d65a7eab63b7987e423"
SRC_URI[wasi-0.9.0+wasi-snapshot-preview1.sha256sum] = "cccddf32554fecc6acb585f82a32a72e28b48f8c4c1883ddfeeeaa96f7d8e519"
SRC_URI[wasm-bindgen-backend-0.2.85.sha256sum] = "35e522ed4105a9d626d885b35d62501b30d9666283a5c8be12c14a8bdafe7822"
SRC_URI[wasm-bindgen-futures-0.4.35.sha256sum] = "083abe15c5d88556b77bdf7aef403625be9e327ad37c62c4e4129af740168163"
SRC_URI[wasm-bindgen-macro-support-0.2.85.sha256sum] = "4783ce29f09b9d93134d41297aded3a712b7b979e9c6f28c32cb88c973a94869"
SRC_URI[wasm-bindgen-macro-0.2.85.sha256sum] = "358a79a0cb89d21db8120cbfb91392335913e4890665b1a7981d9e956903b434"
SRC_URI[wasm-bindgen-shared-0.2.85.sha256sum] = "a901d592cafaa4d711bc324edfaff879ac700b19c3dfd60058d2b445be2691eb"
SRC_URI[wasm-bindgen-0.2.85.sha256sum] = "5b6cb788c4e39112fbe1822277ef6fb3c55cd86b95cb3d3c4c1c9597e4ac74b4"
SRC_URI[web-sys-0.3.62.sha256sum] = "16b5f940c7edfdc6d12126d98c9ef4d1b3d470011c47c76a6581df47ad9ba721"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.5.sha256sum] = "70ec6ce85bb158151cae5e5c87f95a8e97d2c0c4b001223f33a334e3ce5de178"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-sys-0.45.0.sha256sum] = "75283be5efb2831d37ea142365f009c02ec203cd29a3ebecbc093d52315b66d0"
SRC_URI[windows-sys-0.48.0.sha256sum] = "677d2418bec65e3338edb076e806bc1ec15693c5d0104683f2efe857f61056a9"
SRC_URI[windows-targets-0.42.2.sha256sum] = "8e5180c00cd44c9b1c88adb3693291f1cd93605ded80c250a75d472756b4d071"
SRC_URI[windows-targets-0.48.0.sha256sum] = "7b1eb6f0cd7c80c79759c929114ef071b87354ce476d9d94271031c0497adfd5"
SRC_URI[windows-0.48.0.sha256sum] = "e686886bc078bc1b0b600cac0147aadb815089b6e4da64016cbd754b6342700f"
SRC_URI[windows_aarch64_gnullvm-0.42.2.sha256sum] = "597a5118570b68bc08d8d59125332c54f1ba9d9adeedeef5b99b02ba2b0698f8"
SRC_URI[windows_aarch64_gnullvm-0.48.0.sha256sum] = "91ae572e1b79dba883e0d315474df7305d12f569b400fcf90581b06062f7e1bc"
SRC_URI[windows_aarch64_msvc-0.42.2.sha256sum] = "e08e8864a60f06ef0d0ff4ba04124db8b0fb3be5776a5cd47641e942e58c4d43"
SRC_URI[windows_aarch64_msvc-0.48.0.sha256sum] = "b2ef27e0d7bdfcfc7b868b317c1d32c641a6fe4629c171b8928c7b08d98d7cf3"
SRC_URI[windows_i686_gnu-0.42.2.sha256sum] = "c61d927d8da41da96a81f029489353e68739737d3beca43145c8afec9a31a84f"
SRC_URI[windows_i686_gnu-0.48.0.sha256sum] = "622a1962a7db830d6fd0a69683c80a18fda201879f0f447f065a3b7467daa241"
SRC_URI[windows_i686_msvc-0.42.2.sha256sum] = "44d840b6ec649f480a41c8d80f9c65108b92d89345dd94027bfe06ac444d1060"
SRC_URI[windows_i686_msvc-0.48.0.sha256sum] = "4542c6e364ce21bf45d69fdd2a8e455fa38d316158cfd43b3ac1c5b1b19f8e00"
SRC_URI[windows_x86_64_gnu-0.42.2.sha256sum] = "8de912b8b8feb55c064867cf047dda097f92d51efad5b491dfb98f6bbb70cb36"
SRC_URI[windows_x86_64_gnu-0.48.0.sha256sum] = "ca2b8a661f7628cbd23440e50b05d705db3686f894fc9580820623656af974b1"
SRC_URI[windows_x86_64_gnullvm-0.42.2.sha256sum] = "26d41b46a36d453748aedef1486d5c7a85db22e56aff34643984ea85514e94a3"
SRC_URI[windows_x86_64_gnullvm-0.48.0.sha256sum] = "7896dbc1f41e08872e9d5e8f8baa8fdd2677f29468c4e156210174edc7f7b953"
SRC_URI[windows_x86_64_msvc-0.42.2.sha256sum] = "9aec5da331524158c6d1a4ac0ab1541149c0b9505fde06423b02f5ef0106b9f0"
SRC_URI[windows_x86_64_msvc-0.48.0.sha256sum] = "1a515f5799fe4961cb532f983ce2b23082366b898e52ffbce459c86f67c8378a"
SRC_URI[winnow-0.4.1.sha256sum] = "ae8970b36c66498d8ff1d66685dc86b91b29db0c7739899012f63a63814b4b28"
SRC_URI[wyz-0.5.1.sha256sum] = "05f360fc0b24296329c78fda852a1e9ae82de9cf7b27dae4b7f62f118f77b9ed"
SRC_URI[xdg-home-1.0.0.sha256sum] = "2769203cd13a0c6015d515be729c526d041e9cf2c0cc478d57faee85f40c6dcd"
SRC_URI[zbus-3.12.0.sha256sum] = "29242fa5ec5693629ae74d6eb1f69622a9511f600986d6d9779bccf36ac316e3"
SRC_URI[zbus_macros-3.12.0.sha256sum] = "537793e26e9af85f774801dc52c6f6292352b2b517c5cf0449ffd3735732a53a"
SRC_URI[zbus_names-2.5.0.sha256sum] = "f34f314916bd89bdb9934154627fab152f4f28acdda03e7c4c68181b214fe7e3"
SRC_URI[zvariant-3.12.0.sha256sum] = "46fe4914a985446d6fd287019b5fceccce38303d71407d9e6e711d44954a05d8"
SRC_URI[zvariant_derive-3.12.0.sha256sum] = "34c20260af4b28b3275d6676c7e2a6be0d4332e8e0aba4616d34007fd84e462a"
SRC_URI[zvariant_utils-1.0.0.sha256sum] = "53b22993dbc4d128a17a3b6c92f1c63872dd67198537ee728d8b5d7c40640a8b"

LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
"

SUMMARY = "tacd"
HOMEPAGE = "https://github.com/linux-automation/tacd"
LICENSE = "GPL-2.0-or-later"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include tacd-${PV}.inc
include tacd.inc
