plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}



android {
    namespace = "dev.oianmol.spotifyappremote"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.oianmol.spotifyappremote"
        minSdk = 24
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
}

publishing {
    publications {
        maven(MavenPublication) {
            groupId = "com.github.oianmol"
            artifactId = "dev.oianmol.spotifyappremote"
            version = "0.8.0"
            pom {
                description = "First release"
            }
        }
    }
    repositories {
        mavenLocal()
    }
}