# Emojis, Users Avatars and Repositories

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.3.72-blue.svg)](https://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/Gradle-6.5-blue?style=flat)](https://gradle.org)

# Project characteristics

This project brings to table set of best practices, tools, and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Clean Architecture (presentation/feature, domain and data layer divided into modules)
* MVVM (Model-View-ViewModel)
* Navigation Component
* [Android Jetpack](https://developer.android.com/jetpack)
* CI pipeline ([GitHub Actions](https://github.com/features/actions))
* Unit Testing
* Dependency Injection
* GIT Flow

# Architecture

I tried to follow the concepts of Clean Architecture, so I divided the project into:

* app module (module which is started when user opens the application. It contains an Application class and a MainActivity which is the navigation host)

* feature-modules (home, emoji_list, repository_list and avatar_list) where these features do not know about each other. It's also known as the presentation layer

* data module (it contains all the necessary code to retrieve data whether it's from local database or Github API and also to map the entities)

* domain module (business logic layer). This module is kotlin pure, so it does not know about android framework. Contains entities and use cases.

* core module (the "lowest" level module, contains classes, extensions and resources used across the modules)

* buildSrc module is where all the dependencies and versions used for the project relies.


