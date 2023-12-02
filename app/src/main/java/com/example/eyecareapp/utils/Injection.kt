package com.example.eyecareapp.utils

import android.content.Context

object Injection {
    fun provideRepository(context: Context):RepositoryGlasses{
        return RepositoryGlasses.getInstance()
    }
}