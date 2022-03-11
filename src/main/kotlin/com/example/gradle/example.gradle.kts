package com.example.gradle

interface ExampleExtension {
    @get:Input
    val apolloOutputPackageName: Property<String>

    fun build(project: Project): Unit = with(project) {
        // the following line is red in IntelliJ 2021.3.2 w/ Kotlin plugin 213.1.6.10-release961
        configure<com.apollographql.apollo3.gradle.api.ApolloExtension>() {
            service("test") {
                packageNamesFromFilePaths(apolloOutputPackageName.get())
            }
            srcDir("src/test/graphql")
            customTypeMapping.putAll(
                mapOf(
                    "DateTime" to "java.time.Instant",
                    "UUID" to "java.util.UUID"
                )
            )
        }
    }
}

plugins {
    id("com.apollographql.apollo3")
}
