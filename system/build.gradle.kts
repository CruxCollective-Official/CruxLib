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
            artifactId = "crux-system"
            from(components["java"])
            groupId = "org.crux"
            version = project.property("sharedVersion") as String
        }
    }

    repositories {
        maven {
            name = "GitHubPages"

            url = uri(rootProject.layout.projectDirectory.dir("docs"))
        }
    }
}