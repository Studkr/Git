package com.gitrepository.data.api

import com.gitrepository.data.model.GitModel
import com.gitrepository.data.model.Item
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {

    @GET("/search/repositories")
    suspend fun searchRepository(
            @Query("q") searchParam: String
    ):GitModel

    @GET("/repositories/{id}")
    suspend fun getRepoById(@Path("id") id:Long): Item
}