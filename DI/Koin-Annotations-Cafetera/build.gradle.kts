val koin_version: String by project
val logging_version: String by project
val logback_version: String by project
val ksp_version: String by project
val koin_annotations: String by project


plugins {
    kotlin("jvm") version "1.9.23"
    // Plugin KSP para anotaciones con Koin
    id("com.google.devtools.ksp") version "1.9.23-1.0.20" //"1.8.21-1.0.11"
}

group = "dev.joseluisgs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Koin, con BOM ya se instalan todas las dependencias necesarias con la versión correcta
    implementation(platform("io.insert-koin:koin-bom:$koin_version")) // BOM
    implementation("io.insert-koin:koin-core") // Core
    // Para las anotaciones
    implementation(platform("io.insert-koin:koin-annotations-bom:$koin_annotations")) // BOM
    implementation("io.insert-koin:koin-annotations") // Annotations
    ksp("io.insert-koin:koin-ksp-compiler:$koin_annotations") // KSP Compiler, debes poner el mismo que el de las anotaciones
    // Logger
    implementation("org.lighthousegames:logging:$logging_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    // Test
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

// Solo para anotaciones!!!
// KSP - To use generated sources
// Para usar notaciones de Koin
/*

// Forma A
sourceSets.main {
    java.srcDirs("build/generated/ksp/main/kotlin")
}

// Forma B

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
    sourceSets.test {
        kotlin.srcDir("build/generated/ksp/test/kotlin")
    }
}
*/

