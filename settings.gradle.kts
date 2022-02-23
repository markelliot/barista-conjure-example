rootProject.name = "barista-conjure-example-root"

include("barista-conjure-api")
include("barista-conjure-api:barista-conjure-api-objects")
include("barista-conjure-api:barista-conjure-api-undertow")
include("barista-conjure-example")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.palantir.conjure") {
                useModule("com.palantir.gradle.conjure:gradle-conjure:${requested.version}")
            }
        }
    }
}
