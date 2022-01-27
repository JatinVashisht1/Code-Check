package com.example.data.remote.pojos

import com.example.domain.model.ResultContestList

data class ResultXXX(
    val durationSeconds: Int,
    val frozen: Boolean,
    val id: Int,
    val name: String,
    val phase: String,
    val relativeTimeSeconds: Int,
    val startTimeSeconds: Int,
    val type: String
)

fun ResultXXX.toModelContestList() : ResultContestList = ResultContestList(
    durationSeconds =  durationSeconds,
    frozen = frozen,
    id = id,
    name = name,
    phase = phase,
    relativeTimeSeconds = relativeTimeSeconds,
    startTimeSeconds = startTimeSeconds,
    type = type
)