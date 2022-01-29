package com.example.domain

import com.example.domain.model.*

//@InstallIn(SingletonComponent::class)
//@EntryPoint
//@Component(modules=[AppModule::class])
interface CFRepo {
    suspend fun getUserRating(userHandle: String) : List<ModelUserRating>

    suspend fun getUserStatus(userHandle: String, fromIndex: Int, count: Int) : ModelUserStatus

    suspend fun getContestStatus(contestId: Int, from: Int, count: Int) : ModelContestStatus

    suspend fun getContestList() : ModelContestList

    suspend fun getUserInfo(handles: String) : ModelUserInfo
}