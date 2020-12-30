package com.daniel.data.service

import com.daniel.data.dto.EmojiDTOList
import com.daniel.data.dto.UserDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("emojis")
    suspend fun getEmojis(): EmojiDTOList

    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): UserDTO
}
