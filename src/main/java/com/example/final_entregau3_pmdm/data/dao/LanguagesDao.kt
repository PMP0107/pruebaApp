package com.example.final_entregau3_pmdm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.final_entregau3_pmdm.data.entities.LanguageEntity

@Dao
interface LanguagesDao {

    @Query("SELECT * FROM languages_table")
    suspend fun getAllLanguages(): List<LanguageEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLanguage(languages:LanguageEntity)
}