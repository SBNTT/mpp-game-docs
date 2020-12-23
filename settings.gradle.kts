pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.4.21"
        id("org.jetbrains.dokka") version "1.4.20"
    }
}

rootProject.name = "mpp-game-docs"

file("./modules").list()?.forEach {
    if(!file("./modules/$it").isDirectory) return@forEach
    include(":$it")
    project(":$it").projectDir = file("./modules/$it")
}