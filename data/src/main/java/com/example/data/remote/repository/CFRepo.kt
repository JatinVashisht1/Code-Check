package com.example.data.remote.repository

import com.example.data.remote.pojos.ContestList
import com.example.data.remote.pojos.ContestStatus
import com.example.data.remote.pojos.Result
import com.example.data.remote.pojos.UserStatus

interface CFRepo {
    suspend fun getUserRating(userHandle: String) : List<Result>

    suspend fun getUserStatus(userHandle: String, fromIndex: Int, count: Int) : UserStatus

    suspend fun getUserContentInfo(contestId: String, userHandle: String, from: Int, count: Int) : ContestStatus

    suspend fun getContestList() : ContestList
}