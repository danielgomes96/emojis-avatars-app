package com.daniel.data.mapper.local

import com.daniel.data.database.entity.UserLocal
import com.daniel.domain.entity.User
import junit.framework.TestCase
import org.junit.Test

class UserLocalMapperTest {

    companion object {
        private val FAKE_LOCAL_USER = UserLocal(0, "danielgomes96", "https://avatars3.githubusercontent.com/u/16447825?v=4")
        val FAKE_USER = User(0, "danielgomes96", "https://avatars3.githubusercontent.com/u/16447825?v=4")
    }

    private val userMapper by lazy {
        UserLocalMapper()
    }

    @Test
    fun `GIVEN an user WHEN transforming it THEN get proper user local object`() {
        // Given
        // When
        val userLocal = userMapper.transform(FAKE_USER)

        // Then
        TestCase.assertEquals(FAKE_LOCAL_USER, userLocal)
    }
}
