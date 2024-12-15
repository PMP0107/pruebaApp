package com.example.final_entregau3_pmdm.data.entities

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "projects_table")
data class ProjectEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "duration")val duration: String,
    @ColumnInfo(name = "description")val description: String,
    @ColumnInfo(name = "initDate")val initDate: String,
    @ColumnInfo(name = "language")val language: String,
    @ColumnInfo(name = "projectDetail")val projDetail: String
)