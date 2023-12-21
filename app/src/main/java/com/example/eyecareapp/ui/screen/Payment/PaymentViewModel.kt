package com.example.eyecareapp.ui.screen.Payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.OrderGlassData
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.screen.Detail.WishlistState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PaymentViewModel(private val repository: WishlistRepository): ViewModel() {
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
    fun addOrder(orderGlassData: OrderGlassData)=repository.insertOrder(orderGlassData)
}