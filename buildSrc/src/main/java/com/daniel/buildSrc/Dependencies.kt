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
