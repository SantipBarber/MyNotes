val ktor_version: String by rootProject.project
val logback_version: String by rootProject.project

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
    id("com.android.library")
}

group = "com.spbarber"
version = "1.0-SNAPSHOT"


kotlin {
    android() {
        publishLibraryVariants("release", "debug")
    }


    jvm("desktop") {
        jvmToolchain(11)
    }

    js(IR) {
        browser()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(compose.materialIconsExtended)

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
                implementation("io.ktor:ktor-client-core:${ktor_version}")
                implementation("io.ktor:ktor-client-logging:$ktor_version")
                implementation("ch.qos.logback:logback-classic:$logback_version")
                implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
            }
        }
        val commonTest by getting

        val commonComposeKmpMain by creating {
            dependsOn(commonMain)
        }

        val desktopMain by getting {
            dependsOn(commonComposeKmpMain)
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(compose.foundation)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.7.3")
                implementation("io.ktor:ktor-client-okhttp:${ktor_version}")
            }
        }
        val desktopTest by getting

        val androidMain by getting {
            dependsOn(commonComposeKmpMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
                implementation("io.ktor:ktor-client-okhttp:${ktor_version}")
            }
        }

        val androidTest by getting

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                implementation("io.ktor:ktor-client-js:$ktor_version")
            }
        }
        val jsTest by getting
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        compileSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
