package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RemoveUserAvatarImplTest {
    private val userRepository: UserRepository = spyk()
    private val useCase: RemoveUserAvatar by lazy {
        RemoveUserAvatarImpl(userRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `WHEN use case is executed THEN repository should be called`() = runBlocking {
        useCase.execute(FAKE_USER)

        coVerify {
            userRepository.removeUserAvatar(FAKE_USER)
        }
    }

    private companion object {
        val FAKE_USER = User(0, "danielgomes96", "")
    }
}
