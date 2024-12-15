package com.example.final_entregau3_pmdm.data.entities

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "languages_table")
data class LanguageEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")val id: Int = 0,
    @ColumnInfo(name = "name")val name: String
)