package dev.huskuraft.universal.gradle


import org.gradle.api.Plugin
import org.gradle.api.Project

class UniversalQuiltPlugin implements Plugin<Project> {
    void apply(Project project) {

        project.repositories {
            mavenCentral()
        }
    }

}
