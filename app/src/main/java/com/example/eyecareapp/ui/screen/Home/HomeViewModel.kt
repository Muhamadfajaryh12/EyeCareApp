package com.example.eyecareapp.ui.screen.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.eyecareapp.data.Glasses
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.data.preference.UserModel
import com.example.eyecareapp.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: WishlistRepository): ViewModel(){

    private val _glass : MutableStateFlow<UiState<List<Glasses>>> = MutableStateFlow(UiState.Loading)
    val glass : StateFlow<UiState<List<Glasses>>> get() = _glass

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun getAllGlass(){
        _glass.value = UiState.Loading
        _glass.value = UiState.Success(repository.getAllGlasses().sortedBy { it.title })
    }

    fun getAllGlassByCategory(type:String){
        _glass.value = UiState.Loading
        _glass.value = UiState.Success(repository.getGlassByCategory(type).sortedBy { it.title })
    }
    fun search(newQuery : String){
        _query.value = newQuery
        _glass.value = UiState.Success(repository.searchFood(_query.value).sortedBy { it.title })
    }
    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
}