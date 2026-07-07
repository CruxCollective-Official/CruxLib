plugins {
    kotlin("jvm") version "2.4.0"
}

group = "org.crux"
version = "0.2.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}