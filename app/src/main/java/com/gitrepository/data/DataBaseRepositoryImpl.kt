package com.gitrepository.data

import com.gitrepository.data.repository.DataBaseRepository
import com.gitrepository.db.DataBaseDao
import com.gitrepository.db.DataBaseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataBaseRepositoryImpl @Inject constructor(
    private val dao: DataBaseDao
): DataBaseRepository {
    override  fun getSavedRepositoryList(): Flow<List<DataBaseEntity>> = dao.getSavedList()


    override suspend fun inset(model: DataBaseEntity) = withContext(Dispatchers.IO) {
     dao.insert(model)
    }

    override suspend fun delete(model: DataBaseEntity) = withContext(Dispatchers.IO) {
        dao.delete(model)
    }

}