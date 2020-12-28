package com.daniel.domain.usecase

import com.daniel.domain.entity.Emoji

interface GetRandomEmoji {
    fun execute(): Emoji
}