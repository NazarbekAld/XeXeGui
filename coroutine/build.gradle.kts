plugins {
    kotlin("jvm")
}

group = "me.nazarxexe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    api(project(":core"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    compileOnly("org.spigotmc:spigot-api:1.21.1-R0.1-SNAPSHOT")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}