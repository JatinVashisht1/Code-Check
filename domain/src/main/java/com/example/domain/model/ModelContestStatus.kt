package com.example.domain.model

data class ModelContestStatus(
    val resultContestStatuses : List<ResultContestStatus> = listOf()
)

data class ResultContestStatus(
    val author: AuthorContestStatus,
    val contestId: Int = -1,
    val creationTimeSeconds: Int = -1,
    val id: Int = -1,
    val memoryConsumedBytes: Int = -1,
    val passedTestCount: Int = -1,
    val problem: ProblemContestStatus,
    val programmingLanguage: String = "",
    val relativeTimeSeconds: Int = -1,
    val testSet: String = "",
    val timeConsumedMillis: Int = -1
)

data class AuthorContestStatus(
    val contestId : Int = -1,
    val ghost: Boolean = false,
    val members: List<MemberContestStatus>,
    val participantType: String = "",
    val startTimeSeconds: Int = -1
)

data class MemberContestStatus(
    val handle: String = ""
)

data class ProblemContestStatus(
    val contestId: Int,
    val index: String,
    val name: String,
    val points: Double,
    val rating: Int,
    val tags: List<String>,
    val type: String
)
