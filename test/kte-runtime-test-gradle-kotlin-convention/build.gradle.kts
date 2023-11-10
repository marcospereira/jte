
plugins {
    kotlin("jvm") version "1.9.20"
    id("gg.jte.gradle") version("3.1.5-SNAPSHOT")
}

repositories {
    mavenCentral()
    mavenLocal()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.junit.jupiter:junit-jupiter:5.9.2")
    implementation("gg.jte:jte-runtime:3.1.5-SNAPSHOT")
}

jte {
    precompile()
    kotlinCompileArgs.set(arrayOf("-jvm-target", "17"))
}

tasks.jar {
    dependsOn(tasks.precompileJte)
    from(fileTree("jte-classes") {
        include("**/*.class")
    })
}

// See docs here:
// https://docs.gradle.org/8.4/userguide/toolchains.html#sec:consuming
// According to Kotlin Gradle Plugin docs:
// https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
// > You can set a toolchain via the java extension, and Kotlin compilation tasks will use it
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(System.getProperty("gradle.matrix.java_version", "17").toInt()))
    }
}
