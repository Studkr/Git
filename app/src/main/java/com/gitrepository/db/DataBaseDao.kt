package com.gitrepository.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DataBaseDao {
    @Insert
    suspend fun insert(model: DataBaseEntity)

    @Delete
    suspend fun delete(model: DataBaseEntity)

    @Query("SELECT * FROM saved")
     fun getSavedList(): Flow<List<DataBaseEntity>>
}