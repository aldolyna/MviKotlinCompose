pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MviKotlinCompose"

include(
    ":app",
    ":core:common",
    ":core:mvi",
    ":core:ui"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
