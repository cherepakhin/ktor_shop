import org.gradle.api.publish.PublishingExtension

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

group = "ru.perm.v.ktor_shop"
version = "0.0.1"

plugins {
    `maven-publish`
    kotlin("jvm") version "1.9.22"
    id("io.ktor.plugin") version "2.3.7"
    java
    idea
    application
}

application {
    mainClass.set("ru.perm.v.ktor.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("http://v.perm.ru:8082/repository/ru.perm.v")
        isAllowInsecureProtocol = true
        credentials {
            username = "admin"
            password = "pass"

// export NEXUS_CI_USER=admin
// echo $NEXUS_CI_USER
//            username = System.getenv("NEXUS_CRED_USR") ?: extra.properties["nexus-ci-username"] as String?
// export NEXUS_CI_PASS=pass
// echo $NEXUS_CI_PASS
//            password = System.getenv("NEXUS_CRED_PASS") ?: extra.properties["nexus-ci-password"] as String?
        }
    }
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-html-builder-jvm")
    implementation("org.jetbrains.kotlinx:kotlinx-html")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-jackson-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

ktor {
    fatJar {
        archiveFileName.set("ktor_shop.jar")
    }

}

buildscript {
    var kotlinVersion: String? by extra; kotlinVersion = "1.1.51"

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }

}

configure<PublishingExtension> {
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "ktor-shop"
            groupId = "ru.perm.v.ktor_shop"
            version = "0.0.1"
        }
        repositories {
            maven {
                url = uri("http://v.perm.ru:8082/repository/ru.perm.v/")
                isAllowInsecureProtocol = true
                //  publish в nexus "./gradlew publish" из ноута и Jenkins проходит
                // export NEXUS_CRED_USR=admin
                // echo $NEXUS_CRED_USR
                credentials {
                    username = System.getenv("NEXUS_CRED_USR")
                    password = System.getenv("NEXUS_CRED_PSW")
                }
            }
        }
    }
}
