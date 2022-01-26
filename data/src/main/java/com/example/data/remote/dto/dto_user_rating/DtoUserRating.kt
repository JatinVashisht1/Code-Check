package com.example.data.remote.dto.dto_user_rating


import com.google.gson.annotations.SerializedName

data class DtoUserRating(
    @SerializedName("result")
    val result: List<Result> = listOf(),
    @SerializedName("status")
    val status: String = ""
)