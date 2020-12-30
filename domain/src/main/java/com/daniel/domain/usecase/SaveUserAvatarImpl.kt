package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository

class SaveUserAvatarImpl(
    private val userRepository: UserRepository
) : SaveUserAvatar {
    override suspend fun execute(user: User) = userRepository.saveUserAvatar(user)
}
