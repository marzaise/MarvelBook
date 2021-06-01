plugins {
    id(Plugins.android)
    id(Plugins.kotlin_android)
    id(Plugins.kapt)
    id(Plugins.hilt)
}

android {
    compileSdkVersion(SdkVersions.compile_sdk)
    buildToolsVersion(SdkVersions.build_tools)

    defaultConfig {
        applicationId(ApplicationId.id)
        minSdkVersion(SdkVersions.min_sdk)
        targetSdkVersion(SdkVersions.target_sdk)
        versionCode(SdkVersions.version_code)
        versionName(SdkVersions.version_name)

        buildConfigField("String", "API_URL", "\"http://developer.marvel.com\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(Android.kotlin)
    implementation(Android.androidx_core)
    implementation(Android.appCompat)
    implementation(Android.material)
    implementation(Android.constraintLayout)
    implementation(Android.lifecycle)
    implementation(Android.recyclerview)
    implementation(Android.gson)

    implementation(Navigation.navigation_fragment)
    implementation(Navigation.navigation_ui)

    implementation(Network.retrofit)
    implementation(Network.gson)
    implementation(Network.okHhtp)

    implementation(Hilt.hilt)
    kapt(Hilt.compiler)
    implementation(Hilt.lifecycle)
    kapt(Hilt.compiler_androidX)
}