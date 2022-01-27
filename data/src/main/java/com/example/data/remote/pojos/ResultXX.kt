package com.example.data.remote.pojos

import com.example.domain.model.ResultContestStatus

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

fun ResultXX.toResultContestStatus(): ResultContestStatus = ResultContestStatus(
    author = author.toAuthorContestStatus(),
    contestId = contestId,
    creationTimeSeconds = creationTimeSeconds,
    id = id,
    memoryConsumedBytes = memoryConsumedBytes,
    passedTestCount = passedTestCount,
    problem = problem.toProblemContentStatus(),
    programmingLanguage = programmingLanguage,
    relativeTimeSeconds = relativeTimeSeconds,
    testSet = testset,
    timeConsumedMillis = timeConsumedMillis
)