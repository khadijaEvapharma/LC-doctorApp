import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp") version "1.8.0-1.0.9"
    id("com.google.protobuf") version "0.8.19"

}

android {
    namespace = "com.limitlesscare.doctor"
    compileSdk = Android.compileSDK

    defaultConfig {
        applicationId = Android.applicationIdStaging
        minSdk = Android.minSDK
        targetSdk = Android.targetSDK
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    flavorDimensions("mode")
    productFlavors {
        create("live") {
            dimension = "mode"
            buildConfigField(
                "String",
                "BASE_URL",
                providers.gradleProperty("prod_url").orNull ?: ""
            )
        }
        create("pre_prod") {
            applicationId = Android.applicationIdStaging
            dimension = "mode"
            buildConfigField(
                "String",
                "BASE_URL",
                providers.gradleProperty("pre_prod_url").orNull ?: ""
            )
        }
        create("mock") {
            applicationId = Android.applicationIdStaging
            dimension = "mode"
            buildConfigField("String", "BASE_URL", providers.gradleProperty("mock_url").orNull?:"")
        }
        create("development") {
            applicationId = Android.applicationId
            dimension = "mode"
            buildConfigField("String", "BASE_URL", providers.gradleProperty("dev_url").orNull ?: "")
        }
        create("staging") {
            applicationId = Android.applicationId
            dimension = "mode"
            buildConfigField(
                "String",
                "BASE_URL",
                providers.gradleProperty("stage_url").orNull ?: ""
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(mapOf("path" to ":core")))

    implementation(Libs.coreExt)
    implementation(Libs.lifeCycleRunTime)
    //compose
    implementation(Libs.composeActivity)
    implementation(Libs.composeUi)
    implementation(Libs.composeTooling)
    implementation(Libs.composeMaterial)
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltAndroidCompiler)
    implementation (Libs.composeNavigation)
    implementation(Libs.composeViewModel)
    implementation (Libs.hiltNavigation)
    implementation(Libs.compose_destinations)
    ksp("io.github.raamcosta.compose-destinations:ksp:${Versions.COMPOSE_DESTINATION}")

    //room
    implementation(Libs.roomKtx)
    implementation(Libs.roomRunTime)

    //retrofit and gson
    implementation(Libs.gson)
    implementation(Libs.Retrofit2.gsonConverter)
    implementation(Libs.Retrofit2.retrofit)
    implementation(Libs.Retrofit2.loggingInterceptor)
    implementation(Libs.Retrofit2.okhttp)


    //dataStore
    implementation(Libs.dataStorePreference)
    implementation("androidx.datastore:datastore:1.0.0")
    implementation("androidx.datastore:datastore-core:1.0.0")
    implementation("com.google.protobuf:protobuf-java:3.19.1")
//    implementation(Libs.protobuf)

    //firebase
    implementation(Libs.Firebase.messagingKtx)

    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.test_junit)
    androidTestImplementation(TestLibs.espresso)
    androidTestImplementation(Libs.compose_ui_test)
    debugImplementation(Libs.composeTooling)
    debugImplementation(Libs.compose_ui_test_manifest)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.18.0"
    }
//    plugins {
//        id("java") {
//            artifact = "com.google.protobuf:protoc-gen-javalite:1.42.1"
//        }
//    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                id("java")
            }
        }
    }
}