#!/usr/bin/env python3
"""Show the dependency relations between two packages in an SPDX 3.x
JSON-LD SBOM.

This file is entirely LLM generated and has not undergone strict review.
If it proves useful and if we want to make large changes in the future,
consider replacing it instead of putting too much effort into understanding it.

Meant for OpenEmbedded/Yocto rootfs SBOMs (oe-spdx-creator output). Given a
start package (e.g. an image) and a goal package (e.g. a library), every
relation a -> b that occurs on a dependency path from the start to the goal
is printed once, one per line, ordered by the distance of the relation's
source from the start package. This shows which installed packages directly
or transitively depend on the goal.

Usage:
  sbom-dependency-chain.py SBOM.json PACKAGE_A PACKAGE_B

Examples:
  sbom-dependency-chain.py lxatac-core-image-base-lxatac.rootfs.spdx.json \\
      lxatac-core-image-base libxml2
  sbom-dependency-chain.py lxatac-core-image-base-lxatac.rootfs.spdx.json wireshark libxml2

Exit codes: 0 = relations printed, 1 = no dependency path found, 2 = bad input.
"""

import difflib
import json
import re
import sys

TWIN_RE = re.compile(r"^.*?/(?:recipe|package)/([^/]+)$")


def die(msg, code=2):
    print(msg, file=sys.stderr)
    sys.exit(code)


def load_graph(path):
    """Return the @graph of an SPDX 3.x JSON-LD document."""
    try:
        with open(path) as f:
            return json.load(f)["@graph"]
    except (OSError, ValueError, KeyError) as e:
        die(f"error: cannot load SPDX 3 JSON document from {path}: {e}")


def to_list(x):
    return x if isinstance(x, list) else [x]


class Sbom:
    def __init__(self, graph):
        # Merge recipe/X and package/X twin nodes into one logical package,
        # keyed by package name. Everything else keeps its spdxId.
        self.name = {}  # logical id -> display name
        self.by_name = {}  # display name -> logical id (first node wins)
        self.lid = {}  # spdx id -> logical id
        for x in graph:
            sid = x.get("spdxId")
            if not sid:
                continue
            m = TWIN_RE.match(sid)
            logical = m.group(1) if m and m.group(1) == x.get("name") else sid
            self.lid[sid] = logical
            self.name[logical] = x.get("name") or sid
            n = x.get("name")
            if n:
                self.by_name.setdefault(n, logical)

        self.edges = {}  # logical id -> {neighbor ids}
        self.redges = {}  # logical id -> {predecessor ids}
        self.has_contains = set()  # logical ids incident to a 'contains' edge
        self._dist_cache = {}  # goal logical id -> distance map

        # 1) package membership derived from the 'contains' file structure.
        files_of = {}  # file spdx id -> {logical pkg ids}
        pkg_files = {}  # logical pkg id -> {file spdx ids}
        for r in graph:
            if r.get("type") == "Relationship" and r.get("relationshipType") == "contains":
                frm = self.lid.get(r.get("from"))
                if not frm:
                    continue
                for t in to_list(r.get("to")):
                    tl = self.lid.get(t)
                    if not tl:
                        continue
                    files_of.setdefault(t, set()).add(frm)
                    pkg_files.setdefault(frm, set()).add(t)
        for pkgs in files_of.values():
            pkgs = sorted(pkgs)
            for i in range(len(pkgs)):
                for j in range(i + 1, len(pkgs)):
                    a, b = pkgs[i], pkgs[j]
                    fa, fb = len(pkg_files[a]), len(pkg_files[b])
                    if fa > fb:
                        self.add(a, b, contains=True)
                    elif fb > fa:
                        self.add(b, a, contains=True)

        # 2) software_Sbom -> its root elements
        for x in graph:
            if x.get("type") == "software_Sbom":
                for t in to_list(x.get("rootElement")):
                    tl = self.lid.get(t)
                    if tl:
                        self.add(self.lid[x["spdxId"]], tl, contains=True)

        # 3) dependsOn (runtime and build scope)
        for r in graph:
            if r.get("relationshipType") != "dependsOn":
                continue
            frm = self.lid.get(r.get("from"))
            if not frm:
                continue
            for t in to_list(r.get("to")):
                tl = self.lid.get(t)
                if tl:
                    self.add(frm, tl)

    def add(self, a, b, contains=False):
        if a == b:  # self-loop created by the twin merge
            return
        self.edges.setdefault(a, set()).add(b)
        self.redges.setdefault(b, set()).add(a)
        if contains:
            self.has_contains.update((a, b))

    def resolve(self, pkg):
        """Resolve a package name to a logical node id; error with suggestions."""
        if pkg in self.by_name:
            return self.by_name[pkg]
        suggestions = difflib.get_close_matches(pkg, self.by_name, n=5)
        die(
            f"error: package {pkg!r} not found in SBOM"
            + (f"; did you mean: {', '.join(suggestions)}" if suggestions else "")
        )

    def dist_to(self, goal):
        """Shortest distance (in hops) from every node to goal.

        Reverse BFS over the dependency edges; the result is the
        transitive-dependency set of goal (n is in the result iff n can
        transitively reach goal). Cached per goal node.
        """
        if goal not in self._dist_cache:
            dist = {goal: 0}
            frontier, d = [goal], 0
            while frontier:
                d += 1
                nxt = []
                for n in frontier:
                    for p in self.redges.get(n, ()):
                        if p not in dist:
                            dist[p] = d
                            nxt.append(p)
                frontier = nxt
            self._dist_cache[goal] = dist
        return self._dist_cache[goal]


