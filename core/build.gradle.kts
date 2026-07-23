plugins {
    kotlin("jvm")
    kotlin("kapt")
    `java-library`
    `maven-publish`
}

dependencies {
    implementation(project(":annotations"))
    kapt(project(":processor"))

    testImplementation(kotlin("test"))
}

java {
    withSourcesJar()
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
        create<MavenPublication>("maven") {
            artifactId = "crux-core"
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