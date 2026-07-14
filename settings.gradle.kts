plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "CruxLib"
include("core")
include("annotations")
include("processor")