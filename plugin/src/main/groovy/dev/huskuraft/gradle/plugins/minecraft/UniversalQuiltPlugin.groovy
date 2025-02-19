package dev.huskuraft.gradle.plugins.minecraft


import org.gradle.api.Plugin
import org.gradle.api.Project

class UniversalQuiltPlugin implements Plugin<Project> {
    void apply(Project project) {

        project.repositories {
            mavenCentral()
        }
    }

}
