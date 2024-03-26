inherit cargo

DEFAULT_PREFERENCE = "-1"

SRC_URI += "git://github.com/linux-automation/tacd.git;protocol=https;branch=main"
SRCREV = "e1e6ef55a8e2e9752c75e0a7debbfdb525eb1e70"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV = "0.1.0+git${SRCPV}"

SRC_URI += " \
    crate://crates.io/addr2line/0.21.0 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/aead/0.3.2 \
    crate://crates.io/aes-gcm/0.8.0 \
    crate://crates.io/aes-soft/0.6.4 \
    crate://crates.io/aes/0.6.0 \
    crate://crates.io/aesni/0.10.0 \
    crate://crates.io/aho-corasick/1.1.2 \
    crate://crates.io/android-tzdata/0.1.1 \
    crate://crates.io/android_system_properties/0.1.5 \
    crate://crates.io/anyhow/1.0.75 \
    crate://crates.io/arrayref/0.3.7 \
    crate://crates.io/arrayvec/0.5.2 \
    crate://crates.io/async-attributes/1.1.2 \
    crate://crates.io/async-broadcast/0.5.1 \
    crate://crates.io/async-channel/1.9.0 \
    crate://crates.io/async-dup/1.2.2 \
    crate://crates.io/async-executor/1.6.0 \
    crate://crates.io/async-fs/1.6.0 \
    crate://crates.io/async-global-executor/2.3.1 \
    crate://crates.io/async-h1/2.3.4 \
    crate://crates.io/async-io/1.13.0 \
    crate://crates.io/async-io/2.1.0 \
    crate://crates.io/async-lock/2.8.0 \
    crate://crates.io/async-process/1.8.1 \
    crate://crates.io/async-recursion/1.0.5 \
    crate://crates.io/async-session/2.0.1 \
    crate://crates.io/async-signal/0.2.5 \
    crate://crates.io/async-sse/4.1.0 \
    crate://crates.io/async-sse/5.1.0 \
    crate://crates.io/async-std/1.12.0 \
    crate://crates.io/async-task/4.5.0 \
    crate://crates.io/async-trait/0.1.74 \
    crate://crates.io/async-tungstenite/0.22.2 \
    crate://crates.io/atomic-waker/1.1.2 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/az/1.2.1 \
    crate://crates.io/backtrace/0.3.69 \
    crate://crates.io/base-x/0.2.11 \
    crate://crates.io/base64/0.12.3 \
    crate://crates.io/base64/0.13.1 \
    crate://crates.io/base64/0.21.5 \
    crate://crates.io/bincode/1.3.3 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bitflags/2.4.1 \
    crate://crates.io/bitvec/1.0.1 \
    crate://crates.io/blake3/0.3.8 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/block-buffer/0.9.0 \
    crate://crates.io/blocking/1.4.1 \
    crate://crates.io/build-env/0.3.1 \
    crate://crates.io/bumpalo/3.14.0 \
    crate://crates.io/byteorder/1.5.0 \
    crate://crates.io/bytes/1.5.0 \
    crate://crates.io/cc/1.0.83 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/chrono/0.4.31 \
    crate://crates.io/cipher/0.2.5 \
    crate://crates.io/concurrent-queue/2.3.0 \
    crate://crates.io/config/0.10.1 \
    crate://crates.io/const_fn/0.4.9 \
    crate://crates.io/constant_time_eq/0.1.5 \
    crate://crates.io/cookie/0.14.4 \
    crate://crates.io/core-foundation-sys/0.8.4 \
    crate://crates.io/cpufeatures/0.2.11 \
    crate://crates.io/cpuid-bool/0.2.0 \
    crate://crates.io/crc32fast/1.3.2 \
    crate://crates.io/crossbeam-queue/0.3.8 \
    crate://crates.io/crossbeam-utils/0.8.16 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/crypto-mac/0.10.1 \
    crate://crates.io/crypto-mac/0.8.0 \
    crate://crates.io/cstr-argument/0.1.2 \
    crate://crates.io/ctr/0.6.0 \
    crate://crates.io/dashmap/5.5.3 \
    crate://crates.io/data-encoding/2.4.0 \
    crate://crates.io/deadpool/0.7.0 \
    crate://crates.io/derivative/2.2.0 \
    crate://crates.io/digest/0.10.7 \
    crate://crates.io/digest/0.9.0 \
    crate://crates.io/discard/1.0.4 \
    crate://crates.io/embedded-graphics-core/0.3.3 \
    crate://crates.io/embedded-graphics/0.7.1 \
    crate://crates.io/enumflags2/0.7.8 \
    crate://crates.io/enumflags2_derive/0.7.8 \
    crate://crates.io/env_logger/0.10.0 \
    crate://crates.io/equivalent/1.0.1 \
    crate://crates.io/erased-serde/0.3.31 \
    crate://crates.io/errno-dragonfly/0.1.2 \
    crate://crates.io/errno/0.2.8 \
    crate://crates.io/errno/0.3.5 \
    crate://crates.io/evdev/0.12.1 \
    crate://crates.io/event-listener/2.5.3 \
    crate://crates.io/event-listener/3.0.1 \
    crate://crates.io/fastrand/1.9.0 \
    crate://crates.io/fastrand/2.0.1 \
    crate://crates.io/fdeflate/0.3.1 \
    crate://crates.io/femme/2.2.1 \
    crate://crates.io/flate2/1.0.28 \
    crate://crates.io/float-cmp/0.8.0 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/foreign-types-macros/0.2.3 \
    crate://crates.io/foreign-types-shared/0.3.1 \
    crate://crates.io/foreign-types/0.5.0 \
    crate://crates.io/form_urlencoded/1.2.0 \
    crate://crates.io/framebuffer/0.3.1 \
    crate://crates.io/funty/2.0.0 \
    crate://crates.io/futures-channel/0.3.29 \
    crate://crates.io/futures-core/0.3.29 \
    crate://crates.io/futures-executor/0.3.29 \
    crate://crates.io/futures-io/0.3.29 \
    crate://crates.io/futures-lite/1.13.0 \
    crate://crates.io/futures-macro/0.3.29 \
    crate://crates.io/futures-sink/0.3.29 \
    crate://crates.io/futures-task/0.3.29 \
    crate://crates.io/futures-util/0.3.29 \
    crate://crates.io/futures/0.3.29 \
    crate://crates.io/generic-array/0.14.7 \
    crate://crates.io/getrandom/0.1.16 \
    crate://crates.io/getrandom/0.2.10 \
    crate://crates.io/ghash/0.3.1 \
    crate://crates.io/gimli/0.28.0 \
    crate://crates.io/gloo-timers/0.2.6 \
    crate://crates.io/gpio-cdev/0.5.1 \
    crate://crates.io/hashbrown/0.14.2 \
    crate://crates.io/hermit-abi/0.3.3 \
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
    crate://crates.io/iana-time-zone-haiku/0.1.2 \
    crate://crates.io/iana-time-zone/0.1.58 \
    crate://crates.io/idna/0.4.0 \
    crate://crates.io/indexmap/2.1.0 \
    crate://crates.io/industrial-io/0.5.2 \
    crate://crates.io/infer/0.2.3 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/io-lifetimes/1.0.11 \
    crate://crates.io/is-terminal/0.4.9 \
    crate://crates.io/itoa/1.0.9 \
    crate://crates.io/js-sys/0.3.65 \
    crate://crates.io/kv-log-macro/1.0.7 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/lexical-core/0.7.6 \
    crate://crates.io/libc/0.2.149 \
    crate://crates.io/libiio-sys/0.3.1 \
    crate://crates.io/libsystemd-sys/0.9.3 \
    crate://crates.io/linux-raw-sys/0.3.8 \
    crate://crates.io/linux-raw-sys/0.4.10 \
    crate://crates.io/lock_api/0.4.11 \
    crate://crates.io/log/0.4.20 \
    crate://crates.io/memchr/2.6.4 \
    crate://crates.io/memmap/0.7.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/memoffset/0.7.1 \
    crate://crates.io/micromath/1.1.1 \
    crate://crates.io/mime/0.3.17 \
    crate://crates.io/mime_guess/2.0.4 \
    crate://crates.io/miniz_oxide/0.7.1 \
    crate://crates.io/mqtt-protocol/0.11.2 \
    crate://crates.io/nix/0.23.2 \
    crate://crates.io/nix/0.26.4 \
    crate://crates.io/nom/5.1.3 \
    crate://crates.io/num-traits/0.2.17 \
    crate://crates.io/num_cpus/1.16.0 \
    crate://crates.io/numtoa/0.2.4 \
    crate://crates.io/object/0.32.1 \
    crate://crates.io/once_cell/1.18.0 \
    crate://crates.io/opaque-debug/0.3.0 \
    crate://crates.io/ordered-stream/0.2.0 \
    crate://crates.io/parking/2.2.0 \
    crate://crates.io/parking_lot_core/0.9.9 \
    crate://crates.io/percent-encoding/2.3.0 \
    crate://crates.io/pin-project-internal/1.1.3 \
    crate://crates.io/pin-project-lite/0.1.12 \
    crate://crates.io/pin-project-lite/0.2.13 \
    crate://crates.io/pin-project/1.1.3 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/piper/0.2.1 \
    crate://crates.io/pkg-config/0.3.27 \
    crate://crates.io/png/0.17.10 \
    crate://crates.io/polling/2.8.0 \
    crate://crates.io/polling/3.3.0 \
    crate://crates.io/polyval/0.4.5 \
    crate://crates.io/ppv-lite86/0.2.17 \
    crate://crates.io/proc-macro-crate/1.3.1 \
    crate://crates.io/proc-macro-hack/0.5.20+deprecated \
    crate://crates.io/proc-macro2/1.0.69 \
    crate://crates.io/quote/1.0.33 \
    crate://crates.io/radium/0.7.0 \
    crate://crates.io/rand/0.7.3 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.2.2 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.5.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/rand_hc/0.2.0 \
    crate://crates.io/redox_syscall/0.4.1 \
    crate://crates.io/regex-automata/0.4.3 \
    crate://crates.io/regex-syntax/0.8.2 \
    crate://crates.io/regex/1.10.2 \
    crate://crates.io/route-recognizer/0.2.0 \
    crate://crates.io/rustc-demangle/0.1.23 \
    crate://crates.io/rustc_version/0.2.3 \
    crate://crates.io/rustix/0.37.27 \
    crate://crates.io/rustix/0.38.21 \
    crate://crates.io/rustversion/1.0.14 \
    crate://crates.io/ryu/1.0.15 \
    crate://crates.io/scopeguard/1.2.0 \
    crate://crates.io/semver-parser/0.7.0 \
    crate://crates.io/semver/0.9.0 \
    crate://crates.io/serde/1.0.190 \
    crate://crates.io/serde_derive/1.0.190 \
    crate://crates.io/serde_fmt/1.0.3 \
    crate://crates.io/serde_json/1.0.108 \
    crate://crates.io/serde_qs/0.8.5 \
    crate://crates.io/serde_repr/0.1.17 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/serde_yaml/0.9.27 \
    crate://crates.io/sha-1/0.10.1 \
    crate://crates.io/sha1/0.10.6 \
    crate://crates.io/sha1/0.6.1 \
    crate://crates.io/sha1_smol/1.0.0 \
    crate://crates.io/sha2/0.9.9 \
    crate://crates.io/signal-hook-registry/1.4.1 \
    crate://crates.io/simd-adler32/0.3.7 \
    crate://crates.io/simple-mutex/1.1.5 \
    crate://crates.io/slab/0.4.9 \
    crate://crates.io/smallvec/1.11.1 \
    crate://crates.io/socket2/0.4.10 \
    crate://crates.io/standback/0.2.17 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/stdweb-derive/0.5.3 \
    crate://crates.io/stdweb-internal-macros/0.2.9 \
    crate://crates.io/stdweb-internal-runtime/0.1.5 \
    crate://crates.io/stdweb/0.4.20 \
    crate://crates.io/subtle/2.4.1 \
    crate://crates.io/surf/2.3.2 \
    crate://crates.io/sval/2.10.2 \
    crate://crates.io/sval_buffer/2.10.2 \
    crate://crates.io/sval_dynamic/2.10.2 \
    crate://crates.io/sval_fmt/2.10.2 \
    crate://crates.io/sval_json/2.10.2 \
    crate://crates.io/sval_ref/2.10.2 \
    crate://crates.io/sval_serde/2.10.2 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/syn/2.0.38 \
    crate://crates.io/sysfs-class/0.1.3 \
    crate://crates.io/systemd/0.10.0 \
    crate://crates.io/tap/1.0.1 \
    crate://crates.io/tempfile/3.8.1 \
    crate://crates.io/termcolor/1.3.0 \
    crate://crates.io/thiserror-impl/1.0.50 \
    crate://crates.io/thiserror/1.0.50 \
    crate://crates.io/thread-priority/0.13.1 \
    crate://crates.io/tide/0.16.0 \
    crate://crates.io/time-macros-impl/0.1.2 \
    crate://crates.io/time-macros/0.1.1 \
    crate://crates.io/time/0.2.27 \
    crate://crates.io/tinyvec/1.6.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio/1.33.0 \
    crate://crates.io/toml_datetime/0.6.5 \
    crate://crates.io/toml_edit/0.19.15 \
    crate://crates.io/tracing-attributes/0.1.27 \
    crate://crates.io/tracing-core/0.1.32 \
    crate://crates.io/tracing/0.1.40 \
    crate://crates.io/tungstenite/0.19.0 \
    crate://crates.io/typenum/1.17.0 \
    crate://crates.io/uds_windows/1.0.2 \
    crate://crates.io/unicase/2.7.0 \
    crate://crates.io/unicode-bidi/0.3.13 \
    crate://crates.io/unicode-ident/1.0.12 \
    crate://crates.io/unicode-normalization/0.1.22 \
    crate://crates.io/unique-token/0.2.0 \
    crate://crates.io/universal-hash/0.4.1 \
    crate://crates.io/unsafe-libyaml/0.2.9 \
    crate://crates.io/url/2.4.1 \
    crate://crates.io/utf-8/0.7.6 \
    crate://crates.io/utf8-cstr/0.1.6 \
    crate://crates.io/utf8-width/0.1.6 \
    crate://crates.io/value-bag-serde1/1.4.2 \
    crate://crates.io/value-bag-sval2/1.4.2 \
    crate://crates.io/value-bag/1.4.2 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/waker-fn/1.1.1 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.9.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.88 \
    crate://crates.io/wasm-bindgen-futures/0.4.38 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.88 \
    crate://crates.io/wasm-bindgen-macro/0.2.88 \
    crate://crates.io/wasm-bindgen-shared/0.2.88 \
    crate://crates.io/wasm-bindgen/0.2.88 \
    crate://crates.io/web-sys/0.3.65 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.6 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-core/0.51.1 \
    crate://crates.io/windows-sys/0.48.0 \
    crate://crates.io/windows-targets/0.48.5 \
    crate://crates.io/windows_aarch64_gnullvm/0.48.5 \
    crate://crates.io/windows_aarch64_msvc/0.48.5 \
    crate://crates.io/windows_i686_gnu/0.48.5 \
    crate://crates.io/windows_i686_msvc/0.48.5 \
    crate://crates.io/windows_x86_64_gnu/0.48.5 \
    crate://crates.io/windows_x86_64_gnullvm/0.48.5 \
    crate://crates.io/windows_x86_64_msvc/0.48.5 \
    crate://crates.io/winnow/0.5.18 \
    crate://crates.io/wyz/0.5.1 \
    crate://crates.io/xdg-home/1.0.0 \
    crate://crates.io/zbus/3.14.1 \
    crate://crates.io/zbus_macros/3.14.1 \
    crate://crates.io/zbus_names/2.6.0 \
    crate://crates.io/zvariant/3.15.0 \
    crate://crates.io/zvariant_derive/3.15.0 \
    crate://crates.io/zvariant_utils/1.0.1 \
