package com.example.data.remote.pojos

data class Author(
    val contestId: Int,
    val ghost: Boolean,
    val members: List<Member>,
    val participantType: String,
    val startTimeSeconds: Int
)