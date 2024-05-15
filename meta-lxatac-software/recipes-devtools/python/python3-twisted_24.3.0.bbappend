# This is a backport of meta-oe master commit bd1b5cde3
# ("python3-twisted: prepend split PACKAGES"),
# which fixes an issue where the `python3-twisted` package would gobble up
# all of the files in the split stage (because it matches broadly and comes
# before the other packages in the list) and most of the other packages
# ended up empty.
# Since this workaround is only required until that commit makes it into
# the scarthgap branch go the easy route and just hardcode the package
# order achieved by bd1b5cde3.

PACKAGES = "\
    python3-twisted-zsh \
    python3-twisted-test \
    python3-twisted-protocols \
    python3-twisted-conch \
    python3-twisted-mail \
    python3-twisted-names \
    python3-twisted-news \
    python3-twisted-runner \
    python3-twisted-web \
    python3-twisted-words \
    python3-twisted-flow \
    python3-twisted-pair \
    python3-twisted-core \
    python3-twisted-src \
    python3-twisted-dbg \
    python3-twisted-staticdev \
    python3-twisted-dev \
    python3-twisted-doc \
    python3-twisted-locale \
    python3-twisted \
"
