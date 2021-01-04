package com.daniel.data.repository

import com.daniel.data.database.dao.EmojisDao
import com.daniel.data.database.entity.EmojiLocal
import com.daniel.data.dto.EmojiDTO
import com.daniel.data.dto.EmojiDTOList
import com.daniel.data.service.GithubService
import com.daniel.domain.entity.Emoji
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.Assert
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class EmojiRepositoryImplTest {

    @MockK
    internal lateinit var mockService: GithubService

    @MockK
    internal lateinit var emojisDao: EmojisDao

    private lateinit var emojiRepository: EmojiRepositoryImpl

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
        private val FAKE_LOCAL_EMOJIS_LIST = listOf(
            EmojiLocal(0, "100", "https://github.githubassets.com/images/icons/emoji/unicode/1f4af.png?v8"),
            EmojiLocal(1, "1234", "https://github.githubassets.com/images/icons/emoji/unicode/1f522.png?v8"),
            EmojiLocal(2, "+1", "https://github.githubassets.com/images/icons/emoji/unicode/1f44d.png?v8")
        )
    }

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        emojiRepository = EmojiRepositoryImpl(mockService, emojisDao)
    }

    @Test
    fun `GIVEN an emoji list response WHEN getEmojis is called THEN maps to Domain`() {
        // given
        coEvery {
            emojisDao.getEmojiList()
        } returns FAKE_LOCAL_EMOJIS_LIST

        coEvery {
            mockService.getEmojis()
        } returns FAKE_DTO_EMOJI_LIST

        // when
        val result = runBlocking { emojiRepository.getEmojiList().first() }

        runBlocking {
            val emojiListFlow = flow {
                emit(FAKE_LIST_EMOJI)
            }.first()

            // then
            Assert.assertEquals(result, emojiListFlow)
        }
    }
}
