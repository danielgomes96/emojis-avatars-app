package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.spyk

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetUserDetailsImplTest {
    private val userRepository: UserRepository = spyk()
    private val useCase: GetUserDetails by lazy {
        GetUserDetailsImpl(userRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `GIVEN username WHEN use case is executed THEN repository should be called`() = runBlocking {
        useCase.execute(FAKE_USERNAME)

        coVerify {
            userRepository.getUserDetails(FAKE_USERNAME)
        }
    }

    @Test
    fun `GIVEN fake user WHEN use case is executed THEN repository should return the correct user`() = runBlocking {
        val userResponse = flow {
            emit(FAKE_USER)
        }
        coEvery {
            userRepository.getUserDetails(FAKE_USERNAME)
        } returns userResponse

        val result = useCase.execute(FAKE_USERNAME)

        assertEquals(result, userResponse)
    }

    companion object {
        private const val FAKE_USERNAME = "daniel"
        private val FAKE_USER = User(
            0,
            "danielgomes96",
            "https://avatars3.githubusercontent.com/u/16447825?v=4"
        )
    }
}
