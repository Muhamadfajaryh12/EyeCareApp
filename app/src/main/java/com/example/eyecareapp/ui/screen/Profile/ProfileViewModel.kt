package com.example.eyecareapp.ui.screen.Profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository : WishlistRepository): ViewModel() {
    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Loading)
    val uiState:StateFlow<UiState<String>> get() = _uiState

    fun changePassword(password:String,passwordConfirmation:String){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try{
                val response = repository.changePassword(password,passwordConfirmation)
                _uiState.value = UiState.Success(response.message.toString())
            }catch (e:Exception){
                _uiState.value = UiState.Error(e.message.toString())
            }
        }
    }
    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }
}