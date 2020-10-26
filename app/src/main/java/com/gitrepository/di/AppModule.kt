package com.gitrepository.di

import android.app.Application
import android.content.Context
import com.gitrepository.data.repository.DataBaseRepository
import com.gitrepository.data.DataBaseRepositoryImpl
import com.gitrepository.data.RepositoryModule
import com.gitrepository.db.DataBaseModule
import com.gitrepository.screen.MainActivityModule
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [
    MainActivityModule::class,
    DataBaseModule::class,
    RepositoryModule::class
])
class AppModule(val app: Application) {
    @Provides
    fun context(): Context = app

    @Singleton
    @Provides
    fun repository(impl: DataBaseRepositoryImpl): DataBaseRepository = impl
}

const val COROUTINE_CONTEX = "SEARCH_LIST_USE_CASE_COROUTINE_CONTEXT"

@Module
class CoroutineContextModule {

    @Provides
    @Singleton
    @Named(COROUTINE_CONTEX)
    fun providesCoroutineContext() = Job() + Dispatchers.Default
}