package com.daniel.data.di

import com.daniel.data.database.AppDatabase
import com.daniel.data.repository.EmojiRepositoryImpl
import com.daniel.data.repository.RepoRepositoryImpl
import com.daniel.data.repository.UserRepositoryImpl
import com.daniel.domain.repository.EmojiRepository
import com.daniel.domain.repository.RepoRepository
import com.daniel.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        EmojiRepositoryImpl(
            get(),
            get()
        ) as EmojiRepository
    }

    factory {
        UserRepositoryImpl(
            get(),
            get()
        ) as UserRepository
    }

    factory {
        RepoRepositoryImpl(
            get(),
            get<AppDatabase>().repositoryDao()
        ) as RepoRepository
    }
}
