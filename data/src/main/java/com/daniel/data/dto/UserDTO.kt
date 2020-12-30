package com.daniel.data.dto

import com.google.gson.annotations.SerializedName

data class UserDTO(
    val id: Int,
    @SerializedName("login") val userName: String,
    @SerializedName("avatar_url") val imageUrl: String
)
