package com.daniel.data.di

import androidx.room.Room
import com.daniel.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        get<AppDatabase>().emojisDao()
    }

    single {
        get<AppDatabase>().usersDao()
    }

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app-database")
            .build()
    }
}
