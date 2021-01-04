package com.daniel.data.repository

import com.daniel.data.database.dao.RepositoryDao
import com.daniel.data.database.entity.RepositoryLocal
import com.daniel.data.dto.RepositoryDTO
import com.daniel.data.service.GithubService
import com.daniel.domain.entity.Repository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RepoRepositoryImplTest {
    @MockK
    internal lateinit var mockService: GithubService

    @MockK
    internal lateinit var repositoryDao: RepositoryDao

    private lateinit var repoRepositoryImpl: RepoRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repoRepositoryImpl = RepoRepositoryImpl(mockService, repositoryDao)
    }

    private companion object {
        const val USERNAME = "google"
        const val CURRENT_PAGE = 1
        const val PAGE_SIZE = 10
        val REPOSITORY_DTO_LIST = listOf<RepositoryDTO>(
            RepositoryDTO(0, ""),
            RepositoryDTO(0, "")
        )
        val REPOSITORY_LOCAL_LIST = listOf<RepositoryLocal>(
            RepositoryLocal(0, 0, ""),
            RepositoryLocal(0, 0, "")
        )
        val REPOSITORY_LIST = listOf<Repository>(
            Repository(0, ""),
            Repository(0, "")
        )
    }

    @Test
    fun `GIVEN an repository list response WHEN  is called THEN maps to Domain`() {
        // given
        coEvery {
            repositoryDao.getRepos(CURRENT_PAGE)
        } returns REPOSITORY_LOCAL_LIST

        coEvery {
            mockService.fetchUserRepositories(USERNAME, CURRENT_PAGE, PAGE_SIZE)
        } returns REPOSITORY_DTO_LIST

        // when
        val result = runBlocking { repoRepositoryImpl.fetchRepositories(CURRENT_PAGE).first() }

        runBlocking {
            val repositoryFlow = flow {
                emit(REPOSITORY_LIST)
            }.first()

            // then
            Assert.assertEquals(result, repositoryFlow)
        }
    }
}
