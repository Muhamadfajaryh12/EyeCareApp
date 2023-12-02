package com.example.eyecareapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eyecareapp.ui.screen.Home.HomeViewModel
import com.example.eyecareapp.utils.RepositoryGlasses

class ViewModelFactory(private val repositoryGlasses: RepositoryGlasses) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create (modelClass:Class<T>):T{
            if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
                return HomeViewModel(repositoryGlasses) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
}