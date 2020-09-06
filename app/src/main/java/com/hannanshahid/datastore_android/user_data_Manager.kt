package com.hannanshahid.datastore_android

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import androidx.lifecycle.Transformations.map
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class user_data_Manager(context:Context) {

    val dataStore=context.createDataStore(
        name = "user_data"
    )



    fun getname(): Flow<String>
    {
        val name: Flow<String> = dataStore.data
            .map { preferences ->
                // No type safety.
                preferences[name]?:"no name"
            }
        return name
    }

    suspend fun setname(nam:String) {
        dataStore.edit { preferences ->
            preferences[name]=nam
        }
    }

    suspend fun setage(ag:Int) {
        dataStore.edit { preferences ->
            preferences[age]=ag
        }
    }

    companion object {
        val name = preferencesKey<String>("name")
        val age= preferencesKey<Int>("age")
    }
}