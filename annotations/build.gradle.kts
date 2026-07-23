plugins {
    kotlin("jvm")
    `java-library`
    `maven-publish`
}

java {
    withSourcesJar()
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "crux-annotations"
            from(components["java"])
            groupId = "org.crux"
            version = "0.7.0"
        }
    }

    repositories {
        maven {
            name = "GitHubPages"

            url = uri(rootProject.layout.projectDirectory.dir("docs"))
        }
    }
}