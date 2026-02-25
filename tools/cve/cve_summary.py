#!/usr/bin/env python3

import json
import sys

import common

TEMPLATE = """
{% if packages | length == 0 %}
There are no packages with known vulnerabilities!
{% else %}
There are {{ packages | length }} packages with known vulnerabilities:

{% for package in packages %}
- {{ package.name }} {{ package.version }}
{% for issue in package.issue %}
  - {{ issue.id }} | {{ issue.vector }} | {{ issue.score  // 10 }}.{{ issue.score % 10 }}

    {{ issue.summary | striptags | wordwrap(76) | indent(4) }}

    Status: {{ issue.status }}
    Last Modified: {{ issue.modified }}
    Link: {{ issue.link }}
{% if not loop.last %}

{% endif %}
{% endfor %}

{% endfor %}
{% endif %}
"""


def main():
    # The output from `sbom-cve-check --export-type yocto-cve-check-manifest ...`
    # is expected to be piped into stdin.
    manifest = json.load(sys.stdin)
    packages = common.filter_and_sort_packages(manifest)
    html = common.render(packages, TEMPLATE)
    sys.stdout.write(html)

    # Exit with error code 100 if vulnerabilities were found.
    sys.exit(0 if len(packages) == 0 else 100)


if __name__ == "__main__":
    main()
