plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.jetbrainsKotlinSerialization)

}

android {
    namespace = "com.blannonnetwork.mynote"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.blannonnetwork.mynote"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.blannonnetwork.mynote.notes_app_test.HiltTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }

    packaging{
        resources{
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }
}

dependencies {
    testImplementation(libs.junit.junit)
    testImplementation(libs.junit.junit)
    testImplementation(libs.junit.junit)
    testImplementation(libs.junit.junit)
    testImplementation(libs.junit.junit)
    coreLibraryDesugaring(libs.desugar.jdk.libs)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//    firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)

//    RoomDB
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.paging)
    testImplementation(libs.androidx.room.testing)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)

//    Dagger - Hilt
    implementation(libs.dagger.compiler)
    implementation(libs.hilt.android)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)


//    Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

//    Retrofit
    implementation (libs.retrofit)
    implementation (libs.okhttp)
    implementation (libs.converter.gson)
    implementation(libs.logging.interceptor)

//    Coil
    implementation(libs.coil.compose)

//    Extended Icons
    implementation (libs.androidx.material.icons.extended)

//    Navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    // Local Tests
    testImplementation(libs.junit)
    testImplementation(libs.truth)
    testImplementation(libs.androidx.core)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockwebserver)
    testImplementation(libs.mockk)
    debugImplementation(libs.ui.test.manifest)

    // Instrumented Tests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(libs.core.ktx)
    androidTestImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.androidx.runner)
    androidTestImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.truth)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.mockwebserver)
    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.android.compiler)
    androidTestImplementation(platform(libs.androidx.compose.bom))


}