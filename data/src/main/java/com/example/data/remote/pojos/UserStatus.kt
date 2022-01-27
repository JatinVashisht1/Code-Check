package com.example.data.remote.pojos

import com.example.domain.model.AuthorUserStatus
import com.example.domain.model.ModelUserStatus
import com.example.domain.model.ResultUserStatus

data class UserStatus(
    val result: List<ResultX>,
    val status: String
)

fun UserStatus.toModelUserStatus() : ModelUserStatus = ModelUserStatus(
    resultUserStatus = result.map{ it.toAuthorUserStatus() }
)