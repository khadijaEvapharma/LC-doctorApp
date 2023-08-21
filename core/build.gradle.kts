plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("kotlin-parcelize")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.limitlesscare.core"
    compileSdk = Android.compileSDK

    defaultConfig {
        minSdk = Android.minSDK
        targetSdk = Android.targetSDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = true
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
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
}

dependencies {

    implementation(Libs.coreExt)
    implementation(Libs.appCompat)
    implementation(Libs.material)

    //retrofit and gson
    implementation(Libs.gson)
    implementation(Libs.Retrofit2.gsonConverter)
    implementation(Libs.Retrofit2.retrofit)
    implementation(Libs.Retrofit2.loggingInterceptor)

    testImplementation(TestLibs.junit)

    androidTestImplementation(TestLibs.test_junit)
    androidTestImplementation(TestLibs.espresso)

    implementation(Libs.viewModel)

}