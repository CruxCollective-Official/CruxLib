plugins {
    kotlin("jvm") version "2.4.0" apply false
}

group = "org.crux"
version = project.property("sharedVersion") as String

subprojects {
    repositories {
        mavenCentral()
    }
}
/*
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
*/