package com.example.final_entregau3_pmdm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.final_entregau3_pmdm.data.entities.ProjectEntity

@Dao
interface ProjectsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProject(project: ProjectEntity)

    @Query("SELECT * FROM projects_table")
    suspend fun getAllProjects():List<ProjectEntity>

}