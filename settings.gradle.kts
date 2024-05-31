pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "cleanarch"
include(":app")
include(":domain:api")
include(":domain:impl")
include(":presentation:splash")
include(":presentation:auth")
include(":presentation:general")
include(":presentation:home")
include(":presentation:settings")
include(":common:core")
include(":common:navigation:api")
include(":common:navigation:impl")
include(":data")
