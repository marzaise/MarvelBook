plugins {
    id(Plugins.android)
    id(Plugins.kotlin_android)
    id(Plugins.kapt)
    id(Plugins.hilt)
    id(Plugins.navigation)
    id(Plugins.extensions)
}

android {
    compileSdkVersion(SdkVersions.compile_sdk)
    buildToolsVersion(SdkVersions.build_tools)

    buildFeatures {
        dataBinding = true
    }

    androidExtensions {
        isExperimental = true
    }

    defaultConfig {
        applicationId(ApplicationId.id)
        minSdkVersion(SdkVersions.min_sdk)
        targetSdkVersion(SdkVersions.target_sdk)
        versionCode(SdkVersions.version_code)
        versionName(SdkVersions.version_name)

        buildConfigField("String", "API_URL", "\"https://gateway.marvel.com:443/v1/public/\"")
        buildConfigField("String", "PUBLIC_KEY", "\"2bfd78abf2c178541244193d2d79b57f\"")
        buildConfigField("String", "PRIVATE_KEY", "\"8b2cd16e58999b4a42e495b669c089b9767ebd7d\"")

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
    implementation(Android.palette)

    implementation(Navigation.navigation_fragment)
    implementation(Navigation.navigation_ui)

    implementation(Network.retrofit)
    implementation(Network.gson)
    implementation(Network.okHhtp)

    implementation(Hilt.hilt)
    kapt(Hilt.compiler)
    implementation(Hilt.lifecycle)
    kapt(Hilt.compiler_androidX)

    implementation(Coroutines.coroutines)

    implementation(Glide.glide)
    kapt(Glide.glide_compiler)
}