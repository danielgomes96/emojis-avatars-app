package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class RemoveUserAvatarImpl(
    private val userRepository: UserRepository
) : RemoveUserAvatar {
    override suspend fun execute(user: User): Flow<Unit> =
            userRepository.removeUserAvatar(user)
}
