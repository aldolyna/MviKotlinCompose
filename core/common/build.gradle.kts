@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

kotlin {
    jvmToolchain(libs.versions.java.get().toInt())
}

android {
    namespace = "com.aldolyna.mvikotlincompose.ui"
    compileSdk = libs.versions.android.api.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.api.min.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packaging {
        resources {
            excludes += "/META-INF/**"
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
}