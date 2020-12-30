package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface GetUserDetails {
    suspend fun execute(userName: String): Flow<User>
}
