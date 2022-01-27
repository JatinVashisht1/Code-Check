package com.example.data.remote.pojos

import com.example.domain.model.ProblemUserStatus

data class Problem(
    val contestId: Int,
    val index: String,
    val name: String,
    val rating: Int,
    val tags: List<String>,
    val type: String
)

fun Problem.toProblemUserStatus() : ProblemUserStatus = ProblemUserStatus(
    contestId = contestId,
    index = index,
    rating = rating,
    tags = tags,
    type = type
)