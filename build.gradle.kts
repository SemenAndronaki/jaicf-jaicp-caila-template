plugins {
    application
    kotlin("jvm") version "1.3.61"
}

group = "com.justai.jaicf"
version = "1.0.0"

val jaicf = "0.8.0"
val logback = "1.2.3"
val ktor = "1.3.1"

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.justai.jaicf:jaicp-build-plugin:0.1.0")
    }
}
apply(plugin = "com.justai.jaicf.jaicp-build-plugin")

// Main class to run application in JAICP Cloud.
application {
    mainClassName = "com.justai.jaicf.template.connections.JaicpServerKt"
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("ch.qos.logback:logback-classic:$logback")

    implementation("com.justai.jaicf:core:$jaicf")
    implementation("com.justai.jaicf:mongo:$jaicf")
    implementation("com.justai.jaicf:jaicp:$jaicf")
    implementation("com.justai.jaicf:caila:$jaicf")

    implementation("io.ktor:ktor-server-netty:$ktor")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.withType<com.justai.jaicf.plugins.jaicp.build.JaicpBuild> {
    mainClassName.set(application.mainClassName)
}