plugins {
    id("java")
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
}

dependencies {
    compileOnly(project(":annotations"))

    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "crux-processor"
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