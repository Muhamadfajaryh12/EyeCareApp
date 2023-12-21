package com.example.eyecareapp.ui.screen.Test.ColourBlind

import androidx.lifecycle.ViewModel
import com.example.eyecareapp.data.WishlistRepository

class ColourBlindViewModel(private val repository: WishlistRepository) :ViewModel() {
    fun predict(inputData:List<String>)= repository.predict(inputData)

}