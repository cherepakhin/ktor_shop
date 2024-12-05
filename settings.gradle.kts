rootProject.name = "ru.perm.v.ktor_shop"

pluginManagement {
    repositories {
        jcenter()
        gradlePluginPortal()
    }
    plugins {
        kotlin("jvm") version "1.9.0"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
