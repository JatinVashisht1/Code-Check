package com.example.data.remote.repository

import com.example.data.remote.pojos.ContestList
import com.example.data.remote.pojos.ContestStatus
import com.example.data.remote.pojos.DtoUserRating
import com.example.data.remote.pojos.UserStatus
import retrofit2.http.GET
import retrofit2.http.Query

interface CodeforcesApi {

    @GET("/user.rating")
    suspend fun getUserRating(
        @Query("handle") userHandle: String
    ) : DtoUserRating

    @GET("/user.status")
    suspend fun getUserStatus(
        @Query("handle") userHandle: String,
        @Query("from") fromIndex: Int,
        @Query("count") count: Int
    ) : UserStatus

    //todo : [Header List] query user.info

    //Can be used to find upsolved problems for a user
    @GET("/contest.status")
    suspend fun getUserContestInfo(
        @Query("contestId") contestId: String,
        @Query("handle") userHandle: String,
        @Query("from") from: Int,
        @Query("count") count: Int
    ) : ContestStatus

    //todo : [Header List] Contest.standings

    @GET("/contest.list")//By default gym is not returned
    suspend fun getContestList() : ContestList

    //todo : try to lessen POJO classes if possible
}
