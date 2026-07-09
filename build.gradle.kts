plugins {
    kotlin("jvm") version "2.4.0"
    `java-library`
    `maven-publish`
}

group = "org.crux"
version = "0.3.0-SNAPSHOT"

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
        create<MavenPublication>("gpr") {
            artifactId = "crux-lib"

            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/CruxCollective-Official/CruxLib")

            credentials {
                username = project.findProperty("GITHUB_ACTOR")?.toString()
                    ?: System.getenv("GITHUB_ACTOR")

                password = project.findProperty("GITHUB_TOKEN")?.toString()
                    ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}