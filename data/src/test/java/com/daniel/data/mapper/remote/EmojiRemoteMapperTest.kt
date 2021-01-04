package com.daniel.data.mapper.remote

import com.daniel.data.dto.EmojiDTO
import com.daniel.data.dto.EmojiDTOList
import com.daniel.domain.entity.Emoji
import junit.framework.TestCase
import org.junit.Test

class EmojiRemoteMapperTest {

    companion object {
        private val FAKE_DTO_EMOJIS_LIST = listOf(
                EmojiDTO("100", "https://github.githubassets.com/images/icons/emoji/unicode/1f4af.png?v8"),
                EmojiDTO("1234", "https://github.githubassets.com/images/icons/emoji/unicode/1f522.png?v8"),
                EmojiDTO("+1", "https://github.githubassets.com/images/icons/emoji/unicode/1f44d.png?v8")
        )
        val FAKE_DTO_EMOJI_LIST = EmojiDTOList(
                FAKE_DTO_EMOJIS_LIST
        )
        val FAKE_LIST_EMOJI = listOf(
                Emoji("100", "https://github.githubassets.com/images/icons/emoji/unicode/1f4af.png?v8"),
                Emoji("1234", "https://github.githubassets.com/images/icons/emoji/unicode/1f522.png?v8"),
                Emoji("+1", "https://github.githubassets.com/images/icons/emoji/unicode/1f44d.png?v8")
        )
    }

    private val emojiMapper by lazy {
        EmojiRemoteMapper()
    }

    @Test
    fun `GIVEN an emoji list response WHEN transforming it THEN get proper emoji list object`() {
        // Given
        // When
        val emojiList = emojiMapper.transform(FAKE_DTO_EMOJI_LIST)

        // Then
        TestCase.assertEquals(FAKE_LIST_EMOJI, emojiList)
    }
}