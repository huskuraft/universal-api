package dev.huskuraft.gradle.plugins.minecraft

import groovy.transform.Immutable

@Immutable
class UniversalMod {
    String id
    String name
    String license
    List<UniversalTarget> includeTargets
}
