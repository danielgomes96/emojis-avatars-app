package com.daniel.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.daniel.data.database.entity.UserLocal

@Dao
interface UsersDao {
    @Query("SELECT * FROM userlocal")
    fun getUsersList(): List<UserLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(user: UserLocal)

    @Query("DELETE FROM userlocal WHERE id = :userId")
    fun removeUser(userId: Long)
}
