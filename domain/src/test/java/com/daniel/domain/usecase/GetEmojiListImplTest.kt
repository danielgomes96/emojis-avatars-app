package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.spyk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetEmojiListImplTest {
    private val emojiRepository: EmojiRepository = spyk()
    private val useCase: GetEmojiList by lazy {
        GetEmojiListImpl(emojiRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `WHEN use case is executed THEN repository should be called`() = runBlocking {
        useCase.execute()

        coVerify(exactly = 1) {
            emojiRepository.getEmojiList()
        }
    }

    @Test
    fun `GIVEN flow emoji list WHEN repository returns it THEN use case should return the same`() = runBlocking {
        val flow = flow {
            emit(FAKE_FLOW_EMOJI_LIST)
        }

        coEvery {
            emojiRepository.getEmojiList()
        } returns flow

        assertEquals(useCase.execute(), flow)
    }

    private companion object {
        private val FAKE_FLOW_EMOJI_LIST = listOf(
            Emoji("a", "a"),
            Emoji("a", "b")
        )
    }
}
