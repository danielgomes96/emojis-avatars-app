package com.daniel.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmojisDao {
    @Query("SELECT * FROM emojilocal")
    fun getEmojiList(): List<EmojiLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEmojiList(emojiList: List<EmojiLocal>)

    @Query("SELECT * FROM emojilocal ORDER BY RANDOM() LIMIT 1")
    fun getRandomEmoji(): EmojiLocal
}
