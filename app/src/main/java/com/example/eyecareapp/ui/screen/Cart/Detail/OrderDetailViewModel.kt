package com.example.eyecareapp.ui.screen.Cart.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.OrderGlassData
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrderDetailViewModel (private val repository: WishlistRepository) : ViewModel(){
    private val _uiState : MutableStateFlow<UiState<OrderGlassData>> = MutableStateFlow(UiState.Loading)
    val uiState : StateFlow<UiState<OrderGlassData>> get() = _uiState

    fun getOrderById(id:Int){
        viewModelScope.launch {
            repository.getOrderById(id).collect{
                _uiState.value = UiState.Loading
                repository.getOrderById(id).collect { orderGlassData ->
                    _uiState.value = UiState.Success(orderGlassData)
                }
            }
        }
    }
}