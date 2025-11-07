pluginManagement {
    repositories {
        google()
        mavenCentral()
        // This repository hosts the Apollo plugin and was missing
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

rootProject.name = "GraphQl"
include(":app")