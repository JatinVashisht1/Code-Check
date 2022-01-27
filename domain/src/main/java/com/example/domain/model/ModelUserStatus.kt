package com.example.domain.model

data class ModelUserStatus(
    val resultUserStatus: List<ResultUserStatus> = listOf()
)

data class ResultUserStatus(
    val author: AuthorUserStatus,
    val contestId: Int = -1,
    val creationTimeSeconds: Int = -1,
    val id: Int = -1,
    val memoryConsumedBytes:Int = -1,
    val passedTestCount: Int = -1,
    val problem: ProblemUserStatus = ProblemUserStatus(),
    val programmingLanguage: String = "",
    val relativeTimeSeconds: Int = -1,
    val testSet: String = "",
    val timeConsumedMillis: Int = -1,
    val verdict: String = ""
)

data class AuthorUserStatus(
    val contestId: Int,
    val ghost: Boolean,
    val members: List<MemberUserStatus>,
    val participantType: String
)

data class MemberUserStatus(
    val handle: String
)

data class ProblemUserStatus(
    val contestId: Int  = -1,
    val index: String = "",
    val rating: Int = -1,
    val tags: List<String> = listOf(),
    val type: String = ""
)
