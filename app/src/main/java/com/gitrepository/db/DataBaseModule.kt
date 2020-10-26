package com.gitrepository.db

import android.content.Context
import androidx.room.Database
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class DataBaseModule @Inject constructor(
        val context: Context
) {
    val db = DataBase(context)

    @Singleton
    @Provides
    fun provideDataBase(): DataBase = DataBase.invoke(context)

    @Singleton
    @Provides
    fun provideDao(): DataBaseDao = DataBase.invoke(context).dao()


}