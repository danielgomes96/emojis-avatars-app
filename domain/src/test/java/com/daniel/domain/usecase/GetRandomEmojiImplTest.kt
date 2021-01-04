package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetRandomEmojiImplTest {

    private val emojiRepository: EmojiRepository = spyk()
    private val useCase: GetRandomEmoji by lazy {
        GetRandomEmojiImpl(emojiRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `SHOULD return random emoji from Repository WHEN use case is executed`() {
        every {
            emojiRepository.getRandomEmoji()
        } returns FAKE_EMOJI

        useCase.execute()

        verify(exactly = 1) {
            emojiRepository.getRandomEmoji()
        }
    }

    @Test
    fun `SHOULD return the same emoji WHEN repository get random emoji returns`() {
        every {
            emojiRepository.getRandomEmoji()
        } returns FAKE_EMOJI

        assertEquals(useCase.execute(), FAKE_EMOJI)
    }

    companion object {
        val FAKE_EMOJI = Emoji(
            "brazil",
            "https://github.githubassets.com/images/icons/emoji/unicode/1f1e7-1f1f7.png?v8"
        )
    }
}
