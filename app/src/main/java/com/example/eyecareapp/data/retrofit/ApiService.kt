package com.example.eyecareapp.data.retrofit

import com.example.eyecareapp.data.response.ResponseRegister
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

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
    ):ResponseRegister
}