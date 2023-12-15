package com.example.eyecareapp.ui.screen.Cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CartViewModel(private val repository: WishlistRepository): ViewModel() {
    private  val _uiState : MutableStateFlow<UiState<List<Glass>>> = MutableStateFlow(UiState.Loading)
    val uiState : StateFlow<UiState<List<Glass>>>
        get() = _uiState

    fun getAllWishlist(){
        viewModelScope.launch {
            repository.getWishlist()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect{
                    glass -> _uiState.value = UiState.Success(glass)
                }
        }
    }
}