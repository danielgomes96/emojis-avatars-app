package com.daniel.domain.repository

import com.daniel.domain.entity.Emoji
import kotlinx.coroutines.flow.Flow

interface EmojiRepository {
    suspend fun getEmojiList(): Flow<List<Emoji>>
}
