import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.Platform

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
}

repositories {
    jcenter()
}

kotlin {
    jvm()
}

tasks.withType<DokkaMultiModuleTask>().configureEach {
    if (!name.contains("html", ignoreCase = true)) return@configureEach

    val docs = projectDir.resolve("docs")
    outputDirectory.set(docs)
    doLast {
        docs.resolve("-modules.html").renameTo(docs.resolve("index.html"))
    }
}

subprojects {
    plugins.apply("org.jetbrains.dokka")

    repositories {
        jcenter()
    }

    tasks.withType<DokkaTask>().configureEach {
        dokkaSourceSets {
            configureEach {
                if (platform.get() == Platform.native) {
                    displayName.set("native")
                }
            }
        }
    }
}

