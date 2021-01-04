package com.daniel.domain.usecase

import com.daniel.domain.repository.EmojiRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class HasCacheImplTest {
    private val emojiRepository: EmojiRepository = spyk()
    private val useCase: HasCache by lazy {
        HasCacheImpl(emojiRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `WHEN use case is executed THEN repository should be called`() = runBlocking {
        useCase.execute()

        coVerify {
            emojiRepository.hasCache()
        }
    }
}
