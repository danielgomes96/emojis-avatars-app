package com.daniel.domain.usecase

import com.daniel.domain.entity.User

interface SaveUserAvatar {
    suspend fun execute(user: User)
}
