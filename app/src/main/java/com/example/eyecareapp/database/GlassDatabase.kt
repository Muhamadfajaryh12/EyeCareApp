package com.example.eyecareapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eyecareapp.data.Glass

@Database(entities = [Glass::class], version = 1, exportSchema = false)
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