"

SRC_URI[addr2line-0.21.0.sha256sum] = "8a30b2e23b9e17a9f90641c7ab1549cd9b44f296d3ccbf309d2863cfe398a0cb"
SRC_URI[adler-1.0.2.sha256sum] = "f26201604c87b1e01bd3d98f8d5d9a8fcbb815e8cedb41ffccbeb4bf593a35fe"
SRC_URI[aead-0.3.2.sha256sum] = "7fc95d1bdb8e6666b2b217308eeeb09f2d6728d104be3e31916cc74d15420331"
SRC_URI[aes-gcm-0.8.0.sha256sum] = "5278b5fabbb9bd46e24aa69b2fdea62c99088e0a950a9be40e3e0101298f88da"
SRC_URI[aes-soft-0.6.4.sha256sum] = "be14c7498ea50828a38d0e24a765ed2effe92a705885b57d029cd67d45744072"
SRC_URI[aes-0.6.0.sha256sum] = "884391ef1066acaa41e766ba8f596341b96e93ce34f9a43e7d24bf0a0eaf0561"
SRC_URI[aesni-0.10.0.sha256sum] = "ea2e11f5e94c2f7d386164cc2aa1f97823fed6f259e486940a71c174dd01b0ce"
SRC_URI[aho-corasick-1.1.2.sha256sum] = "b2969dcb958b36655471fc61f7e416fa76033bdd4bfed0678d8fee1e2d07a1f0"
SRC_URI[android-tzdata-0.1.1.sha256sum] = "e999941b234f3131b00bc13c22d06e8c5ff726d1b6318ac7eb276997bbb4fef0"
SRC_URI[android_system_properties-0.1.5.sha256sum] = "819e7219dbd41043ac279b19830f2efc897156490d7fd6ea916720117ee66311"
SRC_URI[anyhow-1.0.75.sha256sum] = "a4668cab20f66d8d020e1fbc0ebe47217433c1b6c8f2040faf858554e394ace6"
SRC_URI[arrayref-0.3.7.sha256sum] = "6b4930d2cb77ce62f89ee5d5289b4ac049559b1c45539271f5ed4fdc7db34545"
SRC_URI[arrayvec-0.5.2.sha256sum] = "23b62fc65de8e4e7f52534fb52b0f3ed04746ae267519eef2a83941e8085068b"
SRC_URI[async-attributes-1.1.2.sha256sum] = "a3203e79f4dd9bdda415ed03cf14dae5a2bf775c683a00f94e9cd1faf0f596e5"
SRC_URI[async-broadcast-0.5.1.sha256sum] = "7c48ccdbf6ca6b121e0f586cbc0e73ae440e56c67c30fa0873b4e110d9c26d2b"
SRC_URI[async-channel-1.9.0.sha256sum] = "81953c529336010edd6d8e358f886d9581267795c61b19475b71314bffa46d35"
SRC_URI[async-dup-1.2.2.sha256sum] = "7427a12b8dc09291528cfb1da2447059adb4a257388c2acd6497a79d55cf6f7c"
SRC_URI[async-executor-1.6.0.sha256sum] = "4b0c4a4f319e45986f347ee47fef8bf5e81c9abc3f6f58dc2391439f30df65f0"
SRC_URI[async-fs-1.6.0.sha256sum] = "279cf904654eeebfa37ac9bb1598880884924aab82e290aa65c9e77a0e142e06"
SRC_URI[async-global-executor-2.3.1.sha256sum] = "f1b6f5d7df27bd294849f8eec66ecfc63d11814df7a4f5d74168a2394467b776"
SRC_URI[async-h1-2.3.4.sha256sum] = "5d1d1dae8cb2c4258a79d6ed088b7fb9b4763bf4e9b22d040779761e046a2971"
SRC_URI[async-io-1.13.0.sha256sum] = "0fc5b45d93ef0529756f812ca52e44c221b35341892d3dcc34132ac02f3dd2af"
SRC_URI[async-io-2.1.0.sha256sum] = "10da8f3146014722c89e7859e1d7bb97873125d7346d10ca642ffab794355828"
SRC_URI[async-lock-2.8.0.sha256sum] = "287272293e9d8c41773cec55e365490fe034813a2f172f502d6ddcf75b2f582b"
SRC_URI[async-process-1.8.1.sha256sum] = "ea6438ba0a08d81529c69b36700fa2f95837bfe3e776ab39cde9c14d9149da88"
SRC_URI[async-recursion-1.0.5.sha256sum] = "5fd55a5ba1179988837d24ab4c7cc8ed6efdeff578ede0416b4225a5fca35bd0"
SRC_URI[async-session-2.0.1.sha256sum] = "345022a2eed092cd105cc1b26fd61c341e100bd5fcbbd792df4baf31c2cc631f"
SRC_URI[async-signal-0.2.5.sha256sum] = "9e47d90f65a225c4527103a8d747001fc56e375203592b25ad103e1ca13124c5"
SRC_URI[async-sse-4.1.0.sha256sum] = "53bba003996b8fd22245cd0c59b869ba764188ed435392cf2796d03b805ade10"
SRC_URI[async-sse-5.1.0.sha256sum] = "2e6fa871e4334a622afd6bb2f611635e8083a6f5e2936c0f90f37c7ef9856298"
SRC_URI[async-std-1.12.0.sha256sum] = "62565bb4402e926b29953c785397c6dc0391b7b446e45008b0049eb43cec6f5d"
SRC_URI[async-task-4.5.0.sha256sum] = "b4eb2cdb97421e01129ccb49169d8279ed21e829929144f4a22a6e54ac549ca1"
SRC_URI[async-trait-0.1.74.sha256sum] = "a66537f1bb974b254c98ed142ff995236e81b9d0fe4db0575f46612cb15eb0f9"
SRC_URI[async-tungstenite-0.22.2.sha256sum] = "ce01ac37fdc85f10a43c43bc582cbd566720357011578a935761075f898baf58"
SRC_URI[atomic-waker-1.1.2.sha256sum] = "1505bd5d3d116872e7271a6d4e16d81d0c8570876c8de68093a09ac269d8aac0"
SRC_URI[autocfg-1.1.0.sha256sum] = "d468802bab17cbc0cc575e9b053f41e72aa36bfa6b7f55e3529ffa43161b97fa"
SRC_URI[az-1.2.1.sha256sum] = "7b7e4c2464d97fe331d41de9d5db0def0a96f4d823b8b32a2efd503578988973"
SRC_URI[backtrace-0.3.69.sha256sum] = "2089b7e3f35b9dd2d0ed921ead4f6d318c27680d4a5bd167b3ee120edb105837"
SRC_URI[base-x-0.2.11.sha256sum] = "4cbbc9d0964165b47557570cce6c952866c2678457aca742aafc9fb771d30270"
SRC_URI[base64-0.12.3.sha256sum] = "3441f0f7b02788e948e47f457ca01f1d7e6d92c693bc132c22b087d3141c03ff"
SRC_URI[base64-0.13.1.sha256sum] = "9e1b586273c5702936fe7b7d6896644d8be71e6314cfe09d3167c95f712589e8"
SRC_URI[base64-0.21.5.sha256sum] = "35636a1494ede3b646cc98f74f8e62c773a38a659ebc777a2cf26b9b74171df9"
SRC_URI[bincode-1.3.3.sha256sum] = "b1f45e9417d87227c7a56d22e471c6206462cba514c7590c09aff4cf6d1ddcad"
SRC_URI[bitflags-1.3.2.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[bitflags-2.4.1.sha256sum] = "327762f6e5a765692301e5bb513e0d9fef63be86bbc14528052b1cd3e6f03e07"
SRC_URI[bitvec-1.0.1.sha256sum] = "1bc2832c24239b0141d5674bb9174f9d68a8b5b3f2753311927c172ca46f7e9c"
SRC_URI[blake3-0.3.8.sha256sum] = "b64485778c4f16a6a5a9d335e80d449ac6c70cdd6a06d2af18a6f6f775a125b3"
SRC_URI[block-buffer-0.10.4.sha256sum] = "3078c7629b62d3f0439517fa394996acacc5cbc91c5a20d8c658e77abd503a71"
SRC_URI[block-buffer-0.9.0.sha256sum] = "4152116fd6e9dadb291ae18fc1ec3575ed6d84c29642d97890f4b4a3417297e4"
SRC_URI[blocking-1.4.1.sha256sum] = "8c36a4d0d48574b3dd360b4b7d95cc651d2b6557b6402848a27d4b228a473e2a"
SRC_URI[build-env-0.3.1.sha256sum] = "1522ac6ee801a11bf9ef3f80403f4ede6eb41291fac3dde3de09989679305f25"
SRC_URI[bumpalo-3.14.0.sha256sum] = "7f30e7476521f6f8af1a1c4c0b8cc94f0bee37d91763d0ca2665f299b6cd8aec"
SRC_URI[byteorder-1.5.0.sha256sum] = "1fd0f2584146f6f2ef48085050886acf353beff7305ebd1ae69500e27c67f64b"
SRC_URI[bytes-1.5.0.sha256sum] = "a2bd12c1caf447e69cd4528f47f94d203fd2582878ecb9e9465484c4148a8223"
SRC_URI[cc-1.0.83.sha256sum] = "f1174fb0b6ec23863f8b971027804a42614e347eafb0a95bf0b12cdae21fc4d0"
SRC_URI[cfg-if-0.1.10.sha256sum] = "4785bdd1c96b2a846b2bd7cc02e86b6b3dbf14e7e53446c4f54c92a361040822"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[chrono-0.4.31.sha256sum] = "7f2c685bad3eb3d45a01354cedb7d5faa66194d1d58ba6e267a8de788f79db38"
SRC_URI[cipher-0.2.5.sha256sum] = "12f8e7987cbd042a63249497f41aed09f8e65add917ea6566effbc56578d6801"
SRC_URI[concurrent-queue-2.3.0.sha256sum] = "f057a694a54f12365049b0958a1685bb52d567f5593b355fbf685838e873d400"
SRC_URI[config-0.10.1.sha256sum] = "19b076e143e1d9538dde65da30f8481c2a6c44040edb8e02b9bf1351edb92ce3"
SRC_URI[const_fn-0.4.9.sha256sum] = "fbdcdcb6d86f71c5e97409ad45898af11cbc995b4ee8112d59095a28d376c935"
SRC_URI[constant_time_eq-0.1.5.sha256sum] = "245097e9a4535ee1e3e3931fcfcd55a796a44c643e8596ff6566d68f09b87bbc"
SRC_URI[cookie-0.14.4.sha256sum] = "03a5d7b21829bc7b4bf4754a978a241ae54ea55a40f92bb20216e54096f4b951"
SRC_URI[core-foundation-sys-0.8.4.sha256sum] = "e496a50fda8aacccc86d7529e2c1e0892dbd0f898a6b5645b5561b89c3210efa"
SRC_URI[cpufeatures-0.2.11.sha256sum] = "ce420fe07aecd3e67c5f910618fe65e94158f6dcc0adf44e00d69ce2bdfe0fd0"
SRC_URI[cpuid-bool-0.2.0.sha256sum] = "dcb25d077389e53838a8158c8e99174c5a9d902dee4904320db714f3c653ffba"
SRC_URI[crc32fast-1.3.2.sha256sum] = "b540bd8bc810d3885c6ea91e2018302f68baba2129ab3e88f32389ee9370880d"
SRC_URI[crossbeam-queue-0.3.8.sha256sum] = "d1cfb3ea8a53f37c40dea2c7bedcbd88bdfae54f5e2175d6ecaff1c988353add"
SRC_URI[crossbeam-utils-0.8.16.sha256sum] = "5a22b2d63d4d1dc0b7f1b6b2747dd0088008a9be28b6ddf0b1e7d335e3037294"
SRC_URI[crypto-common-0.1.6.sha256sum] = "1bfb12502f3fc46cca1bb51ac28df9d618d813cdc3d2f25b9fe775a34af26bb3"
SRC_URI[crypto-mac-0.10.1.sha256sum] = "bff07008ec701e8028e2ceb8f83f0e4274ee62bd2dbdc4fefff2e9a91824081a"
SRC_URI[crypto-mac-0.8.0.sha256sum] = "b584a330336237c1eecd3e94266efb216c56ed91225d634cb2991c5f3fd1aeab"
SRC_URI[cstr-argument-0.1.2.sha256sum] = "b6bd9c8e659a473bce955ae5c35b116af38af11a7acb0b480e01f3ed348aeb40"
SRC_URI[ctr-0.6.0.sha256sum] = "fb4a30d54f7443bf3d6191dcd486aca19e67cb3c49fa7a06a319966346707e7f"
SRC_URI[dashmap-5.5.3.sha256sum] = "978747c1d849a7d2ee5e8adc0159961c48fb7e5db2f06af6723b80123bb53856"
SRC_URI[data-encoding-2.4.0.sha256sum] = "c2e66c9d817f1720209181c316d28635c050fa304f9c79e47a520882661b7308"
SRC_URI[deadpool-0.7.0.sha256sum] = "3d126179d86aee4556e54f5f3c6bf6d9884e7cc52cef82f77ee6f90a7747616d"
SRC_URI[derivative-2.2.0.sha256sum] = "fcc3dd5e9e9c0b295d6e1e4d811fb6f157d5ffd784b8d202fc62eac8035a770b"
SRC_URI[digest-0.10.7.sha256sum] = "9ed9a281f7bc9b7576e61468ba615a66a5c8cfdff42420a70aa82701a3b1e292"
SRC_URI[digest-0.9.0.sha256sum] = "d3dd60d1080a57a05ab032377049e0591415d2b31afd7028356dbf3cc6dcb066"
SRC_URI[discard-1.0.4.sha256sum] = "212d0f5754cb6769937f4501cc0e67f4f4483c8d2c3e1e922ee9edbe4ab4c7c0"
SRC_URI[embedded-graphics-core-0.3.3.sha256sum] = "b8b1239db5f3eeb7e33e35bd10bd014e7b2537b17e071f726a09351431337cfa"
SRC_URI[embedded-graphics-0.7.1.sha256sum] = "750082c65094fbcc4baf9ba31583ce9a8bb7f52cadfb96f6164b1bc7f922f32b"
SRC_URI[enumflags2-0.7.8.sha256sum] = "5998b4f30320c9d93aed72f63af821bfdac50465b75428fce77b48ec482c3939"
SRC_URI[enumflags2_derive-0.7.8.sha256sum] = "f95e2801cd355d4a1a3e3953ce6ee5ae9603a5c833455343a8bfe3f44d418246"
SRC_URI[env_logger-0.10.0.sha256sum] = "85cdab6a89accf66733ad5a1693a4dcced6aeff64602b634530dd73c1f3ee9f0"
SRC_URI[equivalent-1.0.1.sha256sum] = "5443807d6dff69373d433ab9ef5378ad8df50ca6298caf15de6e52e24aaf54d5"
SRC_URI[erased-serde-0.3.31.sha256sum] = "6c138974f9d5e7fe373eb04df7cae98833802ae4b11c24ac7039a21d5af4b26c"
SRC_URI[errno-dragonfly-0.1.2.sha256sum] = "aa68f1b12764fab894d2755d2518754e71b4fd80ecfb822714a1206c2aab39bf"
SRC_URI[errno-0.2.8.sha256sum] = "f639046355ee4f37944e44f60642c6f3a7efa3cf6b78c78a0d989a8ce6c396a1"
SRC_URI[errno-0.3.5.sha256sum] = "ac3e13f66a2f95e32a39eaa81f6b95d42878ca0e1db0c7543723dfe12557e860"
SRC_URI[evdev-0.12.1.sha256sum] = "2bed59fcc8cfd6b190814a509018388462d3b203cf6dd10db5c00087e72a83f3"
SRC_URI[event-listener-2.5.3.sha256sum] = "0206175f82b8d6bf6652ff7d71a1e27fd2e4efde587fd368662814d6ec1d9ce0"
SRC_URI[event-listener-3.0.1.sha256sum] = "01cec0252c2afff729ee6f00e903d479fba81784c8e2bd77447673471fdfaea1"
SRC_URI[fastrand-1.9.0.sha256sum] = "e51093e27b0797c359783294ca4f0a911c270184cb10f85783b118614a1501be"
SRC_URI[fastrand-2.0.1.sha256sum] = "25cbce373ec4653f1a01a31e8a5e5ec0c622dc27ff9c4e6606eefef5cbbed4a5"
SRC_URI[fdeflate-0.3.1.sha256sum] = "64d6dafc854908ff5da46ff3f8f473c6984119a2876a383a860246dd7841a868"
SRC_URI[femme-2.2.1.sha256sum] = "cc04871e5ae3aa2952d552dae6b291b3099723bf779a8054281c1366a54613ef"
SRC_URI[flate2-1.0.28.sha256sum] = "46303f565772937ffe1d394a4fac6f411c6013172fadde9dcdb1e147a086940e"
SRC_URI[float-cmp-0.8.0.sha256sum] = "e1267f4ac4f343772758f7b1bdcbe767c218bbab93bb432acbf5162bbf85a6c4"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[foreign-types-macros-0.2.3.sha256sum] = "1a5c6c585bc94aaf2c7b51dd4c2ba22680844aba4c687be581871a6f518c5742"
SRC_URI[foreign-types-shared-0.3.1.sha256sum] = "aa9a19cbb55df58761df49b23516a86d432839add4af60fc256da840f66ed35b"
SRC_URI[foreign-types-0.5.0.sha256sum] = "d737d9aa519fb7b749cbc3b962edcf310a8dd1f4b67c91c4f83975dbdd17d965"
SRC_URI[form_urlencoded-1.2.0.sha256sum] = "a62bc1cf6f830c2ec14a513a9fb124d0a213a629668a4186f329db21fe045652"
SRC_URI[framebuffer-0.3.1.sha256sum] = "878caaaf1bb92c9f707dc6eef90933e07e913dac4bb8e11e145eaabaa94ef149"
SRC_URI[funty-2.0.0.sha256sum] = "e6d5a32815ae3f33302d95fdcb2ce17862f8c65363dcfd29360480ba1001fc9c"
SRC_URI[futures-channel-0.3.29.sha256sum] = "ff4dd66668b557604244583e3e1e1eada8c5c2e96a6d0d6653ede395b78bbacb"
SRC_URI[futures-core-0.3.29.sha256sum] = "eb1d22c66e66d9d72e1758f0bd7d4fd0bee04cad842ee34587d68c07e45d088c"
SRC_URI[futures-executor-0.3.29.sha256sum] = "0f4fb8693db0cf099eadcca0efe2a5a22e4550f98ed16aba6c48700da29597bc"
SRC_URI[futures-io-0.3.29.sha256sum] = "8bf34a163b5c4c52d0478a4d757da8fb65cabef42ba90515efee0f6f9fa45aaa"
SRC_URI[futures-lite-1.13.0.sha256sum] = "49a9d51ce47660b1e808d3c990b4709f2f415d928835a17dfd16991515c46bce"
SRC_URI[futures-macro-0.3.29.sha256sum] = "53b153fd91e4b0147f4aced87be237c98248656bb01050b96bf3ee89220a8ddb"
SRC_URI[futures-sink-0.3.29.sha256sum] = "e36d3378ee38c2a36ad710c5d30c2911d752cb941c00c72dbabfb786a7970817"
SRC_URI[futures-task-0.3.29.sha256sum] = "efd193069b0ddadc69c46389b740bbccdd97203899b48d09c5f7969591d6bae2"
SRC_URI[futures-util-0.3.29.sha256sum] = "a19526d624e703a3179b3d322efec918b6246ea0fa51d41124525f00f1cc8104"
SRC_URI[futures-0.3.29.sha256sum] = "da0290714b38af9b4a7b094b8a37086d1b4e61f2df9122c3cad2577669145335"
SRC_URI[generic-array-0.14.7.sha256sum] = "85649ca51fd72272d7821adaf274ad91c288277713d9c18820d8499a7ff69e9a"
SRC_URI[getrandom-0.1.16.sha256sum] = "8fc3cb4d91f53b50155bdcfd23f6a4c39ae1969c2ae85982b135750cccaf5fce"
SRC_URI[getrandom-0.2.10.sha256sum] = "be4136b2a15dd319360be1c07d9933517ccf0be8f16bf62a3bee4f0d618df427"
SRC_URI[ghash-0.3.1.sha256sum] = "97304e4cd182c3846f7575ced3890c53012ce534ad9114046b0a9e00bb30a375"
SRC_URI[gimli-0.28.0.sha256sum] = "6fb8d784f27acf97159b40fc4db5ecd8aa23b9ad5ef69cdd136d3bc80665f0c0"
SRC_URI[gloo-timers-0.2.6.sha256sum] = "9b995a66bb87bebce9a0f4a95aed01daca4872c050bfcb21653361c03bc35e5c"
SRC_URI[gpio-cdev-0.5.1.sha256sum] = "409296415b8abc7b47e5b77096faae14595c53724972da227434fc8f4b05ec8b"
SRC_URI[hashbrown-0.14.2.sha256sum] = "f93e7192158dbcda357bdec5fb5788eebf8bbac027f3f33e719d29135ae84156"
SRC_URI[hermit-abi-0.3.3.sha256sum] = "d77f7ec81a6d05a3abb01ab6eb7590f6083d08449fe5a1c8b1e620283546ccb7"
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
SRC_URI[iana-time-zone-haiku-0.1.2.sha256sum] = "f31827a206f56af32e590ba56d5d2d085f558508192593743f16b2306495269f"
SRC_URI[iana-time-zone-0.1.58.sha256sum] = "8326b86b6cff230b97d0d312a6c40a60726df3332e721f72a1b035f451663b20"
SRC_URI[idna-0.4.0.sha256sum] = "7d20d6b07bfbc108882d88ed8e37d39636dcc260e15e30c45e6ba089610b917c"
SRC_URI[indexmap-2.1.0.sha256sum] = "d530e1a18b1cb4c484e6e34556a0d948706958449fca0cab753d649f2bce3d1f"
SRC_URI[industrial-io-0.5.2.sha256sum] = "3948a8818efcd4e0e189df60d79b58a9f4ae20b87437b2fde4dc4ca5b520c4ed"
SRC_URI[infer-0.2.3.sha256sum] = "64e9829a50b42bb782c1df523f78d332fe371b10c661e78b7a3c34b0198e9fac"
SRC_URI[instant-0.1.12.sha256sum] = "7a5bbe824c507c5da5956355e86a746d82e0e1464f65d862cc5e71da70e94b2c"
SRC_URI[io-lifetimes-1.0.11.sha256sum] = "eae7b9aee968036d54dce06cebaefd919e4472e753296daccd6d344e3e2df0c2"
SRC_URI[is-terminal-0.4.9.sha256sum] = "cb0889898416213fab133e1d33a0e5858a48177452750691bde3666d0fdbaf8b"
SRC_URI[itoa-1.0.9.sha256sum] = "af150ab688ff2122fcef229be89cb50dd66af9e01a4ff320cc137eecc9bacc38"
SRC_URI[js-sys-0.3.65.sha256sum] = "54c0c35952f67de54bb584e9fd912b3023117cbafc0a77d8f3dee1fb5f572fe8"
SRC_URI[kv-log-macro-1.0.7.sha256sum] = "0de8b303297635ad57c9f5059fd9cee7a47f8e8daa09df0fcd07dd39fb22977f"
SRC_URI[lazy_static-1.4.0.sha256sum] = "e2abad23fbc42b3700f2f279844dc832adb2b2eb069b2df918f455c4e18cc646"
SRC_URI[lexical-core-0.7.6.sha256sum] = "6607c62aa161d23d17a9072cc5da0be67cdfc89d3afb1e8d9c842bebc2525ffe"
SRC_URI[libc-0.2.149.sha256sum] = "a08173bc88b7955d1b3145aa561539096c421ac8debde8cbc3612ec635fee29b"
SRC_URI[libiio-sys-0.3.1.sha256sum] = "6d6c255d73b8f345bb10550b44e93b2b5c910a31ce72ee2528c5dbc028cf24ec"
SRC_URI[libsystemd-sys-0.9.3.sha256sum] = "ed080163caa59cc29b34bce2209b737149a4bac148cd9a8b04e4c12822798119"
SRC_URI[linux-raw-sys-0.3.8.sha256sum] = "ef53942eb7bf7ff43a617b3e2c1c4a5ecf5944a7c1bc12d7ee39bbb15e5c1519"
SRC_URI[linux-raw-sys-0.4.10.sha256sum] = "da2479e8c062e40bf0066ffa0bc823de0a9368974af99c9f6df941d2c231e03f"
SRC_URI[lock_api-0.4.11.sha256sum] = "3c168f8615b12bc01f9c17e2eb0cc07dcae1940121185446edc3744920e8ef45"
SRC_URI[log-0.4.20.sha256sum] = "b5e6163cb8c49088c2c36f57875e58ccd8c87c7427f7fbd50ea6710b2f3f2e8f"
SRC_URI[memchr-2.6.4.sha256sum] = "f665ee40bc4a3c5590afb1e9677db74a508659dfd71e126420da8274909a0167"
SRC_URI[memmap-0.7.0.sha256sum] = "6585fd95e7bb50d6cc31e20d4cf9afb4e2ba16c5846fc76793f11218da9c475b"
SRC_URI[memoffset-0.6.5.sha256sum] = "5aa361d4faea93603064a027415f07bd8e1d5c88c9fbf68bf56a285428fd79ce"
SRC_URI[memoffset-0.7.1.sha256sum] = "5de893c32cde5f383baa4c04c5d6dbdd735cfd4a794b0debdb2bb1b421da5ff4"
SRC_URI[micromath-1.1.1.sha256sum] = "bc4010833aea396656c2f91ee704d51a6f1329ec2ab56ffd00bfd56f7481ea94"
SRC_URI[mime-0.3.17.sha256sum] = "6877bb514081ee2a7ff5ef9de3281f14a4dd4bceac4c09388074a6b5df8a139a"
SRC_URI[mime_guess-2.0.4.sha256sum] = "4192263c238a5f0d0c6bfd21f336a313a4ce1c450542449ca191bb657b4642ef"
SRC_URI[miniz_oxide-0.7.1.sha256sum] = "e7810e0be55b428ada41041c41f32c9f1a42817901b4ccf45fa3d4b6561e74c7"
SRC_URI[mqtt-protocol-0.11.2.sha256sum] = "ca0b17380dc69fbcf5f967828cfd10e55028ba83a57da1f580c5b0792ab807ac"
SRC_URI[nix-0.23.2.sha256sum] = "8f3790c00a0150112de0f4cd161e3d7fc4b2d8a5542ffc35f099a2562aecb35c"
SRC_URI[nix-0.26.4.sha256sum] = "598beaf3cc6fdd9a5dfb1630c2800c7acd31df7aaf0f565796fba2b53ca1af1b"
SRC_URI[nom-5.1.3.sha256sum] = "08959a387a676302eebf4ddbcbc611da04285579f76f88ee0506c63b1a61dd4b"
SRC_URI[num-traits-0.2.17.sha256sum] = "39e3200413f237f41ab11ad6d161bc7239c84dcb631773ccd7de3dfe4b5c267c"
SRC_URI[num_cpus-1.16.0.sha256sum] = "4161fcb6d602d4d2081af7c3a45852d875a03dd337a6bfdd6e06407b61342a43"
SRC_URI[numtoa-0.2.4.sha256sum] = "6aa2c4e539b869820a2b82e1aef6ff40aa85e65decdd5185e83fb4b1249cd00f"
SRC_URI[object-0.32.1.sha256sum] = "9cf5f9dd3933bd50a9e1f149ec995f39ae2c496d31fd772c1fd45ebc27e902b0"
SRC_URI[once_cell-1.18.0.sha256sum] = "dd8b5dd2ae5ed71462c540258bedcb51965123ad7e7ccf4b9a8cafaa4a63576d"
SRC_URI[opaque-debug-0.3.0.sha256sum] = "624a8340c38c1b80fd549087862da4ba43e08858af025b236e509b6649fc13d5"
SRC_URI[ordered-stream-0.2.0.sha256sum] = "9aa2b01e1d916879f73a53d01d1d6cee68adbb31d6d9177a8cfce093cced1d50"
SRC_URI[parking-2.2.0.sha256sum] = "bb813b8af86854136c6922af0598d719255ecb2179515e6e7730d468f05c9cae"
SRC_URI[parking_lot_core-0.9.9.sha256sum] = "4c42a9226546d68acdd9c0a280d17ce19bfe27a46bf68784e4066115788d008e"
SRC_URI[percent-encoding-2.3.0.sha256sum] = "9b2a4787296e9989611394c33f193f676704af1686e70b8f8033ab5ba9a35a94"
SRC_URI[pin-project-internal-1.1.3.sha256sum] = "4359fd9c9171ec6e8c62926d6faaf553a8dc3f64e1507e76da7911b4f6a04405"
SRC_URI[pin-project-lite-0.1.12.sha256sum] = "257b64915a082f7811703966789728173279bdebb956b143dbcd23f6f970a777"
SRC_URI[pin-project-lite-0.2.13.sha256sum] = "8afb450f006bf6385ca15ef45d71d2288452bc3683ce2e2cacc0d18e4be60b58"
SRC_URI[pin-project-1.1.3.sha256sum] = "fda4ed1c6c173e3fc7a83629421152e01d7b1f9b7f65fb301e490e8cfc656422"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[piper-0.2.1.sha256sum] = "668d31b1c4eba19242f2088b2bf3316b82ca31082a8335764db4e083db7485d4"
SRC_URI[pkg-config-0.3.27.sha256sum] = "26072860ba924cbfa98ea39c8c19b4dd6a4a25423dbdf219c1eca91aa0cf6964"
SRC_URI[png-0.17.10.sha256sum] = "dd75bf2d8dd3702b9707cdbc56a5b9ef42cec752eb8b3bafc01234558442aa64"
SRC_URI[polling-2.8.0.sha256sum] = "4b2d323e8ca7996b3e23126511a523f7e62924d93ecd5ae73b333815b0eb3dce"
SRC_URI[polling-3.3.0.sha256sum] = "e53b6af1f60f36f8c2ac2aad5459d75a5a9b4be1e8cdd40264f315d78193e531"
SRC_URI[polyval-0.4.5.sha256sum] = "eebcc4aa140b9abd2bc40d9c3f7ccec842679cd79045ac3a7ac698c1a064b7cd"
SRC_URI[ppv-lite86-0.2.17.sha256sum] = "5b40af805b3121feab8a3c29f04d8ad262fa8e0561883e7653e024ae4479e6de"
SRC_URI[proc-macro-crate-1.3.1.sha256sum] = "7f4c021e1093a56626774e81216a4ce732a735e5bad4868a03f3ed65ca0c3919"
SRC_URI[proc-macro-hack-0.5.20+deprecated.sha256sum] = "dc375e1527247fe1a97d8b7156678dfe7c1af2fc075c9a4db3690ecd2a148068"
SRC_URI[proc-macro2-1.0.69.sha256sum] = "134c189feb4956b20f6f547d2cf727d4c0fe06722b20a0eec87ed445a97f92da"
SRC_URI[quote-1.0.33.sha256sum] = "5267fca4496028628a95160fc423a33e8b2e6af8a5302579e322e4b520293cae"
SRC_URI[radium-0.7.0.sha256sum] = "dc33ff2d4973d518d823d61aa239014831e521c75da58e3df4840d3f47749d09"
SRC_URI[rand-0.7.3.sha256sum] = "6a6b1679d49b24bbfe0c803429aa1874472f50d9b363131f0e89fc356b544d03"
SRC_URI[rand-0.8.5.sha256sum] = "34af8d1a0e25924bc5b7c43c079c942339d8f0a8b57c39049bef581b46327404"
SRC_URI[rand_chacha-0.2.2.sha256sum] = "f4c8ed856279c9737206bf725bf36935d8666ead7aa69b52be55af369d193402"
SRC_URI[rand_chacha-0.3.1.sha256sum] = "e6c10a63a0fa32252be49d21e7709d4d4baf8d231c2dbce1eaa8141b9b127d88"
SRC_URI[rand_core-0.5.1.sha256sum] = "90bde5296fc891b0cef12a6d03ddccc162ce7b2aff54160af9338f8d40df6d19"
SRC_URI[rand_core-0.6.4.sha256sum] = "ec0be4795e2f6a28069bec0b5ff3e2ac9bafc99e6a9a7dc3547996c5c816922c"
SRC_URI[rand_hc-0.2.0.sha256sum] = "ca3129af7b92a17112d59ad498c6f81eaf463253766b90396d39ea7a39d6613c"
SRC_URI[redox_syscall-0.4.1.sha256sum] = "4722d768eff46b75989dd134e5c353f0d6296e5aaa3132e776cbdb56be7731aa"
SRC_URI[regex-automata-0.4.3.sha256sum] = "5f804c7828047e88b2d32e2d7fe5a105da8ee3264f01902f796c8e067dc2483f"
SRC_URI[regex-syntax-0.8.2.sha256sum] = "c08c74e62047bb2de4ff487b251e4a92e24f48745648451635cec7d591162d9f"
SRC_URI[regex-1.10.2.sha256sum] = "380b951a9c5e80ddfd6136919eef32310721aa4aacd4889a8d39124b026ab343"
SRC_URI[route-recognizer-0.2.0.sha256sum] = "56770675ebc04927ded3e60633437841581c285dc6236109ea25fbf3beb7b59e"
SRC_URI[rustc-demangle-0.1.23.sha256sum] = "d626bb9dae77e28219937af045c257c28bfd3f69333c512553507f5f9798cb76"
SRC_URI[rustc_version-0.2.3.sha256sum] = "138e3e0acb6c9fb258b19b67cb8abd63c00679d2851805ea151465464fe9030a"
SRC_URI[rustix-0.37.27.sha256sum] = "fea8ca367a3a01fe35e6943c400addf443c0f57670e6ec51196f71a4b8762dd2"
SRC_URI[rustix-0.38.21.sha256sum] = "2b426b0506e5d50a7d8dafcf2e81471400deb602392c7dd110815afb4eaf02a3"
SRC_URI[rustversion-1.0.14.sha256sum] = "7ffc183a10b4478d04cbbbfc96d0873219d962dd5accaff2ffbd4ceb7df837f4"
SRC_URI[ryu-1.0.15.sha256sum] = "1ad4cc8da4ef723ed60bced201181d83791ad433213d8c24efffda1eec85d741"
SRC_URI[scopeguard-1.2.0.sha256sum] = "94143f37725109f92c262ed2cf5e59bce7498c01bcc1502d7b9afe439a4e9f49"
SRC_URI[semver-parser-0.7.0.sha256sum] = "388a1df253eca08550bef6c72392cfe7c30914bf41df5269b68cbd6ff8f570a3"
SRC_URI[semver-0.9.0.sha256sum] = "1d7eb9ef2c18661902cc47e535f9bc51b78acd254da71d375c2f6720d9a40403"
SRC_URI[serde-1.0.190.sha256sum] = "91d3c334ca1ee894a2c6f6ad698fe8c435b76d504b13d436f0685d648d6d96f7"
SRC_URI[serde_derive-1.0.190.sha256sum] = "67c5609f394e5c2bd7fc51efda478004ea80ef42fee983d5c67a65e34f32c0e3"
SRC_URI[serde_fmt-1.0.3.sha256sum] = "e1d4ddca14104cd60529e8c7f7ba71a2c8acd8f7f5cfcdc2faf97eeb7c3010a4"
SRC_URI[serde_json-1.0.108.sha256sum] = "3d1c7e3eac408d115102c4c24ad393e0821bb3a5df4d506a80f85f7a742a526b"
SRC_URI[serde_qs-0.8.5.sha256sum] = "c7715380eec75f029a4ef7de39a9200e0a63823176b759d055b613f5a87df6a6"
SRC_URI[serde_repr-0.1.17.sha256sum] = "3081f5ffbb02284dda55132aa26daecedd7372a42417bbbab6f14ab7d6bb9145"
SRC_URI[serde_urlencoded-0.7.1.sha256sum] = "d3491c14715ca2294c4d6a88f15e84739788c1d030eed8c110436aafdaa2f3fd"
SRC_URI[serde_yaml-0.9.27.sha256sum] = "3cc7a1570e38322cfe4154732e5110f887ea57e22b76f4bfd32b5bdd3368666c"
SRC_URI[sha-1-0.10.1.sha256sum] = "f5058ada175748e33390e40e872bd0fe59a19f265d0158daa551c5a88a76009c"
SRC_URI[sha1-0.10.6.sha256sum] = "e3bf829a2d51ab4a5ddf1352d8470c140cadc8301b2ae1789db023f01cedd6ba"
SRC_URI[sha1-0.6.1.sha256sum] = "c1da05c97445caa12d05e848c4a4fcbbea29e748ac28f7e80e9b010392063770"
SRC_URI[sha1_smol-1.0.0.sha256sum] = "ae1a47186c03a32177042e55dbc5fd5aee900b8e0069a8d70fba96a9375cd012"
SRC_URI[sha2-0.9.9.sha256sum] = "4d58a1e1bf39749807d89cf2d98ac2dfa0ff1cb3faa38fbb64dd88ac8013d800"
SRC_URI[signal-hook-registry-1.4.1.sha256sum] = "d8229b473baa5980ac72ef434c4415e70c4b5e71b423043adb4ba059f89c99a1"
SRC_URI[simd-adler32-0.3.7.sha256sum] = "d66dc143e6b11c1eddc06d5c423cfc97062865baf299914ab64caa38182078fe"
SRC_URI[simple-mutex-1.1.5.sha256sum] = "38aabbeafa6f6dead8cebf246fe9fae1f9215c8d29b3a69f93bd62a9e4a3dcd6"
SRC_URI[slab-0.4.9.sha256sum] = "8f92a496fb766b417c996b9c5e57daf2f7ad3b0bebe1ccfca4856390e3d3bb67"
SRC_URI[smallvec-1.11.1.sha256sum] = "942b4a808e05215192e39f4ab80813e599068285906cc91aa64f923db842bd5a"
SRC_URI[socket2-0.4.10.sha256sum] = "9f7916fc008ca5542385b89a3d3ce689953c143e9304a9bf8beec1de48994c0d"
SRC_URI[standback-0.2.17.sha256sum] = "e113fb6f3de07a243d434a56ec6f186dfd51cb08448239fe7bcae73f87ff28ff"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[stdweb-derive-0.5.3.sha256sum] = "c87a60a40fccc84bef0652345bbbbbe20a605bf5d0ce81719fc476f5c03b50ef"
SRC_URI[stdweb-internal-macros-0.2.9.sha256sum] = "58fa5ff6ad0d98d1ffa8cb115892b6e69d67799f6763e162a1c9db421dc22e11"
SRC_URI[stdweb-internal-runtime-0.1.5.sha256sum] = "213701ba3370744dcd1a12960caa4843b3d68b4d1c0a5d575e0d65b2ee9d16c0"
SRC_URI[stdweb-0.4.20.sha256sum] = "d022496b16281348b52d0e30ae99e01a73d737b2f45d38fed4edf79f9325a1d5"
SRC_URI[subtle-2.4.1.sha256sum] = "6bdef32e8150c2a081110b42772ffe7d7c9032b606bc226c8260fd97e0976601"
SRC_URI[surf-2.3.2.sha256sum] = "718b1ae6b50351982dedff021db0def601677f2120938b070eadb10ba4038dd7"
SRC_URI[sval-2.10.2.sha256sum] = "b15df12a8db7c216a04b4b438f90d50d5335cd38f161b56389c9f5c9d96d0873"
SRC_URI[sval_buffer-2.10.2.sha256sum] = "57e80556bc8acea0446e574ce542ad6114a76a0237f28a842bc01ca3ea98f479"
SRC_URI[sval_dynamic-2.10.2.sha256sum] = "9d93d2259edb1d7b4316179f0a98c62e3ffc726f47ab200e07cfe382771f57b8"
SRC_URI[sval_fmt-2.10.2.sha256sum] = "532f7f882226f7a5a4656f5151224aaebf8217e0d539cb1595b831bace921343"
SRC_URI[sval_json-2.10.2.sha256sum] = "76e03bd8aa0ae6ee018f7ae95c9714577687a4415bd1a5f19b26e34695f7e072"
SRC_URI[sval_ref-2.10.2.sha256sum] = "75ed054f2fb8c2a0ab5d36c1ec57b412919700099fc5e32ad8e7a38b23e1a9e1"
SRC_URI[sval_serde-2.10.2.sha256sum] = "7ff191c4ff05b67e3844c161021427646cde5d6624597958be158357d9200586"
SRC_URI[syn-1.0.109.sha256sum] = "72b64191b275b66ffe2469e8af2c1cfe3bafa67b529ead792a6d0160888b4237"
SRC_URI[syn-2.0.38.sha256sum] = "e96b79aaa137db8f61e26363a0c9b47d8b4ec75da28b7d1d614c2303e232408b"
SRC_URI[sysfs-class-0.1.3.sha256sum] = "5e1bbcf869732c45a77898f7f61ed6d411dfc37613517e444842f58d428856d1"
SRC_URI[systemd-0.10.0.sha256sum] = "afec0101d9ae8ab26aedf0840109df689938ea7e538aa03df4369f1854f11562"
SRC_URI[tap-1.0.1.sha256sum] = "55937e1799185b12863d447f42597ed69d9928686b8d88a1df17376a097d8369"
SRC_URI[tempfile-3.8.1.sha256sum] = "7ef1adac450ad7f4b3c28589471ade84f25f731a7a0fe30d71dfa9f60fd808e5"
SRC_URI[termcolor-1.3.0.sha256sum] = "6093bad37da69aab9d123a8091e4be0aa4a03e4d601ec641c327398315f62b64"
SRC_URI[thiserror-impl-1.0.50.sha256sum] = "266b2e40bc00e5a6c09c3584011e08b06f123c00362c92b975ba9843aaaa14b8"
SRC_URI[thiserror-1.0.50.sha256sum] = "f9a7210f5c9a7156bb50aa36aed4c95afb51df0df00713949448cf9e97d382d2"
SRC_URI[thread-priority-0.13.1.sha256sum] = "0c56ce92f1285eaaa11fc1a3201e25de97898c50e87caa4c2aee836fe05288de"
SRC_URI[tide-0.16.0.sha256sum] = "c459573f0dd2cc734b539047f57489ea875af8ee950860ded20cf93a79a1dee0"
SRC_URI[time-macros-impl-0.1.2.sha256sum] = "fd3c141a1b43194f3f56a1411225df8646c55781d5f26db825b3d98507eb482f"
SRC_URI[time-macros-0.1.1.sha256sum] = "957e9c6e26f12cb6d0dd7fc776bb67a706312e7299aed74c8dd5b17ebb27e2f1"
SRC_URI[time-0.2.27.sha256sum] = "4752a97f8eebd6854ff91f1c1824cd6160626ac4bd44287f7f4ea2035a02a242"
SRC_URI[tinyvec-1.6.0.sha256sum] = "87cc5ceb3875bb20c2890005a4e226a4651264a5c75edb2421b52861a0a0cb50"
SRC_URI[tinyvec_macros-0.1.1.sha256sum] = "1f3ccbac311fea05f86f61904b462b55fb3df8837a366dfc601a0161d0532f20"
SRC_URI[tokio-1.33.0.sha256sum] = "4f38200e3ef7995e5ef13baec2f432a6da0aa9ac495b2c0e8f3b7eec2c92d653"
SRC_URI[toml_datetime-0.6.5.sha256sum] = "3550f4e9685620ac18a50ed434eb3aec30db8ba93b0287467bca5826ea25baf1"
SRC_URI[toml_edit-0.19.15.sha256sum] = "1b5bb770da30e5cbfde35a2d7b9b8a2c4b8ef89548a7a6aeab5c9a576e3e7421"
SRC_URI[tracing-attributes-0.1.27.sha256sum] = "34704c8d6ebcbc939824180af020566b01a7c01f80641264eba0999f6c2b6be7"
SRC_URI[tracing-core-0.1.32.sha256sum] = "c06d3da6113f116aaee68e4d601191614c9053067f9ab7f6edbcb161237daa54"
SRC_URI[tracing-0.1.40.sha256sum] = "c3523ab5a71916ccf420eebdf5521fcef02141234bbc0b8a49f2fdc4544364ef"
SRC_URI[tungstenite-0.19.0.sha256sum] = "15fba1a6d6bb030745759a9a2a588bfe8490fc8b4751a277db3a0be1c9ebbf67"
SRC_URI[typenum-1.17.0.sha256sum] = "42ff0bf0c66b8238c6f3b578df37d0b7848e55df8577b3f74f92a69acceeb825"
SRC_URI[uds_windows-1.0.2.sha256sum] = "ce65604324d3cce9b966701489fbd0cf318cb1f7bd9dd07ac9a4ee6fb791930d"
SRC_URI[unicase-2.7.0.sha256sum] = "f7d2d4dafb69621809a81864c9c1b864479e1235c0dd4e199924b9742439ed89"
SRC_URI[unicode-bidi-0.3.13.sha256sum] = "92888ba5573ff080736b3648696b70cafad7d250551175acbaa4e0385b3e1460"
SRC_URI[unicode-ident-1.0.12.sha256sum] = "3354b9ac3fae1ff6755cb6db53683adb661634f67557942dea4facebec0fee4b"
SRC_URI[unicode-normalization-0.1.22.sha256sum] = "5c5713f0fc4b5db668a2ac63cdb7bb4469d8c9fed047b1d0292cc7b0ce2ba921"
SRC_URI[unique-token-0.2.0.sha256sum] = "d3be9e39e944fa35b07f5eb280902bf4d2dc29dfbc26175230a0d0ea124a7b66"
SRC_URI[universal-hash-0.4.1.sha256sum] = "9f214e8f697e925001e66ec2c6e37a4ef93f0f78c2eed7814394e10c62025b05"
SRC_URI[unsafe-libyaml-0.2.9.sha256sum] = "f28467d3e1d3c6586d8f25fa243f544f5800fec42d97032474e17222c2b75cfa"
SRC_URI[url-2.4.1.sha256sum] = "143b538f18257fac9cad154828a57c6bf5157e1aa604d4816b5995bf6de87ae5"
SRC_URI[utf-8-0.7.6.sha256sum] = "09cc8ee72d2a9becf2f2febe0205bbed8fc6615b7cb429ad062dc7b7ddd036a9"
SRC_URI[utf8-cstr-0.1.6.sha256sum] = "55bcbb425141152b10d5693095950b51c3745d019363fc2929ffd8f61449b628"
SRC_URI[utf8-width-0.1.6.sha256sum] = "5190c9442dcdaf0ddd50f37420417d219ae5261bbf5db120d0f9bab996c9cba1"
SRC_URI[value-bag-serde1-1.4.2.sha256sum] = "07ba39dc791ecb35baad371a3fc04c6eab688c04937d2e0ac6c22b612c0357bf"
SRC_URI[value-bag-sval2-1.4.2.sha256sum] = "c3e06c10810a57bbf45778d023d432a50a1daa7d185991ae06bcfb6c654d0945"
SRC_URI[value-bag-1.4.2.sha256sum] = "4a72e1902dde2bd6441347de2b70b7f5d59bf157c6c62f0c44572607a1d55bbe"
SRC_URI[version_check-0.9.4.sha256sum] = "49874b5167b65d7193b8aba1567f5c7d93d001cafc34600cee003eda787e483f"
SRC_URI[waker-fn-1.1.1.sha256sum] = "f3c4517f54858c779bbcbf228f4fca63d121bf85fbecb2dc578cdf4a39395690"
SRC_URI[wasi-0.11.0+wasi-snapshot-preview1.sha256sum] = "9c8d87e72b64a3b4db28d11ce29237c246188f4f51057d65a7eab63b7987e423"
SRC_URI[wasi-0.9.0+wasi-snapshot-preview1.sha256sum] = "cccddf32554fecc6acb585f82a32a72e28b48f8c4c1883ddfeeeaa96f7d8e519"
SRC_URI[wasm-bindgen-backend-0.2.88.sha256sum] = "e397f4664c0e4e428e8313a469aaa58310d302159845980fd23b0f22a847f217"
SRC_URI[wasm-bindgen-futures-0.4.38.sha256sum] = "9afec9963e3d0994cac82455b2b3502b81a7f40f9a0d32181f7528d9f4b43e02"
SRC_URI[wasm-bindgen-macro-support-0.2.88.sha256sum] = "c5353b8dab669f5e10f5bd76df26a9360c748f054f862ff5f3f8aae0c7fb3907"
SRC_URI[wasm-bindgen-macro-0.2.88.sha256sum] = "5961017b3b08ad5f3fe39f1e79877f8ee7c23c5e5fd5eb80de95abc41f1f16b2"
SRC_URI[wasm-bindgen-shared-0.2.88.sha256sum] = "0d046c5d029ba91a1ed14da14dca44b68bf2f124cfbaf741c54151fdb3e0750b"
SRC_URI[wasm-bindgen-0.2.88.sha256sum] = "7daec296f25a1bae309c0cd5c29c4b260e510e6d813c286b19eaadf409d40fce"
SRC_URI[web-sys-0.3.65.sha256sum] = "5db499c5f66323272151db0e666cd34f78617522fb0c1604d31a27c50c206a85"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.6.sha256sum] = "f29e6f9198ba0d26b4c9f07dbe6f9ed633e1f3d5b8b414090084349e46a52596"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-core-0.51.1.sha256sum] = "f1f8cf84f35d2db49a46868f947758c7a1138116f7fac3bc844f43ade1292e64"
SRC_URI[windows-sys-0.48.0.sha256sum] = "677d2418bec65e3338edb076e806bc1ec15693c5d0104683f2efe857f61056a9"
SRC_URI[windows-targets-0.48.5.sha256sum] = "9a2fa6e2155d7247be68c096456083145c183cbbbc2764150dda45a87197940c"
SRC_URI[windows_aarch64_gnullvm-0.48.5.sha256sum] = "2b38e32f0abccf9987a4e3079dfb67dcd799fb61361e53e2882c3cbaf0d905d8"
SRC_URI[windows_aarch64_msvc-0.48.5.sha256sum] = "dc35310971f3b2dbbf3f0690a219f40e2d9afcf64f9ab7cc1be722937c26b4bc"
SRC_URI[windows_i686_gnu-0.48.5.sha256sum] = "a75915e7def60c94dcef72200b9a8e58e5091744960da64ec734a6c6e9b3743e"
SRC_URI[windows_i686_msvc-0.48.5.sha256sum] = "8f55c233f70c4b27f66c523580f78f1004e8b5a8b659e05a4eb49d4166cca406"
SRC_URI[windows_x86_64_gnu-0.48.5.sha256sum] = "53d40abd2583d23e4718fddf1ebec84dbff8381c07cae67ff7768bbf19c6718e"
SRC_URI[windows_x86_64_gnullvm-0.48.5.sha256sum] = "0b7b52767868a23d5bab768e390dc5f5c55825b6d30b86c844ff2dc7414044cc"
SRC_URI[windows_x86_64_msvc-0.48.5.sha256sum] = "ed94fce61571a4006852b7389a063ab983c02eb1bb37b47f8272ce92d06d9538"
SRC_URI[winnow-0.5.18.sha256sum] = "176b6138793677221d420fd2f0aeeced263f197688b36484660da767bca2fa32"
SRC_URI[wyz-0.5.1.sha256sum] = "05f360fc0b24296329c78fda852a1e9ae82de9cf7b27dae4b7f62f118f77b9ed"
SRC_URI[xdg-home-1.0.0.sha256sum] = "2769203cd13a0c6015d515be729c526d041e9cf2c0cc478d57faee85f40c6dcd"
SRC_URI[zbus-3.14.1.sha256sum] = "31de390a2d872e4cd04edd71b425e29853f786dc99317ed72d73d6fcf5ebb948"
SRC_URI[zbus_macros-3.14.1.sha256sum] = "41d1794a946878c0e807f55a397187c11fc7a038ba5d868e7db4f3bd7760bc9d"
SRC_URI[zbus_names-2.6.0.sha256sum] = "fb80bb776dbda6e23d705cf0123c3b95df99c4ebeaec6c2599d4a5419902b4a9"
SRC_URI[zvariant-3.15.0.sha256sum] = "44b291bee0d960c53170780af148dca5fa260a63cdd24f1962fa82e03e53338c"
SRC_URI[zvariant_derive-3.15.0.sha256sum] = "934d7a7dfc310d6ee06c87ffe88ef4eca7d3e37bb251dece2ef93da8f17d8ecd"
SRC_URI[zvariant_utils-1.0.1.sha256sum] = "7234f0d811589db492d16893e3f21e8e2fd282e6d01b0cddee310322062cc200"

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
