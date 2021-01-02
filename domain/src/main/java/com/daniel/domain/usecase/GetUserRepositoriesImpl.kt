package com.daniel.domain.usecase

import com.daniel.domain.entity.Repository
import com.daniel.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow

class GetUserRepositoriesImpl(
    private val repoRepository: RepoRepository
) : GetUserRepositories {
    override suspend fun execute(currentPage: Int): Flow<List<Repository>> {
        return repoRepository.fetchRepositories(currentPage)
    }
}
