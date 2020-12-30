package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserDetailsImpl(
    private val userRepository: UserRepository
) : GetUserDetails {
    override suspend fun execute(userName: String): Flow<User> =
        userRepository.getUserDetails(userName)
}
