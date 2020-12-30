package com.daniel.domain.repository

import com.daniel.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserDetails(userName: String): Flow<User>
    suspend fun saveUserAvatar(user: User)
    suspend fun getUserAvatarList(): Flow<List<User>>
    suspend fun removeUserAvatar(user: User): Flow<Unit>
}
