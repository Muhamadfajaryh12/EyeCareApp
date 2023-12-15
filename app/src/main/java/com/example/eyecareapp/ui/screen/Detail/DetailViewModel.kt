package com.example.eyecareapp.ui.screen.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel (private val repository: WishlistRepository): ViewModel() {

    private val _uiState : MutableStateFlow<UiState<WishlistState>> =
        MutableStateFlow(UiState.Loading)
    val uiState : StateFlow<UiState<WishlistState>>
        get() = _uiState

    fun getGlassById(id:Int){
        viewModelScope.launch {
            repository.getWishlistById(id).collect{
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(WishlistState(repository.getGlassById(id),it!=null))
            }
        }
    }

    fun addWishlist(glass: Glass){
        viewModelScope.launch {
            repository.addWishlist(glass)
        }
    }

    fun deleteWishlist(glass: Glass){
        viewModelScope.launch {
            repository.deleteWishlist(glass)
        }
    }
}