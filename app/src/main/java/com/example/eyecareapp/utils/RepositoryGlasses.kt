package com.example.eyecareapp.utils

import com.example.eyecareapp.data.CategoryGlass
import com.example.eyecareapp.data.CategoryGlassData
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.data.GlassData

class RepositoryGlasses {

    fun getAllGlasses():List<Glass>{
        return GlassData.glass
    }

    fun getCategoryGlasses():List<CategoryGlass>{
        return CategoryGlassData.category
    }

    companion object{
        @Volatile
        private var instance : RepositoryGlasses? = null

        fun getInstance():RepositoryGlasses =
            instance ?: synchronized(this){
                RepositoryGlasses().apply {
                    instance = this
                }
            }
    }
}