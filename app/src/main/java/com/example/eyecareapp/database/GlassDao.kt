package com.example.eyecareapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.data.OrderGlassData
import kotlinx.coroutines.flow.Flow

@Dao
interface GlassDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addWishlist(glass: Glass)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addOrder(orderGlassData: OrderGlassData)
    @Delete
    suspend fun delete(glass: Glass)

    @Query("SELECT * FROM Wishlist")
    fun getAllWishlist(): Flow<List<Glass>>

    @Query("SELECT * FROM OrderGlass")
    fun getAllOrder():Flow<List<OrderGlassData>>

    @Query("SELECT * FROM Wishlist WHERE id = :id ")
    fun getWishlistById(id:Int):Flow<Glass>

    @Query("SELECT * FROM OrderGlass WHERE id=:id")
    fun getOrderById(id: Int):Flow<OrderGlassData>

}