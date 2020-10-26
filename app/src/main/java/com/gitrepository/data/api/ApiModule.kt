package com.gitrepository.data.api

import com.flipsidegroup.nmt.rest.RetrofitModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
class ApiModule {
    @Provides
    fun provideGitApi(retrofit: Retrofit) = retrofit.create(Api::class.java)
}
