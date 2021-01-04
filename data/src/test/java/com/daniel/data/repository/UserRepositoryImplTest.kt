package com.daniel.data.repository

import com.daniel.data.database.dao.UsersDao
import com.daniel.data.database.entity.UserLocal
import com.daniel.data.dto.UserDTO
import com.daniel.data.service.GithubService
import com.daniel.domain.entity.User
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UserRepositoryImplTest {
    @MockK
    internal lateinit var mockService: GithubService

    @MockK
    internal lateinit var usersDao: UsersDao

    private lateinit var userRepository: UserRepositoryImpl

    private companion object {
        const val USERNAME = "danielgomes96"
        val FAKE_USER_DTO = UserDTO(0, "danielgomes96", "")
        val FAKE_USER = User(0, "danielgomes96", "")
        val FAKE_USER_LOCAL_LIST = listOf<UserLocal>(
                UserLocal(0, "danielgomes96", "https://avatars3.githubusercontent.com/u/16447825?v=4"),
                UserLocal(1, "danielneto96", "https://avatars3.githubusercontent.com/u/16447825?v=4")
        )
        val FAKE_USER_LIST = listOf<User>(
                User(0, "danielgomes96", "https://avatars3.githubusercontent.com/u/16447825?v=4"),
                User(1, "danielneto96", "https://avatars3.githubusercontent.com/u/16447825?v=4")
        )
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        userRepository = UserRepositoryImpl(mockService, usersDao)
    }

    @Test
    fun `GIVEN username WHEN getUserDetails is called THEN maps to Domain`() {
        // given
        coEvery {
            mockService.getUserDetails(USERNAME)
        } returns FAKE_USER_DTO

        // when
        val result = runBlocking { userRepository.getUserDetails(USERNAME).first() }

        runBlocking {
            val userFlow = flow {
                emit(FAKE_USER)
            }.first()

            // then
            assertEquals(result, userFlow)
        }
    }

    @Test
    fun `GIVEN local users list WHEN getUsersList is called THEN returns mapped Users List`() {
        // given
        coEvery {
            usersDao.getUsersList()
        } returns FAKE_USER_LOCAL_LIST

        // when
        val result = runBlocking { userRepository.getUserAvatarList().first() }

        runBlocking {
            val userFlow = flow {
                emit(FAKE_USER_LIST)
            }.first()

            // then
            assertEquals(result, userFlow)
        }
    }
}
