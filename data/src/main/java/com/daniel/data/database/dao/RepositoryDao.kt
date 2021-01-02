package com.daniel.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.daniel.data.database.entity.RepositoryLocal

@Dao
interface RepositoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(repos: List<RepositoryLocal>)

    @Query("SELECT * FROM REPOSITORIES WHERE page = :page ORDER BY name")
    fun getRepos(page: Int): List<RepositoryLocal>
}
