package com.daniel.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repositories")
data class RepositoryLocal(
    @PrimaryKey
    val id: Long,
    val page: Int,
    val name: String
)
