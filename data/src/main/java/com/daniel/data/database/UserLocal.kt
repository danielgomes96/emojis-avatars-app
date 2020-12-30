package com.daniel.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserLocal(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "avatar_url") val avatarUrl: String
)
