plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.apollo)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dagger)
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.example.graphql"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.graphql"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    // This is required to match the Kotlin version 2.0.0
    composeOptions {
        kotlinCompilerExtensionVersion = "2.0.0"
    }
}

apollo {
    service("first time") {
        // 1. This is now a valid Kotlin package name.
        // Your generated classes will be in `com.example.graphql.api`
        packageName.set("com.example.graphql.api")

        introspection {
            endpointUrl = "https://countries.trevorblades.com/" // This is the error
            schemaFile.set("src/main/graphql/kumar/snehil/graphql/scema.sdl")
        }
    }
}

dependencies {
    // Core & Compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Apollo
    implementation(libs.apollo.runtime)

    // Dagger - Hilt
    implementation(libs.dagger.hilt)
    implementation(libs.hilt.compose.navigation)
    kapt(libs.dagger.kapt)

    // Navigation
    implementation(libs.navigation.compose)

    // Serialization
    implementation(libs.kotlinx.serialization)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}