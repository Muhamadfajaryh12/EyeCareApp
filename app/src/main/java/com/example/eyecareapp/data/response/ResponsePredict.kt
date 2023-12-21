package com.example.eyecareapp.data.response

import com.google.gson.annotations.SerializedName

data class ResponsePredict(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("predict")
	val predict: String? = null
)
