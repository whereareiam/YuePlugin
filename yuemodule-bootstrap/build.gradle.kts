import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    alias(libs.plugins.shadow)
}

tasks.withType<ShadowJar> {
    archiveBaseName.set(rootProject.name)
    archiveClassifier.set("")

    destinationDirectory.set(rootProject.layout.buildDirectory.dir("libs"))
}