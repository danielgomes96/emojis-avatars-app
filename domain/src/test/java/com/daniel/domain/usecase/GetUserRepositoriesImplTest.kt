package com.daniel.domain.usecase

import com.daniel.domain.repository.RepoRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetUserRepositoriesImplTest {
    private val repoRepository: RepoRepository = spyk()
    private val useCase: GetUserRepositories by lazy {
        GetUserRepositoriesImpl(repoRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `WHEN use case is executed THEN repository should be called`() = runBlocking {
        useCase.execute(CURRENT_PAGE)

        coVerify {
            repoRepository.fetchRepositories(CURRENT_PAGE)
        }
    }

    private companion object {
        const val CURRENT_PAGE = 20
    }
}
