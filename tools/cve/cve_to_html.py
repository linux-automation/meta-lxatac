#!/usr/bin/env python3

import json
import sys

import common

TEMPLATE = """
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Vulnerability Report</title>
    <style>
      body { font-family: sans-serif; background:#f7f9fc; padding:20px; }
      h3 { margin-top: 2rem; }
      table { border-collapse: collapse; width: 100%; background:#fff; }
      th, td { padding: 8px 10px; border: 1px solid #e2e8f0; vertical-align: top; }
      th { background: #1f2937; color: #fff; text-align: left; }
      tr:nth-child(even) { background: #f3f4f6; }
      .severity-high { color: #b91c1c; font-weight: bold; }
      .severity-medium { color: #b45309; font-weight: bold; }
      .severity-low { color: #065f46; font-weight: bold; }
      a { color:#2563eb; text-decoration:none; }
      a:hover { text-decoration: underline; }
      .meta { font-size: 0.85em; color:#555; }
      .details { width: 60%}
    </style>
  </head>

  <body>
    {% for package in packages %}
      <h3>{{ package.name | escape }} {{ package.version | escape }}</h3>

      <table>
        <thead>
          <tr>
            <th>CVE ID</th>
            <th>Status</th>
            <th>Score</th>
            <th>Vector</th>
            <th>Last Modified</th>
            <th>Details</th>
          </tr>
        </thead>
        <tbody>
          {% for issue in package.issue %}
            <tr>
              <td>
                <a href="{{ issue.link | escape }}" target="_blank">{{ issue.id | escape }}</a>
              </td>
              <td>{{ issue.status | escape }}</td>
              <td class="
                {% if issue.score >= 90 %}severity-high
                {% elif issue.score >= 70 %}severity-medium
                {% else %}severity-low{% endif %}
              ">
                {{ issue.score  // 10 }}.{{ issue.score % 10 }}
              </td>
              <td>{{ issue.vector | escape }}</td>
              <td class="meta">{{ issue.modified | escape }}</td>
              <td class="details">
                <div><strong>Summary:</strong> {{ issue.summary | striptags | escape }}</div>
                <div><strong>Description:</strong> {{ issue.description | striptags | escape }}</div>
                <div class="meta"><strong>Vector String:</strong> {{ issue.vectorString | escape }}</div>
                {% if package.name == "linux-lxatac" %}
                  <div><a href="https://kernel-team.pages.debian.net/kernel-sec/{{ issue.id | escape }}.html">Debian Kernel Security Tracker</a></div>
                {% endif %}
                <div><a href="https://security-tracker.debian.org/tracker/{{ issue.id | escape }}">Debian Security Tracker</a></div>
              </td>
            </tr>
          {% endfor %}
        </tbody>
      </table>
    {% endfor %}
  </body>
</html>
"""


def main():
    # The output from `sbom-cve-check --export-type yocto-cve-check-manifest ...`
    # is expected to be piped into stdin.
    manifest = json.load(sys.stdin)
    packages = common.filter_and_sort_packages(manifest)
    html = common.render(packages, TEMPLATE)
    sys.stdout.write(html)


if __name__ == "__main__":
    main()
