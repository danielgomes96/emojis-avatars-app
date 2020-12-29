package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository
import kotlinx.coroutines.flow.Flow

class HasCacheImpl(
    private val emojiRepository: EmojiRepository
) : HasCache {
    override suspend fun execute(): Flow<List<Emoji>> = emojiRepository.hasCache()
}
