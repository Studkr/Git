package com.gitrepository.data

import com.gitrepository.data.api.Api
import com.gitrepository.data.model.GitModel
import com.gitrepository.data.model.Item
import com.gitrepository.data.repository.ApiReopository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val api: Api
): ApiReopository{
    override suspend fun searchRepository(repository: String):GitModel = withContext(Dispatchers.IO){
        api.searchRepository(repository)
    }

    override suspend fun getRepoById(id: Long): Item  = withContext(Dispatchers.IO){
        api.getRepoById(id)
    }

}