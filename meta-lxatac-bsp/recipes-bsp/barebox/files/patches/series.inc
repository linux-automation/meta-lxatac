# umpf-base: v2023.03.0
# umpf-name: 2023.03.0/customers/lxa/tac
# umpf-version: 2023.03.0/customers/lxa/tac/20230421-1
# umpf-topic: v2023.03.0/topic/tlv
# umpf-hashinfo: 38338204f9113c23c5d5f667cc209fe3a9476456
# umpf-topic-range: e068bbf6a3608351484567af19da68e0e382fa0f..77abc3a4c4e8d2b240ac1edac15337d1132b0f19
SRC_URI += "\
  file://patches/0001-scripts-implement-slurp-a-read_file-with-fd-as-argum.patch \
  file://patches/0002-of_path-support-phandles-in-of_find_path.patch \
  file://patches/0003-Makefile-add-common-boards-include-to-include-search.patch \
  file://patches/0004-net-add-ethaddr-sequence-handling.patch \
  file://patches/0005-common-add-global.serial_number-with-device-tree-fix.patch \
  file://patches/0006-common-add-optional-systemd.hostname-generation.patch \
  file://patches/0007-net-factor-out-eth_of_get_fixup_node.patch \
  file://patches/0008-net-export-list-of-registered-ethernet-addresses.patch \
  file://patches/0009-net-implement-ethaddr_string_cmp.patch \
  file://patches/0010-common-add-barebox-TLV-support.patch \
  file://patches/0011-commands-add-TLV-debugging-command.patch \
  file://patches/0012-scripts-add-bareboxtlv-host-target-tool.patch \
  "
# umpf-topic: v2023.03.0/topic/panel-mipi-dbi-spi
# umpf-hashinfo: 8a7941ffcb996287a6d051ede87e1233374fc69e
# umpf-topic-range: 77abc3a4c4e8d2b240ac1edac15337d1132b0f19..4c2e5658b246b15dbc42103768f81532b0632357
SRC_URI += "\
  file://patches/0101-firmware-Add-request-release_firmware-calls.patch \
  file://patches/0102-video-Add-of_get_display_timing.patch \
  file://patches/0103-video-add-MIPI-DBI-framebuffer-helpers.patch \
  file://patches/0104-video-Add-MIPI-DBI-compatible-SPI-driver.patch \
  file://patches/0105-spi-add-per-driver-bits-per-word-mask.patch \
  file://patches/0106-spi-stm32-support-per-transfer-bits-per-word-switchi.patch \
  file://patches/0107-video-mipi_dbi-disable-byte-swapping-if-16-bit-SPI-t.patch \
  file://patches/0108-spi-update-spi_board_info-FIXME-comment.patch \
  file://patches/0109-video-fb-add-optional-damage-tracking.patch \
  file://patches/0110-graphic_utils-add-optional-damage-tracking.patch \
  file://patches/0111-video-mipi_dbi-add-damage-tracking-and-partial-updat.patch \
  file://patches/0112-video-fbconsole-implement-non-fullscreen-fbconsole.patch \
  "
# umpf-topic: v2023.03.0/customers/lxa/tac
# umpf-hashinfo: 8c736feb931b1859c471397de58a8c26a6cdceb5
# umpf-topic-range: 4c2e5658b246b15dbc42103768f81532b0632357..a6ceb1b0371c91b35341ec013d0faf51eb6c0e1b
SRC_URI += "\
  file://patches/0201-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  file://patches/0202-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0203-ARM-stm32mp-dts-lxa-tac-wire-in-factory-data.patch \
  file://patches/0204-ARM-lxatac-register-TLV-decoder-and-print-out-serial.patch \
  file://patches/0205-ARM-stm32mp-lxa-tac-enable-deep-probe.patch \
  file://patches/0206-ARM-stm32mp-dts-lxa-tac-disable-OLED-display.patch \
  file://patches/0207-ARM-stm32mp-dts-lxa-tac-update-dts-from-kernel.patch \
  file://patches/0208-ARM-stm32mp-lxa-tac-distinguish-between-device-gener.patch \
  file://patches/0209-ARM-stm32mp-lxa-tac-model-the-PWM-RGB-status-LED-as-.patch \
  "
# umpf-release: 2023.03.0/customers/lxa/tac/20230421-1
# umpf-topic-range: a6ceb1b0371c91b35341ec013d0faf51eb6c0e1b..4139879f6fbf38100c523744eed1fcc52b6d37f1
SRC_URI += "\
  file://patches/0301-Release-2023.03.0-customers-lxa-tac-20230421-1.patch \
  "
# umpf-end
