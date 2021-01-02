package com.daniel.repository_list.di

import com.daniel.domain.usecase.GetUserRepositories
import com.daniel.domain.usecase.GetUserRepositoriesImpl
import com.daniel.repository_list.RepositoryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryListModule = module {
    factory {
        GetUserRepositoriesImpl(get()) as GetUserRepositories
    }
    viewModel {
        RepositoryListViewModel(get())
    }
}
