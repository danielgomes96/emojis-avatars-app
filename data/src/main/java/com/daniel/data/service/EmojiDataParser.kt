package com.daniel.data.service

import com.daniel.data.dto.EmojiDTO
import com.daniel.data.dto.EmojiDTOList
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class EmojiDataParser : JsonDeserializer<EmojiDTOList> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): EmojiDTOList {
        val emojiList = mutableListOf<EmojiDTO>()

        Gson().fromJson(json, Map::class.java).forEach { map ->
            emojiList.add(EmojiDTO(map.key as String, map.value as String))
        }

        return EmojiDTOList(emojiList)
    }
}
