#!/usr/bin/env python3

import datetime
import json
import os
import subprocess
import sys
from contextlib import suppress

import common


def main(*manifest_paths):
    now = datetime.datetime.now()

    packages = list()

    # First generate a manifest without involving the custom annotation
    # database:
    #
    #   $ sbom-cve-check --verbose \
    #     --sbom-path "${BBPATH}/tmp/deploy/images/lxatac/lxatac-core-image-base-lxatac.rootfs.spdx.json" \
    #     --yocto-vex-manifest "${BBPATH}/tmp/deploy/images/lxatac/lxatac-core-image-base-lxatac.rootfs.vex.json" \
    #     --export-type yocto-cve-check-manifest \
    #     --export-path cve-check-no-annot.json
    #
    # Then clean up the Linux kernel CVEs:
    #
    #   $ git -C ~/work/Projects/linux-vulns/ pull
    #   $ ./openembedded-core/scripts/contrib/improve_kernel_cve_report.py \
    #     --spdx "${BBPATH}/tmp/deploy/spdx/3.0.1/lxatac/recipes/build-linux-lxatac.spdx.json" \
    #     --datadir ~/work/Projects/linux-vulns/ \
    #     --old-cve-report cve-check-no-annot.json \
    #     --new-cve-report cve-check-linux-no-annot.json
    #
    # Repeat for all branches you currently care about.
    # Pass the path to all manifests as arguments to this script:
    #
    #   $ python3 tools/cve/cve_whatever.py cve-check-linux-no-annot.json ...
    #
    # Finally address all CVEs with unclear status:
    #
    #   $ nano $(rg --files-with-matches TODO tools/cve/annotations/ | sort -R)

    for manifest_path in manifest_paths:
        with open(manifest_path) as fd:
            manifest = json.load(fd)

        packages.extend(common.filter_and_sort_packages(manifest))

    # Move the previous annotations out of the way to make it easier to remove
    # annotations that are no longer required.
    annot_base = os.path.join("tools", "cve", "annotations")
    annot_old_base = f"{annot_base}.old-{now:%Y%m%d%H%M%S}"
    os.rename(annot_base, annot_old_base)
    os.mkdir(annot_base)

    author = "TODO"

    with suppress(Exception):
        author = subprocess.run(
            ["git", "config", "get", "user.name"],
            stdout=subprocess.PIPE,
            check=True,
            text=True,
        ).stdout.strip()

    for package in packages:
        for issue in package["issue"]:
            filename = f"{issue['id']}.json"
            annot_path = os.path.join(annot_base, filename)
            annot_old_path = os.path.join(annot_old_base, filename)

            annotation = {}

            # Check if we had an annotation for this vulnerability before
            with suppress(FileNotFoundError), open(annot_old_path) as fd:
                annotation = json.load(fd)

            # Check if we already touched the annotation this time around
            with suppress(FileNotFoundError), open(annot_path) as fd:
                annotation = json.load(fd)

            has_changed = False

            if "author" not in annotation:
                annotation["author"] = author
                has_changed = True

            if "version" not in annotation:
                annotation["version"] = 1
                has_changed = True

            if "statements" not in annotation:
                stm = {
                    "vulnerability": {"name": issue["id"]},
                    "products": [],
                    "status_notes": "TODO",
                    "status": "not_affected",
                }
                annotation["statements"] = [stm]
                has_changed = True

            for cpe in package.get("cpes", []):
                product = {"identifiers": {"cpe23": cpe}}

                if product in annotation["statements"][0]["products"]:
                    continue

                annotation["statements"][0]["products"].append(product)
                has_changed = True

            if has_changed or "timestamp" not in annotation:
                has_changed = True
                annotation["timestamp"] = now.isoformat()

            assert annotation["statements"][0]["vulnerability"]["name"] == issue["id"]

            with open(annot_path, "w") as fd:
                json.dump(annotation, fd, indent=2, ensure_ascii=False, sort_keys=True)
                fd.write("\n")

            action = "updated" if has_changed else "copied"
            print(f"{action} {annot_path}")


if __name__ == "__main__":
    main(*sys.argv[1:])
