plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
//    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.miroinvest.testproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.miroinvest.testproject"
        minSdk = 27
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
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.activity)
    implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)



    implementation(libs.hilt.android)
//    kapt(libs.hilt.android.compiler)
    ksp(libs.hilt.android.compiler)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
//    kapt(libs.androidx.lifecycle.compiler)
    ksp(libs.androidx.lifecycle.compiler)
    implementation(libs.androidx.work.runtime.ktx.v2100)


    //used by viewModels
    implementation(libs.androidx.lifecycle.extensions)

    //navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.activity.ktx)


    //work manager
    implementation(libs.work.runtime.ktx)
    implementation(libs.androidx.hilt.work)
    implementation(libs.work.runtime.ktx)
    implementation(libs.androidx.startup.runtime)
    ksp(libs.androidx.hilt.compiler)

    //utilities
    implementation(libs.timber)
    implementation(libs.alerter)
    implementation(libs.circleimageview)
    implementation(libs.ccp)
    implementation(libs.ssp.android)

    // Lottie light weight animation
    implementation(libs.lottie)

    // PIN view
    implementation(libs.pinview)
    // Image Loaders
    implementation(libs.picasso)
    implementation(libs.circleimageview)

    implementation(project(":data"))
}

