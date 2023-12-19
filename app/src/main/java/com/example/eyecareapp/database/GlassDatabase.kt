package com.example.eyecareapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.data.OrderGlassData

@Database(entities = [Glass::class,OrderGlassData::class], version = 3, exportSchema = false)
abstract class GlassDatabase:RoomDatabase() {
    abstract fun glassDao() : GlassDao

    companion object{
        @Volatile
        private var instance: GlassDatabase? = null
        fun getInstance(context: Context):GlassDatabase =
            instance ?: synchronized(this){
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    GlassDatabase::class.java, "Database"
                ).build()
            }
    }
}