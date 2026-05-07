#!/usr/bin/env python3

from jinja2 import Template, StrictUndefined


def filter_and_sort_packages(manifest):
    packages = list()

    for package in manifest["package"]:
        issues = list()

        for issue in package.get("issue", []):
            if issue.get("status") in ("Patched", "Ignored"):
                continue

            score_strs = list(
                issue[v]
                for v in ("scorev2", "scorev3", "scorev4")
                if v in issue and issue[v] != "0.0"
            ) + ["0.0"]
            major, minor = score_strs[0].split(".")
            issue["score"] = int(major) * 10 + int(minor)

            issues.append(issue)

        if not issues:
            continue

        issues.sort(key=lambda i: (i["score"], i["id"]), reverse=True)

        package["issue"] = issues
        packages.append(package)

    packages.sort(key=lambda p: p["issue"][0]["score"], reverse=True)

    return packages


def render(packages, template):
    template = Template(
        template, undefined=StrictUndefined, trim_blocks=True, lstrip_blocks=True
    )
    output = template.render(packages=packages).strip() + "\n"

    return output


def spdx_software_packages(spdx):
    return dict(
        (node["name"], node)
        for node in spdx["@graph"]
        if node.get("type", "").lower() == "software_package"
        and node.get("software_primaryPurpose", "").lower() == "install"
        and "name" in node
    )
