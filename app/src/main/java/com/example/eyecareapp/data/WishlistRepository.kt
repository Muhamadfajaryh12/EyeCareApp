package com.example.eyecareapp.data

import androidx.lifecycle.liveData
import com.example.eyecareapp.data.preference.UserModel
import com.example.eyecareapp.data.preference.UserPreferences
import com.example.eyecareapp.data.response.ResponseError
import com.example.eyecareapp.data.response.ResponseProfile
import com.example.eyecareapp.data.response.ResponseRegister
import com.example.eyecareapp.data.retrofit.ApiService
import com.example.eyecareapp.database.GlassDao
import com.example.eyecareapp.ui.common.UiState
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException

class WishlistRepository private constructor(
    private val glassDao : GlassDao,
    private val apiService : ApiService,
    private val userPreferences: UserPreferences
    ){
    fun getAllGlasses(): List<Glass> {
        return GlassData.glass
    }

    fun getGlassById(id:Int): Glass {
        return GlassData.glass.first{
            it.id == id
        }
    }

    fun searchFood(query:String):List<Glass>{
        return GlassData.glass.filter {
            it.title.contains(query,ignoreCase = true)
        }
    }
    fun getGlassByCategory(type: String): List<Glass> {
        return if (type == "Default") {
            GlassData.glass
        } else {
            GlassData.glass.filter {
                it.type == type
            }
        }
    }
    suspend fun addWishlist(glass: Glass){
        return glassDao.addWishlist(glass)
    }

    suspend fun deleteWishlist(glass:Glass){
        return glassDao.delete(glass)
    }

    suspend fun getWishlist(): Flow<List<Glass>> {
        return glassDao.getAllWishlist()
    }

    suspend fun getWishlistById(id:Int):Flow<Glass>{
        return glassDao.getWishlistById(id)
    }

    suspend fun register( name: String, email:String, password: String, password_confirmation:String, tc:Boolean): ResponseRegister {
            return apiService.register(name, email, password,password_confirmation,tc)
    }

    fun login(email:String,password: String)= liveData {
        emit(UiState.Loading)
        try{
            val response = apiService.login(email,password)
            emit(UiState.Success(response))
        }catch(e: HttpException){
            val errorBody = e.response()?.errorBody()?.string()
            val responseError= Gson().fromJson(errorBody, ResponseError::class.java)
            emit(UiState.Error(responseError.message.toString()))
        }
    }

    suspend fun profile(id:String) : ResponseProfile{
        return apiService.profile((id))
    }
    suspend fun changePassword(password: String, password_confirmation: String) : ResponseRegister{
        return apiService.changepassword(password,password_confirmation)
    }
    suspend fun saveSession(user: UserModel) {
        userPreferences.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreferences.getSession()
    }

    suspend fun logout() {
        userPreferences.logout()
    }

    suspend fun insertOrder(orderGlassData: OrderGlassData){
        return glassDao.addOrder(orderGlassData)
    }
    fun getAllOrder():Flow<List<OrderGlassData>>{
        return glassDao.getAllOrder()
    }

    fun getOrderById(id:Int):Flow<OrderGlassData>{
        return glassDao.getOrderById(id)
    }

    companion object{
        @Volatile
        private var instance : WishlistRepository? = null
        fun getInstance(
            glassDao: GlassDao,
            apiService: ApiService,
            userPreferences: UserPreferences
        ):WishlistRepository  =
            instance ?: synchronized(this){
                WishlistRepository(glassDao,apiService,userPreferences).apply {
                    instance = this
                }
            }
        fun refreshRepository() {
            instance = null
        }
    }
}