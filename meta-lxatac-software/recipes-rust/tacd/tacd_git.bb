inherit cargo

DEFAULT_PREFERENCE = "-1"

SRC_URI += "git://github.com/linux-automation/tacd.git;protocol=https;branch=main"
SRCREV = "e79b017da65f4a084a8b24f1118e15b0c3f25ae8"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = ""
PV = "0.1.0+git${SRCPV}"

SRC_URI += " \
    crate://crates.io/addr2line/0.22.0 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/aead/0.3.2 \
    crate://crates.io/aes-gcm/0.8.0 \
    crate://crates.io/aes-soft/0.6.4 \
    crate://crates.io/aes/0.6.0 \
    crate://crates.io/aesni/0.10.0 \
    crate://crates.io/aho-corasick/1.1.3 \
    crate://crates.io/android-tzdata/0.1.1 \
    crate://crates.io/android_system_properties/0.1.5 \
    crate://crates.io/anyhow/1.0.86 \
    crate://crates.io/arrayref/0.3.8 \
    crate://crates.io/arrayvec/0.5.2 \
    crate://crates.io/async-attributes/1.1.2 \
    crate://crates.io/async-broadcast/0.5.1 \
    crate://crates.io/async-channel/1.9.0 \
    crate://crates.io/async-channel/2.3.1 \
    crate://crates.io/async-dup/1.2.4 \
    crate://crates.io/async-executor/1.13.0 \
    crate://crates.io/async-fs/1.6.0 \
    crate://crates.io/async-global-executor/2.4.1 \
    crate://crates.io/async-h1/2.3.4 \
    crate://crates.io/async-io/1.13.0 \
    crate://crates.io/async-io/2.3.3 \
    crate://crates.io/async-lock/2.8.0 \
    crate://crates.io/async-lock/3.4.0 \
    crate://crates.io/async-process/1.8.1 \
    crate://crates.io/async-recursion/1.1.1 \
    crate://crates.io/async-session/2.0.1 \
    crate://crates.io/async-signal/0.2.9 \
    crate://crates.io/async-sse/4.1.0 \
    crate://crates.io/async-sse/5.1.0 \
    crate://crates.io/async-std/1.12.0 \
    crate://crates.io/async-task/4.7.1 \
    crate://crates.io/async-trait/0.1.81 \
    crate://crates.io/async-tungstenite/0.22.2 \
    crate://crates.io/atomic-waker/1.1.2 \
    crate://crates.io/autocfg/1.3.0 \
    crate://crates.io/az/1.2.1 \
    crate://crates.io/backtrace/0.3.73 \
    crate://crates.io/base-x/0.2.11 \
    crate://crates.io/base64/0.12.3 \
    crate://crates.io/base64/0.13.1 \
    crate://crates.io/base64/0.21.7 \
    crate://crates.io/bincode/1.3.3 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/bitflags/2.6.0 \
    crate://crates.io/bitvec/1.0.1 \
    crate://crates.io/blake3/0.3.8 \
    crate://crates.io/block-buffer/0.10.4 \
    crate://crates.io/block-buffer/0.9.0 \
    crate://crates.io/blocking/1.6.1 \
    crate://crates.io/build-env/0.3.1 \
    crate://crates.io/bumpalo/3.16.0 \
    crate://crates.io/byteorder/1.5.0 \
    crate://crates.io/bytes/1.7.1 \
    crate://crates.io/cc/1.1.7 \
    crate://crates.io/cfg-if/0.1.10 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/chrono/0.4.38 \
    crate://crates.io/cipher/0.2.5 \
    crate://crates.io/concurrent-queue/2.5.0 \
    crate://crates.io/config/0.10.1 \
    crate://crates.io/const_fn/0.4.10 \
    crate://crates.io/constant_time_eq/0.1.5 \
    crate://crates.io/cookie/0.14.4 \
    crate://crates.io/core-foundation-sys/0.8.6 \
    crate://crates.io/cpufeatures/0.2.12 \
    crate://crates.io/cpuid-bool/0.2.0 \
    crate://crates.io/crc32fast/1.4.2 \
    crate://crates.io/crossbeam-queue/0.3.11 \
    crate://crates.io/crossbeam-utils/0.8.20 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/crypto-mac/0.10.1 \
    crate://crates.io/crypto-mac/0.8.0 \
    crate://crates.io/cstr-argument/0.1.2 \
    crate://crates.io/ctr/0.6.0 \
    crate://crates.io/dashmap/5.5.3 \
    crate://crates.io/data-encoding/2.6.0 \
    crate://crates.io/deadpool/0.7.0 \
    crate://crates.io/derivative/2.2.0 \
    crate://crates.io/digest/0.10.7 \
    crate://crates.io/digest/0.9.0 \
    crate://crates.io/discard/1.0.4 \
    crate://crates.io/embedded-graphics-core/0.3.3 \
    crate://crates.io/embedded-graphics/0.7.1 \
    crate://crates.io/enumflags2/0.7.10 \
    crate://crates.io/enumflags2_derive/0.7.10 \
    crate://crates.io/env_logger/0.10.2 \
    crate://crates.io/equivalent/1.0.1 \
    crate://crates.io/erased-serde/0.4.5 \
    crate://crates.io/errno-dragonfly/0.1.2 \
    crate://crates.io/errno/0.2.8 \
    crate://crates.io/errno/0.3.9 \
    crate://crates.io/evdev/0.12.2 \
    crate://crates.io/event-listener-strategy/0.5.2 \
    crate://crates.io/event-listener/2.5.3 \
    crate://crates.io/event-listener/3.1.0 \
    crate://crates.io/event-listener/5.3.1 \
    crate://crates.io/fastrand/1.9.0 \
    crate://crates.io/fastrand/2.1.0 \
    crate://crates.io/fdeflate/0.3.4 \
    crate://crates.io/femme/2.2.1 \
    crate://crates.io/flate2/1.0.30 \
    crate://crates.io/float-cmp/0.8.0 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/foreign-types-macros/0.2.3 \
    crate://crates.io/foreign-types-shared/0.3.1 \
    crate://crates.io/foreign-types/0.5.0 \
    crate://crates.io/form_urlencoded/1.2.1 \
    crate://crates.io/framebuffer/0.3.1 \
    crate://crates.io/funty/2.0.0 \
    crate://crates.io/futures-channel/0.3.30 \
    crate://crates.io/futures-core/0.3.30 \
    crate://crates.io/futures-executor/0.3.30 \
    crate://crates.io/futures-io/0.3.30 \
    crate://crates.io/futures-lite/1.13.0 \
    crate://crates.io/futures-lite/2.3.0 \
    crate://crates.io/futures-macro/0.3.30 \
    crate://crates.io/futures-sink/0.3.30 \
    crate://crates.io/futures-task/0.3.30 \
    crate://crates.io/futures-util/0.3.30 \
    crate://crates.io/futures/0.3.30 \
    crate://crates.io/generic-array/0.14.7 \
    crate://crates.io/getrandom/0.1.16 \
    crate://crates.io/getrandom/0.2.15 \
    crate://crates.io/ghash/0.3.1 \
    crate://crates.io/gimli/0.29.0 \
    crate://crates.io/gloo-timers/0.2.6 \
    crate://crates.io/gpio-cdev/0.5.1 \
    crate://crates.io/hashbrown/0.14.5 \
    crate://crates.io/hermit-abi/0.3.9 \
    crate://crates.io/hermit-abi/0.4.0 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/hkdf/0.10.0 \
    crate://crates.io/hmac/0.10.1 \
    crate://crates.io/hmac/0.8.1 \
    crate://crates.io/html-escape/0.2.13 \
    crate://crates.io/http-client/6.5.3 \
    crate://crates.io/http-types/2.12.0 \
    crate://crates.io/http/0.2.12 \
    crate://crates.io/httparse/1.9.4 \
    crate://crates.io/humantime/2.1.0 \
    crate://crates.io/iana-time-zone-haiku/0.1.2 \
    crate://crates.io/iana-time-zone/0.1.60 \
    crate://crates.io/idna/0.5.0 \
    crate://crates.io/indexmap/2.3.0 \
    crate://crates.io/industrial-io/0.5.2 \
    crate://crates.io/infer/0.2.3 \
    crate://crates.io/instant/0.1.13 \
    crate://crates.io/io-lifetimes/1.0.11 \
    crate://crates.io/is-terminal/0.4.12 \
    crate://crates.io/itoa/1.0.11 \
    crate://crates.io/js-sys/0.3.69 \
    crate://crates.io/kv-log-macro/1.0.7 \
    crate://crates.io/lazy_static/1.5.0 \
    crate://crates.io/lexical-core/0.7.6 \
    crate://crates.io/libc/0.2.155 \
    crate://crates.io/libiio-sys/0.3.1 \
    crate://crates.io/libsystemd-sys/0.9.3 \
    crate://crates.io/linux-raw-sys/0.3.8 \
    crate://crates.io/linux-raw-sys/0.4.14 \
    crate://crates.io/lock_api/0.4.12 \
    crate://crates.io/log/0.4.22 \
    crate://crates.io/memchr/2.7.4 \
    crate://crates.io/memmap/0.7.0 \
    crate://crates.io/memoffset/0.6.5 \
    crate://crates.io/memoffset/0.7.1 \
    crate://crates.io/memoffset/0.9.1 \
    crate://crates.io/micromath/1.1.1 \
    crate://crates.io/mime/0.3.17 \
    crate://crates.io/mime_guess/2.0.5 \
    crate://crates.io/miniz_oxide/0.7.4 \
    crate://crates.io/mqtt-protocol/0.11.2 \
    crate://crates.io/nix/0.23.2 \
    crate://crates.io/nix/0.26.4 \
    crate://crates.io/nom/5.1.3 \
    crate://crates.io/num-traits/0.2.19 \
    crate://crates.io/num_cpus/1.16.0 \
    crate://crates.io/numtoa/0.2.4 \
    crate://crates.io/object/0.36.2 \
    crate://crates.io/once_cell/1.19.0 \
    crate://crates.io/opaque-debug/0.3.1 \
    crate://crates.io/ordered-stream/0.2.0 \
    crate://crates.io/parking/2.2.0 \
    crate://crates.io/parking_lot_core/0.9.10 \
    crate://crates.io/percent-encoding/2.3.1 \
    crate://crates.io/pin-project-internal/1.1.5 \
    crate://crates.io/pin-project-lite/0.1.12 \
    crate://crates.io/pin-project-lite/0.2.14 \
    crate://crates.io/pin-project/1.1.5 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/piper/0.2.3 \
    crate://crates.io/pkg-config/0.3.30 \
    crate://crates.io/png/0.17.13 \
    crate://crates.io/polling/2.8.0 \
    crate://crates.io/polling/3.7.2 \
    crate://crates.io/polyval/0.4.5 \
    crate://crates.io/ppv-lite86/0.2.18 \
    crate://crates.io/proc-macro-crate/1.3.1 \
    crate://crates.io/proc-macro-hack/0.5.20+deprecated \
    crate://crates.io/proc-macro2/1.0.86 \
    crate://crates.io/quote/1.0.36 \
    crate://crates.io/radium/0.7.0 \
    crate://crates.io/rand/0.7.3 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.2.2 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.5.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/rand_hc/0.2.0 \
    crate://crates.io/redox_syscall/0.5.3 \
    crate://crates.io/regex-automata/0.4.7 \
    crate://crates.io/regex-syntax/0.8.4 \
    crate://crates.io/regex/1.10.5 \
    crate://crates.io/route-recognizer/0.2.0 \
    crate://crates.io/rustc-demangle/0.1.24 \
    crate://crates.io/rustc_version/0.2.3 \
    crate://crates.io/rustix/0.37.27 \
    crate://crates.io/rustix/0.38.34 \
    crate://crates.io/rustversion/1.0.17 \
    crate://crates.io/ryu/1.0.18 \
    crate://crates.io/scopeguard/1.2.0 \
    crate://crates.io/semver-parser/0.7.0 \
    crate://crates.io/semver/0.9.0 \
    crate://crates.io/serde/1.0.204 \
    crate://crates.io/serde_derive/1.0.204 \
    crate://crates.io/serde_fmt/1.0.3 \
    crate://crates.io/serde_json/1.0.122 \
    crate://crates.io/serde_qs/0.8.5 \
    crate://crates.io/serde_repr/0.1.19 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/serde_yaml/0.9.34+deprecated \
    crate://crates.io/sha-1/0.10.1 \
    crate://crates.io/sha1/0.10.6 \
    crate://crates.io/sha1/0.6.1 \
    crate://crates.io/sha1_smol/1.0.1 \
    crate://crates.io/sha2/0.9.9 \
    crate://crates.io/signal-hook-registry/1.4.2 \
    crate://crates.io/simd-adler32/0.3.7 \
    crate://crates.io/slab/0.4.9 \
    crate://crates.io/smallvec/1.13.2 \
    crate://crates.io/socket2/0.4.10 \
    crate://crates.io/standback/0.2.17 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/stdweb-derive/0.5.3 \
    crate://crates.io/stdweb-internal-macros/0.2.9 \
    crate://crates.io/stdweb-internal-runtime/0.1.5 \
    crate://crates.io/stdweb/0.4.20 \
    crate://crates.io/subtle/2.4.1 \
    crate://crates.io/surf/2.3.2 \
    crate://crates.io/sval/2.13.0 \
    crate://crates.io/sval_buffer/2.13.0 \
    crate://crates.io/sval_dynamic/2.13.0 \
    crate://crates.io/sval_fmt/2.13.0 \
    crate://crates.io/sval_json/2.13.0 \
    crate://crates.io/sval_nested/2.13.0 \
    crate://crates.io/sval_ref/2.13.0 \
    crate://crates.io/sval_serde/2.13.0 \
    crate://crates.io/syn/1.0.109 \
    crate://crates.io/syn/2.0.72 \
    crate://crates.io/sysfs-class/0.1.3 \
    crate://crates.io/systemd/0.10.0 \
    crate://crates.io/tap/1.0.1 \
    crate://crates.io/tempfile/3.10.1 \
    crate://crates.io/termcolor/1.4.1 \
    crate://crates.io/thiserror-impl/1.0.63 \
    crate://crates.io/thiserror/1.0.63 \
    crate://crates.io/thread-priority/0.13.1 \
    crate://crates.io/tide/0.16.0 \
    crate://crates.io/time-macros-impl/0.1.2 \
    crate://crates.io/time-macros/0.1.1 \
    crate://crates.io/time/0.2.27 \
    crate://crates.io/tinyvec/1.8.0 \
    crate://crates.io/tinyvec_macros/0.1.1 \
    crate://crates.io/tokio/1.39.2 \
    crate://crates.io/toml_datetime/0.6.8 \
    crate://crates.io/toml_edit/0.19.15 \
    crate://crates.io/tracing-attributes/0.1.27 \
    crate://crates.io/tracing-core/0.1.32 \
    crate://crates.io/tracing/0.1.40 \
    crate://crates.io/tungstenite/0.19.0 \
    crate://crates.io/typeid/1.0.0 \
    crate://crates.io/typenum/1.17.0 \
    crate://crates.io/uds_windows/1.1.0 \
    crate://crates.io/unicase/2.7.0 \
    crate://crates.io/unicode-bidi/0.3.15 \
    crate://crates.io/unicode-ident/1.0.12 \
    crate://crates.io/unicode-normalization/0.1.23 \
    crate://crates.io/unique-token/0.2.0 \
    crate://crates.io/universal-hash/0.4.1 \
    crate://crates.io/unsafe-libyaml/0.2.11 \
    crate://crates.io/url/2.5.2 \
    crate://crates.io/utf-8/0.7.6 \
    crate://crates.io/utf8-cstr/0.1.6 \
    crate://crates.io/utf8-width/0.1.7 \
    crate://crates.io/value-bag-serde1/1.9.0 \
    crate://crates.io/value-bag-sval2/1.9.0 \
    crate://crates.io/value-bag/1.9.0 \
    crate://crates.io/version_check/0.9.5 \
    crate://crates.io/waker-fn/1.2.0 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.9.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.92 \
    crate://crates.io/wasm-bindgen-futures/0.4.42 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.92 \
    crate://crates.io/wasm-bindgen-macro/0.2.92 \
    crate://crates.io/wasm-bindgen-shared/0.2.92 \
    crate://crates.io/wasm-bindgen/0.2.92 \
    crate://crates.io/web-sys/0.3.69 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.8 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-core/0.52.0 \
    crate://crates.io/windows-sys/0.48.0 \
    crate://crates.io/windows-sys/0.52.0 \
    crate://crates.io/windows-targets/0.48.5 \
    crate://crates.io/windows-targets/0.52.6 \
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
    crate://crates.io/winnow/0.5.40 \
    crate://crates.io/wyz/0.5.1 \
    crate://crates.io/xdg-home/1.2.0 \
    crate://crates.io/zbus/3.15.2 \
    crate://crates.io/zbus_macros/3.15.2 \
    crate://crates.io/zbus_names/2.6.1 \
    crate://crates.io/zerocopy-derive/0.6.6 \
    crate://crates.io/zerocopy/0.6.6 \
    crate://crates.io/zvariant/3.15.2 \
    crate://crates.io/zvariant_derive/3.15.2 \
    crate://crates.io/zvariant_utils/1.0.1 \
