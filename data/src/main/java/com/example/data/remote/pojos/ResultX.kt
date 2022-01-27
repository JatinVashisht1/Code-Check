package com.example.data.remote.pojos

import com.example.domain.model.AuthorUserStatus
import com.example.domain.model.ResultUserStatus

data class ResultX(
    val author: Author,
    val contestId: Int,
    val creationTimeSeconds: Int,
    val id: Int,
    val memoryConsumedBytes: Int,
    val passedTestCount: Int,
    val problem: Problem,
    val programmingLanguage: String,
    val relativeTimeSeconds: Int,
    val testset: String,
    val timeConsumedMillis: Int,
    val verdict: String
)

fun ResultX.toAuthorUserStatus() : ResultUserStatus = ResultUserStatus(
    author = author.toAuthorUserStatus(),
    contestId = contestId,
    creationTimeSeconds = creationTimeSeconds,
    id = id,
    memoryConsumedBytes = memoryConsumedBytes,
    passedTestCount = passedTestCount,
    problem = problem.toProblemUserStatus(),
    programmingLanguage = programmingLanguage,
    relativeTimeSeconds = relativeTimeSeconds,
    testSet = testset,
    timeConsumedMillis = timeConsumedMillis,
    verdict = verdict
)