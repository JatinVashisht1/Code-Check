package com.example.data.remote.pojos

data class AuthorX(
    val contestId: Int,
    val ghost: Boolean,
    val members: List<MemberX>,
    val participantType: String,
    val startTimeSeconds: Int
)