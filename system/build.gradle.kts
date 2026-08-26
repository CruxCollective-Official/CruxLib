plugins {
    kotlin("jvm")
    kotlin("kapt")
    `java-library`
    `maven-publish`

    id("me.champeau.jmh") version "0.7.3"
}

dependencies {
    implementation(project(":annotations"))
    kapt(project(":processor"))

    testImplementation(kotlin("test"))

    jmh("org.openjdk.jmh:jmh-core:1.37")
    jmhAnnotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.37")
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