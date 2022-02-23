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

    compileOnly("com.markelliot.barista:barista-annotations")
    annotationProcessor("com.markelliot.barista:barista-processor")

    compileOnly("org.immutables:value::annotations")
    annotationProcessor("org.immutables:value")

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
