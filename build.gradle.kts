import org.jetbrains.dokka.gradle.DokkaTask
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

