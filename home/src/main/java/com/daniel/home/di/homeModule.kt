package com.daniel.home.di

import com.daniel.domain.usecase.GetEmojiListUseCase
import com.daniel.domain.usecase.GetEmojiListUseCaseImpl
import com.daniel.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory {
        GetEmojiListUseCaseImpl(get()) as GetEmojiListUseCase
    }
    viewModel {
        HomeViewModel(get())
    }
}
