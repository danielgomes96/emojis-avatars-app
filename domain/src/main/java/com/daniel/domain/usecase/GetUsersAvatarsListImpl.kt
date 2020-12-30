package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUsersAvatarsListImpl(
    private val userRepository: UserRepository
) : GetUsersAvatarsList {
    override suspend fun execute(): Flow<List<User>> = userRepository.getUserAvatarList()
}
