package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository
import kotlinx.coroutines.flow.Flow

class GetEmojiListImpl(
    private val emojiRepository: EmojiRepository
) : GetEmojiList {
    override suspend fun execute(): Flow<List<Emoji>> = emojiRepository.getEmojiList()
}
