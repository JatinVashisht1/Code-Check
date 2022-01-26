package com.example.data.remote.repository

import com.example.data.remote.dto.dto_user_rating.DtoUserRating
import com.example.data.remote.dto.dto_user_rating.Result

interface CFRepo {
    suspend fun getUserRating(userHandle: String) : List<Result>
}