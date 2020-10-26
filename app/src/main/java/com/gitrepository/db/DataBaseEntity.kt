package com.gitrepository.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "saved")
data class DataBaseEntity(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "id")
        val id: Long,
        @ColumnInfo(name = "link")
        val link: String

)