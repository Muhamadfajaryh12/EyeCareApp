package com.example.eyecareapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.ui.screen.Cart.CartViewModel
import com.example.eyecareapp.ui.screen.Detail.DetailViewModel
import com.example.eyecareapp.ui.screen.Home.HomeViewModel

class ViewModelFactory(private val wishlistRepository: WishlistRepository) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create (modelClass:Class<T>):T{
            if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
                return HomeViewModel(wishlistRepository) as T
            }
            else if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
                return DetailViewModel(wishlistRepository) as T
            }
            else if (modelClass.isAssignableFrom(CartViewModel::class.java)){
                return CartViewModel(wishlistRepository) as T
            }

            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
}