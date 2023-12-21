package com.example.eyecareapp.data

data class Quiz(
    val id : Int,
    val image : String,
    val option : List<Option>
)

data class Option(
    val idOption : Int,
    val opsi:String,
    val value:String
)