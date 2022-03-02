plugins {
    `java-library`
    `application`
}

dependencies {
    // depend on Conjure-generated code
    implementation(project(":barista-conjure-api:barista-conjure-api-objects"))
    implementation(project(":barista-conjure-api:barista-conjure-api-undertow"))

    // required Conjure runtime elements
    implementation("com.palantir.conjure.java:conjure-java-undertow-runtime")

    implementation("com.markelliot.barista:barista")
    implementation("com.markelliot.barista:barista-conjure")

    testImplementation(platform("org.junit:junit-bom"))
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.assertj:assertj-core")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
