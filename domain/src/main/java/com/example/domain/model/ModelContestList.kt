package com.example.domain.model

data class ModelContestList(
    val resultContentList: List<ResultContestList>
)

data class ResultContestList(
    val durationSeconds: Int = -1,
    val frozen: Boolean = false,
    val id: Int = -1,
    val name: String = "",
    val phase: String = "",
    val relativeTimeSeconds: Int = -1,
    val startTimeSeconds: Int = -1,
    val type: String = ""
)