package com.example.eyecareapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.ui.screen.Cart.CartViewModel
import com.example.eyecareapp.ui.screen.Detail.DetailViewModel
import com.example.eyecareapp.ui.screen.Home.HomeViewModel
import com.example.eyecareapp.ui.screen.Login.LoginViewModel
import com.example.eyecareapp.ui.screen.Payment.PaymentViewModel
import com.example.eyecareapp.ui.screen.Profile.ProfileViewModel
import com.example.eyecareapp.ui.screen.Register.RegisterViewModel

class ViewModelFactory
    (
    private val wishlistRepository: WishlistRepository
            )
    : ViewModelProvider.NewInstanceFactory() {
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
            else if (modelClass.isAssignableFrom(RegisterViewModel::class.java)){
                return RegisterViewModel(wishlistRepository) as T
            }
            else if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
                return LoginViewModel(wishlistRepository) as T
            }
            else if(modelClass.isAssignableFrom(ProfileViewModel::class.java)){
                return ProfileViewModel(wishlistRepository) as T
            }
            else if(modelClass.isAssignableFrom(PaymentViewModel::class.java)){
                return PaymentViewModel(wishlistRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }

}