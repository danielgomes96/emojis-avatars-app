package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.verify
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class SaveEmojiListImplTest {

    private val emojiRepository: EmojiRepository = mockk()
    private val useCase: SaveEmojiList by lazy {
        SaveEmojiListImpl(emojiRepository)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `GIVEN an Emoji List WHEN use case is executed THEN repository should be called`() {
        every {
            emojiRepository.saveEmojiList(FAKE_EMOJI_LIST)
        } just Runs

        useCase.execute(FAKE_EMOJI_LIST)

        verify(exactly = 1) {
            emojiRepository.saveEmojiList(FAKE_EMOJI_LIST)
        }
    }

    companion object {
        val FAKE_EMOJI_LIST = listOf(
            Emoji("brazil", "https://github.githubassets.com/images/icons/emoji/unicode/1f1e7-1f1f7.png?v8"),
            Emoji("brazil", "https://github.githubassets.com/images/icons/emoji/unicode/1f1e7-1f1f7.png?v8"),
            Emoji("brazil", "https://github.githubassets.com/images/icons/emoji/unicode/1f1e7-1f1f7.png?v8"),
            Emoji("brazil", "https://github.githubassets.com/images/icons/emoji/unicode/1f1e7-1f1f7.png?v8"),
            Emoji("brazil", "https://github.githubassets.com/images/icons/emoji/unicode/1f1e7-1f1f7.png?v8")
        )
    }
}
