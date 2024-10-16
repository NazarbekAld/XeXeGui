plugins {
    kotlin("jvm") version "2.0.20"
    `maven-publish`
}

group = "me.nazarxexe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}