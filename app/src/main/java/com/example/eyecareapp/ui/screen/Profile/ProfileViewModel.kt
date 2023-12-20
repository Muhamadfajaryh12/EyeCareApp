package com.example.eyecareapp.ui.screen.Profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.data.response.ResponseProfile
import com.example.eyecareapp.data.response.ResponseRegister
import com.example.eyecareapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository : WishlistRepository): ViewModel() {
    private val _uiState = MutableStateFlow<UiState<ResponseRegister>>(UiState.Loading)
    val uiState:StateFlow<UiState<ResponseRegister>> get() = _uiState

    private val _profileState = MutableStateFlow<UiState<ResponseProfile>>(UiState.Loading)
    val profileState:StateFlow<UiState<ResponseProfile>> get() = _profileState

    fun profile(id:String){
        viewModelScope.launch {
            _profileState.value = UiState.Loading
            try {
                val response = repository.profile(id)
                _profileState.value = UiState.Success(response)
            }catch(e:Exception){
                _profileState.value = UiState.Error(e.message.toString())
            }
        }
    }

    fun changePassword(password:String,passwordConfirmation:String){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try{
                val response = repository.changePassword(password,passwordConfirmation)
                _uiState.value = UiState.Success(response)
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