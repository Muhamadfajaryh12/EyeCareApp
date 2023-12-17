package com.example.eyecareapp.data.response

import com.google.gson.annotations.SerializedName

data class ResponseError(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
