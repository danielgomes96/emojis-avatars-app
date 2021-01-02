package com.daniel.data.repository

import Consts.PAGE_SIZE_REPOSITORY_LIST
import com.daniel.data.database.dao.RepositoryDao
import com.daniel.data.dto.RepositoryDTO
import com.daniel.data.mapper.local.RepositoryLocalMapper
import com.daniel.data.service.GithubService
import com.daniel.domain.entity.Repository
import com.daniel.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepoRepositoryImpl(
    private val githubService: GithubService,
    private val repositoryDao: RepositoryDao
) : RepoRepository {

    companion object {
        private const val USERNAME = "google"
    }

    override suspend fun fetchRepositories(currentPage: Int): Flow<List<Repository>> = flow {
        val shouldFetchFromApi = repositoryDao.getRepos(currentPage).isEmpty()
        if (shouldFetchFromApi) {
            saveRepositoryList(githubService.fetchUserRepositories(USERNAME, currentPage, PAGE_SIZE_REPOSITORY_LIST), currentPage)
        }
        emit(
            RepositoryLocalMapper().transform(repositoryDao.getRepos(currentPage))
        )
    }

    private fun saveRepositoryList(
        data: List<RepositoryDTO>,
        currentPage: Int
    ) {
        repositoryDao.insertAll(
            RepositoryLocalMapper().fromRemote(data, currentPage)
        )
    }
}
