plugins {
    `kotlin-dsl`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.20.0"
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

pluginBundle {
    website = "https://example.com"
    vcsUrl = "https://example.com"
    tags = listOf("private")
}

gradlePlugin {
    plugins {
        create("simplePlugin") {
            id = "com.example.example-plugin"
            displayName = "Example Plugin"
            description = "Example Plugin"
            implementationClass = "com.example.gradle.ExamplePlugin"
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.apollographql.apollo3:apollo-gradle-plugin:3.0.0")

    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
