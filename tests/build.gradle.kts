plugins {
    kotlin("jvm")
    id("com.gradleup.shadow") version "8.3.3"

}

group = "me.nazarxexe.ui"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")

}

dependencies {
    api(project(":core"))
    api(project(":adventure_util"))
    api(project(":route"))
    api(project(":pagination"))
    api(project(":coroutine"))
    implementation("net.kyori:adventure-text-serializer-legacy:4.17.0")
    implementation("io.ktor:ktor-client-cio-jvm:3.0.0")
    compileOnly("org.spigotmc:spigot-api:1.21.1-R0.1-SNAPSHOT")

    implementation("io.ktor:ktor-client-core:3.0.0")
    implementation("io.ktor:ktor-client-cio:3.0.0")

    testImplementation("com.github.seeseemelk:MockBukkit-v1.21:3.131.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}