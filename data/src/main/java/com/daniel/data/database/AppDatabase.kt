package com.daniel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(EmojiLocal::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun emojisDao(): EmojisDao
}
