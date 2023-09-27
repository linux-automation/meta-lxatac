# Backport of oe-core commit 7e7a7394b47f6fd4a4dd26a18a5d94302ab6df1e
# "perf: add libtraceevent packageconfig"
# But keep libtraceevent disabled

#PACKAGECONFIG:append = "libtraceevent"
PACKAGECONFIG[libtraceevent] = ",NO_LIBTRACEEVENT=1"
