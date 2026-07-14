plugins {
    kotlin("jvm") version "2.4.0" apply false
}

group = "org.crux"
version = "0.7.0"

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