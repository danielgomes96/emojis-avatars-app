package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji
import com.daniel.domain.repository.EmojiRepository

class SaveEmojiListImpl(
    private val emojiRepository: EmojiRepository
) : SaveEmojiList {
    override fun execute(emojiList: List<Emoji>) = emojiRepository.saveEmojiList(emojiList)
}
