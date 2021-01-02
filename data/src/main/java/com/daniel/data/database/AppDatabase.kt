package com.daniel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daniel.data.database.dao.EmojisDao
import com.daniel.data.database.dao.RepositoryDao
import com.daniel.data.database.dao.UsersDao
import com.daniel.data.database.entity.EmojiLocal
import com.daniel.data.database.entity.RepositoryLocal
import com.daniel.data.database.entity.UserLocal

@Database(entities = arrayOf(EmojiLocal::class, UserLocal::class, RepositoryLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun emojisDao(): EmojisDao
    abstract fun usersDao(): UsersDao
    abstract fun repositoryDao(): RepositoryDao
}
