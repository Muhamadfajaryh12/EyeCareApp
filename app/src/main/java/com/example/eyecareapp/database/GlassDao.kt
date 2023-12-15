package com.example.eyecareapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eyecareapp.data.Glass
import kotlinx.coroutines.flow.Flow

@Dao
interface GlassDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWishlist(glass: Glass)

    @Delete
    suspend fun delete(glass: Glass)

    @Query("SELECT * FROM Wishlist")
    fun getAllWishlist(): Flow<List<Glass>>

    @Query("SELECT * FROM Wishlist WHERE id = :id ")
    fun getWishlistById(id:Int):Flow<Glass>

}