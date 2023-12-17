package com.example.eyecareapp.ui.screen.Profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.WishlistRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository : WishlistRepository): ViewModel() {
    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}