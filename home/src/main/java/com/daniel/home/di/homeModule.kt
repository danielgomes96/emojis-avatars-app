package com.daniel.home.di

import com.daniel.domain.usecase.HasCache
import com.daniel.domain.usecase.HasCacheImpl
import com.daniel.domain.usecase.GetEmojiList
import com.daniel.domain.usecase.GetEmojiListImpl
import com.daniel.domain.usecase.GetRandomEmoji
import com.daniel.domain.usecase.GetRandomEmojiImpl
import com.daniel.domain.usecase.SaveEmojiList
import com.daniel.domain.usecase.SaveEmojiListImpl
import com.daniel.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory {
        HasCacheImpl(get()) as HasCache
    }
    factory {
        GetEmojiListImpl(get()) as GetEmojiList
    }
    factory {
        SaveEmojiListImpl(get()) as SaveEmojiList
    }
    factory {
        GetRandomEmojiImpl(get()) as GetRandomEmoji
    }
    viewModel {
        HomeViewModel(get(), get(), get(), get())
    }
}
