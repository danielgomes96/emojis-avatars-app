package com.daniel.data.mapper.remote

import com.daniel.data.dto.UserDTO
import com.daniel.domain.entity.User
import junit.framework.TestCase
import org.junit.Test

class UserRemoteMapperTest {

    companion object {
        private val FAKE_DTO_USER = UserDTO(0, "danielgomes96", "https://avatars3.githubusercontent.com/u/16447825?v=4")
        val FAKE_USER = User(0, "danielgomes96", "https://avatars3.githubusercontent.com/u/16447825?v=4")
    }

    private val userMapper by lazy {
        UserRemoteMapper()
    }

    @Test
    fun `GIVEN an user response WHEN transforming it THEN get proper user object`() {
        // Given
        // When
        val user = userMapper.transform(FAKE_DTO_USER)
        // Then
        TestCase.assertEquals(FAKE_USER, user)
    }
}
