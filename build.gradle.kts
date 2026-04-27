plugins {
    base
}

defaultTasks("build", "pluginJar")

tasks.register("pluginJar") {
    group = "build"
    description = "Builds the shaded YuiPlugin runtime jar."

    dependsOn(":yuiplugin-bootstrap:shadowJar")
}
