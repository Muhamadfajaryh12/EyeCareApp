package com.example.eyecareapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Wishlist")
data class Glass(

    @field:ColumnInfo(name="id")
    @field:PrimaryKey
    val id:Int,
    @field:ColumnInfo(name="title")
    val title:String,
    @field:ColumnInfo(name="image")
    val image:String,
    @field:ColumnInfo(name="price")
    val price:String,
    @field:ColumnInfo(name="type")
    val type:String,
)
data class Glasses(
    val id:Int,
    val title:String,
    val image:String,
    val price:String,
    val type:String,
    val listWarna:List<Warna>,
    val listUkuran:List<Ukuran>,
    val description:String
)

data class Warna(val warna : String)
data class Ukuran(val ukuran :String)
