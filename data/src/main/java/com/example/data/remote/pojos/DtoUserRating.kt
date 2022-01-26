package com.example.data.remote.pojos


import com.example.data.remote.pojos.Result
import com.google.gson.annotations.SerializedName

data class DtoUserRating(
    @SerializedName("result")
    val result: List<Result> = listOf(),
    @SerializedName("status")
    val status: String = ""
)