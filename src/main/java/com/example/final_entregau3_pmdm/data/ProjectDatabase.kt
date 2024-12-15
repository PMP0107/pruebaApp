package com.example.final_entregau3_pmdm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.final_entregau3_pmdm.data.dao.LanguagesDao
import com.example.final_entregau3_pmdm.data.dao.ProjectsDao
import com.example.final_entregau3_pmdm.data.entities.LanguageEntity
import com.example.final_entregau3_pmdm.data.entities.ProjectEntity

@Database(entities = [LanguageEntity::class, ProjectEntity::class], version = 1)
abstract class ProjectDatabase: RoomDatabase() {

    abstract fun getLanguagesDao(): LanguagesDao
    abstract fun ProjectsDao(): ProjectsDao

    companion object {
        @Volatile
        private var INSTANCE: ProjectDatabase? = null

        fun getInstance(context: Context): ProjectDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProjectDatabase::class.java,
                    "project_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}