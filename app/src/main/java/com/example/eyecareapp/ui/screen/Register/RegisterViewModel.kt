package com.example.eyecareapp.ui.screen.Register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.data.response.ResponseRegister
import com.example.eyecareapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel (private val repository: WishlistRepository): ViewModel() {
    private val _registrationState = MutableStateFlow<UiState<ResponseRegister>>(UiState.Loading)
    val registrationState: StateFlow<UiState<ResponseRegister>> get() = _registrationState

    fun register( name: String, email: String, password: String,password_confirmation:String, tc:Boolean) {
        viewModelScope.launch {
            _registrationState.value = UiState.Loading
            try {
                val response = repository.register(name,email, password,password_confirmation,tc)
                _registrationState.value = UiState.Success(response)
            } catch (e: Exception) {
                _registrationState.value = UiState.Error(e.message.toString())
            }
        }
    }

}