package dev.huskuraft.gradle.plugins.minecraft

import org.gradle.api.Plugin
import org.gradle.api.Project

class UniversalFabricPlugin implements Plugin<Project> {
    void apply(Project project) {

        project.pluginManager.apply('fabric-loom')

        project.repositories {
            mavenCentral()
            maven {
                name = 'Fabric'
                url = 'https://maven.fabricmc.net/'
            }
            maven {
                name = 'Quilt'
                url = 'https://maven.quiltmc.org/repository/release'
            }
        }

        project.dependencies {
            minecraft "com.mojang:minecraft:${project.minecraft_version}"
            mappings project.loom.officialMojangMappings() // reserved for fabric loom

            modCompileOnly "net.fabricmc.fabric-api:fabric-api:${project.fabric_version}"
            modCompileOnly "net.fabricmc:fabric-loader:${project.fabric_loader_version}"

            modCompileOnly "org.quiltmc:quilt-loader:${project.quilt_loader_version}"
        }

        project.jar {
        }

        project.shadowJar {
            finalizedBy project.remapJar
        }

        project.remapJar {
            inputFile = project.shadowJar.archiveFile
        }

        project.loom {
            accessWidenerPath = project.file("src/main/resources/fabric.accesswidener")
            mixin {
                add(project.sourceSets.main, 'fabric.refmap.json')
            }
        }

    }

}
