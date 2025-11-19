plugins {
    application
}
repositories { mavenCentral() }

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}
tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "com.mirachen.fincore.app.Main"
}
