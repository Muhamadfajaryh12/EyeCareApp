package com.example.eyecareapp.ui.screen.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.data.preference.UserModel
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: WishlistRepository) : ViewModel() {
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