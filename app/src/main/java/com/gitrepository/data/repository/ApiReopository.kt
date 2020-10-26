package com.gitrepository.data.repository

import com.gitrepository.data.model.GitModel
import com.gitrepository.data.model.Item

interface ApiReopository {
    suspend fun searchRepository(repository:String):GitModel
    suspend fun getRepoById(id:Long): Item
}