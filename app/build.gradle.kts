import org.gradle.kotlin.dsl.implementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services") // Required for Firebase
}

android {
    namespace = "com.example.newapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.newapp"
        minSdk = 24
        targetSdk = 35
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

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13" // Match Compose version
    }
}

dependencies {
    val nav_version = "2.9.0"

    // Jetpack Navigation for Compose
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Compose Core & Material
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Explicit Compose Compiler for Kotlin 2.0+
    implementation(libs.androidx.compose.compiler)

    // Firebase BOM - version 33.15.0 (newest as of mid-2025)
    implementation(platform("com.google.firebase:firebase-bom:33.15.0"))

    // Firebase Auth (required for FirebaseApp.initializeApp + authentication)
    implementation("com.google.firebase:firebase-auth-ktx")

    // Optional: Firebase Analytics or other modules
    // implementation("com.google.firebase:firebase-analytics-ktx")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debug Tools
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
