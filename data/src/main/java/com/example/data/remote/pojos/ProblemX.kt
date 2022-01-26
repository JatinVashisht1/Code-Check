package com.example.data.remote.pojos

data class ProblemX(
    val contestId: Int,
    val index: String,
    val name: String,
    val points: Double,
    val rating: Int,
    val tags: List<String>,
    val type: String
)