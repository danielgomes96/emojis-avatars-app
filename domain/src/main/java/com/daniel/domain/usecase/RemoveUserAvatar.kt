package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface RemoveUserAvatar {
    suspend fun execute(user: User): Flow<Unit>
}
