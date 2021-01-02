package com.daniel.domain.repository

import com.daniel.domain.entity.Repository
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun fetchRepositories(currentPage: Int): Flow<List<Repository>>
}
