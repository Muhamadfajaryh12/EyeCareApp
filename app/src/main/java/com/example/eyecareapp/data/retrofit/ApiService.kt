package com.example.eyecareapp.data.retrofit

import com.example.eyecareapp.data.response.ResponseLogin
import com.example.eyecareapp.data.response.ResponseProfile
import com.example.eyecareapp.data.response.ResponseRegister
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @FormUrlEncoded
    @POST("user/register")
    suspend fun register(
        @Field("email") email:String,
        @Field("name") name:String,
        @Field("password") password:String,
        @Field("password_confirmation") passwordConfirmation:String,
        @Field("tc") tc:Boolean
    ):ResponseRegister

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(
        @Field("email") email:String,
        @Field("password") password: String
    ): ResponseLogin

    @FormUrlEncoded
    @POST("user/changepassword")
    suspend fun changepassword(
        @Field("password") password:String,
        @Field("password_confirmation") passwordConfirmation: String
    ):ResponseRegister

    @GET("user/{id}")
    suspend fun profile(@Path("id") id:String):ResponseProfile
}