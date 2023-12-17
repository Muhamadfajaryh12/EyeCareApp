package com.example.eyecareapp.data

import com.example.eyecareapp.data.preference.UserModel
import com.example.eyecareapp.data.preference.UserPreferences
import com.example.eyecareapp.data.retrofit.ApiService
import kotlinx.coroutines.flow.Flow

class UserRepository private constructor(
    private val apiService : ApiService,
    private val userPreferences: UserPreferences,
) {
    suspend fun saveSession(user: UserModel) {
        userPreferences.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreferences.getSession()
    }



    companion object{
        @Volatile
        private var instance:UserRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreferences: UserPreferences
        ):UserRepository =
            instance ?: synchronized(this){
                instance ?: UserRepository(apiService,userPreferences)
            }.also { instance = it }
        fun refreshRepository() {
            instance = null
        }
    }
}