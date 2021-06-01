object Plugins {
    const val android = "com.android.application"
    const val kotlin_android = "kotlin-android"
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
}