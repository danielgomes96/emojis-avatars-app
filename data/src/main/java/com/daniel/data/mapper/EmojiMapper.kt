package com.daniel.data.mapper

import base.BaseMapper
import com.daniel.data.dto.EmojiDTOList
import com.daniel.domain.entity.Emoji

class EmojiMapper : BaseMapper<EmojiDTOList, List<Emoji>>() {

    override fun transform(entity: EmojiDTOList): List<Emoji> {
        return entity.emojiDTOList.map {
            Emoji(it.name, it.imageUrl)
        }
    }
}
