# umpf-base: v2022.05.0
# umpf-name: 2022.05/customers/lxa/tac
# umpf-version: 2022.05/customers/lxa/tac/20220531-4
# umpf-topic: v2022.05.0/topic/tlv
# umpf-hashinfo: aaf7dac9b4cb017724702b2a97de92a0f8e21731
# umpf-topic-range: 6a3f9ed1f5c55957b2ed4f460955281539e8e785..47be87247d968b5f516db3fc3cb4f829630dfa48
SRC_URI += "\
  file://patches/0001-scripts-implement-slurp-a-read_file-with-fd-as-argum.patch \
  file://patches/0002-of_path-support-phandles-in-of_find_path.patch \
  file://patches/0003-Makefile-add-common-boards-include-to-include-search.patch \
  file://patches/0004-common-add-help-text-for-CONFIG_STATE.patch \
  file://patches/0005-of-implement-of_append_property.patch \
  file://patches/0006-test-self-add-tests-for-of_append_property.patch \
  file://patches/0007-net-add-ethaddr-sequence-handling.patch \
  file://patches/0008-common-add-global.serial_number-with-device-tree-fix.patch \
  file://patches/0009-common-add-optional-systemd.hostname-generation.patch \
  file://patches/0010-net-factor-out-eth_of_get_fixup_node.patch \
  file://patches/0011-net-export-list-of-registered-ethernet-addresses.patch \
  file://patches/0012-net-implement-ethaddr_string_cmp.patch \
  file://patches/0013-common-add-barebox-TLV-support.patch \
  file://patches/0014-commands-add-TLV-debugging-command.patch \
  file://patches/0015-scripts-add-bareboxtlv-host-target-tool.patch \
  "
# umpf-topic: v2022.05.0/customers/lxa/tac
# umpf-hashinfo: 427e898b20a8643496bad61f694ce496840aba06
# umpf-topic-range: 47be87247d968b5f516db3fc3cb4f829630dfa48..996858daac38d31c79537a68ed20afc55e31fb1f
SRC_URI += "\
  file://patches/0101-WIP-ARM-stm32mp-add-Linux-Automation-TAC-board.patch \
  file://patches/0102-ARM-dts-LXATAC-enable-ohci.patch \
  file://patches/0103-ARM-stm32mp-dk2-add-barebox-env-and-state-on-SD.patch \
  file://patches/0104-ARM-stm32mp-lxa-tac-add-barebox-env-and-state-on-eMM.patch \
  file://patches/0105-ARM-stm32mp-lxa-tac-add-properties-for-ssd1306.patch \
  file://patches/0106-HACK-video-ssd1307fb-increase-VCOMH-to-0x40.patch \
  file://patches/0107-ARM-lxatac-add-FIP-barebox-update-handler.patch \
  file://patches/0108-ARM-stm32mp-lxa-tac-enable-access-to-ramoops.patch \
  file://patches/0109-boards-add-decoder-for-LXA-TLV-v1-format.patch \
  file://patches/0110-ARM-stm32mp-dts-lxa-tac-wire-in-factory-data.patch \
  file://patches/0111-ARM-lxatac-register-TLV-decoder-and-print-out-serial.patch \
  file://patches/0112-HACK-Workaround-timeout-after-core-reset-on-some-lxa.patch \
  "
# umpf-topic: v2022.05.0/topic/fix-malloc-overflow
# umpf-hashinfo: 9269eca24e1019789f2136da26b098eac8b1ce7f
# umpf-topic-range: 996858daac38d31c79537a68ed20afc55e31fb1f..5d7f61ffb21bf946285a7d5c298a67853ddb249c
SRC_URI += "\
  file://patches/0201-tlsf-fix-internal-overflow-trying-to-allocate-big-bu.patch \
  "
# umpf-topic: v2022.05.0/topic/stm32mp-bbu-fip
# umpf-hashinfo: 8fd42084d86ed9e9b5cffef424c26872ee979952
# umpf-topic-range: 5d7f61ffb21bf946285a7d5c298a67853ddb249c..b6b6fc7edb15ab2e0916d3b54e98dd782239b412
SRC_URI += "\
  file://patches/0301-fastboot-inform-user-if-barebox-update-falls-back-to.patch \
  file://patches/0302-bbu-move-barebox_update-eMMC-boot-handling-into-comm.patch \
  file://patches/0303-bbu-use-free-NULL-to-simplify-function-cleanup.patch \
  file://patches/0304-bbu-add-flag-for-enabling-eMMC-boot-ack.patch \
  file://patches/0305-bbu-export-bbu_std_file_handler-for-use-in-custom-ha.patch \
  file://patches/0306-filetype-differentiate-between-STM32MP-FSBL-and-SSBL.patch \
  file://patches/0307-ARM-stm32mp-bbu-add-FIP-update-handler.patch \
  file://patches/0308-fastboot-support-TF-A-FSBL-and-FIP-images-for-barebo.patch \
  "
# umpf-topic: v2022.05.0/topic/emmc-boot-ack-param
# umpf-hashinfo: fbdeea89e0c7a81eb755d63c4a627a859393063f
# umpf-topic-range: b6b6fc7edb15ab2e0916d3b54e98dd782239b412..f071f8bd5395ea89aa48c6438285087c55c445cf
SRC_URI += "\
  file://patches/0401-mci-core-add-device-parameter-for-eMMC-boot-ack.patch \
  "
# umpf-release: 2022.05/customers/lxa/tac/20220531-4
# umpf-topic-range: f071f8bd5395ea89aa48c6438285087c55c445cf..421ce5bb837a7ee15e6d14ffed5d3279e31704e6
SRC_URI += "\
  file://patches/0501-Release-2022.05-customers-lxa-tac-20220531-4.patch \
  "
# umpf-end
