buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Android.gradle)
        classpath(Android.kotlin_gradle)
        classpath(Hilt.hilt_plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}