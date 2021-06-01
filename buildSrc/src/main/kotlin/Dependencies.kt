object Plugins {
    const val android = "com.android.application"
    const val kotlin_android = "kotlin-android"
    const val kapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"
    const val navigation = "androidx.navigation.safeargs.kotlin"
    const val extensions = "org.jetbrains.kotlin.android.extensions"
}

object Android {
    const val gradle = "com.android.tools.build:gradle:${AndroidxVersion.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${AndroidxVersion.kotlin_version}"
    const val kotlin_gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${AndroidxVersion.kotlin_version}"
    const val androidx_core = "androidx.core:core-ktx:${AndroidxVersion.appCompat}"
    const val appCompat = "androidx.appcompat:appcompat:${AndroidxVersion.appCompat}"
    const val material = "com.google.android.material:material:${AndroidxVersion.material}"
    const val gson = "com.google.code.gson:gson:${AndroidxVersion.gson}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${AndroidxVersion.constraintLayout}"
    const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${AndroidxVersion.lifecycle}"
    const val recyclerview ="androidx.recyclerview:recyclerview:${AndroidxVersion.recyclerView}"
    const val palette ="androidx.palette:palette-ktx:${AndroidxVersion.palette}"
}

object Navigation {
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${NavigationVersions.navigation}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${NavigationVersions.navigation}"
    const val safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${NavigationVersions.navigation}"
}

object Network {
    const val retrofit = "com.squareup.retrofit2:retrofit:${NetworkVersion.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${NetworkVersion.retrofit}"
    const val okHhtp = "com.squareup.okhttp3:logging-interceptor:${NetworkVersion.okhttp}"
}

object Hilt {
    const val hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${HiltVersion.hilt_plugin}"
    const val hilt = "com.google.dagger:hilt-android:${HiltVersion.hilt}"
    const val compiler = "com.google.dagger:hilt-android-compiler:${HiltVersion.hilt}"
    const val lifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${HiltVersion.androidX}"
    const val compiler_androidX = "androidx.hilt:hilt-compiler:${HiltVersion.androidX}"
}

object Coroutines {
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoroutinesVersion.coroutines}"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${CoroutinesVersion.coroutines}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${GlideVersion.glide}"
    const val glide_compiler = "com.github.bumptech.glide:glide:${GlideVersion.glide}"
}