import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.tasks.compile.JavaCompile

plugins {
    `java-library`
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
val buildVersion = providers.environmentVariable("VERSION").orElse("dev")

version = buildVersion.get()

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = JavaVersion.VERSION_25.toString()
    targetCompatibility = JavaVersion.VERSION_25.toString()
}

dependencies {
    add("compileOnly", libs.findLibrary("yui").get())
    add("compileOnly", libs.findLibrary("spring-boot").get())
    add("compileOnly", libs.findLibrary("jda").get())

    add("compileOnly", libs.findLibrary("lombok").get())
    add("annotationProcessor", libs.findLibrary("lombok").get())

    if (path != ":yuiplugin-common-api") {
        add("compileOnly", project(":yuiplugin-common-api"))
    }
}
