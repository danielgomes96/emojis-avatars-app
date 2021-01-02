package com.daniel.domain.usecase

import com.daniel.domain.entity.Repository
import kotlinx.coroutines.flow.Flow

interface GetUserRepositories {
    suspend fun execute(currentPage: Int): Flow<List<Repository>>
}
