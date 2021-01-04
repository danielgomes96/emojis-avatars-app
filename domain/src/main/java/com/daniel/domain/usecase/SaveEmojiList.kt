package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji

interface SaveEmojiList {
    fun execute(emojiList: List<Emoji>)
}
