package com.example.eyecareapp.di

import android.content.Context
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.data.preference.UserPreferences
import com.example.eyecareapp.data.preference.dataStore
import com.example.eyecareapp.data.retrofit.ApiConfig
import com.example.eyecareapp.database.GlassDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): WishlistRepository{
        val db = GlassDatabase.getInstance(context)
        val dao = db.glassDao()
        val pref = UserPreferences.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return WishlistRepository.getInstance(dao,apiService,pref)
    }
    fun resetInstance() {
        WishlistRepository.refreshRepository()
    }
}
