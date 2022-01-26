package com.example.data.remote.repository

import com.example.data.remote.pojos.ContestList
import com.example.data.remote.pojos.ContestStatus
import com.example.data.remote.pojos.Result
import com.example.data.remote.pojos.UserStatus

class CFRepoImpl(private val api: CodeforcesApi) : CFRepo {
    override suspend fun getUserRating(userHandle: String): List<Result> =
        api.getUserRating(userHandle).result

    override suspend fun getUserStatus(
        userHandle: String,
        fromIndex: Int,
        count: Int
    ): UserStatus = api.getUserStatus(
        userHandle = userHandle,
        fromIndex = fromIndex,
        count = count
    )

    override suspend fun getUserContentInfo(
        contestId: String,
        userHandle: String,
        from: Int,
        count: Int
    ): ContestStatus = api.getUserContestInfo(
        contestId = contestId,
        userHandle = userHandle,
        from = from,
        count = count
    )

    override suspend fun getContestList(): ContestList = api.getContestList()
}