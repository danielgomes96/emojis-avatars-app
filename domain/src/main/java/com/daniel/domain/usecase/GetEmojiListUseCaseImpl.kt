package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository
import kotlinx.coroutines.flow.Flow

class GetEmojiListUseCaseImpl(
    private val emojiRepository: EmojiRepository
) : GetEmojiListUseCase {
    override suspend fun execute(): Flow<List<Emoji>> = emojiRepository.getEmojiList()
}
