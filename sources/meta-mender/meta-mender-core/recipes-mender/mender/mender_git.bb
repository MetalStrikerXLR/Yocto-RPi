require mender_git.inc

def mender_version_of_this_recipe(d, srcpv):
    version = mender_version_from_preferred_version(d, srcpv)
    if version.startswith("1."):
        # Pre-2.0. We don't want to match this.
        return "non-matching-version-" + version
    else:
        return version
PV = "${@mender_version_of_this_recipe(d, '${SRCPV}')}"
