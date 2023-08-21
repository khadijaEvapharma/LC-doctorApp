object Libs {
    const val material = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val gson = "com.google.code.gson:gson:${Versions.GSON_VERSION}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val liveData =
        "androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.LIFE_CYCLE_VERSION}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFE_CYCLE_VERSION}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val coreExt = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val multidex = "androidx.multidex:multidex:${Versions.MULTIDEX}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:${Versions.HILT}"
    const val hiltNavigation="androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAV}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"

    object Retrofit2 {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_LOGGING_INTERCEPTOR_VERSION}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.GSON_CONVERTER}"
        const val  okhttp = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP_VESION}"

    }

    const val googleMap = "com.google.android.gms:play-services-maps:${Versions.GOOGLE_MAP}"
    const val locationServices =
        "com.google.android.gms:play-services-location:${Versions.LOCATION_SERVICES}"
    const val timber = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val permissionsDispatcher =
        "com.github.permissions-dispatcher:permissionsdispatcher:${Versions.PERMISSION_DISPATCHER}"
    const val permissionsDispatcherProcessor =
        "com.github.permissions-dispatcher:permissionsdispatcher-processor:${Versions.PERMISSION_DISPATCHER}"
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH}"
    const val circleImage = "de.hdodenhof:circleimageview:${Versions.CIRCLE_IMAGE}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val kaptGlide = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.RETROFIT_COROUTINES_ADAPTER}"
    const val timeFormater = "org.ocpsoft.prettytime:prettytime:${Versions.TIME_FORMATER}"
    const val materialFavouriteButton =
        "com.github.ivbaranov:materialfavoritebutton:${Versions.MATERIAL_FAVOURITE_BUTTON}"


    const val roomRunTime = "androidx.room:room-runtime:${Versions.ROOM}"
    const val kaptRoom = "androidx.room:room-compiler:${Versions.ROOM}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.ROOM}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val navigationKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"

    const val composeFoundation = "androidx.compose.foundation:foundation:1.3.1"
    const val composeUi = "androidx.compose.ui:ui-util:${Versions.COMPOSE_UI}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_UI}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_UI}"
    const val composeConstrainLayout =
        "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    const val composeNavigation= "androidx.navigation:navigation-compose:${Versions.NAVIGATION}"
    const val composeViewBinding = "androidx.compose.ui:ui-viewbinding:1.4.0"
    const val composeMaterial = "androidx.compose.material:material:${Versions.COMPOSE_MATERIAL}"
    const val composeMaterialRipple =
        "androidx.compose.material:material-ripple:1.3.1"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:1.3.3"
    const val composeCoil = "io.coil-kt:coil-compose:2.0.0-rc03"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1"
    const val composeSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:0.17.0"
    const val accompanistCoil = "com.google.accompanist:accompanist-coil:0.7.0"
    const val accompanistPermissions = "com.google.accompanist:accompanist-permissions:0.24.6-alpha"
    const val compose_pager = "com.google.accompanist:accompanist-pager:0.14.0"
    const val compose_indicators = "com.google.accompanist:accompanist-pager-indicators:0.14.0"
    const val compose_swipeRefresh = "com.google.accompanist:accompanist-swiperefresh:0.19.0"
    const val accompanistFlowLayout = "com.google.accompanist:accompanist-flowlayout:0.24.9-beta"
    const val compose_ui_test = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE_UI}"
    const val compose_ui_test_manifest =
        "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE_UI}"

    const val compose_destinations="io.github.raamcosta.compose-destinations:core:${Versions.COMPOSE_DESTINATION}"
    object Firebase {
        const val boom = "com.google.firebase:firebase-bom:${Versions.FIREBASE_BOM}"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
        const val performance = "com.google.firebase:firebase-perf-ktx"
        const val dynamicLinks = "com.google.firebase:firebase-dynamic-links-ktx"
        const val messagingKtx =
            "com.google.firebase:firebase-messaging-ktx:${Versions.FIREBASE_MESSAGING}"


    }



    const val chuckDebug = "com.github.chuckerteam.chucker:library:${Versions.CHUNK}"
    const val chuckRelease =
        "com.github.chuckerteam.chucker:library-no-op:${Versions.CHUNK}"


    const val Lottie = "com.airbnb.android:lottie-compose:4.0.0"

    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KTX_COROUTINE}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KTX_COROUTINE}"


    const val exoplayer = "com.google.android.exoplayer:exoplayer:2.17.1"
    const val exoplayerCore = "com.google.android.exoplayer:exoplayer-core:2.17.1"
    const val exoplayerUi = "com.google.android.exoplayer:exoplayer-ui:2.11.8"
    const val exoplayerMediaSession = "com.google.android.exoplayer:extension-mediasession:2.17.1"

    const val lifeCycleRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    const val dataStorePreference =
        "androidx.datastore:datastore-preferences:${Versions.DATA_STORE_PREF}"
    const val protobuf="com.google.protobuf:protobuf-javalite:${Versions.PROTOBUF}"

}