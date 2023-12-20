package com.example.eyecareapp.data.response

import com.google.gson.annotations.SerializedName

data class ResponseProfile(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("success")
	val success: Boolean? = null
)

data class Data(

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
