package com.daniel.data.service

import com.daniel.data.dto.EmojiDTOList
import com.daniel.data.dto.RepositoryDTO
import com.daniel.data.dto.UserDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("emojis")
    suspend fun getEmojis(): EmojiDTOList

    @GET("users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): UserDTO

    @GET("users/{username}/repos")
    suspend fun fetchUserRepositories(
        @Path("username") username: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): List<RepositoryDTO>
}
