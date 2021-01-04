package com.daniel.domain.repository

import com.daniel.domain.entity.Emoji
import kotlinx.coroutines.flow.Flow

interface EmojiRepository {
    suspend fun getEmojiList(): Flow<List<Emoji>>
    fun saveEmojiList(emojiList: List<Emoji>)
    fun getRandomEmoji(): Emoji
    suspend fun hasCache(): Flow<List<Emoji>>
}
