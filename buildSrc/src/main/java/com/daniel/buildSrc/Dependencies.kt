package com.daniel.buildSrc

/**
 * File that contains all the dependencies used for this project.
 */

object Dependencies {

    object Core {
        const val appcompat: String = "androidx.appcompat:appcompat:" + Versions.app_compat

        const val core_ktx: String = "androidx.core:core-ktx:" + Versions.core_ktx

        const val kotlin_stdlib_jdk8: String =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk8:" + Versions.kotlin
    }

    object Tool {
        const val gradle: String = "com.android.tools.build:gradle:" + Versions.gradle

        const val gradle_kotlin_plugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" + Versions.kotlin

        const val ktlint: String = "com.pinterest:ktlint:" + Versions.ktlint
    }

    object UI {
        const val constraint_layout: String = "androidx.constraintlayout:constraintlayout:" +
                Versions.constraint_layout

        const val material: String = "com.google.android.material:material:" + Versions.material
    }

    object Test {
        const val junit: String = "junit:junit:" + Versions.junit

        const val espresso: String = "androidx.test.espresso:espresso-core:" + Versions.espresso
    }
}
