package com.example.data.remote.repository

import com.example.data.remote.dto.dto_user_rating.DtoUserRating
import retrofit2.http.GET
import retrofit2.http.Query

interface CodeforcesApi {
    @GET("/user.rating")
    suspend fun getUserRating(
        @Query("handle") userHandle: String
    ) : DtoUserRating
}
