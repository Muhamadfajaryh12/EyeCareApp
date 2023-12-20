package com.example.eyecareapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "OrderGlass")
data class OrderGlassData(
    @ColumnInfo(name="id")
    @PrimaryKey
    val id : Int,
    @ColumnInfo(name="title")
    val title : String,
    @ColumnInfo(name="image")
    val image: String,
    @ColumnInfo(name="ukuran")
    val ukuran:String,
    @ColumnInfo(name="warna")
    val warna:String,
    @ColumnInfo(name="payment")
    val payment:String,
    @ColumnInfo(name="status")
    val status:String,
    @ColumnInfo(name="account")
    val account:String,
    @ColumnInfo(name="address")
    val address:String,
    @ColumnInfo(name="type")
    val type:String,
    @ColumnInfo(name="price")
    val price:String
)