"

SRC_URI[addr2line-0.22.0.sha256sum] = "6e4503c46a5c0c7844e948c9a4d6acd9f50cccb4de1c48eb9e291ea17470c678"
SRC_URI[adler-1.0.2.sha256sum] = "f26201604c87b1e01bd3d98f8d5d9a8fcbb815e8cedb41ffccbeb4bf593a35fe"
SRC_URI[aead-0.3.2.sha256sum] = "7fc95d1bdb8e6666b2b217308eeeb09f2d6728d104be3e31916cc74d15420331"
SRC_URI[aes-gcm-0.8.0.sha256sum] = "5278b5fabbb9bd46e24aa69b2fdea62c99088e0a950a9be40e3e0101298f88da"
SRC_URI[aes-soft-0.6.4.sha256sum] = "be14c7498ea50828a38d0e24a765ed2effe92a705885b57d029cd67d45744072"
SRC_URI[aes-0.6.0.sha256sum] = "884391ef1066acaa41e766ba8f596341b96e93ce34f9a43e7d24bf0a0eaf0561"
SRC_URI[aesni-0.10.0.sha256sum] = "ea2e11f5e94c2f7d386164cc2aa1f97823fed6f259e486940a71c174dd01b0ce"
SRC_URI[aho-corasick-1.1.3.sha256sum] = "8e60d3430d3a69478ad0993f19238d2df97c507009a52b3c10addcd7f6bcb916"
SRC_URI[android-tzdata-0.1.1.sha256sum] = "e999941b234f3131b00bc13c22d06e8c5ff726d1b6318ac7eb276997bbb4fef0"
SRC_URI[android_system_properties-0.1.5.sha256sum] = "819e7219dbd41043ac279b19830f2efc897156490d7fd6ea916720117ee66311"
SRC_URI[anyhow-1.0.86.sha256sum] = "b3d1d046238990b9cf5bcde22a3fb3584ee5cf65fb2765f454ed428c7a0063da"
SRC_URI[arrayref-0.3.8.sha256sum] = "9d151e35f61089500b617991b791fc8bfd237ae50cd5950803758a179b41e67a"
SRC_URI[arrayvec-0.5.2.sha256sum] = "23b62fc65de8e4e7f52534fb52b0f3ed04746ae267519eef2a83941e8085068b"
SRC_URI[async-attributes-1.1.2.sha256sum] = "a3203e79f4dd9bdda415ed03cf14dae5a2bf775c683a00f94e9cd1faf0f596e5"
SRC_URI[async-broadcast-0.5.1.sha256sum] = "7c48ccdbf6ca6b121e0f586cbc0e73ae440e56c67c30fa0873b4e110d9c26d2b"
SRC_URI[async-channel-1.9.0.sha256sum] = "81953c529336010edd6d8e358f886d9581267795c61b19475b71314bffa46d35"
SRC_URI[async-channel-2.3.1.sha256sum] = "89b47800b0be77592da0afd425cc03468052844aff33b84e33cc696f64e77b6a"
SRC_URI[async-dup-1.2.4.sha256sum] = "7c2886ab563af5038f79ec016dd7b87947ed138b794e8dd64992962c9cca0411"
SRC_URI[async-executor-1.13.0.sha256sum] = "d7ebdfa2ebdab6b1760375fa7d6f382b9f486eac35fc994625a00e89280bdbb7"
SRC_URI[async-fs-1.6.0.sha256sum] = "279cf904654eeebfa37ac9bb1598880884924aab82e290aa65c9e77a0e142e06"
SRC_URI[async-global-executor-2.4.1.sha256sum] = "05b1b633a2115cd122d73b955eadd9916c18c8f510ec9cd1686404c60ad1c29c"
SRC_URI[async-h1-2.3.4.sha256sum] = "5d1d1dae8cb2c4258a79d6ed088b7fb9b4763bf4e9b22d040779761e046a2971"
SRC_URI[async-io-1.13.0.sha256sum] = "0fc5b45d93ef0529756f812ca52e44c221b35341892d3dcc34132ac02f3dd2af"
SRC_URI[async-io-2.3.3.sha256sum] = "0d6baa8f0178795da0e71bc42c9e5d13261aac7ee549853162e66a241ba17964"
SRC_URI[async-lock-2.8.0.sha256sum] = "287272293e9d8c41773cec55e365490fe034813a2f172f502d6ddcf75b2f582b"
SRC_URI[async-lock-3.4.0.sha256sum] = "ff6e472cdea888a4bd64f342f09b3f50e1886d32afe8df3d663c01140b811b18"
SRC_URI[async-process-1.8.1.sha256sum] = "ea6438ba0a08d81529c69b36700fa2f95837bfe3e776ab39cde9c14d9149da88"
SRC_URI[async-recursion-1.1.1.sha256sum] = "3b43422f69d8ff38f95f1b2bb76517c91589a924d1559a0e935d7c8ce0274c11"
SRC_URI[async-session-2.0.1.sha256sum] = "345022a2eed092cd105cc1b26fd61c341e100bd5fcbbd792df4baf31c2cc631f"
SRC_URI[async-signal-0.2.9.sha256sum] = "dfb3634b73397aa844481f814fad23bbf07fdb0eabec10f2eb95e58944b1ec32"
SRC_URI[async-sse-4.1.0.sha256sum] = "53bba003996b8fd22245cd0c59b869ba764188ed435392cf2796d03b805ade10"
SRC_URI[async-sse-5.1.0.sha256sum] = "2e6fa871e4334a622afd6bb2f611635e8083a6f5e2936c0f90f37c7ef9856298"
SRC_URI[async-std-1.12.0.sha256sum] = "62565bb4402e926b29953c785397c6dc0391b7b446e45008b0049eb43cec6f5d"
SRC_URI[async-task-4.7.1.sha256sum] = "8b75356056920673b02621b35afd0f7dda9306d03c79a30f5c56c44cf256e3de"
SRC_URI[async-trait-0.1.81.sha256sum] = "6e0c28dcc82d7c8ead5cb13beb15405b57b8546e93215673ff8ca0349a028107"
SRC_URI[async-tungstenite-0.22.2.sha256sum] = "ce01ac37fdc85f10a43c43bc582cbd566720357011578a935761075f898baf58"
SRC_URI[atomic-waker-1.1.2.sha256sum] = "1505bd5d3d116872e7271a6d4e16d81d0c8570876c8de68093a09ac269d8aac0"
SRC_URI[autocfg-1.3.0.sha256sum] = "0c4b4d0bd25bd0b74681c0ad21497610ce1b7c91b1022cd21c80c6fbdd9476b0"
SRC_URI[az-1.2.1.sha256sum] = "7b7e4c2464d97fe331d41de9d5db0def0a96f4d823b8b32a2efd503578988973"
SRC_URI[backtrace-0.3.73.sha256sum] = "5cc23269a4f8976d0a4d2e7109211a419fe30e8d88d677cd60b6bc79c5732e0a"
SRC_URI[base-x-0.2.11.sha256sum] = "4cbbc9d0964165b47557570cce6c952866c2678457aca742aafc9fb771d30270"
SRC_URI[base64-0.12.3.sha256sum] = "3441f0f7b02788e948e47f457ca01f1d7e6d92c693bc132c22b087d3141c03ff"
SRC_URI[base64-0.13.1.sha256sum] = "9e1b586273c5702936fe7b7d6896644d8be71e6314cfe09d3167c95f712589e8"
SRC_URI[base64-0.21.7.sha256sum] = "9d297deb1925b89f2ccc13d7635fa0714f12c87adce1c75356b39ca9b7178567"
SRC_URI[bincode-1.3.3.sha256sum] = "b1f45e9417d87227c7a56d22e471c6206462cba514c7590c09aff4cf6d1ddcad"
SRC_URI[bitflags-1.3.2.sha256sum] = "bef38d45163c2f1dde094a7dfd33ccf595c92905c8f8f4fdc18d06fb1037718a"
SRC_URI[bitflags-2.6.0.sha256sum] = "b048fb63fd8b5923fc5aa7b340d8e156aec7ec02f0c78fa8a6ddc2613f6f71de"
SRC_URI[bitvec-1.0.1.sha256sum] = "1bc2832c24239b0141d5674bb9174f9d68a8b5b3f2753311927c172ca46f7e9c"
SRC_URI[blake3-0.3.8.sha256sum] = "b64485778c4f16a6a5a9d335e80d449ac6c70cdd6a06d2af18a6f6f775a125b3"
SRC_URI[block-buffer-0.10.4.sha256sum] = "3078c7629b62d3f0439517fa394996acacc5cbc91c5a20d8c658e77abd503a71"
SRC_URI[block-buffer-0.9.0.sha256sum] = "4152116fd6e9dadb291ae18fc1ec3575ed6d84c29642d97890f4b4a3417297e4"
SRC_URI[blocking-1.6.1.sha256sum] = "703f41c54fc768e63e091340b424302bb1c29ef4aa0c7f10fe849dfb114d29ea"
SRC_URI[build-env-0.3.1.sha256sum] = "1522ac6ee801a11bf9ef3f80403f4ede6eb41291fac3dde3de09989679305f25"
SRC_URI[bumpalo-3.16.0.sha256sum] = "79296716171880943b8470b5f8d03aa55eb2e645a4874bdbb28adb49162e012c"
SRC_URI[byteorder-1.5.0.sha256sum] = "1fd0f2584146f6f2ef48085050886acf353beff7305ebd1ae69500e27c67f64b"
SRC_URI[bytes-1.7.1.sha256sum] = "8318a53db07bb3f8dca91a600466bdb3f2eaadeedfdbcf02e1accbad9271ba50"
SRC_URI[cc-1.1.7.sha256sum] = "26a5c3fd7bfa1ce3897a3a3501d362b2d87b7f2583ebcb4a949ec25911025cbc"
SRC_URI[cfg-if-0.1.10.sha256sum] = "4785bdd1c96b2a846b2bd7cc02e86b6b3dbf14e7e53446c4f54c92a361040822"
SRC_URI[cfg-if-1.0.0.sha256sum] = "baf1de4339761588bc0619e3cbc0120ee582ebb74b53b4efbf79117bd2da40fd"
SRC_URI[chrono-0.4.38.sha256sum] = "a21f936df1771bf62b77f047b726c4625ff2e8aa607c01ec06e5a05bd8463401"
SRC_URI[cipher-0.2.5.sha256sum] = "12f8e7987cbd042a63249497f41aed09f8e65add917ea6566effbc56578d6801"
SRC_URI[concurrent-queue-2.5.0.sha256sum] = "4ca0197aee26d1ae37445ee532fefce43251d24cc7c166799f4d46817f1d3973"
SRC_URI[config-0.10.1.sha256sum] = "19b076e143e1d9538dde65da30f8481c2a6c44040edb8e02b9bf1351edb92ce3"
SRC_URI[const_fn-0.4.10.sha256sum] = "373e9fafaa20882876db20562275ff58d50e0caa2590077fe7ce7bef90211d0d"
SRC_URI[constant_time_eq-0.1.5.sha256sum] = "245097e9a4535ee1e3e3931fcfcd55a796a44c643e8596ff6566d68f09b87bbc"
SRC_URI[cookie-0.14.4.sha256sum] = "03a5d7b21829bc7b4bf4754a978a241ae54ea55a40f92bb20216e54096f4b951"
SRC_URI[core-foundation-sys-0.8.6.sha256sum] = "06ea2b9bc92be3c2baa9334a323ebca2d6f074ff852cd1d7b11064035cd3868f"
SRC_URI[cpufeatures-0.2.12.sha256sum] = "53fe5e26ff1b7aef8bca9c6080520cfb8d9333c7568e1829cef191a9723e5504"
SRC_URI[cpuid-bool-0.2.0.sha256sum] = "dcb25d077389e53838a8158c8e99174c5a9d902dee4904320db714f3c653ffba"
SRC_URI[crc32fast-1.4.2.sha256sum] = "a97769d94ddab943e4510d138150169a2758b5ef3eb191a9ee688de3e23ef7b3"
SRC_URI[crossbeam-queue-0.3.11.sha256sum] = "df0346b5d5e76ac2fe4e327c5fd1118d6be7c51dfb18f9b7922923f287471e35"
SRC_URI[crossbeam-utils-0.8.20.sha256sum] = "22ec99545bb0ed0ea7bb9b8e1e9122ea386ff8a48c0922e43f36d45ab09e0e80"
SRC_URI[crypto-common-0.1.6.sha256sum] = "1bfb12502f3fc46cca1bb51ac28df9d618d813cdc3d2f25b9fe775a34af26bb3"
SRC_URI[crypto-mac-0.10.1.sha256sum] = "bff07008ec701e8028e2ceb8f83f0e4274ee62bd2dbdc4fefff2e9a91824081a"
SRC_URI[crypto-mac-0.8.0.sha256sum] = "b584a330336237c1eecd3e94266efb216c56ed91225d634cb2991c5f3fd1aeab"
SRC_URI[cstr-argument-0.1.2.sha256sum] = "b6bd9c8e659a473bce955ae5c35b116af38af11a7acb0b480e01f3ed348aeb40"
SRC_URI[ctr-0.6.0.sha256sum] = "fb4a30d54f7443bf3d6191dcd486aca19e67cb3c49fa7a06a319966346707e7f"
SRC_URI[dashmap-5.5.3.sha256sum] = "978747c1d849a7d2ee5e8adc0159961c48fb7e5db2f06af6723b80123bb53856"
SRC_URI[data-encoding-2.6.0.sha256sum] = "e8566979429cf69b49a5c740c60791108e86440e8be149bbea4fe54d2c32d6e2"
SRC_URI[deadpool-0.7.0.sha256sum] = "3d126179d86aee4556e54f5f3c6bf6d9884e7cc52cef82f77ee6f90a7747616d"
SRC_URI[derivative-2.2.0.sha256sum] = "fcc3dd5e9e9c0b295d6e1e4d811fb6f157d5ffd784b8d202fc62eac8035a770b"
SRC_URI[digest-0.10.7.sha256sum] = "9ed9a281f7bc9b7576e61468ba615a66a5c8cfdff42420a70aa82701a3b1e292"
SRC_URI[digest-0.9.0.sha256sum] = "d3dd60d1080a57a05ab032377049e0591415d2b31afd7028356dbf3cc6dcb066"
SRC_URI[discard-1.0.4.sha256sum] = "212d0f5754cb6769937f4501cc0e67f4f4483c8d2c3e1e922ee9edbe4ab4c7c0"
SRC_URI[embedded-graphics-core-0.3.3.sha256sum] = "b8b1239db5f3eeb7e33e35bd10bd014e7b2537b17e071f726a09351431337cfa"
SRC_URI[embedded-graphics-0.7.1.sha256sum] = "750082c65094fbcc4baf9ba31583ce9a8bb7f52cadfb96f6164b1bc7f922f32b"
SRC_URI[enumflags2-0.7.10.sha256sum] = "d232db7f5956f3f14313dc2f87985c58bd2c695ce124c8cdd984e08e15ac133d"
SRC_URI[enumflags2_derive-0.7.10.sha256sum] = "de0d48a183585823424a4ce1aa132d174a6a81bd540895822eb4c8373a8e49e8"
SRC_URI[env_logger-0.10.2.sha256sum] = "4cd405aab171cb85d6735e5c8d9db038c17d3ca007a4d2c25f337935c3d90580"
SRC_URI[equivalent-1.0.1.sha256sum] = "5443807d6dff69373d433ab9ef5378ad8df50ca6298caf15de6e52e24aaf54d5"
SRC_URI[erased-serde-0.4.5.sha256sum] = "24e2389d65ab4fab27dc2a5de7b191e1f6617d1f1c8855c0dc569c94a4cbb18d"
SRC_URI[errno-dragonfly-0.1.2.sha256sum] = "aa68f1b12764fab894d2755d2518754e71b4fd80ecfb822714a1206c2aab39bf"
SRC_URI[errno-0.2.8.sha256sum] = "f639046355ee4f37944e44f60642c6f3a7efa3cf6b78c78a0d989a8ce6c396a1"
SRC_URI[errno-0.3.9.sha256sum] = "534c5cf6194dfab3db3242765c03bbe257cf92f22b38f6bc0c58d59108a820ba"
SRC_URI[evdev-0.12.2.sha256sum] = "ab6055a93a963297befb0f4f6e18f314aec9767a4bbe88b151126df2433610a7"
SRC_URI[event-listener-strategy-0.5.2.sha256sum] = "0f214dc438f977e6d4e3500aaa277f5ad94ca83fbbd9b1a15713ce2344ccc5a1"
SRC_URI[event-listener-2.5.3.sha256sum] = "0206175f82b8d6bf6652ff7d71a1e27fd2e4efde587fd368662814d6ec1d9ce0"
SRC_URI[event-listener-3.1.0.sha256sum] = "d93877bcde0eb80ca09131a08d23f0a5c18a620b01db137dba666d18cd9b30c2"
SRC_URI[event-listener-5.3.1.sha256sum] = "6032be9bd27023a771701cc49f9f053c751055f71efb2e0ae5c15809093675ba"
SRC_URI[fastrand-1.9.0.sha256sum] = "e51093e27b0797c359783294ca4f0a911c270184cb10f85783b118614a1501be"
SRC_URI[fastrand-2.1.0.sha256sum] = "9fc0510504f03c51ada170672ac806f1f105a88aa97a5281117e1ddc3368e51a"
SRC_URI[fdeflate-0.3.4.sha256sum] = "4f9bfee30e4dedf0ab8b422f03af778d9612b63f502710fc500a334ebe2de645"
SRC_URI[femme-2.2.1.sha256sum] = "cc04871e5ae3aa2952d552dae6b291b3099723bf779a8054281c1366a54613ef"
SRC_URI[flate2-1.0.30.sha256sum] = "5f54427cfd1c7829e2a139fcefea601bf088ebca651d2bf53ebc600eac295dae"
SRC_URI[float-cmp-0.8.0.sha256sum] = "e1267f4ac4f343772758f7b1bdcbe767c218bbab93bb432acbf5162bbf85a6c4"
SRC_URI[fnv-1.0.7.sha256sum] = "3f9eec918d3f24069decb9af1554cad7c880e2da24a9afd88aca000531ab82c1"
SRC_URI[foreign-types-macros-0.2.3.sha256sum] = "1a5c6c585bc94aaf2c7b51dd4c2ba22680844aba4c687be581871a6f518c5742"
SRC_URI[foreign-types-shared-0.3.1.sha256sum] = "aa9a19cbb55df58761df49b23516a86d432839add4af60fc256da840f66ed35b"
SRC_URI[foreign-types-0.5.0.sha256sum] = "d737d9aa519fb7b749cbc3b962edcf310a8dd1f4b67c91c4f83975dbdd17d965"
SRC_URI[form_urlencoded-1.2.1.sha256sum] = "e13624c2627564efccf4934284bdd98cbaa14e79b0b5a141218e507b3a823456"
SRC_URI[framebuffer-0.3.1.sha256sum] = "878caaaf1bb92c9f707dc6eef90933e07e913dac4bb8e11e145eaabaa94ef149"
SRC_URI[funty-2.0.0.sha256sum] = "e6d5a32815ae3f33302d95fdcb2ce17862f8c65363dcfd29360480ba1001fc9c"
SRC_URI[futures-channel-0.3.30.sha256sum] = "eac8f7d7865dcb88bd4373ab671c8cf4508703796caa2b1985a9ca867b3fcb78"
SRC_URI[futures-core-0.3.30.sha256sum] = "dfc6580bb841c5a68e9ef15c77ccc837b40a7504914d52e47b8b0e9bbda25a1d"
SRC_URI[futures-executor-0.3.30.sha256sum] = "a576fc72ae164fca6b9db127eaa9a9dda0d61316034f33a0a0d4eda41f02b01d"
SRC_URI[futures-io-0.3.30.sha256sum] = "a44623e20b9681a318efdd71c299b6b222ed6f231972bfe2f224ebad6311f0c1"
SRC_URI[futures-lite-1.13.0.sha256sum] = "49a9d51ce47660b1e808d3c990b4709f2f415d928835a17dfd16991515c46bce"
SRC_URI[futures-lite-2.3.0.sha256sum] = "52527eb5074e35e9339c6b4e8d12600c7128b68fb25dcb9fa9dec18f7c25f3a5"
SRC_URI[futures-macro-0.3.30.sha256sum] = "87750cf4b7a4c0625b1529e4c543c2182106e4dedc60a2a6455e00d212c489ac"
SRC_URI[futures-sink-0.3.30.sha256sum] = "9fb8e00e87438d937621c1c6269e53f536c14d3fbd6a042bb24879e57d474fb5"
SRC_URI[futures-task-0.3.30.sha256sum] = "38d84fa142264698cdce1a9f9172cf383a0c82de1bddcf3092901442c4097004"
SRC_URI[futures-util-0.3.30.sha256sum] = "3d6401deb83407ab3da39eba7e33987a73c3df0c82b4bb5813ee871c19c41d48"
SRC_URI[futures-0.3.30.sha256sum] = "645c6916888f6cb6350d2550b80fb63e734897a8498abe35cfb732b6487804b0"
SRC_URI[generic-array-0.14.7.sha256sum] = "85649ca51fd72272d7821adaf274ad91c288277713d9c18820d8499a7ff69e9a"
SRC_URI[getrandom-0.1.16.sha256sum] = "8fc3cb4d91f53b50155bdcfd23f6a4c39ae1969c2ae85982b135750cccaf5fce"
SRC_URI[getrandom-0.2.15.sha256sum] = "c4567c8db10ae91089c99af84c68c38da3ec2f087c3f82960bcdbf3656b6f4d7"
SRC_URI[ghash-0.3.1.sha256sum] = "97304e4cd182c3846f7575ced3890c53012ce534ad9114046b0a9e00bb30a375"
SRC_URI[gimli-0.29.0.sha256sum] = "40ecd4077b5ae9fd2e9e169b102c6c330d0605168eb0e8bf79952b256dbefffd"
SRC_URI[gloo-timers-0.2.6.sha256sum] = "9b995a66bb87bebce9a0f4a95aed01daca4872c050bfcb21653361c03bc35e5c"
SRC_URI[gpio-cdev-0.5.1.sha256sum] = "409296415b8abc7b47e5b77096faae14595c53724972da227434fc8f4b05ec8b"
SRC_URI[hashbrown-0.14.5.sha256sum] = "e5274423e17b7c9fc20b6e7e208532f9b19825d82dfd615708b70edd83df41f1"
SRC_URI[hermit-abi-0.3.9.sha256sum] = "d231dfb89cfffdbc30e7fc41579ed6066ad03abda9e567ccafae602b97ec5024"
SRC_URI[hermit-abi-0.4.0.sha256sum] = "fbf6a919d6cf397374f7dfeeea91d974c7c0a7221d0d0f4f20d859d329e53fcc"
SRC_URI[hex-0.4.3.sha256sum] = "7f24254aa9a54b5c858eaee2f5bccdb46aaf0e486a595ed5fd8f86ba55232a70"
SRC_URI[hkdf-0.10.0.sha256sum] = "51ab2f639c231793c5f6114bdb9bbe50a7dbbfcd7c7c6bd8475dec2d991e964f"
SRC_URI[hmac-0.10.1.sha256sum] = "c1441c6b1e930e2817404b5046f1f989899143a12bf92de603b69f4e0aee1e15"
SRC_URI[hmac-0.8.1.sha256sum] = "126888268dcc288495a26bf004b38c5fdbb31682f992c84ceb046a1f0fe38840"
SRC_URI[html-escape-0.2.13.sha256sum] = "6d1ad449764d627e22bfd7cd5e8868264fc9236e07c752972b4080cd351cb476"
SRC_URI[http-client-6.5.3.sha256sum] = "1947510dc91e2bf586ea5ffb412caad7673264e14bb39fb9078da114a94ce1a5"
SRC_URI[http-types-2.12.0.sha256sum] = "6e9b187a72d63adbfba487f48095306ac823049cb504ee195541e91c7775f5ad"
SRC_URI[http-0.2.12.sha256sum] = "601cbb57e577e2f5ef5be8e7b83f0f63994f25aa94d673e54a92d5c516d101f1"
SRC_URI[httparse-1.9.4.sha256sum] = "0fcc0b4a115bf80b728eb8ea024ad5bd707b615bfed49e0665b6e0f86fd082d9"
SRC_URI[humantime-2.1.0.sha256sum] = "9a3a5bfb195931eeb336b2a7b4d761daec841b97f947d34394601737a7bba5e4"
SRC_URI[iana-time-zone-haiku-0.1.2.sha256sum] = "f31827a206f56af32e590ba56d5d2d085f558508192593743f16b2306495269f"
SRC_URI[iana-time-zone-0.1.60.sha256sum] = "e7ffbb5a1b541ea2561f8c41c087286cc091e21e556a4f09a8f6cbf17b69b141"
SRC_URI[idna-0.5.0.sha256sum] = "634d9b1461af396cad843f47fdba5597a4f9e6ddd4bfb6ff5d85028c25cb12f6"
SRC_URI[indexmap-2.3.0.sha256sum] = "de3fc2e30ba82dd1b3911c8de1ffc143c74a914a14e99514d7637e3099df5ea0"
SRC_URI[industrial-io-0.5.2.sha256sum] = "3948a8818efcd4e0e189df60d79b58a9f4ae20b87437b2fde4dc4ca5b520c4ed"
SRC_URI[infer-0.2.3.sha256sum] = "64e9829a50b42bb782c1df523f78d332fe371b10c661e78b7a3c34b0198e9fac"
SRC_URI[instant-0.1.13.sha256sum] = "e0242819d153cba4b4b05a5a8f2a7e9bbf97b6055b2a002b395c96b5ff3c0222"
SRC_URI[io-lifetimes-1.0.11.sha256sum] = "eae7b9aee968036d54dce06cebaefd919e4472e753296daccd6d344e3e2df0c2"
SRC_URI[is-terminal-0.4.12.sha256sum] = "f23ff5ef2b80d608d61efee834934d862cd92461afc0560dedf493e4c033738b"
SRC_URI[itoa-1.0.11.sha256sum] = "49f1f14873335454500d59611f1cf4a4b0f786f9ac11f4312a78e4cf2566695b"
SRC_URI[js-sys-0.3.69.sha256sum] = "29c15563dc2726973df627357ce0c9ddddbea194836909d655df6a75d2cf296d"
SRC_URI[kv-log-macro-1.0.7.sha256sum] = "0de8b303297635ad57c9f5059fd9cee7a47f8e8daa09df0fcd07dd39fb22977f"
SRC_URI[lazy_static-1.5.0.sha256sum] = "bbd2bcb4c963f2ddae06a2efc7e9f3591312473c50c6685e1f298068316e66fe"
SRC_URI[lexical-core-0.7.6.sha256sum] = "6607c62aa161d23d17a9072cc5da0be67cdfc89d3afb1e8d9c842bebc2525ffe"
SRC_URI[libc-0.2.155.sha256sum] = "97b3888a4aecf77e811145cadf6eef5901f4782c53886191b2f693f24761847c"
SRC_URI[libiio-sys-0.3.1.sha256sum] = "6d6c255d73b8f345bb10550b44e93b2b5c910a31ce72ee2528c5dbc028cf24ec"
SRC_URI[libsystemd-sys-0.9.3.sha256sum] = "ed080163caa59cc29b34bce2209b737149a4bac148cd9a8b04e4c12822798119"
SRC_URI[linux-raw-sys-0.3.8.sha256sum] = "ef53942eb7bf7ff43a617b3e2c1c4a5ecf5944a7c1bc12d7ee39bbb15e5c1519"
SRC_URI[linux-raw-sys-0.4.14.sha256sum] = "78b3ae25bc7c8c38cec158d1f2757ee79e9b3740fbc7ccf0e59e4b08d793fa89"
SRC_URI[lock_api-0.4.12.sha256sum] = "07af8b9cdd281b7915f413fa73f29ebd5d55d0d3f0155584dade1ff18cea1b17"
SRC_URI[log-0.4.22.sha256sum] = "a7a70ba024b9dc04c27ea2f0c0548feb474ec5c54bba33a7f72f873a39d07b24"
SRC_URI[memchr-2.7.4.sha256sum] = "78ca9ab1a0babb1e7d5695e3530886289c18cf2f87ec19a575a0abdce112e3a3"
SRC_URI[memmap-0.7.0.sha256sum] = "6585fd95e7bb50d6cc31e20d4cf9afb4e2ba16c5846fc76793f11218da9c475b"
SRC_URI[memoffset-0.6.5.sha256sum] = "5aa361d4faea93603064a027415f07bd8e1d5c88c9fbf68bf56a285428fd79ce"
SRC_URI[memoffset-0.7.1.sha256sum] = "5de893c32cde5f383baa4c04c5d6dbdd735cfd4a794b0debdb2bb1b421da5ff4"
SRC_URI[memoffset-0.9.1.sha256sum] = "488016bfae457b036d996092f6cb448677611ce4449e970ceaf42695203f218a"
SRC_URI[micromath-1.1.1.sha256sum] = "bc4010833aea396656c2f91ee704d51a6f1329ec2ab56ffd00bfd56f7481ea94"
SRC_URI[mime-0.3.17.sha256sum] = "6877bb514081ee2a7ff5ef9de3281f14a4dd4bceac4c09388074a6b5df8a139a"
SRC_URI[mime_guess-2.0.5.sha256sum] = "f7c44f8e672c00fe5308fa235f821cb4198414e1c77935c1ab6948d3fd78550e"
SRC_URI[miniz_oxide-0.7.4.sha256sum] = "b8a240ddb74feaf34a79a7add65a741f3167852fba007066dcac1ca548d89c08"
SRC_URI[mqtt-protocol-0.11.2.sha256sum] = "ca0b17380dc69fbcf5f967828cfd10e55028ba83a57da1f580c5b0792ab807ac"
SRC_URI[nix-0.23.2.sha256sum] = "8f3790c00a0150112de0f4cd161e3d7fc4b2d8a5542ffc35f099a2562aecb35c"
SRC_URI[nix-0.26.4.sha256sum] = "598beaf3cc6fdd9a5dfb1630c2800c7acd31df7aaf0f565796fba2b53ca1af1b"
SRC_URI[nom-5.1.3.sha256sum] = "08959a387a676302eebf4ddbcbc611da04285579f76f88ee0506c63b1a61dd4b"
SRC_URI[num-traits-0.2.19.sha256sum] = "071dfc062690e90b734c0b2273ce72ad0ffa95f0c74596bc250dcfd960262841"
SRC_URI[num_cpus-1.16.0.sha256sum] = "4161fcb6d602d4d2081af7c3a45852d875a03dd337a6bfdd6e06407b61342a43"
SRC_URI[numtoa-0.2.4.sha256sum] = "6aa2c4e539b869820a2b82e1aef6ff40aa85e65decdd5185e83fb4b1249cd00f"
SRC_URI[object-0.36.2.sha256sum] = "3f203fa8daa7bb185f760ae12bd8e097f63d17041dcdcaf675ac54cdf863170e"
SRC_URI[once_cell-1.19.0.sha256sum] = "3fdb12b2476b595f9358c5161aa467c2438859caa136dec86c26fdd2efe17b92"
SRC_URI[opaque-debug-0.3.1.sha256sum] = "c08d65885ee38876c4f86fa503fb49d7b507c2b62552df7c70b2fce627e06381"
SRC_URI[ordered-stream-0.2.0.sha256sum] = "9aa2b01e1d916879f73a53d01d1d6cee68adbb31d6d9177a8cfce093cced1d50"
SRC_URI[parking-2.2.0.sha256sum] = "bb813b8af86854136c6922af0598d719255ecb2179515e6e7730d468f05c9cae"
SRC_URI[parking_lot_core-0.9.10.sha256sum] = "1e401f977ab385c9e4e3ab30627d6f26d00e2c73eef317493c4ec6d468726cf8"
SRC_URI[percent-encoding-2.3.1.sha256sum] = "e3148f5046208a5d56bcfc03053e3ca6334e51da8dfb19b6cdc8b306fae3283e"
SRC_URI[pin-project-internal-1.1.5.sha256sum] = "2f38a4412a78282e09a2cf38d195ea5420d15ba0602cb375210efbc877243965"
SRC_URI[pin-project-lite-0.1.12.sha256sum] = "257b64915a082f7811703966789728173279bdebb956b143dbcd23f6f970a777"
SRC_URI[pin-project-lite-0.2.14.sha256sum] = "bda66fc9667c18cb2758a2ac84d1167245054bcf85d5d1aaa6923f45801bdd02"
SRC_URI[pin-project-1.1.5.sha256sum] = "b6bf43b791c5b9e34c3d182969b4abb522f9343702850a2e57f460d00d09b4b3"
SRC_URI[pin-utils-0.1.0.sha256sum] = "8b870d8c151b6f2fb93e84a13146138f05d02ed11c7e7c54f8826aaaf7c9f184"
SRC_URI[piper-0.2.3.sha256sum] = "ae1d5c74c9876f070d3e8fd503d748c7d974c3e48da8f41350fa5222ef9b4391"
SRC_URI[pkg-config-0.3.30.sha256sum] = "d231b230927b5e4ad203db57bbcbee2802f6bce620b1e4a9024a07d94e2907ec"
SRC_URI[png-0.17.13.sha256sum] = "06e4b0d3d1312775e782c86c91a111aa1f910cbb65e1337f9975b5f9a554b5e1"
SRC_URI[polling-2.8.0.sha256sum] = "4b2d323e8ca7996b3e23126511a523f7e62924d93ecd5ae73b333815b0eb3dce"
SRC_URI[polling-3.7.2.sha256sum] = "a3ed00ed3fbf728b5816498ecd316d1716eecaced9c0c8d2c5a6740ca214985b"
SRC_URI[polyval-0.4.5.sha256sum] = "eebcc4aa140b9abd2bc40d9c3f7ccec842679cd79045ac3a7ac698c1a064b7cd"
SRC_URI[ppv-lite86-0.2.18.sha256sum] = "dee4364d9f3b902ef14fab8a1ddffb783a1cb6b4bba3bfc1fa3922732c7de97f"
SRC_URI[proc-macro-crate-1.3.1.sha256sum] = "7f4c021e1093a56626774e81216a4ce732a735e5bad4868a03f3ed65ca0c3919"
SRC_URI[proc-macro-hack-0.5.20+deprecated.sha256sum] = "dc375e1527247fe1a97d8b7156678dfe7c1af2fc075c9a4db3690ecd2a148068"
SRC_URI[proc-macro2-1.0.86.sha256sum] = "5e719e8df665df0d1c8fbfd238015744736151d4445ec0836b8e628aae103b77"
SRC_URI[quote-1.0.36.sha256sum] = "0fa76aaf39101c457836aec0ce2316dbdc3ab723cdda1c6bd4e6ad4208acaca7"
SRC_URI[radium-0.7.0.sha256sum] = "dc33ff2d4973d518d823d61aa239014831e521c75da58e3df4840d3f47749d09"
SRC_URI[rand-0.7.3.sha256sum] = "6a6b1679d49b24bbfe0c803429aa1874472f50d9b363131f0e89fc356b544d03"
SRC_URI[rand-0.8.5.sha256sum] = "34af8d1a0e25924bc5b7c43c079c942339d8f0a8b57c39049bef581b46327404"
SRC_URI[rand_chacha-0.2.2.sha256sum] = "f4c8ed856279c9737206bf725bf36935d8666ead7aa69b52be55af369d193402"
SRC_URI[rand_chacha-0.3.1.sha256sum] = "e6c10a63a0fa32252be49d21e7709d4d4baf8d231c2dbce1eaa8141b9b127d88"
SRC_URI[rand_core-0.5.1.sha256sum] = "90bde5296fc891b0cef12a6d03ddccc162ce7b2aff54160af9338f8d40df6d19"
SRC_URI[rand_core-0.6.4.sha256sum] = "ec0be4795e2f6a28069bec0b5ff3e2ac9bafc99e6a9a7dc3547996c5c816922c"
SRC_URI[rand_hc-0.2.0.sha256sum] = "ca3129af7b92a17112d59ad498c6f81eaf463253766b90396d39ea7a39d6613c"
SRC_URI[redox_syscall-0.5.3.sha256sum] = "2a908a6e00f1fdd0dfd9c0eb08ce85126f6d8bbda50017e74bc4a4b7d4a926a4"
SRC_URI[regex-automata-0.4.7.sha256sum] = "38caf58cc5ef2fed281f89292ef23f6365465ed9a41b7a7754eb4e26496c92df"
SRC_URI[regex-syntax-0.8.4.sha256sum] = "7a66a03ae7c801facd77a29370b4faec201768915ac14a721ba36f20bc9c209b"
SRC_URI[regex-1.10.5.sha256sum] = "b91213439dad192326a0d7c6ee3955910425f441d7038e0d6933b0aec5c4517f"
SRC_URI[route-recognizer-0.2.0.sha256sum] = "56770675ebc04927ded3e60633437841581c285dc6236109ea25fbf3beb7b59e"
SRC_URI[rustc-demangle-0.1.24.sha256sum] = "719b953e2095829ee67db738b3bfa9fa368c94900df327b3f07fe6e794d2fe1f"
SRC_URI[rustc_version-0.2.3.sha256sum] = "138e3e0acb6c9fb258b19b67cb8abd63c00679d2851805ea151465464fe9030a"
SRC_URI[rustix-0.37.27.sha256sum] = "fea8ca367a3a01fe35e6943c400addf443c0f57670e6ec51196f71a4b8762dd2"
SRC_URI[rustix-0.38.34.sha256sum] = "70dc5ec042f7a43c4a73241207cecc9873a06d45debb38b329f8541d85c2730f"
SRC_URI[rustversion-1.0.17.sha256sum] = "955d28af4278de8121b7ebeb796b6a45735dc01436d898801014aced2773a3d6"
SRC_URI[ryu-1.0.18.sha256sum] = "f3cb5ba0dc43242ce17de99c180e96db90b235b8a9fdc9543c96d2209116bd9f"
SRC_URI[scopeguard-1.2.0.sha256sum] = "94143f37725109f92c262ed2cf5e59bce7498c01bcc1502d7b9afe439a4e9f49"
SRC_URI[semver-parser-0.7.0.sha256sum] = "388a1df253eca08550bef6c72392cfe7c30914bf41df5269b68cbd6ff8f570a3"
SRC_URI[semver-0.9.0.sha256sum] = "1d7eb9ef2c18661902cc47e535f9bc51b78acd254da71d375c2f6720d9a40403"
SRC_URI[serde-1.0.204.sha256sum] = "bc76f558e0cbb2a839d37354c575f1dc3fdc6546b5be373ba43d95f231bf7c12"
SRC_URI[serde_derive-1.0.204.sha256sum] = "e0cd7e117be63d3c3678776753929474f3b04a43a080c744d6b0ae2a8c28e222"
SRC_URI[serde_fmt-1.0.3.sha256sum] = "e1d4ddca14104cd60529e8c7f7ba71a2c8acd8f7f5cfcdc2faf97eeb7c3010a4"
SRC_URI[serde_json-1.0.122.sha256sum] = "784b6203951c57ff748476b126ccb5e8e2959a5c19e5c617ab1956be3dbc68da"
SRC_URI[serde_qs-0.8.5.sha256sum] = "c7715380eec75f029a4ef7de39a9200e0a63823176b759d055b613f5a87df6a6"
SRC_URI[serde_repr-0.1.19.sha256sum] = "6c64451ba24fc7a6a2d60fc75dd9c83c90903b19028d4eff35e88fc1e86564e9"
SRC_URI[serde_urlencoded-0.7.1.sha256sum] = "d3491c14715ca2294c4d6a88f15e84739788c1d030eed8c110436aafdaa2f3fd"
SRC_URI[serde_yaml-0.9.34+deprecated.sha256sum] = "6a8b1a1a2ebf674015cc02edccce75287f1a0130d394307b36743c2f5d504b47"
SRC_URI[sha-1-0.10.1.sha256sum] = "f5058ada175748e33390e40e872bd0fe59a19f265d0158daa551c5a88a76009c"
SRC_URI[sha1-0.10.6.sha256sum] = "e3bf829a2d51ab4a5ddf1352d8470c140cadc8301b2ae1789db023f01cedd6ba"
SRC_URI[sha1-0.6.1.sha256sum] = "c1da05c97445caa12d05e848c4a4fcbbea29e748ac28f7e80e9b010392063770"
SRC_URI[sha1_smol-1.0.1.sha256sum] = "bbfa15b3dddfee50a0fff136974b3e1bde555604ba463834a7eb7deb6417705d"
SRC_URI[sha2-0.9.9.sha256sum] = "4d58a1e1bf39749807d89cf2d98ac2dfa0ff1cb3faa38fbb64dd88ac8013d800"
SRC_URI[signal-hook-registry-1.4.2.sha256sum] = "a9e9e0b4211b72e7b8b6e85c807d36c212bdb33ea8587f7569562a84df5465b1"
SRC_URI[simd-adler32-0.3.7.sha256sum] = "d66dc143e6b11c1eddc06d5c423cfc97062865baf299914ab64caa38182078fe"
SRC_URI[slab-0.4.9.sha256sum] = "8f92a496fb766b417c996b9c5e57daf2f7ad3b0bebe1ccfca4856390e3d3bb67"
SRC_URI[smallvec-1.13.2.sha256sum] = "3c5e1a9a646d36c3599cd173a41282daf47c44583ad367b8e6837255952e5c67"
SRC_URI[socket2-0.4.10.sha256sum] = "9f7916fc008ca5542385b89a3d3ce689953c143e9304a9bf8beec1de48994c0d"
SRC_URI[standback-0.2.17.sha256sum] = "e113fb6f3de07a243d434a56ec6f186dfd51cb08448239fe7bcae73f87ff28ff"
SRC_URI[static_assertions-1.1.0.sha256sum] = "a2eb9349b6444b326872e140eb1cf5e7c522154d69e7a0ffb0fb81c06b37543f"
SRC_URI[stdweb-derive-0.5.3.sha256sum] = "c87a60a40fccc84bef0652345bbbbbe20a605bf5d0ce81719fc476f5c03b50ef"
SRC_URI[stdweb-internal-macros-0.2.9.sha256sum] = "58fa5ff6ad0d98d1ffa8cb115892b6e69d67799f6763e162a1c9db421dc22e11"
SRC_URI[stdweb-internal-runtime-0.1.5.sha256sum] = "213701ba3370744dcd1a12960caa4843b3d68b4d1c0a5d575e0d65b2ee9d16c0"
SRC_URI[stdweb-0.4.20.sha256sum] = "d022496b16281348b52d0e30ae99e01a73d737b2f45d38fed4edf79f9325a1d5"
SRC_URI[subtle-2.4.1.sha256sum] = "6bdef32e8150c2a081110b42772ffe7d7c9032b606bc226c8260fd97e0976601"
SRC_URI[surf-2.3.2.sha256sum] = "718b1ae6b50351982dedff021db0def601677f2120938b070eadb10ba4038dd7"
SRC_URI[sval-2.13.0.sha256sum] = "53eb957fbc79a55306d5d25d87daf3627bc3800681491cda0709eef36c748bfe"
SRC_URI[sval_buffer-2.13.0.sha256sum] = "96e860aef60e9cbf37888d4953a13445abf523c534640d1f6174d310917c410d"
SRC_URI[sval_dynamic-2.13.0.sha256sum] = "ea3f2b07929a1127d204ed7cb3905049381708245727680e9139dac317ed556f"
SRC_URI[sval_fmt-2.13.0.sha256sum] = "c4e188677497de274a1367c4bda15bd2296de4070d91729aac8f0a09c1abf64d"
SRC_URI[sval_json-2.13.0.sha256sum] = "32f456c07dae652744781f2245d5e3b78e6a9ebad70790ac11eb15dbdbce5282"
SRC_URI[sval_nested-2.13.0.sha256sum] = "886feb24709f0476baaebbf9ac10671a50163caa7e439d7a7beb7f6d81d0a6fb"
SRC_URI[sval_ref-2.13.0.sha256sum] = "be2e7fc517d778f44f8cb64140afa36010999565528d48985f55e64d45f369ce"
SRC_URI[sval_serde-2.13.0.sha256sum] = "79bf66549a997ff35cd2114a27ac4b0c2843280f2cfa84b240d169ecaa0add46"
SRC_URI[syn-1.0.109.sha256sum] = "72b64191b275b66ffe2469e8af2c1cfe3bafa67b529ead792a6d0160888b4237"
SRC_URI[syn-2.0.72.sha256sum] = "dc4b9b9bf2add8093d3f2c0204471e951b2285580335de42f9d2534f3ae7a8af"
SRC_URI[sysfs-class-0.1.3.sha256sum] = "5e1bbcf869732c45a77898f7f61ed6d411dfc37613517e444842f58d428856d1"
SRC_URI[systemd-0.10.0.sha256sum] = "afec0101d9ae8ab26aedf0840109df689938ea7e538aa03df4369f1854f11562"
SRC_URI[tap-1.0.1.sha256sum] = "55937e1799185b12863d447f42597ed69d9928686b8d88a1df17376a097d8369"
SRC_URI[tempfile-3.10.1.sha256sum] = "85b77fafb263dd9d05cbeac119526425676db3784113aa9295c88498cbf8bff1"
SRC_URI[termcolor-1.4.1.sha256sum] = "06794f8f6c5c898b3275aebefa6b8a1cb24cd2c6c79397ab15774837a0bc5755"
SRC_URI[thiserror-impl-1.0.63.sha256sum] = "a4558b58466b9ad7ca0f102865eccc95938dca1a74a856f2b57b6629050da261"
SRC_URI[thiserror-1.0.63.sha256sum] = "c0342370b38b6a11b6cc11d6a805569958d54cfa061a29969c3b5ce2ea405724"
SRC_URI[thread-priority-0.13.1.sha256sum] = "0c56ce92f1285eaaa11fc1a3201e25de97898c50e87caa4c2aee836fe05288de"
SRC_URI[tide-0.16.0.sha256sum] = "c459573f0dd2cc734b539047f57489ea875af8ee950860ded20cf93a79a1dee0"
SRC_URI[time-macros-impl-0.1.2.sha256sum] = "fd3c141a1b43194f3f56a1411225df8646c55781d5f26db825b3d98507eb482f"
SRC_URI[time-macros-0.1.1.sha256sum] = "957e9c6e26f12cb6d0dd7fc776bb67a706312e7299aed74c8dd5b17ebb27e2f1"
SRC_URI[time-0.2.27.sha256sum] = "4752a97f8eebd6854ff91f1c1824cd6160626ac4bd44287f7f4ea2035a02a242"
SRC_URI[tinyvec-1.8.0.sha256sum] = "445e881f4f6d382d5f27c034e25eb92edd7c784ceab92a0937db7f2e9471b938"
SRC_URI[tinyvec_macros-0.1.1.sha256sum] = "1f3ccbac311fea05f86f61904b462b55fb3df8837a366dfc601a0161d0532f20"
SRC_URI[tokio-1.39.2.sha256sum] = "daa4fb1bc778bd6f04cbfc4bb2d06a7396a8f299dc33ea1900cedaa316f467b1"
SRC_URI[toml_datetime-0.6.8.sha256sum] = "0dd7358ecb8fc2f8d014bf86f6f638ce72ba252a2c3a2572f2a795f1d23efb41"
SRC_URI[toml_edit-0.19.15.sha256sum] = "1b5bb770da30e5cbfde35a2d7b9b8a2c4b8ef89548a7a6aeab5c9a576e3e7421"
SRC_URI[tracing-attributes-0.1.27.sha256sum] = "34704c8d6ebcbc939824180af020566b01a7c01f80641264eba0999f6c2b6be7"
SRC_URI[tracing-core-0.1.32.sha256sum] = "c06d3da6113f116aaee68e4d601191614c9053067f9ab7f6edbcb161237daa54"
SRC_URI[tracing-0.1.40.sha256sum] = "c3523ab5a71916ccf420eebdf5521fcef02141234bbc0b8a49f2fdc4544364ef"
SRC_URI[tungstenite-0.19.0.sha256sum] = "15fba1a6d6bb030745759a9a2a588bfe8490fc8b4751a277db3a0be1c9ebbf67"
SRC_URI[typeid-1.0.0.sha256sum] = "059d83cc991e7a42fc37bd50941885db0888e34209f8cfd9aab07ddec03bc9cf"
SRC_URI[typenum-1.17.0.sha256sum] = "42ff0bf0c66b8238c6f3b578df37d0b7848e55df8577b3f74f92a69acceeb825"
SRC_URI[uds_windows-1.1.0.sha256sum] = "89daebc3e6fd160ac4aa9fc8b3bf71e1f74fbf92367ae71fb83a037e8bf164b9"
SRC_URI[unicase-2.7.0.sha256sum] = "f7d2d4dafb69621809a81864c9c1b864479e1235c0dd4e199924b9742439ed89"
SRC_URI[unicode-bidi-0.3.15.sha256sum] = "08f95100a766bf4f8f28f90d77e0a5461bbdb219042e7679bebe79004fed8d75"
SRC_URI[unicode-ident-1.0.12.sha256sum] = "3354b9ac3fae1ff6755cb6db53683adb661634f67557942dea4facebec0fee4b"
SRC_URI[unicode-normalization-0.1.23.sha256sum] = "a56d1686db2308d901306f92a263857ef59ea39678a5458e7cb17f01415101f5"
SRC_URI[unique-token-0.2.0.sha256sum] = "d3be9e39e944fa35b07f5eb280902bf4d2dc29dfbc26175230a0d0ea124a7b66"
SRC_URI[universal-hash-0.4.1.sha256sum] = "9f214e8f697e925001e66ec2c6e37a4ef93f0f78c2eed7814394e10c62025b05"
SRC_URI[unsafe-libyaml-0.2.11.sha256sum] = "673aac59facbab8a9007c7f6108d11f63b603f7cabff99fabf650fea5c32b861"
SRC_URI[url-2.5.2.sha256sum] = "22784dbdf76fdde8af1aeda5622b546b422b6fc585325248a2bf9f5e41e94d6c"
SRC_URI[utf-8-0.7.6.sha256sum] = "09cc8ee72d2a9becf2f2febe0205bbed8fc6615b7cb429ad062dc7b7ddd036a9"
SRC_URI[utf8-cstr-0.1.6.sha256sum] = "55bcbb425141152b10d5693095950b51c3745d019363fc2929ffd8f61449b628"
SRC_URI[utf8-width-0.1.7.sha256sum] = "86bd8d4e895da8537e5315b8254664e6b769c4ff3db18321b297a1e7004392e3"
SRC_URI[value-bag-serde1-1.9.0.sha256sum] = "ccacf50c5cb077a9abb723c5bcb5e0754c1a433f1e1de89edc328e2760b6328b"
SRC_URI[value-bag-sval2-1.9.0.sha256sum] = "1785bae486022dfb9703915d42287dcb284c1ee37bd1080eeba78cc04721285b"
SRC_URI[value-bag-1.9.0.sha256sum] = "5a84c137d37ab0142f0f2ddfe332651fdbf252e7b7dbb4e67b6c1f1b2e925101"
SRC_URI[version_check-0.9.5.sha256sum] = "0b928f33d975fc6ad9f86c8f283853ad26bdd5b10b7f1542aa2fa15e2289105a"
SRC_URI[waker-fn-1.2.0.sha256sum] = "317211a0dc0ceedd78fb2ca9a44aed3d7b9b26f81870d485c07122b4350673b7"
SRC_URI[wasi-0.11.0+wasi-snapshot-preview1.sha256sum] = "9c8d87e72b64a3b4db28d11ce29237c246188f4f51057d65a7eab63b7987e423"
SRC_URI[wasi-0.9.0+wasi-snapshot-preview1.sha256sum] = "cccddf32554fecc6acb585f82a32a72e28b48f8c4c1883ddfeeeaa96f7d8e519"
SRC_URI[wasm-bindgen-backend-0.2.92.sha256sum] = "614d787b966d3989fa7bb98a654e369c762374fd3213d212cfc0251257e747da"
SRC_URI[wasm-bindgen-futures-0.4.42.sha256sum] = "76bc14366121efc8dbb487ab05bcc9d346b3b5ec0eaa76e46594cabbe51762c0"
SRC_URI[wasm-bindgen-macro-support-0.2.92.sha256sum] = "e94f17b526d0a461a191c78ea52bbce64071ed5c04c9ffe424dcb38f74171bb7"
SRC_URI[wasm-bindgen-macro-0.2.92.sha256sum] = "a1f8823de937b71b9460c0c34e25f3da88250760bec0ebac694b49997550d726"
SRC_URI[wasm-bindgen-shared-0.2.92.sha256sum] = "af190c94f2773fdb3729c55b007a722abb5384da03bc0986df4c289bf5567e96"
SRC_URI[wasm-bindgen-0.2.92.sha256sum] = "4be2531df63900aeb2bca0daaaddec08491ee64ceecbee5076636a3b026795a8"
SRC_URI[web-sys-0.3.69.sha256sum] = "77afa9a11836342370f4817622a2f0f418b134426d91a82dfb48f532d2ec13ef"
SRC_URI[winapi-i686-pc-windows-gnu-0.4.0.sha256sum] = "ac3b87c63620426dd9b991e5ce0329eff545bccbbb34f3be09ff6fb6ab51b7b6"
SRC_URI[winapi-util-0.1.8.sha256sum] = "4d4cc384e1e73b93bafa6fb4f1df8c41695c8a91cf9c4c64358067d15a7b6c6b"
SRC_URI[winapi-x86_64-pc-windows-gnu-0.4.0.sha256sum] = "712e227841d057c1ee1cd2fb22fa7e5a5461ae8e48fa2ca79ec42cfc1931183f"
SRC_URI[winapi-0.3.9.sha256sum] = "5c839a674fcd7a98952e593242ea400abe93992746761e38641405d28b00f419"
SRC_URI[windows-core-0.52.0.sha256sum] = "33ab640c8d7e35bf8ba19b884ba838ceb4fba93a4e8c65a9059d08afcfc683d9"
SRC_URI[windows-sys-0.48.0.sha256sum] = "677d2418bec65e3338edb076e806bc1ec15693c5d0104683f2efe857f61056a9"
SRC_URI[windows-sys-0.52.0.sha256sum] = "282be5f36a8ce781fad8c8ae18fa3f9beff57ec1b52cb3de0789201425d9a33d"
SRC_URI[windows-targets-0.48.5.sha256sum] = "9a2fa6e2155d7247be68c096456083145c183cbbbc2764150dda45a87197940c"
SRC_URI[windows-targets-0.52.6.sha256sum] = "9b724f72796e036ab90c1021d4780d4d3d648aca59e491e6b98e725b84e99973"
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
SRC_URI[winnow-0.5.40.sha256sum] = "f593a95398737aeed53e489c785df13f3618e41dbcd6718c6addbf1395aa6876"
SRC_URI[wyz-0.5.1.sha256sum] = "05f360fc0b24296329c78fda852a1e9ae82de9cf7b27dae4b7f62f118f77b9ed"
SRC_URI[xdg-home-1.2.0.sha256sum] = "ca91dcf8f93db085f3a0a29358cd0b9d670915468f4290e8b85d118a34211ab8"
SRC_URI[zbus-3.15.2.sha256sum] = "675d170b632a6ad49804c8cf2105d7c31eddd3312555cffd4b740e08e97c25e6"
SRC_URI[zbus_macros-3.15.2.sha256sum] = "7131497b0f887e8061b430c530240063d33bf9455fa34438f388a245da69e0a5"
SRC_URI[zbus_names-2.6.1.sha256sum] = "437d738d3750bed6ca9b8d423ccc7a8eb284f6b1d6d4e225a0e4e6258d864c8d"
SRC_URI[zerocopy-derive-0.6.6.sha256sum] = "125139de3f6b9d625c39e2efdd73d41bdac468ccd556556440e322be0e1bbd91"
SRC_URI[zerocopy-0.6.6.sha256sum] = "854e949ac82d619ee9a14c66a1b674ac730422372ccb759ce0c39cabcf2bf8e6"
SRC_URI[zvariant-3.15.2.sha256sum] = "4eef2be88ba09b358d3b58aca6e41cd853631d44787f319a1383ca83424fb2db"
SRC_URI[zvariant_derive-3.15.2.sha256sum] = "37c24dc0bed72f5f90d1f8bb5b07228cbf63b3c6e9f82d82559d4bae666e7ed9"
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
