package com.example.data.remote.pojos

data class ResultXX(
    val author: AuthorX,
    val contestId: Int,
    val creationTimeSeconds: Int,
    val id: Int,
    val memoryConsumedBytes: Int,
    val passedTestCount: Int,
    val problem: ProblemX,
    val programmingLanguage: String,
    val relativeTimeSeconds: Int,
    val testset: String,
    val timeConsumedMillis: Int,
    val verdict: String
)