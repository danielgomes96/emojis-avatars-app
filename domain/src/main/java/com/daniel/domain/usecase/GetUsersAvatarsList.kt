package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface GetUsersAvatarsList {
    suspend fun execute(): Flow<List<User>>
}
