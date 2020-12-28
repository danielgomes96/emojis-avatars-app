package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository

class GetRandomEmojiImpl(
    private val emojiRepository: EmojiRepository
) : GetRandomEmoji {
    override fun execute(): Emoji = emojiRepository.getRandomEmoji()
}