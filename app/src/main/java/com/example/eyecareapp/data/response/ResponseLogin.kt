package com.example.eyecareapp.data.response

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

	@field:SerializedName("data")
	val data: Datas? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("token")
	val token: String? = null
)

data class Datas(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
