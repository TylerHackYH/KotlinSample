import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.0")
    }
}

plugins {
    kotlin("jvm") version "1.4.32"
    application
    id("com.squareup.sqldelight")
}

group = "api.sample"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation("com.squareup.sqldelight:gradle-plugin:1.5.0")
    implementation("com.squareup.sqldelight:jdbc-driver:1.5.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}

application {
    mainClassName = "MainKt"
}

sqldelight {
    database("Database") { // This will be the name of the generated database class.
        packageName = "com.sample.test"
        dialect = "mysql"
    }
}