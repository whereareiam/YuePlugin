import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("yuiplugin.java-common")
    id("com.gradleup.shadow")
}

tasks.withType<ShadowJar>().configureEach {
    archiveBaseName.set(rootProject.name)
    archiveClassifier.set("")

    val defaultDestination = rootProject.layout.buildDirectory.dir("libs")

    val customOutputDir = if (project.hasProperty("output")) {
        project.layout.dir(project.provider { file(project.property("output").toString()) })
    } else {
        null
    }

    destinationDirectory.set(customOutputDir ?: defaultDestination)
}

dependencies {
    rootProject.subprojects
        .filter { it.path != ":yuiplugin-bootstrap" }
        .forEach { subproject ->
            add("implementation", project(subproject.path))
        }
}
