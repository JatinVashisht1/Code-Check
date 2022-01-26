package com.example.data.remote.pojos


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("contestId")
    val contestId: Int = 0,
    @SerializedName("contestName")
    val contestName: String = "",
    @SerializedName("handle")
    val handle: String = "",
    @SerializedName("newRating")
    val newRating: Int = 0,
    @SerializedName("oldRating")
    val oldRating: Int = 0,
    @SerializedName("rank")
    val rank: Int = 0,
    @SerializedName("ratingUpdateTimeSeconds")
    val ratingUpdateTimeSeconds: Int = 0
)