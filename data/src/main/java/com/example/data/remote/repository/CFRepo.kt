package com.example.data.remote.repository

import com.example.data.remote.pojos.Result

interface CFRepo {
    suspend fun getUserRating(userHandle: String) : List<Result>
}