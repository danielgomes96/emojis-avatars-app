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

        const val navigation_fragment: String =
            "androidx.navigation:navigation-fragment-ktx:" + Versions.navigation

        const val navigation_ui: String =
            "androidx.navigation:navigation-ui-ktx:" + Versions.navigation

        const val navigation_dynamic_features: String =
            "androidx.navigation:navigation-dynamic-features-fragment:" + Versions.navigation

        const val lifecycle_common_java8: String =
                "androidx.lifecycle:lifecycle-common-java8:" + Versions.lifecycle

        const val lifecycle_runtime: String =
                "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.lifecycle

        const val lifecycle_viewmodel: String =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.lifecycle

        const val lifecycle_livedata: String =
                "androidx.lifecycle:lifecycle-livedata-ktx:" + Versions.lifecycle

        const val kotlin_coroutines_core: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:" + Versions.kotlin_coroutines

        const val kotlin_coroutines_android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.kotlin_coroutines
    }

    object Data {
        const val retrofit: String = "com.squareup.retrofit2:retrofit:" + Versions.retrofit

        const val converter_gson: String = "com.squareup.retrofit2:converter-gson:" +
                Versions.converter_gson

        const val okhttp: String = "com.squareup.okhttp3:okhttp:" + Versions.okhttp

        const val logging_interceptor: String = "com.squareup.okhttp3:logging-interceptor:" +
                Versions.okhttp

        const val room = "androidx.room:room-runtime:" + Versions.room

        const val room_ktx = "androidx.room:room-ktx:" + Versions.room

        const val room_compiler = "androidx.room:room-compiler:" + Versions.room
    }

    object DI {
        /**
         * https://github.com/InsertKoinIO/koin
         */
        const val koin: String = "org.koin:koin-android:" + Versions.koin

        const val koin_core: String = "org.koin:koin-core:" + Versions.koin

        const val koin_view_model: String = "org.koin:koin-androidx-viewmodel:" + Versions.koin
    }

    object Tool {
        const val gradle: String = "com.android.tools.build:gradle:" + Versions.gradle

        const val gradle_kotlin_plugin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:" + Versions.kotlin

        const val ktlint: String = "com.pinterest:ktlint:" + Versions.ktlint

        const val navigation_gradle_plugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:" + Versions.navigation
    }

    object UI {
        const val constraint_layout: String = "androidx.constraintlayout:constraintlayout:" +
                Versions.constraint_layout

        const val material: String = "com.google.android.material:material:" + Versions.material

        const val glide: String =
            "com.github.bumptech.glide:glide:" + Versions.glide

        const val glide_compiler: String = "com.github.bumptech.glide:compiler:" + Versions.glide

        const val swipe_to_refresh: String =
            "androidx.swiperefreshlayout:swiperefreshlayout:" + Versions.swipe_to_refresh
    }

    object Test {
        const val junit: String = "junit:junit:" + Versions.junit

        const val mockk: String = "io.mockk:mockk:" + Versions.mockk

        const val mockwebserver: String =
                "com.squareup.okhttp3:mockwebserver:" + Versions.mockwebserver

        const val espresso: String = "androidx.test.espresso:espresso-core:" + Versions.espresso
    }
}
