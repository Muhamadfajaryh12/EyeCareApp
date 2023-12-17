package com.example.eyecareapp.ui.common

sealed class UiState<out T: Any?> private constructor(){

    object Loading : UiState<Nothing>()

    data class Success<out T: Any>(val data: T) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}