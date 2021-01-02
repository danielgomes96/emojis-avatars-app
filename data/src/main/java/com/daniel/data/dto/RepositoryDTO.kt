package com.daniel.data.dto

import com.google.gson.annotations.SerializedName

data class RepositoryDTO(
    val id: Long,
    @SerializedName("full_name")
    val name: String
)
