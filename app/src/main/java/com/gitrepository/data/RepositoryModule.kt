package com.gitrepository.data

import com.gitrepository.data.api.ApiModule
import com.gitrepository.data.repository.ApiReopository
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class])
class RepositoryModule {

    @Provides
    fun provideApiRepo(repository:ApiRepositoryImpl):ApiReopository = repository
}