pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.4.21"
        id("org.jetbrains.dokka") version "1.4.20"
    }
}

rootProject.name = "mpp-game-docs"

include(":mpp-game-math")
project(":mpp-game-math").projectDir = file("./modules/mpp-game-math")
