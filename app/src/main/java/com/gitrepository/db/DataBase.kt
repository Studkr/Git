package com.gitrepository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataBaseEntity::class],version = 1)
abstract class DataBase: RoomDatabase(){
    abstract fun dao():DataBaseDao
    companion object {
        operator fun invoke(context: Context) = Room.databaseBuilder(
                context,
                DataBase::class.java,
                "git"
        ).fallbackToDestructiveMigration()
                .build()
    }
}