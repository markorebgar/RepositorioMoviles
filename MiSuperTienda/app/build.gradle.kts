plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mshop2"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.mshop2"
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
    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("com.squareup.retrofit2:retrofit:3.0.0" )
    implementation ("com.squareup.retrofit2:converter-gson:3.0.0" )
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2" )
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.10.0" )
}