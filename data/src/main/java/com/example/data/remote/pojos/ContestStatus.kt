package com.example.data.remote.pojos

import com.example.domain.model.ModelContestStatus

data class ContestStatus(
    val result: List<ResultXX>,
    val status: String
)

fun ContestStatus.toModelContestStatus() : ModelContestStatus = ModelContestStatus(resultContestStatuses = result.map { it.toResultContestStatus() })