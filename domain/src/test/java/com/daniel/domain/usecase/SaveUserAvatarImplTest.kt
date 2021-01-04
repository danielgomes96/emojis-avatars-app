package com.daniel.domain.usecase

import com.daniel.domain.entity.User
import com.daniel.domain.repository.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SaveUserAvatarImplTest {
    private val userRepository: UserRepository = spyk()
    private val useCase: SaveUserAvatar by lazy {
        SaveUserAvatarImpl(userRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `GIVEN an user WHEN use case is executed THEN repository should be called`() = runBlocking {
        useCase.execute(FAKE_USER)

        coVerify(exactly = 1) {
            userRepository.saveUserAvatar(FAKE_USER)
        }
    }

    companion object {
        private val FAKE_USER = User(
            0,
            "danielgomes96",
            "https://avatars3.githubusercontent.com/u/16447825?v=4"
        )
    }
}
