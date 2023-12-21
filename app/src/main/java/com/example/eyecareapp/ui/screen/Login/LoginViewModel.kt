package com.example.eyecareapp.ui.screen.Login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.data.preference.UserModel
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: WishlistRepository) : ViewModel() {
//    private val _loginState = MutableStateFlow<UiState<ResponseLogin>>(UiState.Loading)
//    val loginState: StateFlow<UiState<ResponseLogin>> get() = _loginState
//
//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            _loginState.value = UiState.Loading
//            try {
//                val response = repository.login(email,password)
//                _loginState.value = UiState.Success(response)
//            } catch (e: Exception) {
//                _loginState.value = UiState.Error(e.message.toString())
//            }
//        }
//    }
    fun login(email:String,password:String)= repository.login(email,password)

    fun saveSession(userModel: UserModel){
        viewModelScope.launch {
            repository.saveSession(userModel)
        }
    }

}