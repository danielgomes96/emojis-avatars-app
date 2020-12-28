package com.daniel.data.service

import com.daniel.data.dto.EmojiDTOList
import retrofit2.http.GET

interface GithubService {
    @GET("emojis")
    suspend fun getEmojis(): EmojiDTOList
}
