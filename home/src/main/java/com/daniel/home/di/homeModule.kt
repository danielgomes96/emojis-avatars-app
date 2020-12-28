package com.daniel.home.di

import com.daniel.domain.usecase.*
import com.daniel.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
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
        HomeViewModel(get(), get(), get())
    }
}
