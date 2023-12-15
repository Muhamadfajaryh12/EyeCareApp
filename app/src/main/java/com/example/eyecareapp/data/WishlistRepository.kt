package com.example.eyecareapp.data

import com.example.eyecareapp.database.GlassDao
import kotlinx.coroutines.flow.Flow

class WishlistRepository private constructor(private val glassDao : GlassDao){
    fun getAllGlasses(): List<Glass> {
        return GlassData.glass
    }

    fun getGlassById(id:Int): Glass {
        return GlassData.glass.first{
            it.id == id
        }
    }

    suspend fun addWishlist(glass: Glass){
        return glassDao.addWishlist(glass)
    }

    suspend fun deleteWishlist(glass:Glass){
        return glassDao.delete(glass)
    }

    suspend fun getWishlist(): Flow<List<Glass>> {
        return glassDao.getAllWishlist()
    }

    suspend fun getWishlistById(id:Int):Flow<Glass>{
        return glassDao.getWishlistById(id)
    }

    companion object{
        @Volatile
        private var instance : WishlistRepository? = null
        fun getInstance(glassDao: GlassDao):WishlistRepository  =
            instance ?: synchronized(this){
                WishlistRepository(glassDao).apply {
                    instance = this
                }
            }
    }
}