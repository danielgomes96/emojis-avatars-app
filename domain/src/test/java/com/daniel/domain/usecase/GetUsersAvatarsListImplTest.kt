package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetUsersAvatarsListImplTest {
    private val userRepository: UserRepository = spyk()
    private val useCase: GetUsersAvatarsList by lazy {
        GetUsersAvatarsListImpl(userRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `WHEN use case is executed THEN repository should be called`() = runBlocking {
        useCase.execute()

        coVerify {
            userRepository.getUserAvatarList()
        }
    }

    companion object {
        val FAKE_USER_LIST = listOf(
                User(0, "danielgomes96", "https://avatars3.githubusercontent.com/u/16447825?v=4"),
                User(1, "danielneto96", ""),
                User(2, "danielteste96", ""),
                User(3, "danielsilva96", ""),
                User(4, "daniel96", "")
        )
    }
}
