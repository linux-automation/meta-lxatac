#!/bin/bash

set -e -u -o pipefail

FILES="$(find meta-lxatac-bsp/ meta-lxatac-software/ -type f -name \*.bb)"

result="0"

while read -r recipe
do
    # The oe-stylize script is not parameterizable, so we can not tell it not
    # to output warnings about variables it does not know.
    # Use grep to remove the warnings from its output.
    python3 meta-oe/contrib/oe-stylize.py "${recipe}" | \
        grep -v "## Warning: unknown variable/routine" > "${recipe}.linted"

    diff --color=always "${recipe}" "${recipe}.linted" > "${recipe}.diff" \
        && file_result="ok" || file_result="error"

    if [[ "x${file_result}" != "xok" ]]
    then
        # Group the output in the GitHub log as it can become quite unwieldy
        echo "::group::${recipe}"
        cat "${recipe}.diff"
        echo "::endgroup::"

        result="1"
    fi
done <<< "${FILES}"

exit "${result}"
