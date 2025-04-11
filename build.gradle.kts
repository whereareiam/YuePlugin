defaultTasks("build", "shadowJar")

allprojects {
    version = (System.getenv("VERSION") ?: "dev")

    apply(plugin = "java")

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_21.toString()
        targetCompatibility = JavaVersion.VERSION_21.toString()
    }
}

subprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }

    if (project.name != "yuemodule-common-api") {
        dependencies {
            "compileOnly"(project(":yuemodule-common-api"))

            "compileOnly"(rootProject.libs.lombok)
            "annotationProcessor"(rootProject.libs.lombok)
        }
    }

    if (project.name != "yue-bootstrap") {
        dependencies {
            "compileOnly"(rootProject.libs.yue)
            "compileOnly"(rootProject.libs.spring.boot)
            "compileOnly"(rootProject.libs.jda)
        }
    }
}