def all_chains(sbom, dist, start, goal):
    """All chains start -> ... -> goal.

    `dist` maps every node that can still reach `goal` to its shortest
    distance; the search only follows such edges, so it never wanders into
    dead ends. Each chain is simple (a per-path `seen` set), which also
    guards against cycles in the dependency graph.
    """
    chains = []
    stack = [(start, {start}, [start])]
    while stack:
        node, seen, path = stack.pop()
        if node == goal:
            chains.append(path)
            continue
        for nxt in sorted(sbom.edges.get(node, ())):
            if nxt not in seen and dist.get(nxt) is not None:
                stack.append((nxt, seen | {nxt}, path + [nxt]))
    chains.sort(key=lambda p: (len(p), tuple(sbom.name[n] for n in p)))
    return chains


def main():
    if len(sys.argv) != 4:
        die(f"usage: {sys.argv[0]} SBOM.json PACKAGE_A PACKAGE_B")
    _, path, pkg_a, pkg_b = sys.argv

    sbom = Sbom(load_graph(path))
    start = sbom.resolve(pkg_a)
    goal = sbom.resolve(pkg_b)
    if start == goal:
        die(f"error: {pkg_a!r} and {pkg_b!r} are the same package")

    for pkg, lid in ((pkg_a, start), (pkg_b, goal)):
        if lid not in sbom.has_contains:
            print(
                f"warning: {pkg!r} has no 'contains' edges in this SBOM; "
                f"its membership in the image cannot be inferred and "
                f"chains through it may be missing",
                file=sys.stderr,
            )

    dist = sbom.dist_to(goal)
    reversed_dir = False
    if start not in dist:
        dist = sbom.dist_to(start)
        if goal not in dist:
            sys.exit(f"no dependency chain found between {pkg_a!r} and {pkg_b!r}")
        start, goal, reversed_dir = goal, start, True

    chains = all_chains(sbom, dist, start, goal)
    # Collapse all chains to the individual relations occurring in them.
    level = {}  # node -> smallest distance from start seen in any chain
    relations = set()
    for p in chains:
        for i, n in enumerate(p):
            if n not in level or i < level[n]:
                level[n] = i
        relations.update(zip(p[:-1], p[1:], strict=True))
    if reversed_dir:
        print(
            f"note: no chain {pkg_a} -> {pkg_b}; showing relations {pkg_b} -> {pkg_a} (reverse direction)",
            file=sys.stderr,
        )
    for a, b in sorted(relations, key=lambda ab: (level[ab[0]], sbom.name[ab[0]], sbom.name[ab[1]])):
        print(f"{sbom.name[a]} -> {sbom.name[b]}")
    print(f"{len(relations)} relation(s) found in {len(chains)} chain(s)", file=sys.stderr)


if __name__ == "__main__":
    main()
