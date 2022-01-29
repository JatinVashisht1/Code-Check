package com.example.data.remote.pojos.dto_user_info


import com.example.domain.model.ResultUserInfo
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("city")
    val city: String = "",
    @SerializedName("contribution")
    val contribution: Int = 0,
    @SerializedName("country")
    val country: String = "",
    @SerializedName("firstName")
    val firstName: String = "",
    @SerializedName("friendOfCount")
    val friendOfCount: Int = 0,
    @SerializedName("handle")
    val handle: String = "",
    @SerializedName("lastName")
    val lastName: String = "",
    @SerializedName("lastOnlineTimeSeconds")
    val lastOnlineTimeSeconds: Int = 0,
    @SerializedName("maxRank")
    val maxRank: String = "",
    @SerializedName("maxRating")
    val maxRating: Int = 0,
    @SerializedName("organization")
    val organization: String = "",
    @SerializedName("rank")
    val rank: String = "",
    @SerializedName("rating")
    val rating: Int = 0,
    @SerializedName("registrationTimeSeconds")
    val registrationTimeSeconds: Int = 0,
    @SerializedName("titlePhoto")
    val titlePhoto: String = ""
)

fun Result.toResultUserInfo() : ResultUserInfo = ResultUserInfo(
    avatar, city, contribution, country, firstName, friendOfCount, handle, lastName, lastOnlineTimeSeconds, maxRank, maxRating, organization, rank, rating, registrationTimeSeconds, titlePhoto
)