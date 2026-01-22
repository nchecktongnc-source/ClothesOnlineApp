plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.clothesonlineapp"   // ✅ REQUIRED
    compileSdk = 34                              // ✅ REQUIRED

    defaultConfig {
        applicationId = "com.example.clothesonlineapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // 🔥 Firebase BOM
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))

    // 🔥 Firebase Database (THIS WAS MISSING)
    implementation("com.google.firebase:firebase-database-ktx")

    // (Optional – you can remove analytics if not needed)
    implementation("com.google.firebase:firebase-analytics")
}