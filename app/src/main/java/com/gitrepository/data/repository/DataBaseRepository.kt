package com.gitrepository.data.repository

import com.gitrepository.db.DataBaseEntity
import kotlinx.coroutines.flow.Flow

interface DataBaseRepository {
    fun getSavedRepositoryList(): Flow<List<DataBaseEntity>>
    suspend fun inset(model:DataBaseEntity)
    suspend fun delete(model:DataBaseEntity)
}