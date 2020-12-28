package com.daniel.data.mapper

import base.BaseMapper
import com.daniel.data.database.EmojiLocal
import com.daniel.domain.entity.Emoji

class EmojiLocalMapper : BaseMapper<List<EmojiLocal>, List<Emoji>>() {

    override fun transform(entity: List<EmojiLocal>): List<Emoji> {
        return entity.map {
            Emoji(it.name, it.imageUrl)
        }
    }

    fun fromDomain(entity: List<Emoji>): List<EmojiLocal> {
        return entity.map {
            EmojiLocal(0, it.name, it.imageUrl)
        }
    }

    fun fromLocal(randomEmoji: EmojiLocal): Emoji {
        return Emoji(
            randomEmoji.name, randomEmoji.imageUrl
        )
    }
}
