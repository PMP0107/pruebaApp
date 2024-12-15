package com.example.final_entregau3_pmdm.login

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "DATASTORE")

object DataStore {
    private val USER_KEY = stringPreferencesKey("user")
    private val PASSWORD_KEY = stringPreferencesKey("password")

    fun getCredentials(context: Context): Flow<LoginData> {
        return context.dataStore.data.map { preferences ->
            LoginData(
                name = preferences[USER_KEY] ?: "",
                passwd = preferences[PASSWORD_KEY] ?: ""
            )
        }
    }

    suspend fun saveCredentials(context: Context, user: String, password: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_KEY] = user
            preferences[PASSWORD_KEY] = password
        }
    }
}