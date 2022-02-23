plugins {
    id("com.palantir.conjure") version "5.20.0"
}

subprojects {
    tasks["spotlessJavaCheck"].enabled = false
}
