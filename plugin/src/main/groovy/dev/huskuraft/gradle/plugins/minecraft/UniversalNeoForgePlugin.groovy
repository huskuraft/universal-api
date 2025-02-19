package dev.huskuraft.gradle.plugins.minecraft


import org.gradle.api.Plugin
import org.gradle.api.Project

class UniversalNeoForgePlugin implements Plugin<Project> {
    void apply(Project project) {

        project.pluginManager.apply('net.neoforged.gradle.userdev')

        project.dependencies {
            compileOnly "net.neoforged:neoforge:${neo_version}"
            compileOnly('net.sf.jopt-simple:jopt-simple:5.0.4') { version { strictly '5.0.4' } }
        }

        project.minecraft {
            accessTransformers {
                file('src/main/resources/META-INF/neoforge.accesstransformer.cfg')
            }
            runs {
                configureEach {
                    workingDirectory project.file('run')
                    systemProperty 'forge.logging.markers', 'REGISTRIES'
                    systemProperty 'forge.logging.console.level', 'debug'
                }

                client {
                    systemProperty 'forge.enabledGameTestNamespaces', mod_id
                }

                server {
                    systemProperty 'forge.enabledGameTestNamespaces', mod_id
                    programArgument '--nogui'
                }

                gameTestServer {
                    systemProperty 'forge.enabledGameTestNamespaces', mod_id
                }
            }
        }

        project.sourceSets.main.java {
            srcDir "${project(":common-api").projectDir}/src/main/java"
        }

        project.shadowJar {
        }
    }

}
