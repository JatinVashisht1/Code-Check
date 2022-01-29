package com.example.data.remote.pojos.dto_user_info


import com.example.domain.model.ModelUserInfo
import com.google.gson.annotations.SerializedName

data class DtoUserInfo(
    @SerializedName("result")
    val result: List<Result> = listOf(),
    @SerializedName("status")
    val status: String = ""
)

fun DtoUserInfo.toModelUserInfo() : ModelUserInfo = ModelUserInfo(
    result.map { it.toResultUserInfo() }
)