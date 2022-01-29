package com.example.data.remote.repository

import com.example.data.remote.CodeforcesApi
import com.example.data.remote.pojos.*
import com.example.data.remote.pojos.dto_user_info.toModelUserInfo
import com.example.domain.CFRepo
import com.example.domain.model.*

class CFRepoImpl(private val api: CodeforcesApi) : CFRepo {
    override suspend fun getUserRating(userHandle: String): List<ModelUserRating> {
        val data = api.getUserRating(userHandle = userHandle).result
        val result = data.map {
            ModelUserRating(
                contestId = it.contestId,
                contestName = it.contestName,
                handle = it.handle,
                newRating = it.newRating,
                oldRating = it.oldRating,
                rank = it.rank,
                ratingUpdateTimeSeconds = it.ratingUpdateTimeSeconds
            )
        }
        return result
    }


    override suspend fun getUserStatus(
        userHandle: String,
        fromIndex: Int,
        count: Int
    ): ModelUserStatus {
        val data = api.getUserStatus(
            userHandle = userHandle,
            fromIndex = fromIndex,
            count = count
        )
        return data.toModelUserStatus()
    }
    override suspend fun getContestStatus(
        contestId: Int,
//        userHandle: String,
        from: Int,
        count: Int
    ): ModelContestStatus  {
        val data = api.getContestStatus(
            contestId = contestId,
//            userHandle = userHandle,
            from = from,
            count = count
        )
        return data.toModelContestStatus()
    }

    override suspend fun getContestList(): ModelContestList  {
        val data = api.getContestList()
        return data.toModelContestList()
    }

    override suspend fun getUserInfo(handles: String): ModelUserInfo {
        val data = api.getUserInfo(handles = handles)
        return data.toModelUserInfo()
    }
}