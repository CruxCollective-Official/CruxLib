plugins {
    kotlin("jvm") version "2.4.0"
    `java-library`
    `maven-publish`
}

group = "org.crux"
version = "0.4.0"

repositories {

    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

java {
    withSourcesJar()
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("crux") {
            artifactId = "crux-lib"

            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "GitHubPages"

            url = uri(layout.projectDirectory.dir("docs"))
        }
    }
}