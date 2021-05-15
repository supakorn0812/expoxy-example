object ApplicationId {
    const val id = "com.lotuss.oneapp"
}

object Plugins {
    const val ktlint = "org.jlleitschuh.gradle.ktlint"
}

object Modules {
    const val app = ":app"
    const val data = ":data"
    const val domain = ":domain"
    const val analytics = ":analytics"
    const val navigation = ":navigation"
    const val commonUi = ":common-ui"
    const val commonRes = ":common-res"
    const val commonTest = ":common-test"
    const val commonEpoxy = ":common-epoxy"
    const val featureBoarding = ":features:boarding"
    const val featureHome = ":features:home"
    const val featureRegistration = ":features:registration"
    const val featureLogin = ":features:login"
    const val featureCoupon = ":features:coupon"
    const val featureVerify = ":features:verify"
    const val featurePromotion = ":features:promotion"
    const val featureProfile = ":features:profile"
    const val featureMyRewards = ":features:rewards"
    const val featureHost = ":features:host"
    const val featureBasket = ":features:basket"
    const val featureShopping = ":features:shopping"
    const val featureSearch = ":features:search"
    const val featureProductDetails = ":features:productdetails"
    const val featureMediaGallery = ":features:mediagallery"
    const val featureAddress = ":features:address"
    const val featureDeliveryType = ":features:deliverytype"
    const val featureClickAndCollect = ":features:clickandcollect"
    const val featureHomeScreen = ":features:homescreen"
    const val featureInbox = ":features:inbox"
    const val featureDeliverySlot = ":features:deliveryslot"
}

object Releases {
    val versionCode = System.getenv("BUILD_NUMBER")?.toIntOrNull() ?: 1
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 30
}

object Versions {
    const val androidGradle = "4.1.3"
    const val kotlin = "1.4.21"
    const val google = "4.3.3"
    const val material = "1.2.0"
    const val coroutines = "1.4.2"
    const val okhttp = "4.9.0"
    const val retrofit = "2.9.0"
    const val room = "2.2.6"
    const val preference = "1.1.1"
    const val koin = "2.2.2"
    const val appStartup = "1.0.0"
    const val navigation = "2.3.3"
    const val fragment = "1.2.5"
    const val lifecycle = "2.2.0"
    const val appcompat = "1.2.0"
    const val recyclerview = "1.1.0"
    const val constraintLayout = "2.0.4"
    const val coreKtx = "1.3.2"
    const val chucker = "3.4.0"
    const val coil = "1.1.1"
    const val junit = "1.1.0"
    const val robolectric = "4.4"
    const val mockK = "1.9.3"
    const val test = "1.2.0"
    const val archCore = "2.1.0"
    const val pageIndicator = "1.0.3"
    const val epoxy = "4.5.0"
    const val biometric = "1.0.1"
    const val jacoco = "0.8.5"
    const val zxing = "3.4.0"
    const val swiperefreshlayout = "1.f1.0"
    const val cognito = "2.18.0"
    const val shimmer = "0.5.0"
    const val photoview = "2.3.0"
    const val firebaseBom = "26.3.0"
    const val firebaseCrashlyticsGradle = "2.4.1"
    const val jwtdecode = "2.0.0"
    const val leanplum = "5.5.0"
    const val rootbeer = "0.0.8"
    const val gmsAuthAPIPhone = "17.4.0"
    const val servicesLocation = "18.0.0"
    const val servicesMap = "17.0.0"
    const val mapUtils = "2.2.3"
    const val facebookCore = "9.1.0"
    const val browser = "1.3.0"
    const val swipeView = "1.1.4"
    const val ktlint = "10.0.0"
    const val circleIndicator = "2.1.6"
    const val badgeCount = "1.1.0"
}

object Deps {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val koinGradlePlugin = "org.koin:koin-gradle-plugin:${Versions.koin}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinExtensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"
    const val googleServices = "com.google.gms:google-services:${Versions.google}"
    const val jacoco = "org.jacoco:org.jacoco.core:${Versions.jacoco}"

    // di
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // navigation
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationSafeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"

    // ui
    const val appStartup = "androidx.startup:startup-runtime:${Versions.appStartup}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val fragment = "androidx.fragment:fragment:${Versions.fragment}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val coilGif = "io.coil-kt:coil-gif:${Versions.coil}"
    const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
    const val epoxyPaging3 = "com.airbnb.android:epoxy-paging3:${Versions.epoxy}"
    const val epoxyProcessor = "com.airbnb.android:epoxy-processor:${Versions.epoxy}"
    const val epoxyDataBinding = "com.airbnb.android:epoxy-databinding:${Versions.epoxy}"
    const val pageIndicator = "com.romandanylyk:pageindicatorview:${Versions.pageIndicator}"
    const val swiperefreshlayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
    const val photoView = "com.github.chrisbanes:PhotoView:${Versions.photoview}"
    const val swipeView = "com.github.anzaizai:EasySwipeMenuLayout:${Versions.swipeView}"

    // data
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val preference = "androidx.preference:preference:${Versions.preference}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // log
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    //biometric
    const val biometric = "androidx.biometric:biometric:${Versions.biometric}"

    //amplify
    const val cognito = "com.amazonaws:aws-android-sdk-cognitoidentityprovider:${Versions.cognito}"

    //xzing
    const val zxing = "com.google.zxing:core:${Versions.zxing}"

    //firebase
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseCrashlyticsGradle =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlyticsGradle}"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging-ktx"

    //Jwt Decode
    const val jwtdecode = "com.auth0.android:jwtdecode:${Versions.jwtdecode}"

    //leanplum
    const val leanplumCore = "com.leanplum:leanplum-core:${Versions.leanplum}"
    const val leanplumFcm = "com.leanplum:leanplum-fcm:${Versions.leanplum}"

    //root
    const val rootBeer = "com.scottyab:rootbeer-lib:${Versions.rootbeer}"

    //Sms Verification
    const val gmsAuthAPIPhone =
        "com.google.android.gms:play-services-auth-api-phone:${Versions.gmsAuthAPIPhone}"

    //location
    const val serviceLocation =
        "com.google.android.gms:play-services-location:${Versions.servicesLocation}"
    const val serviceMaps = "com.google.android.gms:play-services-maps:${Versions.servicesMap}"

    const val mapUtils = "com.google.maps.android:android-maps-utils:${Versions.mapUtils}"

    //Facebook
    const val facebookCore = "com.facebook.android:facebook-core:${Versions.facebookCore}"

    //Facebook
    const val browser = "androidx.browser:browser:${Versions.browser}"

    //Facebook applink
    const val facebookAppLink = "com.facebook.android:facebook-applinks:${Versions.facebookCore}"

    // KTLint Dependency
    const val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktlint}"

    const val circleIndicator = "me.relex:circleindicator:${Versions.circleIndicator}"

    //BadgeCount
    const val badgeCount = "com.github.nikartm:image-support:${Versions.badgeCount}"


}

object TestDeps {
    const val testCore = "androidx.test:core:${Versions.test}"
    const val testRunner = "androidx.test:runner:${Versions.test}"
    const val testRules = "androidx.test:rules:${Versions.test}"
    const val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCore}"
    const val roomTesting = "androidx.room:room-testing:${Versions.room}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val mockk = "io.mockk:mockk:${Versions.mockK}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockK}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    const val koin = "org.koin:koin-test:${Versions.koin}"
}