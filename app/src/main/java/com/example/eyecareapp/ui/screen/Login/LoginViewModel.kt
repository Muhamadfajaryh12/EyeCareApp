package com.example.eyecareapp.ui.screen.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.data.preference.UserModel
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: WishlistRepository) : ViewModel() {
//    private val _registrationState = MutableStateFlow<UiState<UserModel>>(UiState.Loading)
//    val registrationState: StateFlow<UiState<UserModel>> get() = _registrationState
//
//    fun register( name: String, email: String, password: String,password_confirmation:String, tc:Boolean) {
//        viewModelScope.launch {
//            _registrationState.value = UiState.Loading
//            try {
//                val response = repository.login(name,email)
//                _registrationState.value = UiState.Success(response.message.toString())
//            } catch (e: Exception) {
//                _registrationState.value = UiState.Error(e.message.toString())
//            }
//        }
//    }
    fun login(email:String,password:String)= repository.login(email,password)

    fun saveSession(userModel: UserModel){
        viewModelScope.launch {
            repository.saveSession(userModel)
        }
    }

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
}