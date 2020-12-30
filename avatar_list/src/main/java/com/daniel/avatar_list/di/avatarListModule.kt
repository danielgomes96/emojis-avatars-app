package com.daniel.avatar_list.di

import com.daniel.avatar_list.AvatarListViewModel
import com.daniel.domain.usecase.GetUsersAvatarsList
import com.daniel.domain.usecase.GetUsersAvatarsListImpl
import com.daniel.domain.usecase.RemoveUserAvatar
import com.daniel.domain.usecase.RemoveUserAvatarImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val avatarListModule = module {
    factory {
        GetUsersAvatarsListImpl(get()) as GetUsersAvatarsList
    }
    factory {
        RemoveUserAvatarImpl(get()) as RemoveUserAvatar
    }
    viewModel {
        AvatarListViewModel(get(), get())
    }
}
