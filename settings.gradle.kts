plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "CruxLib"
include("annotations")
include("processor")
include("system")
include("game")
include("json")