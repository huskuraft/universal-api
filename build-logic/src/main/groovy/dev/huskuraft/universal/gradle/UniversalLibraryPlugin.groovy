package dev.huskuraft.universal.gradle

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.publish.maven.MavenPublication

class UniversalLibraryPlugin implements Plugin<Project> {

    static int getVersionCode(Project project) {
        return project.name.replace('v', '').toInteger()
    }

    static JavaVersion getJavaVersion(int dataVersion) {
        switch (dataVersion) {
            case 0000..2503: return JavaVersion.VERSION_1_8
            case 2504..2680: return JavaVersion.VERSION_11
            case 2681..2833: return JavaVersion.VERSION_17 // JavaVersion.VERSION_16
            case 2834..3800: return JavaVersion.VERSION_17
            case 3801..4315: return JavaVersion.VERSION_21
            default: return JavaVersion.VERSION_21
        }
    }

    void apply(Project project) {
        project.pluginManager.apply('java-library')
        project.pluginManager.apply('maven-publish')
        project.pluginManager.apply('com.gradleup.shadow')
        project.group = "dev.huskuraft.universal"

        def dataVersion = getVersionCode(project)

        project.ext {
            minecraft_version_earliest = "${project.minecraft_version_list}".split(",")[0]
            if (project.loader_name == 'fabric' || project.loader_name == 'quilt') {
                minecraft_version_range = ">=${project.minecraft_version_earliest}-"
            }
            if (project.loader_name == 'forge' || project.loader_name == 'neoforge') {
                minecraft_version_range = "[${project.minecraft_version_earliest},)"
            }
            forge_version_range = "[0,)"
            neoforge_version_range = "[0,)"
            loader_version_range = "[0,)"
            mapping_channel = "official"
            mapping_version = project.minecraft_version

            mod_id = 'universal'
            mod_version = project.version
            mod_authors = 'Huskuraft'
            mod_name = 'Universal API'
            mod_license = 'LGPLv3'
            mod_description = ''
            mod_display_url = 'https://github.com/huskuraft/universal-api'
            mod_sources_url = 'https://github.com/huskuraft/universal-api'
            mod_issues_url = 'https://github.com/huskuraft/universal-api/issues'

        }

        project.dependencies {
            compileOnly project.project(':common-api')
            compileOnly project.project(':third-party:open-pac-api-v0')
            if (dataVersion < 3442) {
                compileOnly project.project(':third-party:ftb-chunks-api-v0')
            } else {
                compileOnly project.project(':third-party:ftb-chunks-api-v1')
            }
            compileOnly 'com.google.code.findbugs:jsr305:3.0.2'

            annotationProcessor 'com.google.auto.service:auto-service:1.1.1'
            compileOnly 'com.google.auto.service:auto-service:1.1.1'
        }

        project.base {
            archivesName = "${project.loader_name}-api-${project.minecraft_version}"
        }

        project.java {
            withSourcesJar()
            sourceCompatibility = getJavaVersion(dataVersion)
            targetCompatibility = getJavaVersion(dataVersion)
        }

        project.processResources {

            duplicatesStrategy = DuplicatesStrategy.INCLUDE

            filesMatching(['fabric.mod.json', 'META-INF/mods.toml', 'META-INF/neoforge.mods.toml', 'pack.mcmeta']) {
                expand project.properties
            }
        }

        project.jar {
            manifest {
                attributes([
                    'Specification-Title'     : project.mod_id,
                    'Specification-Vendor'    : project.mod_authors,
                    'Specification-Version'   : '1',
                    'Implementation-Title'    : project.name,
                    'Implementation-Version'  : project.jar.archiveVersion,
                    'Implementation-Vendor'   : '',
                    'Implementation-Timestamp': new Date().format("yyyy-MM-dd'T'HH:mm:ssZ")
                ])
            }
        }

        project.shadowJar {
            configurations = [project.configurations.shadow]
            mergeServiceFiles()
            dependencies {
                exclude dependency('com.google.code.findbugs:jsr305')
            }
            relocate 'dev.huskuraft.universal.vanilla', "dev.huskuraft.universal.${project.loader_name}"

            archiveClassifier.set('')
        }

        project.pluginManager.apply([
            'fabric'  : UniversalFabricPlugin.class,
            'quilt'   : UniversalQuiltPlugin.class,
            'forge'   : UniversalForgePlugin.class,
            'neoforge': UniversalNeoForgePlugin.class
        ]["${project.loader_name}"])


        project.artifacts {
            if (project.loader_name == 'fabric') {
                archives(project.tasks.remapJar)
            } else {
                archives(project.tasks.shadowJar)
            }
        }

        project.publishing {
            publications {
                maven(MavenPublication) {
                    artifactId = "${project.loader_name}-api"
                    if (project.loader_name == 'fabric') {
                        artifact(project.tasks.remapJar) {
                            classifier "v${dataVersion}"
                        }
                    } else {
                        artifact(project.tasks.shadowJar) {
                            classifier "v${dataVersion}"
                        }
                    }
                }
            }
        }

    }

}
