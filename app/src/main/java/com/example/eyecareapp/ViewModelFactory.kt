package com.example.eyecareapp

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eyecareapp.data.WishlistRepository
import com.example.eyecareapp.di.Injection
import com.example.eyecareapp.ui.screen.Cart.CartViewModel
import com.example.eyecareapp.ui.screen.Cart.Detail.OrderDetailViewModel
import com.example.eyecareapp.ui.screen.Detail.DetailViewModel
import com.example.eyecareapp.ui.screen.Home.HomeViewModel
import com.example.eyecareapp.ui.screen.Login.LoginViewModel
import com.example.eyecareapp.ui.screen.Payment.PaymentViewModel
import com.example.eyecareapp.ui.screen.Profile.ProfileViewModel
import com.example.eyecareapp.ui.screen.Register.RegisterViewModel
import com.example.eyecareapp.ui.screen.Test.ColourBlind.ColourBlindViewModel

class ViewModelFactory
    (
    private val wishlistRepository: WishlistRepository
            )
    : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create (modelClass:Class<T>):T {
        return when {

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(wishlistRepository) as T
            }

            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(wishlistRepository) as T
            }

            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(wishlistRepository) as T
            }

            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(wishlistRepository) as T
            }

            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(wishlistRepository) as T
            }

            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(wishlistRepository) as T
            }

            modelClass.isAssignableFrom(PaymentViewModel::class.java) -> {
                PaymentViewModel(wishlistRepository) as T
            }

            modelClass.isAssignableFrom(OrderDetailViewModel::class.java) -> {
                OrderDetailViewModel(wishlistRepository) as T
            }

            modelClass.isAssignableFrom(ColourBlindViewModel::class.java)->{
                ColourBlindViewModel(wishlistRepository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null
        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    val Repository = Injection.provideRepository(context)
                    INSTANCE = ViewModelFactory(Repository)

                }
            }
            return INSTANCE as ViewModelFactory
        }
        fun resetInstance() {
            INSTANCE = null
            Injection.resetInstance()
        }
    }
}