package com.daniel.data.di

import com.daniel.data.repository.EmojiRepositoryImpl
import com.daniel.domain.repository.EmojiRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        EmojiRepositoryImpl(
            get(),
            get()
        ) as EmojiRepository
    }
}
