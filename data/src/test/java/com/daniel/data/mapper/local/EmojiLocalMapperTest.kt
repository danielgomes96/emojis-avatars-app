package com.daniel.data.mapper.local

import com.daniel.data.database.entity.EmojiLocal
import com.daniel.domain.entity.Emoji
import junit.framework.TestCase
import org.junit.Test

class EmojiLocalMapperTest {

    companion object {
        private val FAKE_LOCAL_EMOJIS_LIST = listOf(
                EmojiLocal(0, "100", "https://github.githubassets.com/images/icons/emoji/unicode/1f4af.png?v8"),
                EmojiLocal(1, "1234", "https://github.githubassets.com/images/icons/emoji/unicode/1f522.png?v8"),
                EmojiLocal(2, "+1", "https://github.githubassets.com/images/icons/emoji/unicode/1f44d.png?v8")
        )

        val FAKE_LIST_EMOJI = listOf(
                Emoji("100", "https://github.githubassets.com/images/icons/emoji/unicode/1f4af.png?v8"),
                Emoji("1234", "https://github.githubassets.com/images/icons/emoji/unicode/1f522.png?v8"),
                Emoji("+1", "https://github.githubassets.com/images/icons/emoji/unicode/1f44d.png?v8")
        )
    }

    private val emojiMapper by lazy {
        EmojiLocalMapper()
    }

    @Test
    fun `GIVEN a local emoji list WHEN transforming it THEN get proper emoji list object`() {
        // Given
        // When
        val emojiList = emojiMapper.transform(FAKE_LOCAL_EMOJIS_LIST)

        // Then
        TestCase.assertEquals(FAKE_LIST_EMOJI[0].name, emojiList[0].name)
        TestCase.assertEquals(FAKE_LIST_EMOJI[0].imageUrl, emojiList[0].imageUrl)
    }
}
