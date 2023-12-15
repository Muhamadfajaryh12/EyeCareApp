package com.example.eyecareapp.di

import android.content.Context
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.database.GlassDatabase

object Injection {
    fun provideRepository(context: Context): WishlistRepository{
        val db = GlassDatabase.getInstance(context)
        val dao = db.glassDao()
        return WishlistRepository.getInstance(dao)
    }
}