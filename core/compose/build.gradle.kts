@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

kotlin {
    jvmToolchain(libs.versions.java.get().toInt())
}

android {
    namespace = "com.aldolyna.mvikotlincompose.compose"
    compileSdk = libs.versions.android.api.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.api.min.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(libs.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
