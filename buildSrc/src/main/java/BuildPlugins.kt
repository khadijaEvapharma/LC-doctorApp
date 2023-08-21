object BuildPlugins {

    const val androidGradle = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_VERSION}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val jacocoPlugin = "com.vanniktech:gradle-android-junit-jacoco-plugin:${Versions.JACOCO}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
    const val navigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"

    const val googleServices = "com.google.gms:google-services:${Versions.GOOGLE_SERVICES}"
    const val fbCrashlytics =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.FIREBASE_GRADLE}"
    const val fbPerformance = "com.google.firebase:perf-plugin:${Versions.FIREBASE_PERFORMANCE_GRADLE}"
    const val google_devtools= "com.google.devtools.ksp:${Versions.GOOGLE_DEVTOOLS}" // Depends on your kotlin version


}

