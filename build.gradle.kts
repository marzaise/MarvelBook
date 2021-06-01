buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Android.gradle)
        classpath(Android.kotlin_gradle)
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