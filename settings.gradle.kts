import org.gradle.api.initialization.resolve.RepositoriesMode

rootProject.name = "YuiPlugin"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        gradlePluginPortal()
        mavenLocal()
        mavenCentral()
        maven("https://maven.whereareiam.me/release")
        maven("https://maven.whereareiam.me/development")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)

    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.whereareiam.me/release")
        maven("https://maven.whereareiam.me/development")
    }
}

include(":yuiplugin-adapter-config")
include(":yuiplugin-common-api")
include(":yuiplugin-bootstrap")
include(":yuiplugin-common")
